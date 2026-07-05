import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import tailwindcss from '@tailwindcss/vite'
import path from 'path'


// https://vite.dev/config/
export default defineConfig({
  plugins: [
    react(),
    tailwindcss()
  ],
  resolve: {
    alias: {
      "@":path.resolve(__dirname, "./src"),
      "@assets":path.resolve(__dirname, "./src/assets"),
      "@context":path.resolve(__dirname, "./src/context"),
      "@dataconnect-generated":path.resolve(__dirname, "./src/dataconnect-generated"),
      "@hooks":path.resolve(__dirname, "./src/hooks"),
      "@mappers":path.resolve(__dirname, "./src/mappers"),
      "@models":path.resolve(__dirname, "./src/models"),
      "@pages":path.resolve(__dirname, "./src/pages"),
      "@routes":path.resolve(__dirname, "./src/routes"),
      "@services":path.resolve(__dirname, "./src/services"),
      "@styles":path.resolve(__dirname, "./src/styles"),
      "@utils":path.resolve(__dirname, "./src/utils")
    }
  },
  server: {
    host: true,
    port: 5173,
    open: true
  }
})




