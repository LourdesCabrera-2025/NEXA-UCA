import ModalProject from '@/assets/components/modals/projectModal';
import '../../styles/index.css';
import AddRoundedIcon from '@mui/icons-material/AddRounded';
import { useState } from 'react';

export default function Programs() {

    const [isModalOpen, setIsModalOpen] = useState(false);

    return (
        <>
            <div className="flex gap-2 justify-between">
                <div className="flex flex-col items-start justify-between">
                    <span className="text-xs font-medium text-gray-400 tracking-tight uppercar pl-0.5" id='span-config'>Registro</span>
                    <span className='text-2xl font-bold text-gray-700 leading-snug' id='span-config'>Programas de servicio social</span>
                    <span className='w-full border border-gray-200 mt-2'/>
                </div>
                <button  className='flex items-center justify-center gap-2 border-blue-400 bg-[#056CF2] hover:bg-[#0597F2] activate:scale-[0.98] text-white text-sm font-semibold h-10 px-4 rounded-lg shadow-sm transition-all duration-150  cursor-pointer select-none'>
                    <span onClick={() => setIsModalOpen(true)}  id='span-config' >Registrar programa social</span>
                    <AddRoundedIcon sx={{ fontSize: 22 }} />
                </button>
            </div>
            <section className='w-full max-w-7xl mx-auto px-4 sm:px-6 lg:px-2  mt-20 mb-16'>
                <div className='grid grid-cols-1 md:grid-cols-3 gap-4'>
                    {/* Tarjeta 1 */}
                    <div className="bg-[#22252a] text-gray-300 py-6 rounded-lg font-medium shadow-sm border border-gray-800/40 flex items-center justify-center transition-all hover:bg-[#282c32] cursor-pointer">
                        1
                    </div>

                    {/* Tarjeta 2 */}
                    <div className="bg-[#22252a] text-gray-300 py-6 rounded-lg font-medium shadow-sm border border-gray-800/40 flex items-center justify-center transition-all hover:bg-[#282c32] cursor-pointer">
                        2
                    </div>

                    {/* Tarjeta 3 */}
                    <div className="bg-[#22252a] text-gray-300 py-6 rounded-lg font-medium shadow-sm border border-gray-800/40 flex items-center justify-center transition-all hover:bg-[#282c32] cursor-pointer">
                        3
                    </div>

                    {/* Tarjeta 4 */}
                    <div className="bg-[#22252a] text-gray-300 py-6 rounded-lg font-medium shadow-sm border border-gray-800/40 flex items-center justify-center transition-all hover:bg-[#282c32] cursor-pointer">
                        4
                    </div>

                    {/* Tarjeta 5 */}
                    <div className="bg-[#22252a] text-gray-300 py-6 rounded-lg font-medium shadow-sm border border-gray-800/40 flex items-center justify-center transition-all hover:bg-[#282c32] cursor-pointer">
                        5
                    </div>

                    {/* Tarjeta 6 */}
                    <div className="bg-[#22252a] text-gray-300 py-6 rounded-lg font-medium shadow-sm border border-gray-800/40 flex items-center justify-center transition-all hover:bg-[#282c32] cursor-pointer">
                        6
                    </div>
                </div>
            </section>
            <ModalProject isOpen={isModalOpen} onClose={() => setIsModalOpen(false)} />
        </>
    )
}