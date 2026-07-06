import PeopleAltRoundedIcon from '@mui/icons-material/PeopleAltRounded';
import CheckCircleRoundedIcon from '@mui/icons-material/CheckCircleRounded';
import AccessTimeRoundedIcon from '@mui/icons-material/AccessTimeRounded';
import WarningAmberRoundedIcon from '@mui/icons-material/WarningAmberRounded';
import '../../../styles/index.css';

export default function StudentStats() {

    const stats = [
        {title: 'Total estudiantes', value: '45', desc: 'En todos tus programas', icon: <PeopleAltRoundedIcon sx={{color: '#056CF2'}}/>, bgIcon: 'bg-blue-50'},
        {title: 'Activos', value:'34', desc: '71% del total', icon: <CheckCircleRoundedIcon sx={{color: '#16A34A'}}/>, bgIcon: 'bg-green-50'},
        {title: 'En curso', value: '10', desc: '21% del total', icon: <AccessTimeRoundedIcon sx={{color:'#EAB308'}}/>, bgIcon: 'bg-yellow-50'},
        {title: 'Atrasados', value: '4', desc: '8% del total', icon: <WarningAmberRoundedIcon sx={{color: '#EF4444'}}/> , bgIcon: 'bg-red-50'}
    ];


    return(
        <div className='grid grid-cols-1 sm:grid-cols-2 md:grid-cols-4 gap-4 mt-6 ' style={{fontFamily: '"Inter", sans-serif'}}>
            {stats.map((stat, i) => (
                <div key={i} className='bg-white p-4 rounded-2xl border border-zinc-200 flex items-start gap-4 shadow-sm'>
                    <div className={`p-3 rounded-xl ${stat.bgIcon} flex items-center justify-center shrink-0`}>
                        {stat.icon}
                    </div>
                    <div className='flex flex-col gap-0.5'>
                        <span className='text-xs text-zinc-400 font-medium'>{stat.title}</span>
                        <span className='text-2xl font-bold text-zinc-900'>{stat.value}</span>
                        <span className='text-[11px] text-zinc-400'>{stat.desc}</span>
                    </div>
                </div>
            ))}
        </div>
    )
}