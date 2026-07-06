import '../../../styles/index.css';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import GroupsRoundedIcon from '@mui/icons-material/GroupsRounded';
import AccessTimeRoundedIcon from '@mui/icons-material/AccessTimeRounded';
import LocationOnRoundedIcon from '@mui/icons-material/LocationOnRounded';
import ChevronRightRoundedIcon from '@mui/icons-material/ChevronRightRounded';
import LinearProgress from '@mui/material/LinearProgress';
import { Box } from '@mui/material';
interface ProgramProps {
    title: string,
    type: string,
    description: string,
    currentStudents: number;
    maxStudents: number;
    totalHours: number;
    distance: number;
    progress: number;
    status: 'Activo' | 'Inactivo';
    onClick?: () => void;

}



export default function CardProgramResult({
    title,
    type,
    description,
    currentStudents,
    maxStudents,
    totalHours,
    distance,
    progress,
    status,
    onClick
}: ProgramProps) {

    return (
        <>
            <Card
                elevation={0}
                className='w-full max-w-sm rounded-2xl bg-white  p-2 border border-zinc-200 shadow-sm cursor-pointer' style={{ fontFamily: '"Inter", sans-serif' }} onClick={onClick}>
                <CardContent className='p-4 flex flex-col justify-between h-full '>
                    <div className='flex items-start justify-between gap-4'>
                        <h3 className='text-base font-bold leading-tight text-zinc-900'>
                            {title}
                        </h3>
                        <span className='shrink-0 rounded-full bg-zinc-100 px-2.5 py-1 text-xs font-medium text-zinc-600'>{type}</span>
                    </div>

                    <p className='mt-2.5 text-sm text-zinc-500 leading-relaxed line-clamp-2'>
                        {description}
                    </p>

                    <div className='mt-4 flex items-center gap-4 text-xs font-bold text-shadow-zinc-700'>
                        <div className='flex items-center gap-1'>
                            <GroupsRoundedIcon className='text-zinc-400 ' sx={{ fontSize: 18 }} />
                            <span className='text-black font-medium'>{currentStudents} <span className='text-zinc-400 font-normal'>/{maxStudents}</span></span>
                        </div>
                        <div className='flex items-center gap-1'>
                            <AccessTimeRoundedIcon className='text-zinc-400' sx={{ fontSize: 18 }} />
                            <span className='text-black font-medium'>{totalHours}h <span className='text-zinc-400 font-normal'>requeridas</span></span>
                        </div>
                        <div className='flex items-center gap-1'>
                            <LocationOnRoundedIcon className='text-zinc-400' sx={{ fontSize: 18 }} />
                            <span className='text-black font-medium '>{distance}</span>
                        </div>
                    </div>

                    <div className='mt-4 border-t border-zinc-100'></div>
                    <div className='mt-3.5 flex items-center justify-between gap-3'>
                        <span className='rounded-full bg-emerald-50 border border-emerald-200 px-2.5 py-0.5 text-xs font-bold text-emerald-600 uppercase tracking-wide'>
                            {status}
                        </span>
                        <Box sx={{ width: '100%', mx: 1 }}>
                            <LinearProgress
                                variant="determinate"
                                value={progress}
                                sx={{
                                    height: 6,
                                    borderRadius: 3,
                                    backgroundColor: '#E4E4E7', 
                                    '& .MuiLinearProgress-bar': {
                                        borderRadius: 3,
                                        backgroundColor: '#056CF2', 
                                    }
                                }}
                            />
                        </Box>
                        <span className='text-xs font-bold text-zinc-700'>{progress}</span>
                        <button className='flex w-full justify-center items-center text-zinc-400 hover:text-zinc-800 transition-colors cursor-pointer'>
                            <span className='w-fit text-xs'>ver detalles</span>
                            <ChevronRightRoundedIcon sx={{ fontSize: 20 }} />
                        </button>
                    </div>

                </CardContent>
            </Card>
        </>
    )
}