import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import ProgramsChart from '../Charts/Barcharts/ProjectStudent';

interface CardBarCharts {
    title: string;
}

export default function CardBarChart ({
    title = ""

} : CardBarCharts) {

    return(
        <Card className='bg-white border border-gray-300/40 px-4 shadow-sm w-full mt-6'
        sx={{
            borderRadius: '10px',
            boxShadow: '0px 1px 3px rgba(16,24,40,0.1), 0px 1px 2px rgba(16,24,40,0.06)'
        }}>
        <CardContent className='p-5 last:pb-5'>
            <div className='flex flex-col justify-start items-start'>
                <h4 className='text-xs font-semibold uppercase tracking-wider text-gray-500' id='span-config'>{title}</h4>
                <ProgramsChart />
            </div>
        </CardContent>

        </Card>
    )
}