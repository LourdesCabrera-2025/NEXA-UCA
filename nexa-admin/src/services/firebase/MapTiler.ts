import * as maptilersdk from '@maptiler/sdk';

const MAPTILER_KEY = import.meta.env.VITE_MAPTILER_APIKEY;

if (!MAPTILER_KEY) {
    console.warn("NEXA_DEBUG:La api key de maptiler no esta configurada en el  archivo")
}

maptilersdk.config.apiKey = MAPTILER_KEY || '';

export {maptilersdk};