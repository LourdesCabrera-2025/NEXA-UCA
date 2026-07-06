import { useRef, useCallback, useState, useEffect } from 'react';
import { maptilersdk } from '@/services/mapTiler/MapTiler';
import "@maptiler/sdk/dist/maptiler-sdk.css";
import { Dialog, DialogTitle, DialogContent, DialogActions } from '@mui/material';
import ShareLocationIcon from '@mui/icons-material/ShareLocation';
import CloseRoundedIcon from '@mui/icons-material/CloseRounded';
import SaveRoundedIcon from '@mui/icons-material/SaveRounded';
import RadarIcon from '@mui/icons-material/Radar';
import { searchPlace, type PlaceResult } from "@services/geocoding/nominatim";
import { useDebounce } from '@/hooks/useDebounce';

interface ModalMapProps {
    open: boolean;
    onClose: () => void;
    onSelectLocation?: (lat: number, lng: number, radius: number) => void;
    initialLat?: number | string;
    initialLng?: number | string;
    initialRadius?: number | string;
}

function createGeoJSONCircle(center: [number, number], radiusInMeters: number) {
    const coordinates = [];
    const distanceX = radiusInMeters / (111320 * Math.cos(center[1] * Math.PI / 180));
    const distanceY = radiusInMeters / 110540;

    for (let i = 0; i < 64; i++) {
        const angle = (i / 64) * Math.PI * 2;
        const x = center[0] + distanceX * Math.cos(angle);
        const y = center[1] + distanceY * Math.sin(angle);
        coordinates.push([x, y]);
    }
    coordinates.push(coordinates[0]);

    return {
        type: 'Feature' as const,
        geometry: {
            type: 'Polygon' as const,
            coordinates: [coordinates]
        },
        properties: {}
    };
}

export default function ModalMap({ open, onClose, onSelectLocation, initialLat, initialLng, initialRadius }: ModalMapProps) {
    const mapContainer = useRef<HTMLDivElement | null>(null);
    const map = useRef<maptilersdk.Map | null>(null);
    const markerRef = useRef<maptilersdk.Marker | null>(null);

    const parsedLat = initialLat ? Number(initialLat) : 13.7942;
    const parsedLng = initialLng ? Number(initialLng) : -88.8965;
    const parsedRadius = initialRadius ? Number(initialRadius) : 100;

    const [query, setQuery] = useState("");
    const [result, setResults] = useState<PlaceResult[]>([]);
    const debounceQuery = useDebounce(query, 400);

    const [tempCoords, setTempCoords] = useState<{ lat: number; lng: number }>({ lat: parsedLat, lng: parsedLng });
    const [radius, setRadius] = useState<number>(parsedRadius);

    useEffect(() => {
        if (open) {
            setTempCoords({ lat: parsedLat, lng: parsedLng });
            setRadius(parsedRadius);
            setQuery("");
            setResults([]);
        }
    }, [open, parsedLat, parsedLng, parsedRadius]);

    const updateCircleLayer = (center: [number, number], currentRadius: number) => {
        if (!map.current || !map.current.isStyleLoaded()) return;

        const sourceId = 'circle-source';
        const layerId = 'circle-layer';
        const circleData = createGeoJSONCircle(center, currentRadius);

        const source = map.current.getSource(sourceId) as any;
        if (source) {
            source.setData(circleData);
        } else {
            map.current.addSource(sourceId, {
                type: 'geojson',
                data: circleData
            });
            map.current.addLayer({
                id: layerId,
                type: 'fill',
                source: sourceId,
                layout: {},
                paint: {
                    'fill-color': '#1447ef',
                    'fill-opacity': 0.2,
                    'fill-outline-color': '#031B3F'
                }
            });
        }
    };

    const handleMapInit = useCallback(() => {
        if (!mapContainer.current || map.current) return;

        map.current = new maptilersdk.Map({
            container: mapContainer.current,
            style: maptilersdk.MapStyle.STREETS_V4,
            center: [parsedLng, parsedLat],
            zoom: 14,
        });

        markerRef.current = new maptilersdk.Marker({ draggable: true, color: '#031B3F' })
            .setLngLat([parsedLng, parsedLat])
            .addTo(map.current);

        map.current.on('load', () => {
            updateCircleLayer([parsedLng, parsedLat], parsedRadius);
        });

        // 1. Cuando haces clic en el mapa
        map.current.on('click', (e) => {
            const { lng, lat } = e.lngLat;
            if (markerRef.current) markerRef.current.setLngLat([lng, lat]);

            // ESTA LÍNEA ES CRUCIAL: Actualiza el estado con la nueva posición
            setTempCoords({ lat, lng });

            updateCircleLayer([lng, lat], radius);
        });

        // 2. Cuando arrastras el marcador
        markerRef.current.on('dragend', () => {
            if (markerRef.current) {
                const lngLat = markerRef.current.getLngLat();

                // ESTA LÍNEA TAMBIÉN ES CRUCIAL: Actualiza el estado al soltar el marcador
                setTempCoords({ lat: lngLat.lat, lng: lngLat.lng });

                updateCircleLayer([lngLat.lng, lngLat.lat], radius);
            }
        });
    }, [parsedLat, parsedLng, parsedRadius]);

    useEffect(() => {
        if (map.current) {
            updateCircleLayer([tempCoords.lng, tempCoords.lat], radius);
        }
    }, [radius, tempCoords]);

    useEffect(() => {
        const load = async () => {
            const data: PlaceResult[] = await searchPlace(debounceQuery);
            setResults(data);
        };
        if (debounceQuery) load();
        else setResults([]);
    }, [debounceQuery]);

    const selectPlace = (place: PlaceResult) => {
        if (!map.current || !markerRef.current) return;
        markerRef.current.setLngLat([place.lng, place.lat]);
        map.current.flyTo({ center: [place.lng, place.lat], zoom: 15 });
        setTempCoords({ lat: place.lat, lng: place.lng });
        updateCircleLayer([place.lng, place.lat], radius);
        setQuery(place.label);
        setResults([]);
    };

    const handleSaveLocation = () => {

        if (onSelectLocation) {
            onSelectLocation(tempCoords.lat, tempCoords.lng, radius);
        }
        handleClose();
    };

    const handleClose = useCallback(() => {
        if (map.current) {
            map.current.remove();
            map.current = null;
            markerRef.current = null;
        }
        onClose();
    }, [onClose]);

    return (
        <Dialog
            open={open}
            onClose={handleClose}
            maxWidth="md"
            fullWidth
            disableEnforceFocus
            slotProps={{
                transition: { onEntered: handleMapInit },
                backdrop: { sx: { backgroundColor: 'rgba(0, 0, 0, 0.3)' } }
            }}
            sx={{ zIndex: 1400, '& .MuiPaper-root': { borderRadius: '16px', background: '#ffffff', boxShadow: '0px 25px 50px -12px rgba(0,0,0,0.25)' } }}
        >
            <DialogTitle sx={{ display: 'flex', alignItems: 'center', gap: '12px', padding: '16px 24px', borderBottom: '1px solid rgba(144,161,185,0.3)' }}>
                <div className='flex items-center gap-3 flex-1'>
                    <ShareLocationIcon className='text-gray-500' sx={{ fontSize: 22 }} />
                    <span className='text-base font-bold text-gray-900 tracking-tight' style={{ fontFamily: '"Inter", sans-serif' }}>Punto de validación geográfica</span>
                </div>
                <button onClick={handleClose} className='flex items-center justify-center w-8 h-8 rounded-lg border border-gray-200 text-gray-400 hover:bg-gray-50 hover:text-gray-600 transition-all duration-150 cursor-pointer'><CloseRoundedIcon sx={{ fontSize: 18 }} /></button>
            </DialogTitle>

            <DialogContent style={{ padding: 0, margin: 0, overflow: "hidden", height: "560px", position: "relative" }}>
                <div style={{ position: "absolute", top: 16, left: 16, width: 350, zIndex: 1000, display: 'flex', flexDirection: 'column', gap: '8px' }}>
                    <input
                        value={query}
                        onChange={(e) => setQuery(e.target.value)}
                        placeholder="Buscar lugar o dirección..."
                        style={{ width: "100%", padding: "12px", borderRadius: "10px", border: "1px solid #d4d4d8", outline: "none", fontSize: "14px", backgroundColor: "#fff", boxShadow: "0 4px 10px rgba(0,0,0,.15)", fontFamily: '"Inter", sans-serif' }}
                    />
                    <div style={{ display: 'flex', alignItems: 'center', gap: '8px', padding: '8px 12px', borderRadius: '10px', border: '1px solid #d4d4d8', backgroundColor: '#fff', boxShadow: '0 4px 10px rgba(0,0,0,.11)', width: '60%' }}>
                        <RadarIcon className="text-zinc-400" sx={{ fontSize: 18 }} />
                        <input
                            type="number"
                            value={radius}
                            onChange={(e) => {
                                const val = parseInt(e.target.value);
                                setRadius(isNaN(val) ? 0 : Math.max(1, val));
                            }}
                            style={{ border: 'none', outline: 'none', width: '100%', fontSize: '13px', color: '#3f3f46', fontFamily: '"Inter", sans-serif' }}
                            placeholder="Radio (m)"
                        />
                        <span style={{ fontSize: '12px', color: '#a1a1aa', fontWeight: 'bold' }}>mts</span>
                    </div>
                    {result.length > 0 && (
                        <div style={{ background: "#fff", borderRadius: 10, border: "1px solid #e4e4e7", overflow: "hidden", maxHeight: 200, overflowY: "auto", boxShadow: "0 6px 15px rgba(0,0,0,.15)" }}>
                            {result.map((r, i) => (
                                <div key={i} onClick={() => selectPlace(r)} style={{ padding: "10px 14px", cursor: "pointer", borderBottom: i !== result.length - 1 ? "1px solid #f1f5f9" : "none", fontSize: "13px", color: '#3f3f46', fontFamily: '"Inter", sans-serif' }} onMouseEnter={(e) => (e.currentTarget.style.background = "#f4f4f5")} onMouseLeave={(e) => (e.currentTarget.style.background = "#fff")}>
                                    {r.label}
                                </div>
                            ))}
                        </div>
                    )}
                </div>
                <div ref={mapContainer} style={{ width: "100%", height: "100%", minHeight: "560px" }} />
            </DialogContent>

            <DialogActions sx={{ display: 'flex', alignItems: 'end', gap: '12px', padding: '20px 24px', borderTop: '1px solid rgba(144,161,185, 0.5)' }}>
                <button type='button' className='relative group overflow-hidden rounded-lg border border-zinc-300 px-6 py-2 text-black transition-all duration-300 cursor-pointer' onClick={handleClose}>
                    <span className='absolute inset-0 top-1/2 left-1/2 flex h-0 w-0 -translate-x-1/2 -translate-y-1/2 rounded-full bg-rose-700 duration-300 ease-out group-hover:h-56 group-hover:w-56'></span>
                    <span className='relative text-sm font-semibold p-2 transition-colors duration-300 group-hover:text-white'>Cancelar</span>
                </button>
                <button type='button' onClick={handleSaveLocation} className='relative group overflow-hidden rounded-lg border border-zinc-300 px-6 py-2 text-black transition-all duration-300 cursor-pointer'>
                    <span className='absolute inset-0 top-1/2 left-1/2 flex h-0 w-0 -translate-x-1/2 -translate-y-1/2 rounded-full bg-[#1F2836] duration-300 ease-out group-hover:h-56 group-hover:w-56'></span>
                    <SaveRoundedIcon className='relative transition-colors duration-300 group-hover:text-white' />
                    <span className='relative text-sm font-semibold p-2 transition-colors duration-300 group-hover:text-white'>Guardar Ubicación</span>
                </button>
            </DialogActions>
        </Dialog>
    );
}