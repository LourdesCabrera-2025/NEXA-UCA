import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import SocialHoursChart from '../Charts/DonutCharts/StatusHours';

interface CardDonutCharts {
    title: string;
}

export default function CardDonutChart({
    title = ""

}: CardDonutCharts) {

    return (
        <Card className='bg-white border border-gray-300/40 px-4 shadow-sm w-full  mt-3'
            sx={{
                borderRadius: '10px',
                boxShadow: '0px 1px 3px rgba(16,24,40,0.1), 0px 1px 2px rgba(16,24,40,0.06)'
            }}>
            <CardContent className='p-6 last:pb-6'>
                <div className='flex justify-start items-start'>
                    <h4 className='text-xs font-semibold uppercase tracking-wider text-gray-500' id='span-config'>{title}</h4>
                </div>
                <div className='items-center mt-4'>
                    <SocialHoursChart />
                </div>
            </CardContent>

        </Card>
    )
}