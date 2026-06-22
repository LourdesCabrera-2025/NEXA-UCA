import '../../styles/index.css';
import AddRoundedIcon from '@mui/icons-material/AddRounded';
import CardDashboard from '@/assets/components/Cards/CardDashboard';
import CardMetrics from '@/assets/components/Cards/CardMetrics';
import FolderCopyIcon from '@mui/icons-material/FolderCopy';
import AccessTimeIcon from '@mui/icons-material/AccessTime';
import SchoolIcon from '@mui/icons-material/School';
import CardBarChart from '@/assets/components/Cards/CardBarchart';
import CardDonutChart from '@/assets/components/Cards/CardDonutChart';
import CardLineChart from '@/assets/components/Cards/CardLinechart';
import TableActivity from '@/assets/components/Tables/TableCurrentActivity';
export default function Dashboard() {


    return (
        <>
        
                <div className='flex gap-2 justify-between '>
                    <div className='flex flex-col items-start justify-between'>
                        <span className='text-xs font-medium text-gray-400 tracking-tight uppercase pl-0.5' id='span-config'>OVERVIEW</span>
                        <span className='text-2xl font-bold text-gray-700 leading-snug' id='span-config'>Dashboard</span>
                    </div>
                    <button className='flex items-center justify-center gap-2 border-blue-400 bg-[#056CF2] hover:bg-[#0597F2] activate:scale-[0.98] text-white text-sm font-semibold h-10 px-4 rounded-lg shadow-sm transition-all duration-150  cursor-pointer select-none'>
                        <span className='' id='span-config' >Generar nuevo reporte</span>
                        <AddRoundedIcon sx={{ fontSize: 22 }} />
                    </button>
                </div>
                <section className='w-full max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 mt-20 mb-16'>
                    <CardDashboard
                        title='Bienvenida, Olivia Rhye'
                        description='Tu tienes 5 nuevos mensajes y 2 nuevas notificaciones'
                        total_hours_approved='HORAS APROBADAS'
                        quantity_1='1,350'
                        total_hours_pending='HORAS PENDIENTES DE APROBAR'
                        quantity_2='14'
                        image='https://res.cloudinary.com/nexa2026/image/upload/v1781829266/undraw_reminders_o8j5_begzyl.svg' />
                    <div className='max-w-7xl border border-t border-gray-400/25 mt-6 mb-6'></div>
                    <div className='grid grid-cols-1 gap-4 lg:grid-cols-3 lg:gap-8 '>
                        <CardMetrics
                            title='PROGRAMAS ACTIVOS'
                            quantity='120'
                            icon={<FolderCopyIcon sx={{ fontSize: 22 }} />}
                            isBlue={true}
                        />
                        <CardMetrics
                            title='ESTUDIANTES ACTIVOS'
                            quantity='120'
                            icon={<SchoolIcon sx={{ fontSize: 22 }} />}
                            isGreen={true}
                        />
                        <CardMetrics
                            title='HORAS REGISTRADAS DEL MES'
                            quantity='120'
                            icon={<AccessTimeIcon sx={{ fontSize: 22 }} />}
                            isOrange={true}
                        />
                    </div>
                    <CardBarChart
                        title='PROGRAMAS MÁS INSCRITOS' />
                    <div className='grid grid-cols-1 gap-4 lg:grid-cols-2 lg:gap-8 mt-6 mb-6'>
                        <CardDonutChart
                            title='ESTADO DE SOLICITUDES' />
                        <CardLineChart
                            title='HORAS REGISTRADAS POR MES' />
                    </div>

                    <div className=' justify-start items-start pt-6'>
                        <h4 className='text-2xl font-bold text-gray-700 leading-snug' id='span-config'>Registros  recientes</h4>
                        <div className='mt-4 mb-6'>
                            <TableActivity />
                        </div>
                    </div>
                </section>
        </>
    )
}