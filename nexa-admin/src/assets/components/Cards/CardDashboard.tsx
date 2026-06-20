import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';


interface CardDashboardProps {
    title: string;
    description: string;
    total_hours_approved: string;
    quantity_1: string;
    total_hours_pending: string;
    quantity_2: string;
    image: string;
}

export default function CardDashboard({
    title = "",
    description = "",
    total_hours_approved = "",
    quantity_1 = "0",
    total_hours_pending = "",
    quantity_2 = "0",
    image = "",
}: CardDashboardProps) {

    return (
        <Card
            className='bg-white  border border-gray-300/40 px-4 shadow-sm w-full'
            sx={{
                borderRadius: '12px',
                boxShadow: '0px 1px 3px rgba(16,24,40,0.1), 0px 1px 2px rgba(16,24,40,0.06)'

            }}>
            <CardContent className='p-6 flex flex-col justify-between h-full last:pb-6'>
                <div className='flex flex-col md:flex-row  gap-8 items-start justify-between mb-6 text-left w-full'>
                    <div className='flex flex-col gap-1.5  pt-2'>
                        <h4 className='text-4xl font-bold text-gray-900 tracking-tight ' id='span-config'>
                            {title}
                        </h4>
                        <p className='text-sm font-normal leading-relaxed text-gray-600' id='span-config'>
                            {description}
                        </p>
                    </div>

                    {image && (
                        <div className='flex justify-center md:justify-center w-full md:w-auto shrink-0 md:pr-60  '>
                            <img src={image} alt={title} className='w-full max-w-[280px] rounded-lg object-contain shrink-0 '  />
                        </div>
                    )}
                </div>
                <div className='flex items-center gap-6 pt-4 border-t border-gray-300'>
                    <div className='flex items-center gap-6 pt-4'>
                        <div className='flex flex-col items-start'>
                            <span className='text-2xl font-bold text-gray-950 tracking-tight' id='span-config'>
                                {quantity_1}
                            </span>
                            <span className='text-xs font-medium text-gray-500 mt-0.5' id='span-config'>
                                {total_hours_approved}
                            </span>
                        </div>
                        <div className='h-14 w-[1px] bg-gray-400'></div>
                        <div className='flex flex-col items-start'>
                            <span className='text-2xl font-bold text-gray-950 tracking-tight' id='span-config'>
                                {quantity_2}
                            </span>
                            <span className='text-xs font-medium text-gray-500 mt-0.5'  id='span-config'> 
                                {total_hours_pending}
                            </span>
                        </div>
                    </div>
                </div>
            </CardContent>

        </Card>
    )
}


