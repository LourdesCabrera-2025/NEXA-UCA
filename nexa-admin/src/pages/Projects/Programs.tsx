import ModalProject from '@/assets/components/modals/projectModal';
import '../../styles/index.css';
import AddRoundedIcon from '@mui/icons-material/AddRounded';
import { useState } from 'react';
import CardProgramResult from '@/assets/components/Cards/CardPrograms';
import * as React from 'react';
import { Link, Navigate, Outlet, useLocation, useNavigate } from 'react-router-dom';

export default function Programs() {

    const [isModalOpen, setIsModalOpen] = useState(false);
    const navigate = useNavigate();
    const handleCardClick = () => {
        navigate('/Dashboard/Programas/detalle-id')
    }

    return (
        <>
            <div className="flex gap-2 justify-between">
                <div className="flex flex-col items-start justify-between">
                    <span className="text-xs font-medium text-gray-400 tracking-tight uppercar pl-0.5" id='span-config'>Registro</span>
                    <span className='text-2xl font-bold text-gray-700 leading-snug' id='span-config'>Programas de servicio social</span>
                    <span className='w-full border border-gray-200 mt-2' />
                </div>
                <button className='flex items-center justify-center gap-2 border-blue-400 bg-[#056CF2] hover:bg-[#0597F2] activate:scale-[0.98] text-white text-sm font-semibold h-10 px-4 rounded-lg shadow-sm transition-all duration-150  cursor-pointer select-none'>
                    <span onClick={() => setIsModalOpen(true)} id='span-config' >Registrar programa social</span>
                    <AddRoundedIcon sx={{ fontSize: 22 }} />
                </button>
            </div>
            <section className='w-full max-w-7xl mx-auto px-4 sm:px-6 lg:px-2  mt-20 mb-16'>
                <div className='grid grid-cols-1 md:grid-cols-3 gap-4'>

                    <CardProgramResult
                        title='Biblioteca de Teología'
                        type='Servicio social'
                        description='Catalogación y organización del fondo bibliográfico del área de teología'
                        currentStudents={10}
                        maxStudents={40}
                        totalHours={300}
                        distance={100}
                        progress={78}
                        status='Activo' 
                        onClick={handleCardClick}/>



                </div>
            </section>
            <ModalProject isOpen={isModalOpen} onClose={() => setIsModalOpen(false)} />
        </>
    )
}