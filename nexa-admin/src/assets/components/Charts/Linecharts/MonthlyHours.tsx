import * as React from 'react';
import { LineChart } from '@mui/x-charts/LineChart';
import { useItemTooltip, ChartsTooltipContainer } from '@mui/x-charts';


interface HoursChartData {
    id: number;
    label: string;
    value: number
}


const dataMonthly: HoursChartData[] = [
    { id: 0, label: 'Ene', value: 120 },
    { id: 1, label: 'Feb', value: 385 },
    { id: 2, label: 'Mar', value: 240 },
    { id: 3, label: 'Abr', value: 310 },
    { id: 4, label: 'May', value: 425 },
    { id: 5, label: 'Jun', value: 510 },
    { id: 6, label: 'Jul', value: 590 }
]

const totalDataMap = [...dataMonthly].reduce((acc, item) => {
    acc[item.id] = item;
    return acc;
}, {} as Record<number, HoursChartData>)

function CustomTooltipContent({ mousePos }: { mousePos: { x: number; y: number } }) {

    const tooltipData = useItemTooltip();

    if (!tooltipData || mousePos.x <= 0 || mousePos.y <= 0) {
        return null
    }

    const { value, label, color, identifier } = tooltipData;
    const itemId = (identifier as any)?.dataIndex;

    const data = totalDataMap[itemId] || tooltipData

    return (
        <div className='fixed bg-white border border-gray-100 rounded-2xl shadow-xl p-4 min-w-[250px] pointer-events-none z-[9999] animate-zoom-in'
            style={{
                top: mousePos.y + 12,
                left: mousePos.x + 12,
                willChange: 'top, left'
            }}>

            <span className='text-[10px] font-bold tracking-widest text-gray-400 uppercase block mb-1'>
                Control de Horas Mensuales
            </span>

            <h4 className='text-sm font-bold text-gray-900 mb-1 font-sans'>
                {data.label}
            </h4>

            <div className='border-t border-gray-100 my-2' />
            <div className='flex items-center justify-between gap-4 pt-1 text-sm'>
                <div className='flex items-center gap-2 text-gray-600 font-medium'>
                    <span className='w-3 h-3 rounded-md block shadow-sm'
                        style={{
                            background: color || '#056CF2'
                        }} />
                    <span>Horas Mensuales:</span>
                </div>
                <span className='font-bold text-gray-950 text-base'>
                    {data.value}h
                </span>
            </div>
        </div>
    )
}

function CustomTooltip({ mousePos }: { mousePos: { x: number; y: number } }) {
    return (
        <div className='pointer-events-none'>
            <ChartsTooltipContainer trigger='item'>
                <CustomTooltipContent mousePos={mousePos} />
            </ChartsTooltipContainer>
        </div>
    )
}


export default function MonthlyHoursChart() {

    const [mousePos, setMousePos] = React.useState({ x: 0, y: 0 });

    return (
        <div className='w-full h-[310px] cursor-pointer justify-center items-center'
            onMouseMove={(e) => setMousePos({ x: e.clientX, y: e.clientY })}>
            <LineChart 
                xAxis={[
                    {
                        data: dataMonthly.map(item => item.label),
                        scaleType: 'point'
                    }
                ]}
                series={[
                    {
                        data: dataMonthly.map(item => item.value),
                        label: 'Horas Sociales',
                        curve: 'natural',
                        color: '#0284c7',
                        showMark: ({index}) =>index % 1 === 0
                        
                    },
                ]}
                height={300}
                slots={
                    {
                        tooltip: (props) => <CustomTooltip {...props} mousePos={mousePos} />
                    }
                } />
        </div>
    )
}