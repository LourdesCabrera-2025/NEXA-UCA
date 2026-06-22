import App from '@/App';
import DashboardLayout from '@/assets/layout/DashboardLayout';
import Dashboard from '@/pages/Dashboard/Dashboard';
import Login from '@/pages/Login/Login';
import Programs from '@/pages/Projects/Programs';
import { BrowserRouter, Route, Routes ,Navigate} from 'react-router-dom';



export default function NavManager() {

    return (
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<App />} />
                <Route path='/Login' element={<Login />} />
                <Route path='/Dashboard' element={<DashboardLayout />} >
                    <Route index element={<Navigate to="/Dashboard/Inicio" replace />} />
                    <Route path='Inicio' element={<Dashboard/>}/>
                    <Route index element={<Navigate to="/Dashboard/Programas" replace />}/>
                    <Route path='Programas' element={<Programs/>} />
                </Route>
            </Routes>
        </BrowserRouter>
    )

}