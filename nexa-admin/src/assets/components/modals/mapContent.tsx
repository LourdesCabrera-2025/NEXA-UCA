import React, { useRef, useCallback } from 'react';
import * as maptilersdk from '@maptiler/sdk';
import "@maptiler/sdk/dist/maptiler-sdk.css";

import { Dialog, DialogTitle, DialogContent, DialogActions } from '@mui/material';
import ShareLocationIcon from '@mui/icons-material/ShareLocation';
import CloseRoundedIcon from '@mui/icons-material/CloseRounded';
import SaveRoundedIcon from '@mui/icons-material/SaveRounded';
interface ModalMapProps {
    open: boolean;
    onClose: () => void;
}

export default function ModalMap({ open, onClose }: ModalMapProps) {
    const mapContainer = useRef<HTMLDivElement | null>(null);
    const map = useRef<maptilersdk.Map | null>(null);

    const handleMapInit = useCallback(() => {
        if (!mapContainer.current || map.current) return;

        maptilersdk.config.apiKey = import.meta.env.VITE_MAPTILER_APIKEY?.trim() ?? '';

        map.current = new maptilersdk.Map({
            container: mapContainer.current,
            style: maptilersdk.MapStyle.STREETS_V4,
            center: [-88.8965, 13.7942],
            zoom: 9.5,
        });

        new maptilersdk.Marker({ draggable: true, color: '#031B3F' })
            .setLngLat([-88.8965, 13.7942])
            .addTo(map.current);
    }, []);


    const handleClose = useCallback(() => {
        if (map.current) {
            map.current.remove();
            map.current = null;
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
                transition: { onEntered: handleMapInit },   // ✅
                backdrop: {
                    sx: { backgroundColor: 'rgba(0, 0, 0, 0.3)' }
                }
            }}
            sx={{
                zIndex: 1400,
                '& .MuiPaper-root': {
                    borderRadius: '16px',
                    background: '#ffffff',
                    boxShadow: '0px 25px 50px -12px rgba(0,0,0,0.25)',
                }
            }}
        >
            <DialogTitle
                sx={{
                    display: 'flex',
                    alignItems: 'center',
                    gap: '12px',
                    padding: '16px 24px',
                    borderBottom: '1px solid rgba(144,161,185,0.3)',
                }}
            >
                <div className='flex items-center gap-3 flex-1'>
                    <ShareLocationIcon className='text-gray-500' sx={{ fontSize: 22 }} />
                    <span
                        className='text-base font-bold text-gray-900 tracking-tight'
                        style={{ fontFamily: '"Inter", sans-serif' }}
                    >
                        Punto de validación geográfica
                    </span>
                </div>
                <button
                    onClick={handleClose}
                    className='flex items-center justify-center w-8 h-8 rounded-lg border border-gray-200 text-gray-400 hover:bg-gray-50 hover:text-gray-600 transition-all duration-150 cursor-pointer'
                    aria-label='Cerrar modal.'
                >
                    <CloseRoundedIcon sx={{ fontSize: 18 }} />
                </button>
            </DialogTitle>

            <DialogContent style={{ padding: 0, margin: 0, overflow: 'hidden', height: '450px' }}>
                <div
                    ref={mapContainer}
                    style={{ width: '100%', height: '100%', minHeight: '560px' }}
                />
            </DialogContent>
            <DialogActions sx={
                {
                    display: 'flex',
                    alignItems: 'end',
                    gap: '12px',
                    padding: '20px 24px',
                    borderTop: '1px solid rgba(144,161,185, 0.5)',
                }
            }>
                <button type='submit' className='relative group overflow-hidden rounded-lg border border-zinc-300 px-6 py-2 text-black transition-all duration-300 cursor-pointer' onClick={onClose}>
                    <span className='absolute inset-0 top-1/2 left-1/2 flex h-0 w-0 -translate-x-1/2 -translate-y-1/2 rounded-full bg-rose-700 duration-300 ease-out  group-hover:h-56 group-hover:w-56'></span>
                    <span className='relative text-sm font-semibold p-2 transition-colors duration-300 group-hover:text-white'>Cancelar</span>
                </button>
                <button type='submit' className='relative group overflow-hidden rounded-lg border border-zinc-300 px-6 py-2 text-black transition-all duration-300 cursor-pointer'>
                    <span className='absolute inset-0 top-1/2 left-1/2 flex h-0 w-0 -translate-x-1/2 -translate-y-1/2 rounded-full bg-[#1F2836] duration-300 ease-out  group-hover:h-56 group-hover:w-56'></span>
                    <SaveRoundedIcon className='relative transition-colors duration-300 group-hover:text-white' />
                    <span className='relative text-sm font-semibold p-2 transition-colors duration-300  group-hover:text-white'>Guardar Ubicación</span>
                </button>

            </DialogActions>
        </Dialog>
    );
}