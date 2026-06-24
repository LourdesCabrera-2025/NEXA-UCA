import '../../styles/index.css';
import * as React from 'react';
import { Link, Outlet, useLocation, useNavigate } from 'react-router-dom';
import SearchOutlinedIcon from '@mui/icons-material/SearchOutlined';
import SettingsOutlinedIcon from '@mui/icons-material/SettingsOutlined';
import NotificationsRoundedIcon from '@mui/icons-material/NotificationsRounded';
import PersonRoundedIcon from '@mui/icons-material/PersonRounded';
import DarkModeRoundedIcon from '@mui/icons-material/DarkModeRounded';
import LogoutRoundedIcon from '@mui/icons-material/LogoutRounded';
import KeyboardArrowDownRoundedIcon from '@mui/icons-material/KeyboardArrowDownRounded';
import { authService } from '@/services/firebase/authService';
import { useIdleTimeout } from '@/hooks/useIdleTimeout';


export default function DashboardLayout() {
    const [isProfileOpen, setIsProfileOpen] = React.useState(false);
    const [isHelpOpen, setIsHelpOpen] = React.useState(false);

    const location = useLocation();
    const navigate = useNavigate();

    const [activeTab, setActiveTab] = React.useState('Dashboard');
    const navTabs = [
        {
            name: 'Dashboard', path: '/Dashboard/Inicio'
        },
        {
            name: 'Programas', path: '/Dashboard/Programas'
        },
        {
            name: 'Estudiantes', path: '/Dashboard/Estudiantes'
        },
        {
            name: 'Reportes', path: '/Dashboard/Reportes'
        }
    ]
    const [isDarkMode, setIsDarkMode] = React.useState(false);

    const [userData, setUserData] = React.useState<{
        name: string;
        email: string;
        photoUrl: string;
        role: string;
        isActive: boolean;
    } | null>(null);

    React.useEffect(() => {
        const fetchUserAndRole = async () => {
            const pgUser = await authService.getCurrentPostgressUser();

            if (pgUser) {
                setUserData({
                    name: pgUser.fullname || 'Usuario Nexa',
                    email: pgUser.email || '',
                    photoUrl: pgUser.photoUrl || 'https://i.pinimg.com/1200x/85/e9/7e/85e97e277d8511dc4c68086c6e45041a.jpg',
                    role: pgUser.role?.name || 'Supervisor',
                    isActive: pgUser.isActive! == undefined ? pgUser.isActive : true
                })
            }
        };
        fetchUserAndRole();
    }, [navigate]);


    const handleLogout = async () => {

        try {
            await authService.logout();
            navigate('/');
        } catch (error) {
            console.error("NEXA_DEBUG: Error al cerrar sesión", error)
        }
    };;

    useIdleTimeout({
        onTimeout: handleLogout,
        timeoutInMinutes: 5
    });

    return (
        <>
            <header className='w-full bg-white border-b border-gray-200 flex flex-col z-40 sticky top-0 shadow-md'>
                <div className='w-full max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 h-16 flex items-center justify-between'>
                    <div className='flex items-center gap-8 h-full'>
                        <Link to="/Dashboard" className='flex items-center gap-2.5 shrink-0'>
                            <div className='bg-blue-600 rounded-xl w-10 h-10 flex items-center justify-center  text-white'>
                                <img src="/main_icon.png" alt="" />
                            </div>
                            <span className='font-bold text-gray-900 tracking-tight text-lg title-tab'>NEXA UCA</span>
                        </Link>

                        <nav className='hidden md:flex items-center gap-1 h-full'>
                            {navTabs.map((tab) => {
                                const isActive = location.pathname === tab.path;
                                return (
                                    <button
                                        key={tab.name}
                                        onClick={() => navigate(tab.path)}
                                        className={`h-full px-3 text-sm font-semibold border-b-2 transition-all items-center nav-tabs cursor-pointer ${isActive
                                            ? 'border-blue-600 text-blue-600'
                                            : 'border-transparent text-gray-600 hover:text-gray-900 hover:border-gray-200'
                                            }`}
                                    >
                                        {tab.name}
                                    </button>
                                )
                            })}
                        </nav>
                    </div>

                    <div className='flex items-center gap-4'>
                        <div className="relative hidden sm:block w-64">
                            <SearchOutlinedIcon className='absolute left-3 top-1/2 -translate-y-1/2 text-gray-400' sx={{ fontSize: 20 }} />
                            <input type='text' placeholder='Buscar...' className='w-full bg-gray-50 text-sm border border-gray-300 rounded-lg pl-10 pr-8 py-2 text-gray-900 focus:outline-none focus:ring-2 focus:ring-blue-500/20 focus:border-blue-500 transition-all' />
                            <kbd className='absolute right-2.5  top-1/2 -translate-y-1/2 hidden md:inline-flex items-center bg-white px-1.5 border border-gray-200 rounded text-xs font-medium text-gray-400 gap-0.5 shadow-sm'>
                                ⌘K
                            </kbd>
                        </div>
                        <button className='p-2 text-gray-500 hover:text-gray-900 hover:bg-gray-50 rounded-lg relative transition-colors'>
                            <NotificationsRoundedIcon sx={{ fontSize: 22 }} />
                            <span className='absolute top-1.5 right-1.5 w-4 h-4 bg-red-500 text-[10px] font-bold text-white rounded-full flex items-center justify-center border border-white'>
                                2
                            </span>
                        </button>

                        <div className='relative'>
                            <button
                                onClick={() => {
                                    setIsProfileOpen(!isProfileOpen);
                                    setIsHelpOpen(false);
                                }} className='flex items-center focus:outline-none rounded-full ring-2 ring-transparent hover:ring-blue-500 p-0.5 transition-all cursor-pointer'>
                                <div className="relative">
                                    <img src={userData?.photoUrl} alt="Avatar de usuario" className='w-9 h-9 rounded-full object-cover ring-transparent group-hover:ring-blue-200 transition-all' />
                                </div>
                                <KeyboardArrowDownRoundedIcon className={`text-gray-400 transition-transform duration-200 ease-in-out   ${isProfileOpen ? 'animate-rotate-180 text-gray-700' : ' group-hover:text-gray-600'}`} sx={{ fontSize: 20 }} />
                            </button>
                            {isProfileOpen && (
                                <>
                                    <div className='fixed inset-0 z-10' onClick={() => setIsProfileOpen(false)} />
                                    <div className='absolute right-0 mt-3 w-65 bg-white rounded-xl shadow-lg border border-gray-200 py-1.5 z-20 animate-blurred-fade-in animate-duration-800 animate-delay-150 animate-steps-modern'>
                                        <div className='px-4 py-3 border border-gray-100 flex flex-col '>
                                            <div className='flex items-center  gap-4 h-full'>
                                                <div className="relative shrink-0">
                                                    <img src={userData?.photoUrl} className='rounded-full object-cover w-10 h-10' alt="Profile" />
                                                    <span className={`absolute bottom-0 right-0 block h-2.5 w-2.5 rounded-full ring-2 ring-white ${userData?.isActive ? 'bg-green-500' : 'bg-gray-400'
                                                        }`}></span>
                                                </div>
                                                <div className="items-start flex flex-col">
                                                    <span className='text-sm font-bold text-gray-900 ' id='span-config'>{userData?.role} UCA</span>
                                                    <span className='text-xs text-gray-500 truncate text-[10px]' id='span-config'>{userData?.email}</span>
                                                </div>
                                            </div>
                                        </div>

                                        <div className='p-1 border border-gray-100'>
                                            <button className='w-full flex items-center justify-start px-3 py-2 text-sm text-gray-700 hover:bg-gray-50 rounded-md text-left font-medium cursor-pointer'>
                                                <div className='flex items-center gap-2 pl-3'>
                                                    <PersonRoundedIcon className='text-gray-400' sx={{ fontSize: 22 }} />
                                                    <span className='text-start' id='span-config'>Mi perfil</span>
                                                </div>
                                            </button>
                                            <button className='w-full flex items-center justify-start px-3 py-2 text-sm text-gray-700 hover:bg-gray-50 rounded-md text-left  font-medium cursor-pointer'>
                                                <div className='flex  items-center gap-2 pl-3'>
                                                    <SettingsOutlinedIcon className='text-gray-400' sx={{ fontSize: 22 }} />
                                                    <span className='text-start' id='span-config' >Configuración</span>
                                                </div>
                                            </button>
                                            <div className='w-full flex items-center justify-start px-3 py-2 text-sm text-gray-700 hover:bg-gray-50 rounded-md text-left font-medium cursor-pointer'>
                                                <button onClick={() => setIsDarkMode(!isDarkMode)}
                                                    className={`w-full flex items-center justify-between px-3 py-2 text-sm rounded-md font-medium transition-all duration-150 select-none cursor-pointer
                                                    ${isDarkMode
                                                            ? 'bg-purple-50 text-purple-700 hover:bg-purple-100/70'
                                                            : 'text-gray-700 hover:bg-gray-50'
                                                        }`}>
                                                    <div className='flex items-center gap-2'>
                                                        <DarkModeRoundedIcon className={`transition-colors ${isDarkMode ? 'text-purple-60' : 'text-gray-400'}`} sx={{ fontSize: 22 }} />
                                                        <span className='text-start' id='span-config'>Modo oscuro</span>
                                                    </div>
                                                    {isDarkMode && (
                                                        <span className='flex h-2 w-2 relative'>
                                                            <span className='animate-ping absolute inline-flex h-full w-full rounded-full bg-purple-400 opacity-75'></span>
                                                            <span className='relative inline-flex rounded-full h-2 w-2 bg-purple-50'></span>
                                                        </span>
                                                    )}
                                                </button>
                                            </div>
                                            <div className='p-1'>
                                                <button onClick={handleLogout} className='w-full flex items-center gap-2 px-3 py-2 text-sm text-red-600 hover:bg-red-50/50 rounded-md font-semibold cursor-pointer'>
                                                    <div className='flex items-center gap-2 pl-3'>
                                                        <LogoutRoundedIcon sx={{ fontSize: 22 }} />
                                                        <span id='span-config'>Cerrar Sesión</span>
                                                    </div>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </>
                            )}
                        </div>
                    </div>
                </div>
            </header>


            <main className='w-full max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 p-10'>
                <Outlet />

            </main>

            <footer className='w-full bg-white py-40 border-t border-gray-200 relative overflow-hidden bg-gray-400 pt-20'>
                <div className='mx-auto max-w-3xl px-4 sm:px-6 lg:px-8 flex flex-col items-center justify-center text-center gap-4'>
                    <div className='w-18 h-18 bg-black'
                        style={{
                            WebkitMaskImage: 'url("/main_icon.png")',
                            maskImage: 'url("/main_icon.png")',
                            WebkitMaskSize: 'contain',
                            maskSize: 'contain',
                            WebkitMaskRepeat: 'no-repeat',
                            maskRepeat: 'no-repeat',
                            WebkitMaskPosition: 'center',
                            maskPosition: 'center'
                        }}
                        aria-label='Logo Nexa UCA'
                    />
                    <div className="flex flex-col items-center gap-1.5">
                        <span className='text-base font-black tracking-tight text-gray-900 leading-none'>
                            NEXA <span className='text-gray-500'>UCA</span>
                        </span>
                        <span className='text-[15px] text-gray-400 font-normal mt-1'>
                            Universidad Centroamericana José Simeón Cañas
                        </span>
                    </div>
                    <div className='text-xs font-normal text-gray-400 mt-2'>
                        &copy; {new window.Date().getFullYear()} Todos los derechos reservados.
                    </div>
                </div>
            </footer>
        </>
    )
}