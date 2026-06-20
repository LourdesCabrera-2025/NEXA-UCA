import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import React from 'react';


interface CardMetrics {
    title: string;
    quantity: string;
    icon: React.ReactNode;
    isBlue?: boolean;
    isGreen?: boolean;
    isOrange?: boolean;
}

export default function CardMetrics({
    title = "",
    quantity = "0",
    icon,
    isBlue = false,
    isGreen = false,
    isOrange = false
}: CardMetrics) {

    const colorStyles = isBlue ? 'bg-[#2552EB]/20 text-[#1E318A]'
        : isGreen ? 'bg-[#01B839]/20 text-[#0A712B]'
            : isOrange ? 'bg-[#EA580C]/20 text-[#9A3412]'
                : 'bg-gray-100 text-gray-600';

    return (
        <Card className='bg-white border border-gray-300/40 px-4 shadow-sm w-full mt-3'
            sx={{
                borderRadius: '10px',
                boxShadow: '0px 1px 3px rgba(16,24,40,0.1), 0px 1px 2px rgba(16,24,40,0.06)'
            }}>
            <CardContent className='p-5 last:pb-5'>
                <div className='flex  items-start gap-4 w-full'>
                    <div className={`rounded-xl w-12 h-12 flex items-center justify-center shrink-0 transition-discrete ${colorStyles}`}>
                        {icon}
                    </div>
                    <div className='flex flex-col items-start text-left'>
                        <h4 className='text-xs font-semibold uppercase tracking-wider text-gray-500' id='span-config'>{title}</h4>
                        <span className='text-3xl font-bold tracking-tight text-gray-900 mt-1 leading-none'>{quantity}</span>
                    </div>

                </div>
            </CardContent>

        </Card>
    )
}