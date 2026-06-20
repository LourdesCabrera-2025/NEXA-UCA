
import * as React from 'react';
import { PieChart } from '@mui/x-charts/PieChart';
import { useItemTooltip, ChartsTooltipContainer } from '@mui/x-charts/ChartsTooltip';


interface PieDataNode {
    id: number;
    value: number;
    label: string;
    color: string;
    detalles?: string; 
}


const dataGeneral: PieDataNode[] = [
    { id: 0, value: 68, label: 'Completadas', color: 'rgba(2,132,199,0.86)', detalles: 'Estudiantes que finalizaron su proceso'},
    { id: 1, value: 22, label: 'En Progreso', color: 'rgba(234,179,8,0.86)', detalles: 'Estudiantes activos acumulando horas'},
    { id: 2, value: 10, label: 'Rechazadas', color: 'rgba(185,28,20,0.86)'}
];



const totalDataMap = [...dataGeneral].reduce((acc, item) => {
    acc[item.id] = item;
    return acc;
}, {} as Record<number, PieDataNode>);



function CustomTooltipContent({ mousePos }: { mousePos: { x: number; y: number } }) {
    const tooltipData = useItemTooltip();


if (!tooltipData || mousePos.x <= 0 ||  mousePos.y === 0) {
        return null
    }

    const { value, color, identifier } = tooltipData;
    const itemId = (identifier as any)?.dataIndex; // 

    const nodoActivo = totalDataMap[itemId] || tooltipData

    return (
        <div
            className="fixed bg-white border border-gray-100 rounded-2xl shadow-xl p-4 min-w-[250px] pointer-events-none z-[9999]  animate-zoom-in "
            style={{
                top: mousePos.y + 12,
                left: mousePos.x + 12,
                willChange: 'top, left'
            }}
        >
            <span className="text-[10px] font-bold tracking-widest text-gray-400 uppercase block mb-1">
                Control de Horas
            </span>

            <h4 className="text-sm font-bold text-gray-900 mb-1 font-sans">
                {nodoActivo.label}
            </h4>

            <div className="border-t border-gray-100 my-2" />

            <div className="flex items-center justify-between gap-4 pt-1 text-sm">
                <div className="flex items-center gap-2 text-gray-600 font-medium">
                    <span
                        className="w-3 h-3 rounded-md block shadow-sm"
                        style={{ background: color || '#056CF2' }}
                    />
                    <span>Porcentaje:</span>
                </div>
                <span className="font-bold text-gray-950 text-base">
                    {nodoActivo.value}%
                </span>
            </div>
        </div>
    );
}

function CustomTooltip({ mousePos }: { mousePos: { x: number; y: number } }) {
    return (
        <div className="pointer-events-none">
            <ChartsTooltipContainer trigger="item">
                <CustomTooltipContent mousePos={mousePos} />
            </ChartsTooltipContainer>
        </div>
    );
}


export default function SocialHoursChart() {
    const [mousePos, setMousePos] = React.useState({ x: 0, y: 0 });

    return (
      
        <div 
            className="w-full h-[310px] cursor-pointer justify-center items-center"
            onMouseMove={(e) => setMousePos({ x: e.clientX, y: e.clientY })}
        >
            
                <PieChart className='flex items-center'
                    series={[
                        {
                            data: dataGeneral,
                            innerRadius: 50,
                            outerRadius: 100,
                            paddingAngle: 5,
                            cornerRadius: 5,
                            startAngle: -200,
                            endAngle:225,
                            cx: '50%',
                            cy: '50%',
                            highlightScope: { fade: 'global', highlight: 'item' },
                        },
                    ]}
                   
                    height={260} 
                    slots={{
                        tooltip: (props) => <CustomTooltip {...props} mousePos={mousePos} />
                    }}
                    slotProps={{
                        legend: {
                            direction: 'horizontal',
                            position: { vertical: 'middle', horizontal: 'center' },
                        },
                    }}
                    sx={{
                        '& .MuiChartsLegend-series': {
                            marginBottom: '6px !important',
                        },
                        '& .MuiChartsLegend-root text': {
                            fontFamily: 'sans-serif !important',
                            fontSize: '11px !important',
                            fill: '#0284c7 !important',
                            fontWeight: '500 !important'
                        }
                    }}
                />
           
        </div>
    );
}