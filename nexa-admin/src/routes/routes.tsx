import App from '@/App';
import Dashboard from '@/pages/Dashboard/Dashboard';
import Login from '@/pages/Login/Login';
import {BrowserRouter,  Route,  Routes} from 'react-router-dom';



export default function NavManager() {

    return (
        <BrowserRouter>
        <Routes>
            <Route path='/' element={<App/>}/>
            <Route path='/Login' element={<Login/>}/>
            <Route path='/Dashboard' element={<Dashboard/>}/>
        </Routes>
        </BrowserRouter>
    )

}