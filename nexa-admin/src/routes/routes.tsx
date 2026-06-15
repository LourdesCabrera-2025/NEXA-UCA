import App from '@/App';
import Login from '@/pages/Login/Login';
import {BrowserRouter,  Route,  Routes} from 'react-router-dom';



export default function NavManager() {

    return (
        <BrowserRouter>
        <Routes>
            <Route path='/' element={<App/>}/>
            <Route path='/Login' element={<Login/>}/>
        </Routes>
        </BrowserRouter>
    )

}