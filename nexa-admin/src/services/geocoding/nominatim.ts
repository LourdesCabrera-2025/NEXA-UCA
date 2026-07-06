export interface PlaceResult {
    label: string;
    lat: number;
    lng: number;
}


export async function searchPlace(query: string): Promise<PlaceResult[]> {

    if (!query || query.length < 3) return [];

    const url = `https://nominatim.openstreetmap.org/search?format=json&q=${encodeURIComponent(query)}&countrycodes=sv&limit=5`;
    try {
        const response = await fetch(url, {
            headers: {
                'Accept-Language': 'es' 
            }
        });
        const data = await response.json();

        
        return data.map((item: any) => ({
            label: item.display_name,
            lat: parseFloat(item.lat),
            lng: parseFloat(item.lon)
        }));
    } catch (error) {
        console.error("Error en geocoding:", error);
        return [];
    }



}