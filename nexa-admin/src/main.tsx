import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import NavManager from './routes/routes.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <NavManager />
  </StrictMode>,
)
