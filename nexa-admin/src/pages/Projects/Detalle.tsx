
import ProgramHeaderCard from '@/assets/components/Cards/ProgramHeaderCard';
import '../../styles/index.css';
import AddRoundedIcon from '@mui/icons-material/AddRounded';
import * as React from 'react';
import ParticipantsTable from '@/assets/components/Tables/TableParticipant';
import PeopleAltIcon from '@mui/icons-material/PeopleAlt';
import AccessTimeRoundedIcon from '@mui/icons-material/AccessTimeRounded';
import CalendarMonthRoundedIcon from '@mui/icons-material/CalendarMonthRounded';
import MyLocationRoundedIcon from '@mui/icons-material/MyLocationRounded';
import { TextField, Box } from '@mui/material';
import SearchRoundedIcon from '@mui/icons-material/SearchRounded';
import ModalEnrollStudent from '@/assets/components/modals/ModalEnrollmentStudent';
export default function DetalleProgram() {
    const [isModalOpen, setIsModalOpen] = React.useState(false);
    const [searchQuery, setSearchQuery] = React.useState('');

    const programaData = {
        title: 'Biblioteca de Teología',
        description: 'Catalogación y organización del fondo bibliográfico del área de teología',
        status: 'Activo',
        type: 'Servicio social',
        supervisor: 'Ing. Alvaro García',
        coordinates: '13.6719, -89.2367',
        maxHoursPerDay: 8
    }

    const estudiantes = [
        { id: '1', nombre: 'Gabriela Maldonado', cuenta: '#NXS0001', horas: 72, estado: 'En curso' as const, ultimaActividad: 'Ayer 10:30 am' },
        { id: '2', nombre: 'María de Leon', cuenta: '#NXS0034', horas: 20, estado: 'Atrasado' as const, ultimaActividad: 'Ayer 10:30 am' },
        { id: '3', nombre: 'José Carbajal', cuenta: '#NXS0034', horas: 40, estado: 'Atrasado' as const, ultimaActividad: 'Ayer 10:30 am' },
        { id: '4', nombre: 'María de Leon', cuenta: '#NXS0034', horas: 20, estado: 'Atrasado' as const, ultimaActividad: 'Ayer 10:30 am' }
    ]

    const estudianteFiltrados = estudiantes.filter(estudiante => {
        return (
            estudiante.nombre.toLowerCase().includes(searchQuery.toLowerCase()) ||
            estudiante.cuenta.toLowerCase().includes(searchQuery.toLowerCase())
        );
    })

    return (
        <>
            <div className="flex gap-2 justify-between">
                <div className="flex flex-col items-start justify-between">
                    <span className="text-xs font-medium text-gray-400 tracking-tight uppercar pl-0.5" id='span-config'>Overview</span>
                    <span className='text-2xl font-bold text-gray-700 leading-snug' id='span-config'>Detalle de programa</span>
                    <span className='w-full border border-gray-200 mt-2' />
                </div>
                <button className='flex items-center justify-center gap-2 border-blue-400 bg-[#056CF2] hover:bg-[#0597F2] activate:scale-[0.98] text-white text-sm font-semibold h-10 px-4 rounded-lg shadow-sm transition-all duration-150  cursor-pointer select-none'>
                    <span onClick={() => setIsModalOpen(true)} id='span-config' >Inscribir estudiante</span>
                    <AddRoundedIcon sx={{ fontSize: 22 }} />
                </button>
            </div>
            <section className="w-full max-w-7xl mx-auto flex flex-col gap-6 text-gray-700 mt-20">
                <ProgramHeaderCard {...programaData} />

                <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-4">
                    {/* Participantes */}
                    <div className="bg-[#FFFFFF] p-4 rounded-2xl border border-zinc-200 flex flex-col gap-1 shadow-sm">
                        <span className="text-xs text-zinc-500 font-medium flex items-center gap-1.5">
                            <PeopleAltIcon sx={{ fontSize: 16, color: '#71717A' }} /> Participantes
                        </span>
                        <span className="text-xl font-bold text-zinc-900 mt-1">
                            12 <span className="text-sm text-zinc-400 font-normal">/20</span>
                        </span>
                    </div>

                    {/* Horas requeridas */}
                    <div className="bg-[#FFFFFF] p-4 rounded-2xl border border-zinc-200 flex flex-col gap-1 shadow-sm">
                        <span className="text-xs text-zinc-500 font-medium flex items-center gap-1.5">
                            <AccessTimeRoundedIcon sx={{ fontSize: 16, color: '#71717A' }} /> Horas requeridas
                        </span>
                        <span className="text-xl font-bold text-zinc-900 mt-1">300h</span>
                    </div>

                    {/* Vigencia */}
                    <div className="bg-[#FFFFFF] p-4 rounded-2xl border border-zinc-200 flex flex-col gap-1 shadow-sm">
                        <span className="text-xs text-zinc-500 font-medium flex items-center gap-1.5">
                            <CalendarMonthRoundedIcon sx={{ fontSize: 16, color: '#71717A' }} /> Vigencia
                        </span>
                        <span className="text-base font-bold text-zinc-900 mt-1">Ene — Jun 2026</span>
                    </div>

                    {/* Radio GPS */}
                    <div className="bg-[#FFFFFF] p-4 rounded-2xl border border-zinc-200 flex flex-col gap-1 shadow-sm">
                        <span className="text-xs text-zinc-500 font-medium flex items-center gap-1.5">
                            <MyLocationRoundedIcon sx={{ fontSize: 16, color: '#71717A' }} /> Radio GPS
                        </span>
                        <span className="text-xl font-bold text-zinc-900 mt-1">100m</span>
                    </div>
                </div>
                <Box sx={{ width: '100%', maxWidth: '360px', mt: 2 }}>
                    <TextField
                        fullWidth
                        size='small'
                        placeholder='Buscar estudiante por nombre o carnet ...'
                        value={searchQuery}
                        onChange={(e) => setSearchQuery(e.target.value)}
                        slotProps={{
                            input: {
                                startAdornment: <SearchRoundedIcon sx={{ color: '#71717A', mr: 1, fontSize: 20 }} />
                            }
                        }}
                        sx={{
                            backgroundColor: '#FFFFFF',
                            '& .MuiInputBase-input': {
                                fontFamily: '"Inter" ,sans-serif',
                                fontSize: '14px',
                                color: '#18181B'
                            },
                            '& .MuiInputBase-input::placeholder': {
                                fontFamily: '"Inter", sans-serif',
                                opacity: 1
                            },
                            '& .MuiOutlinedInput-root': {
                                borderRadius: '12px',
                                '& fieldset': {

                                    borderColor: '#E4E4E7'
                                },
                                '&:hover fieldset': {
                                    borderColor: '#A1A1AA'
                                },
                                '&.Mui-focused fieldset': {
                                    borderColor: '#056CF2'
                                }
                            }
                        }} />
                </Box>
                <ParticipantsTable estudiantes={estudianteFiltrados} />
            </section>

            <ModalEnrollStudent 
            open={isModalOpen}
            onClose={() => setIsModalOpen(false)}
            programTitle={programaData.title}/>
        </>
    )
}