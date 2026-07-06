import * as React from 'react';
import {
    Table,
    TableBody,
    TableCell,
    TableContainer,
    TableHead,
    TableRow,
    Box,
    Typography,
    LinearProgress,
    Card
} from '@mui/material';
import PeopleAltIcon from '@mui/icons-material/PeopleAlt';
import WarningRoundedIcon from '@mui/icons-material/WarningRounded';


interface Estudiante {
    id: string;
    nombre: string;
    cuenta: string;
    horas: number;
    estado: 'En curso' | 'Completo' | 'Atrasado';
    ultimaActividad: string;
}

interface ParticipantsTableProps {
    estudiantes: Estudiante[]
}

export default function ParticipantsTable({ estudiantes }: ParticipantsTableProps) {
    return (
        <Card
            elevation={0}
            sx={{
                backgroundColor: '#FFFFFF',
                borderRadius: '16px',
                border: '1px solid #E4E4E7',
                p: 3
            }}>
            <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', borderBottom: '1px solid #E4E4E7', pb: 1.5, mb: 2 }}>
                <Box sx={{ display: 'flex', alignItems: 'center', gap: 1 }}>
                    <PeopleAltIcon sx={{ fontSize: 18, color: '#71717A' }} />
                    <Typography sx={{ fontSize: '14px', fontWeight: 'bold', color: '#18181B', fontFamily: '"Inter", sans-serif' }}>
                        Participantes Inscritos
                    </Typography>
                </Box>
                <Typography sx={{ fontSize: '12px', color: '#71717A', fontWeight: 500, fontFamily: '"Inter", sans-sarif' }}>
                    {estudiantes.length} de 20
                </Typography>
            </Box>

            <TableContainer sx={{width: '100%', overflowX: 'auto'}}>
                <Table stickyHeader sx={{ minWidth: 650, '& .MuiTableCell-root': { borderBottom: '1px solid #F4F4F5', fontFamily: '"Inter", sans-serif' } }} aria-label='tabla de participantes'>
                    <TableHead>
                        <TableRow >
                            <TableCell  sx={{ color: '#71717A', fontSize: '12px', fontWeight: 600, pb: 1.5, pl: 0 }}>Estudiante</TableCell>
                            <TableCell align='center' sx={{ color: '#71717A', fontSize: '12px', fontWeight: 600, pb: 1.5, pl: 0 }}>Horas Acumuladas</TableCell>
                            <TableCell align='center' sx={{ color: '#71717A', fontSize: '12px', fontWeight: 600, pb: 1.5, pl: 0 }}>Progreso</TableCell>
                            <TableCell align='center' sx={{ color: '#71717A', fontSize: '12px', fontWeight: 600, pb: 1.5, pl: 0 }}>Estado</TableCell>
                            <TableCell align='center' sx={{ color: '#71717A', fontSize: '12px', fontWeight: 600, pb: 1.5, pl: 0 }}>Última actividad</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {estudiantes.map((estudiantes) => (
                            <TableRow  key={estudiantes.id}
                                sx={{ '&:hover': { backgroundColor: 'rgba(188,188,188,0.15) ', cursor: 'pointer' }, transition: 'background-color 0.15s ease' }}>

                                <TableCell  sx={{ py: 2, pl: 0 }}>
                                    <Box sx={{ display: 'flex', alignItems: 'center', gap: 1.5 }}>
                                        <Box
                                            sx={{
                                                width: 36,
                                                height: 36,
                                                borderRadius: '50%',
                                                backgroundColor: '#f4f4f6',
                                                display: 'flex',
                                                alignItems: 'center',
                                                justifyContent: 'center',
                                                fontSize: '12px',
                                                fontWeight: 'bold',
                                                color: '#71717a',
                                                fontFamily: '"Inter", sans-serif'
                                            }}>
                                            {estudiantes.nombre.split(' ').map(n => [0]).join('').substring(0, 2)}
                                        </Box>
                                        <Box sx={{ display: 'flex', flexDirection: 'column' }}>
                                            <Typography sx={{ fontSize: '14px', fontWeight: 'bold', color: '#18181B', lineHeight: 1.2, fontFamily: '"Inter", sans-serif' }}>
                                                {estudiantes.nombre}
                                            </Typography>
                                            <Typography sx={{ fontSize: '12px', color: '#A1A1AA', mt: 0.5 }}>
                                                {estudiantes.cuenta}
                                            </Typography>
                                        </Box>
                                    </Box>
                                </TableCell>
                                <TableCell align='center' sx={{ py: 2, color: '#18181B', fontWeight: 600, fontSize: '14px', fontFamily: '"Inter" sans-serif' }}>
                                    {estudiantes.horas}h
                                </TableCell>
                                <TableCell sx={{ py: 2, width: '25%' }}>
                                    <Box sx={{ display: 'flex',flexDirection: 'column', gap: 0.5, maxWidth: '140px', mx: 'auto' }}>
                                        <Typography sx={{ fontSize: '12px', fontWeight: 600, color: estudiantes.estado === 'Completo' ? '#16A34A' : '#71717A' }}>
                                            {estudiantes.horas} / 300 {estudiantes.estado === 'Completo' && '✓'}
                                        </Typography>
                                        <LinearProgress 
                                            variant="determinate"
                                            value={(estudiantes.horas / 300) * 100}
                                            sx={{
                                                
                                                height: 6,
                                                borderRadius: 3,
                                                backgroundColor: '#E4E4E7',
                                                '& .MuiLinearProgress-bar': {
                                                    borderRadius: 3,
                                                    backgroundColor: estudiantes.estado === 'Completo' ? '#16A34A' : '#056CF2',
                                                }
                                            }}
                                        />
                                    </Box>
                                </TableCell>
                                <TableCell align='center' sx={{ py: 2 }}>
                                    {estudiantes.estado === 'En curso' && (
                                        <Box component="span" sx={{ backgroundColor: '#FEF3C7', color: '#D97706', fontSize: '12px', fontWeight: 'bold', px: 1.5, py: 0.5, borderRadius: '8px', border: '1px solid #FDE68A' }}>
                                            ● En curso
                                        </Box>
                                    )}
                                    {estudiantes.estado === 'Completo' && (
                                        <Box component="span" sx={{ backgroundColor: '#DCFCE7', color: '#16A34A', fontSize: '12px', fontWeight: 'bold', px: 1.5, py: 0.5, borderRadius: '8px', border: '1px solid #BBF7D0' }}>
                                            ✓ Completó
                                        </Box>
                                    )}
                                    {estudiantes.estado === 'Atrasado' && (
                                        <Box component="span" sx={{ backgroundColor: '#FEE2E2', color: '#DC2626', fontSize: '12px', fontWeight: 'bold', px: 1.5, py: 0.5, borderRadius: '8px', border: '1px solid #FCA5A5', display: 'inline-flex', alignItems: 'center' }}>
                                            <WarningRoundedIcon sx={{fontSize: 13 }}/>
                                            Atrasado
                                        </Box>
                                    )}
                                </TableCell>

                                <TableCell align='center' sx={{ py: 2, fontSize: '12px', color: '#71717A', pr: 0 }}>
                                    {estudiantes.ultimaActividad}
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>
        </Card>
    )
}