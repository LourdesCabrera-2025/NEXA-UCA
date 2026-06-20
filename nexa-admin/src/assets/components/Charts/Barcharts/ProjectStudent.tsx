import * as React from 'react';
import { BarChart } from '@mui/x-charts/BarChart';
import type { BarChartProps } from '@mui/x-charts/BarChart';
import { useItemTooltip, ChartsTooltipContainer } from '@mui/x-charts/ChartsTooltip';

interface ProyectoData {
    program: string;
    inscritos: number;
}

const datasetMock: ProyectoData[] = [
{ program: 'Alfabetización', inscritos: 45 },
    { program: 'Reforestación', inscritos: 32 },
    { program: 'Soporte TI', inscritos: 28 },
    { program: 'Clases Inglés', inscritos: 54 },
    { program: 'Adulto Mayor', inscritos: 18 },
];

function CustomTooltipContent({ mousePos }: { mousePos: { x: number; y: number } }) {
    const tooltipData = useItemTooltip();

if (!tooltipData) {
        return <div className="fixed pointer-events-none" style={{ top: mousePos.y, left: mousePos.x }} />;
    }

    const { label, value, color, identifier } = tooltipData;

    const index = identifier ? (identifier as any).dataIndex : null; 

    const nombrePrograma = typeof index === 'number' && datasetMock[index] 
        ? datasetMock[index].program 
        : "Cargando...";

    const numericValue = typeof value === 'number' ? value : (value as any)?.y ?? 0;

    return (
        <div 
           
            className="fixed bg-white border border-gray-100 rounded-2xl shadow-xl p-4 min-w-[240px] pointer-events-none z-[9999]"
            style={{
                top: mousePos.y + 12,
                left: mousePos.x + 12,
        
                transition: 'top 0.08s ease-out, left 0.08s ease-out',
                willChange: 'top, left'
            }}
        >
      
            <span className="text-[10px] font-bold tracking-widest text-gray-400 uppercase block mb-1" id='span-config'>
                Programa Social
            </span>

          
            <h4 className="text-base font-bold text-gray-900 mb-2 font-sans"id='span-config'>
                {nombrePrograma}
            </h4>

          
            <div className="border-t border-gray-100 my-2" />

         
            <div className="flex items-center justify-between gap-4 pt-1 text-sm">
                <div className="flex items-center gap-2 text-gray-600 font-medium">
                   
                    <span 
                        className="w-3 h-3 rounded-md block shadow-sm" id='span-config'
                        style={{ background: color }} 
                    />
                    <span>Estudiantes Inscritos:</span>
                </div>
                <span className="font-bold text-gray-950 text-base" id='span-config'>
                    {numericValue}
                </span>
            </div>
        </div>
    );
}

function CustomTooltip({ mousePos }: { mousePos: { x: number; y: number } }) {
    return (
        <ChartsTooltipContainer trigger="item">
            <CustomTooltipContent mousePos={mousePos} />
        </ChartsTooltipContainer>
    );
}

const customBarChartStyles: Partial<BarChartProps> = {
    sx: {
       
        '& rect.MuiBarElement-root': {
            fillOpacity: 0.5,
            transition: 'fill-opacity 0.2s ease, fill 0.2s ease'
        },

        '& rect.MuiBarElement-root[data-highlighted="true"]': {
            fill: '#0d36a2 !important', 
            fillOpacity: 1
        },

        '& rect.MuiBarElement-root[data-faded="true"]': {
            fillOpacity: 0.2
        }
    }
};

const valueFormatter = (value: number | null) => `${value} estudiantes`;

export default function ProgramsChart() {
    const [mousePos, setMousePos] = React.useState({ x: 0, y: 0 });

    return (
        <div
            className='w-full h-[260px]'
            onMouseMove={(e) => setMousePos({ x: e.clientX, y: e.clientY })}
        >
            <BarChart
                className='cursor-pointer'
                dataset={datasetMock as any[]}
                xAxis={[
                    {
                        dataKey: 'program',
                        scaleType: 'band',
                        tickPlacement: 'middle',
                        tickLabelPlacement: 'middle'
                    }
                ]}
                series={[
                    {
                        dataKey: 'inscritos',
                        valueFormatter,
                        color: 'rgba(0,60,255, 0.7)',
                        highlightScope: {
                            highlight: 'item',
                            fade: 'global'
                        },
                        
                    }
                ]}
                borderRadius={8}
                margin={{ top: 10, bottom: 30, left: 40, right: 10 }}
                height={260}
                slots={{
                    tooltip: (props) => <CustomTooltip {...props} mousePos={mousePos} />
                }}
                slotProps={{
                    tooltip: { trigger: 'item' }
                }}
                {...customBarChartStyles}
            />
        </div>
    );
}