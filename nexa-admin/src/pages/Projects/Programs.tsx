import ModalProject from '@/assets/components/modals/projectModal';
import '../../styles/index.css';
import AddRoundedIcon from '@mui/icons-material/AddRounded';
import RefreshRoundedIcon from '@mui/icons-material/RefreshRounded';
import { useState } from 'react';
import CardProgramResult from '@/assets/components/Cards/CardPrograms';
import * as React from 'react';
import { Link, Navigate, Outlet, useLocation, useNavigate } from 'react-router-dom';
import type { GetProjectsData } from '@/dataconnect-generated';
import { ProgramService } from '@/services/firebase/programService';
import { GeneralAlert } from '@/assets/components/Alerts/Alerts';

export default function Programs() {

    const [isModalOpen, setIsModalOpen] = useState(false);
    const navigate = useNavigate();
    const handleCardClick = (projectId: string) => {
        navigate(`/Dashboard/Programas/${projectId}`)
    }
    const [program, setProgram] = useState<GetProjectsData['projects']>([]);
    const [alertOpen, setIsAlertOpen] = useState<boolean>(false);
    const [alertConfig, setAlertConfig] = useState({ type: 'success' as 'success' | 'error', title: '', message: '' });
    const [isRefreshing, setIsRefreshing] = useState<boolean>(false);

    const fetchPrograms = async () => {
        try {
            const data = await ProgramService.getAllProjects();
            setProgram([...data]);
        } catch (error) {
            setAlertConfig({
                type: "error",
                title: "Error",
                message: "No se pudieron cargar los programas."
            });
            setIsAlertOpen(true);
        }
    };

    React.useEffect(() => {
        fetchPrograms();
    }, []);

    const handleProgramCreated = (newProject: any) => {
        
        setProgram(prev => [...prev, newProject]);


        setAlertConfig({
            type: "success",
            title: "Éxito",
            message: "Programa registrado correctamente."
        });
        setIsAlertOpen(true);

  
        setTimeout(async () => {
            await fetchPrograms();
        }, 2000);
    };


    const handleModalMessage = (
        type: "success" | "error",
        title: string,
        message: string
    ) => {
        setAlertConfig({ type, title, message });
        setIsAlertOpen(true);
    };


    const handleManualRefresh = async () => {
        if (isRefreshing) return; 
        setIsRefreshing(true);
        try {
            await fetchPrograms();
        } finally {
            setIsRefreshing(false);
        }
    };

    return (
        <>
            <div className="flex gap-2 justify-between">
                <div className="flex flex-col items-start justify-between">
                    <span className='text-2xl font-bold text-gray-700 leading-snug' id='span-config'>Programas de servicio social</span>
                    <p className='text-xs text-zinc-400 mt-0.5' id='span-config'>Registra tus programas de servicio social y visualiza los detalles de cada uno</p>
                    <span className='w-full border border-gray-200 mt-2' />
                </div>
                <div className='flex items-center gap-2'>
                    <button
                        onClick={handleManualRefresh}
                        disabled={isRefreshing}
                        className='flex items-center justify-center gap-2 border border-gray-300 bg-white hover:bg-gray-50 text-gray-600 text-sm font-semibold h-10 px-4 rounded-lg shadow-sm transition-all duration-150 cursor-pointer select-none disabled:opacity-50 disabled:cursor-not-allowed'
                    >
                        <RefreshRoundedIcon
                            sx={{
                                fontSize: 20,
                                animation: isRefreshing ? 'spin 0.8s linear infinite' : 'none',
                                '@keyframes spin': {
                                    '0%': { transform: 'rotate(0deg)' },
                                    '100%': { transform: 'rotate(360deg)' },
                                },
                            }}
                        />
                        {isRefreshing ? 'Actualizando...' : 'Refrescar'}
                    </button>
                    <button className='flex items-center justify-center gap-2 border-blue-400 bg-[#056CF2] hover:bg-[#0597F2] activate:scale-[0.98] text-white text-sm font-semibold h-10 px-4 rounded-lg shadow-sm transition-all duration-150  cursor-pointer select-none'>
                        <span onClick={() => setIsModalOpen(true)} id='span-config' >Registrar programa social</span>
                        <AddRoundedIcon sx={{ fontSize: 22 }} />
                    </button>
                </div>
            </div>
            <section className='w-full max-w-7xl mx-auto px-4 sm:px-6 lg:px-2  mt-20 mb-16'>
                <div className='grid grid-cols-1 md:grid-cols-3 gap-4'>
                    {program.map((p) => (
                        <CardProgramResult
                            key={p.id}
                            title={p.name}
                            type={p.projectType?.name ?? "Sin tipo"}
                            description={p.description || "Sin descripción"}
                            currentStudents={0}
                            maxStudents={p.maxStudents}
                            totalHours={p.totalRequiredHours}
                            distance={p.allowedRadius}
                            progress={0}
                            status={p.isActive ? 'Activo' : 'Inactivo'}
                            onClick={() => handleCardClick(p.id)}
                        />
                    ))}
                </div>
            </section>
            <ModalProject
                isOpen={isModalOpen}
                onClose={() => setIsModalOpen(false)}
                onProjectCreated={handleProgramCreated}
                onSuccess={handleModalMessage}
            />
            <GeneralAlert
                isOpenAlert={alertOpen}
                onClose={() => setIsAlertOpen(false)}
                {...alertConfig}
            />
        </>
    )
}