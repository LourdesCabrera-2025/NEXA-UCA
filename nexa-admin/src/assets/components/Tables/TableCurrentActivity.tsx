
import { DataGrid, type GridColDef, type GridRowsProp } from '@mui/x-data-grid';
import Avatar from '@mui/material/Avatar';
import '../../../styles/index.css';


const Estados_Config: Record<string, { colorCircle: string; colorText: string, }> = {
    'Completado': {
        colorCircle: 'bg-emerald-500',
        colorText: 'text-emerald-700'
    },
    'Pendiente': {
        colorCircle: 'bg-amber-500',
        colorText: 'text-amber-700'
    },
    'Rechazado': {
        colorCircle: 'bg-rose-500',
        colorText: 'text-rose-700'
    }
}

const Programs_Config: Record<string, { badgeStyles: string }> = {
    'Viva la UCA': {
        badgeStyles: 'bg-purple-200 text-purple-700 border-purple-400/60',
    },
    'Programa Ellacuría': {
        badgeStyles: 'bg-blue-200 text-blue-700 border-blue-400/60',
    },
    'Biblioteca Monseñor Romero': {
        badgeStyles: 'bg-orange-200 text-orange-700 border-orange-400/60',

    },
    'Programa de Instructoria': {
        badgeStyles: 'bg-pink-200 text-pink-700 border-pink-400/60'
    }
}


const columns: GridColDef[] = [
    {
        field: 'usuario',
        headerName: 'Usuario',
        flex: 1,
        minWidth: 196,
        renderCell: (params) => {
            const { nombre, avatarUrl } = params.value || { nombre: params.row.col1, avatarUrl: '' };

            return (
                <div className='flex items-center gap-3 h-full '>
                    <Avatar
                        src={avatarUrl}
                        alt={nombre}
                        sx={{
                            width: 32,
                            height: 32,
                            fontSize: '13px',
                            fontWeight: 600,
                            backgroundColor: '#787a7b',
                            color: '1px solid #E2E8F0'
                        }}>
                        {nombre ? nombre.charAt(0) : 'U'}
                    </Avatar>
                    <span className='font-medium text-slate-800 text-[13px] '>{nombre}</span>
                </div>
            )
        }
    },
    {
        field: 'col2',
        headerName: 'Proyecto',
        flex: 1,
        minWidth: 190,
        renderCell: (params) => {
            const programaActual = params.row.col2 || '';

            const config = Programs_Config[programaActual] || {
                badgeStyles: 'bg-slate-50 text-slate-700 border-slate-200/60'
            }
            return (
                <div style={{display: 'flex', alignItems: 'center', height: '60%', marginLeft: '5px'}}>
                    <span className={`${config.badgeStyles}`} style={{
                        display: 'inline-flex',
                        alignItems: 'center',
                        padding: '2px 10px',
                        borderRadius: '10px',
                        width: 'fit-content',
                        fontSize: '11px',
                        lineHeight: '16px',
                        maxHeight: '20px',
                        fontWeight: 600
                    }}>
                        {programaActual}
                    </span>
                </div>
            )
        }
    },
    {
        field: 'col3',
        headerName: 'Fecha y Hora',
        flex: 1.5,
        minWidth: 120,
        align: 'center',
        headerAlign: 'center',
        renderCell: (params) => {
            return (
                <span className='text-slate-500 text-[12px] '>{params.value}</span>
            )
        }
    },
    {
        field: 'col4',
        headerName: 'Duración',
        flex:0.4,
        minWidth: 110,
        align: 'center',
        headerAlign: 'center',
        renderCell: (params) => {
            return(
                <span className='text-slate-600 font-semibold text-[12px]'>{params.value}</span>
            )
        }

    },
    {
        field: 'col5',
        headerName: 'Descripción',
        flex: 3,
        minWidth: 140,
        renderCell: (params) => {
            return (
                <span className='text-slate-500 text-[12px]' id='span-config'>{params.value}</span>
            )
        }

    },
    {
        field: 'col6',
        headerName: 'Validación ',
        flex: 1.4,
        width: 130,

        renderCell: (params) => {
            const estadoActual = params.row.col6 || '';

            const config = Estados_Config[estadoActual] ||  {
                colorCircle: 'bg-slate-400',
                colorText: 'text-slate-600'
            }
            return (
                <div className='flex items-center gap-2  h-full my-auto'>
                    <span className={`w-3.5 h-3.5 rounded-full inline-block shrink-0 ${config.colorCircle
                        }`} id='span-config'>
                    </span>
                    <span className={`text-[13px] font-medium  ${config.colorText
                        }`}>
                        {estadoActual}
                    </span>
                </div>
            )
        }
    }
];

const rows: GridRowsProp = [

    {
        id: 0,
        col1: 'Ana López',
        col2: 'Programa de Instructoria',
        col3: '20/06/2026 09:14am',
        col4: '2h 14m',
        col5:'Revisión de guías de laboratorio',
        col6: 'Pendiente'
    },
    {
        id: 1,
        col1: 'Barbara Lewis',
        col2: 'Biblioteca Monseñor Romero',
        col3: '20/06/2026 10:30am',
        col4: '2h 00m',
        col5: 'Clasificación e inventariado de nuevos libros de texto',
        col6: 'Completado'
    },
    {
        id: 2,
        col1: 'Bastían Solis',
        col2: 'Viva la UCA',
        col3: '20/06/2026 11:15am',
        col4: '0h 14m',
        col5: 'Registro incompleto por problemas de conexión a la red',
        col6: 'Rechazado'
    },
    {
        id: 3,
        col1: 'Francesco Valdez',
        col2: 'Programa Ellacuría',
        col3: '20/06/2026 01:45pm',
        col4: '3h 00m',
        col5: 'Apoyo logístico en el taller presencial de orientación',
        col6: 'Completado'
    },
    {
        id: 4,
        col1: 'Darcie Dalton',
        col2: 'Viva la UCA',
        col3: '20/06/2026 03:20pm',
        col4: '1h 30m',
        col5: 'Preparación de material gráfico para redes sociales',
        col6: 'Pendiente'
    }
]



export default function TableActivity() {
    return (
        <div className='w-full h-full'>
            <DataGrid
            className='cursor-pointer'
                rows={rows}
                columns={columns}
                disableRowSelectionOnClick
                disableColumnMenu
                hideFooterSelectedRowCount
                pageSizeOptions={[5]}
                hideFooter={true}
                initialState={{
                    pagination: {
                        paginationModel: { pageSize: 5 }
                    }
                }}
                sx={{
              
                    borderRadius: '12px',
                    boxShadow: '0px 1px 3px rgba(16,24,40,0.1), 0px 1px 2px rgba(16,24,40,0.06)',
                    border: '1px solid #E2E8F0',
                    fontFamily: '"Inter", sans-serif',
                    '& .MuiDataGrid-columnHeaders': {
                        backgroundColor: '#F8FAFC',
                        borderBottom: '1px solid #E2E8F0',
                        
                    },
                    '& .MuiDataGrid-cell': {
                        borderBottom: '1px solid #F1F5F9',
                        display: 'flex',
                        alignContent: 'center',
                        alignItems: 'center',
                        '&:focus, &:focus-within': {
                            outline: 'none !important',
                        },
                        maxHeight: '52px !important',
                        minHeight: '53px !important',
                    },
                    '& .MuiDataGrid-row': {
                        maxHeight: '52px !important',
                        minHeight: '52px !important',
                        
                    },
                    '& .MuiDataGrid-row:hover': {
                        backgroundColor: '#F8FAFC',
                    },
                   
                }}
                slotProps={{
                    pagination: {
                        labelRowsPerPage: "",
                        sx: {
                            '& .MuiTablePagination-selectLabel, & .MuiInputBase-root': {
                                display: 'none !important'
                            }
                        }
                    }
                }}
            />
        </div>
    )
}