import App from '@/App';
import DashboardLayout from '@/assets/layout/DashboardLayout';
import Dashboard from '@/pages/Dashboard/Dashboard';
import UnauthorizedPage from '@/pages/Error/Unauthorized';
import Login from '@/pages/Login/Login';
import DetalleProgram from '@/pages/Projects/Detalle';
import Programs from '@/pages/Projects/Programs';
import Alumns from '@/pages/Students/Participant';
import { BrowserRouter, Route, Routes ,Navigate} from 'react-router-dom';



export default function NavManager() {

    return (
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<App />} />
                <Route path='/Login' element={<Login />} />
                <Route path='/Unauthorized' element={<UnauthorizedPage />} />
                <Route path='/Dashboard' element={<DashboardLayout />} >
                    <Route index element={<Navigate to="/Dashboard/Inicio" replace />} />
                    <Route path='Inicio' element={<Dashboard/>}/>
                    
                    <Route path='Programas' element={<Programs/>} />
                   <Route path='/Dashboard/Programas/:id' element={<DetalleProgram />} />
                   <Route path='Estudiantes' element={<Alumns/>}/>
                </Route>
            </Routes>
        </BrowserRouter>
    )

}