import '../../styles/index.css';
import HistoryRoundedIcon from '@mui/icons-material/HistoryRounded';
import DoneAllRoundedIcon from '@mui/icons-material/DoneAllRounded';
import ShareLocationRoundedIcon from '@mui/icons-material/ShareLocationRounded';
import LeaderboardRoundedIcon from '@mui/icons-material/LeaderboardRounded';
import SupervisorAccountRoundedIcon from '@mui/icons-material/SupervisorAccountRounded';
import CheckCircleRoundedIcon from '@mui/icons-material/CheckCircleRounded';
import RadioButtonCheckedRoundedIcon from '@mui/icons-material/RadioButtonCheckedRounded';
import SchoolRoundedIcon from '@mui/icons-material/SchoolRounded';
import WindowRoundedIcon from '@mui/icons-material/WindowRounded';
import CorporateFareRoundedIcon from '@mui/icons-material/CorporateFareRounded';
import { useState } from 'react';
import { Link } from 'react-router-dom';
import { CircularProgress } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import { authService } from '@/services/firebase/authService';

export default function Login() {
    const [selectedRole, setSelectedRole] = useState<'Supervisor' | 'Coordinador'>('Supervisor');
    const [isLoading, setIsLoading] = useState<boolean>(false);
    const navigate = useNavigate();

    const handleMicrosoftLogin = async () => {
        setIsLoading(true);

        try {
            console.log("NEXA_DEBUG: Iniciando flujo con Microsoft.....")

            const supervisorUser = await authService.loginWithMicrosoft();

            console.log("NEXA_DEBUG: Acceso autorizado para supervisor:", supervisorUser);

            navigate('/Dashboard');
        } catch (error: any) {
            console.log("NEXA_DEBUG: Error capturado en vista login", error.message);

            if (error.message?.includes('ACCESO_DENEGADO')) {
                navigate('/Unauthorized');
            } else {
                alert('No se pudo completar la autenticación institucional');
            }
        } finally {
            setIsLoading(false)
        }
    }

    return (
        <main className='min-h-screen w-full flex flex-col lg:flex-row bg-white'>
            <div className='flex flex-col flex-1 items-center justify-center px-6 py-12 sm:px-12 lg:flex-none lg:w-1/2' id='Container'>
                <div className='w-full max-w-md space-y-6 '>
                    <div className="flex items-center gap-3">
                        <div className='bg-blue-100/10 rounded-lg w-12 h-12 flex items-center justify-center  text-white'>
                            <HistoryRoundedIcon className='table-icon-landing' />
                        </div>
                        <span className='text-md  font-medium text-white ' id='span-title-logo'>NEXA UCA</span>
                    </div>
                    <div className='flex items-center pt-9 mb-4 '>
                        <h3 className='text-4xl font-medium text-white leading-tight' id='title-login'>Gestión de horas sociales, sin fricción.</h3>
                    </div>
                    <div className='flex items-center pt-2 mb-4'>
                        <span className='text-sm font-medium text-gray-500 leading-relaxed' id='paragraph'>Portal para supervisores de proyectos y coordinadores académicos</span>
                    </div>
                    <div className='space-y-6 pt-6'>
                        <div className="flex items-start gap-3 pt-9 mb-4">
                            <div className='bg-blue-100/10 rounded-lg w-15 h-14 flex items-center justify-center text-white'>
                                <DoneAllRoundedIcon />
                            </div>
                            <div className='flex flex-col justify-center'>
                                <span className='font-bold text-white' id='span-item'>Aprobación en un clic</span>
                                <p className='text-sm font-medium text-gray-500 leading-relaxed' id='paragraph'>Revisa y aprueba jornadas con toda la información en una sola vista</p>
                            </div>
                        </div>
                        <div className="flex items-start gap-3 pt-5 mb-4">
                            <div className='bg-blue-100/10 rounded-lg w-15 h-14 flex items-center justify-center text-white'>
                                <ShareLocationRoundedIcon />
                            </div>
                            <div className='flex flex-col justify-center'>
                                <span className='font-bold text-white' id='span-item'>Validación GPS</span>
                                <p className='text-sm font-medium text-gray-500 leading-relaxed' id='paragraph'>Cada registro verifica que el estudiante esté en el área autorizada</p>
                            </div>
                        </div>
                        <div className="flex items-start gap-3 pt-5 mb-4">
                            <div className='bg-blue-100/10 rounded-lg w-15 h-14 flex items-center justify-center text-white'>
                                <LeaderboardRoundedIcon />
                            </div>
                            <div className='flex flex-col justify-center'>
                                <span className='font-bold text-white' id='span-item'>Seguimiento en tiempo real </span>
                                <p className='text-sm font-medium text-gray-500 leading-relaxed' id='paragraph'>Consulta el progreso de cada  participante y proyecto al instante</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div className='hidden lg:flex lg:flex-1 items-start justify-start bg-[#30302E] p-8 sm:p-16 relative lg:w-1/2'>
                <div className='w-full max-w-md mx-auto my-auto space-y-8'>
                    <div className='space-y-3'>
                        <h2 className='text-4xl font-bold text-white leading-snug tracking-tight' id='title-login'>Iniciar sesión</h2>
                        <span className='text-sm font-medium text-gray-300 leading-relaxed' id='span-item'>Selecciona tu rol y accede con tu cuenta institucional</span>
                    </div>
                    <div className='w-full space-y-4'>
                        <span className='text-xs font-bold text-gray-400 tracking-widest uppercase block mb-2 ' id='span-item'>TU ROL</span>

                        <div onClick={() => setSelectedRole('Supervisor')} className={`flex items-center justify-between p-4 rounded-xl border cursor-pointer transition-all ${selectedRole === 'Supervisor'
                            ? 'border-[#3B82F6] bg-[#3B82F6]/5'
                            : 'border-gray-700 bg-[#21211F] hover:border-gray-600'
                            }`}>
                            <div className='flex items-center gap-4'>
                                <div className={`w-12 h-12 rounded-lg flex items-center justify-center shrink-0 ${selectedRole === 'Supervisor' ? 'bg-white text-[#2A2A27]' : 'bg-[#2A2A27] text-gray-400'
                                    }`}>
                                    <SupervisorAccountRoundedIcon />
                                </div>
                                <div className="flex flex-col">
                                    <span className='text-sm font-bold text-white' id='span-item'>Supervisor de proyecto</span>
                                    <span className='text-xs text-gray-400 mt-0.5' id='span-item'>Apruebo y gestiono horas sociales</span>
                                </div>
                            </div>
                            {selectedRole === 'Supervisor' ? (
                                <CheckCircleRoundedIcon className='text-[#3B82F6]' fontSize="small" />
                            ) : (
                                <RadioButtonCheckedRoundedIcon className='text-gray-600' fontSize="small" />
                            )}
                        </div>

                        <div onClick={() => setSelectedRole('Coordinador')} className={`flex items-center justify-between p-4 rounded-xl border cursor-pointer transition-all ${selectedRole === 'Coordinador'
                            ? 'border-[#3B82F6] bg-[#3B82F6]/5'
                            : 'border-gray-700 bg-[#21211F] hover:border-gray-600'
                            }`}>
                            <div className='flex items-center gap-4'>
                                <div className={`w-12 h-12  rounded-lg flex items-center justify-center shrink-0 ${selectedRole === 'Coordinador' ? 'bg-white text-[#2A2A27]' : 'bg-[#2A2A27] text-gray-400'
                                    }`}>
                                    <SchoolRoundedIcon />
                                </div>
                                <div className="flex  flex-col">
                                    <span className='text-sm font-bold text-white ' id='span-item'>Coordinador académico</span>
                                    <span className='text-xs text-gray-400 mt-0.5' id='span-item'>Superviso todos los proyectos del ciclo</span>
                                </div>
                            </div>
                            {selectedRole === 'Coordinador' ? (
                                <CheckCircleRoundedIcon className='text-[#3B82F6]' fontSize="small" />
                            ) : (
                                <RadioButtonCheckedRoundedIcon className='text-gray-600' fontSize="small" />
                            )}
                        </div>
                    </div>
                    <div className='pt-2'>
                        <Link
                            to={"/Dashboard"}
                            onClick={(e) => {
                                e.preventDefault();
                                if (!isLoading) {
                                    handleMicrosoftLogin();
                                }
                            }}
                            className={`w-full flex items-center justify-center gap-3 text-gray-400 border border-gray-400 rounded-xl p-3 hover:bg-[#3B82F6]/4 hover:text-white hover:transition-all hover:shrink-0 cursor-pointer ${isLoading ? 'opacity-40 cursor-not-allowed pointer-events-none' : ''
                                }`}
                        >
                            {isLoading ? (
                                <CircularProgress size={18} color="inherit" />
                            ) : (
                                <WindowRoundedIcon sx={{ fontSize: 18 }} />
                            )}
                            <span id='span-item'>
                                {isLoading ? 'Autenticando...' : 'Continuar con Microsoft 365'}
                            </span>
                        </Link>
                    </div>
                    <div className="border-t border-gray-700/60 pt-6 flex items-center gap-3 text-gray-400">
                        <div className="bg-black/15 rounded-lg w-10 h-10 flex items-center justify-center text-white">
                            <CorporateFareRoundedIcon className=' text-gray-500 shrink-0' />
                        </div>

                        <div className='flex  flex-col text-xs'>
                            <span className='font-bold text-gray-300' id='span-item'>Universidad Centroamericana</span>
                            <span className='text-gray-400 font-light' id='span-item'>José Simeón Cañas · Acceso Institucional</span>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    )
}