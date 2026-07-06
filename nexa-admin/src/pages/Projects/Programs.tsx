import ModalProject from '@/assets/components/modals/projectModal';
import '../../styles/index.css';
import AddRoundedIcon from '@mui/icons-material/AddRounded';
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
    const handleCardClick = () => {
        navigate('/Dashboard/Programas/detalle-id')
    }
    const [program, setProgram] = useState<GetProjectsData['projects']>([]);
    const [alertOpen, setIsAlertOpen] = useState<boolean>(false);
    const [alertConfig, setAlertConfig] = useState({ type: 'success' as 'success' | 'error', title: '', message: '' });

    

    React.useEffect(() => {
        const fetchPrograms = async () => {
            try {
                const data = await ProgramService.getAllProjects();
                setProgram(data);
            } catch (error) {
                setAlertConfig({ type: 'error', title: 'Error', message: 'Ocurrió un error al registrar el programa. ' });
                setIsAlertOpen(true);
            }
        };
        fetchPrograms();
    }, [isModalOpen]);

    return (
        <>
            <div className="flex gap-2 justify-between">
                <div className="flex flex-col items-start justify-between">
                    <span className='text-2xl font-bold text-gray-700 leading-snug' id='span-config'>Programas de servicio social</span>
                    <p className='text-xs text-zinc-400 mt-0.5' id='span-config'>Registra tus programas de servicio social y visualiza los detalles de cada uno</p>
                    <span className='w-full border border-gray-200 mt-2' />
                </div>
                <button className='flex items-center justify-center gap-2 border-blue-400 bg-[#056CF2] hover:bg-[#0597F2] activate:scale-[0.98] text-white text-sm font-semibold h-10 px-4 rounded-lg shadow-sm transition-all duration-150  cursor-pointer select-none'>
                    <span onClick={() => setIsModalOpen(true)} id='span-config' >Registrar programa social</span>
                    <AddRoundedIcon sx={{ fontSize: 22 }} />
                </button>
            </div>
            <section className='w-full max-w-7xl mx-auto px-4 sm:px-6 lg:px-2  mt-20 mb-16'>
                <div className='grid grid-cols-1 md:grid-cols-3 gap-4'>
                    {program.map((p) => (
                        <CardProgramResult
                            key={p.id}
                            title={p.name}
                            type={p.projectType.name}
                            description={p.description || "Sin descripción"}
                            currentStudents={0} 
                            maxStudents={p.maxStudents}
                            totalHours={p.totalRequiredHours}
                            distance={p.allowedRadius}
                            progress={0}
                            status={p.isActive ? 'Activo' : 'Inactivo'}
                            onClick={handleCardClick}
                        />
                    ))}
                </div>
            </section>
            <ModalProject isOpen={isModalOpen} onClose={() => setIsModalOpen(false)} />
            <GeneralAlert
                isOpenAlert={alertOpen}
                onClose={() => setIsAlertOpen(false)}
                {...alertConfig}
            />
        </>
    )
}