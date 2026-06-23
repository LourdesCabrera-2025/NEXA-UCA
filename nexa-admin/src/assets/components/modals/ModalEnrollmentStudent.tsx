import * as React from 'react';
import {
    Dialog,
    DialogTitle,
    DialogContent,
    IconButton,
    TextField,
    Checkbox,
    Button,
    Box,
    Typography,
    DialogActions
} from '@mui/material';
import CloseRoundedIcon from '@mui/icons-material/CloseRounded';
import PersonAddAlt1RoundedIcon from '@mui/icons-material/PersonAddAlt1Rounded';
import CheckCircleRoundedIcon from '@mui/icons-material/CheckCircleRounded';
import SearchRoundedIcon from '@mui/icons-material/SearchRounded';
import AccessTimeRoundedIcon from '@mui/icons-material/AccessTimeRounded';
import InfoRoundedIcon from '@mui/icons-material/InfoRounded';
import DeleteRoundedIcon from '@mui/icons-material/DeleteRounded';
import AddRoundedIcon from '@mui/icons-material/AddRounded';
import AssignmentTurnedInRoundedIcon from '@mui/icons-material/AssignmentTurnedInRounded';
import AlarmAddRoundedIcon from '@mui/icons-material/AlarmAddRounded';

interface ModalScrollStudentProps {
    open: boolean;
    onClose: () => void;
    programTitle: string;
}

export default function ModalEnrollStudent({ open, onClose, programTitle }: ModalScrollStudentProps) {
    const [days, setDays] = React.useState({
        Lunes: true,
        Miércoles: true,
        Viernes: true,
    });

    return (
        <Dialog open={open}
            onClose={onClose}
            maxWidth='md'
            fullWidth
            className='fixed inset-0 bg-black/60 backdrop-blur-sm z-50  items-center justify-center p-4 animate-fade-in'
            slotProps={{
                paper: {
                    sx: {
                        borderRadius: '10px',
                        p: 1,
                        backgroundColor: '#FFFFFF'
                    }
                }
            }}>
            <DialogTitle sx={{ m: 0, p: 2, display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
                <Box sx={{ display: 'flex', alignItems: 'center', gap: 1.5 }}>
                    <PersonAddAlt1RoundedIcon sx={{ color: '#6A7282', fontSize: 24 }} />
                    <Typography className='text-lg tracking-tight' variant="h6" sx={{ fontWeight: 'bold', color: '#101828', fontFamily: '"Inter", sans-serif' }}>
                        Inscribir Estudiante
                    </Typography>
                </Box>
                <IconButton onClick={onClose} sx={{ color: '#A1A1AA', position: 'absolute', right: 16, top: 16, border: '1px solid #E5E7EB' }}>
                    <CloseRoundedIcon />
                </IconButton>
            </DialogTitle>

            <DialogContent dividers sx={{ borderTop: '1px solid #E5E7EB', borderBottom: '1px solid #E5E7EB', p: 3, display: 'flex', flexDirection: 'column', gap: 4 }}>
                <Box sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
                    <Box sx={{ display: 'flex', alignItems: 'center', gap: 1 }}>
                        <span className='w-6 h-6 rounded-full bg-[#E5E7EB] text-black text-xs font-bold flex items-center justify-center' >1</span>
                        <Typography sx={{ fontSize: '14px', fontWeight: 'bold', color: '#18181B', fontFamily: '"Inter", sans-serif' }}>Información del estudiante</Typography>
                    </Box>
                    <TextField
                        fullWidth
                        placeholder='Buscar por carnet o nombre del estudiante....'
                        size='small'
                        slotProps={{
                            input: {
                                startAdornment: <SearchRoundedIcon sx={{ color: '#A1A1AA', mr: 1, fontSize: 20 }} />
                            }
                        }}
                        sx={{
                            backgroundColor: '#FFFFFF',
                            '& .MuiInputBase-input': {
                                fontFamily: '"Inter" ,sans-serif',
                                fontSize: '14px',
                                color: '#18181B'
                            },
                            '& .MuiInputBase-input::placeholder': {
                                fontFamily: '"Inter", sans-serif',
                                opacity: 1
                            },
                            '& .MuiOutlinedInput-root': {
                                borderRadius: '12px',
                                '& fieldset': {

                                    borderColor: '#E4E4E7'
                                },
                                '&:hover fieldset': {
                                    borderColor: '#A1A1AA'
                                },
                                '&.Mui-focused fieldset': {
                                    borderColor: '#056CF2'
                                }
                            }
                        }} />

                    <Box className="flex items-center justify-between border border-blue-100 bg-blue-50/40 p-4 rounded-xl">
                        <Box className="flex items-center gap-4">
                            <Box className="w-12 h-12 rounded-full bg-zinc-200 overflow-hidden flex items-center justify-center font-bold text-zinx-600">
                                AL
                            </Box>
                            <Box className="flex flex-col">
                                <Typography sx={{ fontSize: '14px', fontWeight: 'bold', color: '#18181B', fontFamily: '"Inter", sans-serif' }}>Ana López</Typography>
                                <Typography sx={{ fontSize: '12px', color: '#71717A', fontFamily: '"Inter", sans-serif' }}>NX00340</Typography>
                                <Typography sx={{ fontSize: '12px', color: '#52525B', mt: 0.5, fontFamily: '"Inter", sans-serif' }}>Ingeniería Informática · nx00340@nexa-social.site</Typography>
                            </Box>
                        </Box>
                        <CheckCircleRoundedIcon sx={{ color: '#16A34A' }} />
                    </Box>
                </Box>
                <Box sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
                    <Box sx={{ display: 'flex', alignItems: 'center', gap: 1 }}>
                        <span className="w-6 h-6 rounded-full bg-[#E5E7EB] text-black text-xs font-bold flex items-center justify-center">2</span>
                        <Typography sx={{ fontSize: '14px', fontWeight: 'bold', color: '#18181B' }}>Asignar disponibilidad</Typography>
                    </Box>

                    {/* Banner Informativo */}
                    <Box className="flex items-start gap-2 bg-blue-50/60 border border-blue-100 p-3 rounded-xl text-xs text-blue-700">
                        <InfoRoundedIcon sx={{ fontSize: 16, mt: 0.2, color: '#056CF2' }} />
                        <span>Selecciona los días y horarios en los que el estudiante podrá realizar sus horas sociales.<br />Mínimo <strong>1 hora</strong> y máximo <strong>5 horas</strong> por día.</span>
                    </Box>

                    {/* Filas de Horarios por Día */}
                    {['Lunes', 'Miércoles', 'Viernes'].map((day) => (
                        <Box key={day} className="flex flex-wrap items-center justify-between gap-4 border border-zinc-100 p-3 rounded-xl bg-white">
                            <Box className="flex items-center gap-1 font-bold text-sm text-zinc-800 min-w-[100px]">
                                <Checkbox defaultChecked size="small" sx={{ color: '#E5E7EB', '&.Mui-checked': { color: '#0F172B' } }} />
                                {day}
                            </Box>

                            <Box className="flex items-center gap-4 flex-1 justify-end">
                                <Box className="flex flex-col gap-0.5">
                                    <span className="text-[10px] font-semibold text-zinc-400">Inicio</span>
                                    <TextField type="time" defaultValue="08:00" size="small" sx={{ width: 130, '& .MuiOutlinedInput-root': { borderRadius: '8px' } }} />
                                </Box>
                                <Box className="flex flex-col gap-0.5">
                                    <span className="text-[10px] font-semibold text-zinc-400">Fin</span>
                                    <TextField type="time" defaultValue="11:00" size="small" sx={{ width: 130, '& .MuiOutlinedInput-root': { borderRadius: '8px' } }} />
                                </Box>
                                <Box className="flex flex-col gap-0.5 text-center min-w-[60px]">
                                    <span className="text-[10px] font-semibold text-zinc-400">Duración</span>
                                    <span className="text-xs font-bold text-zinc-800 bg-zinc-50 py-2 border border-zinc-200 rounded-lg">3h</span>
                                </Box>
                                <IconButton className="hover:bg-red-50 hover:text-red-500 text-zinc-400 mt-4">
                                    <DeleteRoundedIcon sx={{ fontSize: 20 }} />
                                </IconButton>
                            </Box>
                        </Box>
                    ))}

                    <Button
                        variant="outlined"
                        startIcon={<AddRoundedIcon />}
                        sx={{
                            border: '1px dashed #0F172B',
                            color: '#0F172B',
                            borderRadius: '10px',
                            textTransform: 'none',
                            fontSize: '13px',
                            fontWeight: 600,
                            py: 1,
                            '&:hover': { backgroundColor: '#F0F7FF', border: '1px dashed #0F172B', borderStyle: 'dashed' }
                        }}
                    >
                        Agregar otro día y horario
                    </Button>
                </Box>

                {/* PASO 3: Resumen */}
                <Box sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
                    <Box sx={{ display: 'flex', alignItems: 'center', gap: 1 }}>
                        <span className="w-6 h-6 rounded-full bg-[#E5E7EB] text-black text-xs font-bold flex items-center justify-center">3</span>
                        <Typography sx={{ fontSize: '14px', fontWeight: 'bold', color: '#18181B' }}>Resumen</Typography>
                    </Box>

                    <div className="grid grid-cols-1 md:grid-cols-3 gap-3">
                        <div className="flex items-center gap-3 border border-zinc-100 p-3 rounded-xl bg-zinc-50/50">
                            <AssignmentTurnedInRoundedIcon sx={{ color: '#0F172B', fontSize: 20 }} />
                            <div className="flex flex-col">
                                <span className="text-[10px] text-zinc-400 font-medium">Programa</span>
                                <span className="text-xs font-bold text-zinc-800 line-clamp-1">{programTitle}</span>
                            </div>
                        </div>
                        <div className="flex items-center gap-3 border border-zinc-100 p-3 rounded-xl bg-zinc-50/50">
                            <AccessTimeRoundedIcon sx={{ color: '#0F172B', fontSize: 20 }} />
                            <div className="flex flex-col">
                                <span className="text-[10px] text-zinc-400 font-medium">Horas requeridas</span>
                                <span className="text-xs font-bold text-zinc-800">300 horas</span>
                            </div>
                        </div>
                        <div className="flex items-center gap-3 border border-zinc-100 p-3 rounded-xl bg-zinc-50/50">
                            <AlarmAddRoundedIcon sx={{ color: '#0F172B', fontSize: 20 }} />
                            <div className="flex flex-col">
                                <span className="text-[10px] text-zinc-400 font-medium">Máximo por día</span>
                                <span className="text-xs font-bold text-zinc-800">5 horas</span>
                            </div>
                        </div>
                    </div>
                </Box>
            </DialogContent>
            {/* Botones de acción del Footer */}
            <DialogActions sx={{
                display: 'flex',
                alignItems: 'end',
                gap: '12px',
                padding: '20px 24px',
                borderTop: '1px solid rgba(144,161,185, 0.5)',
            }}>
                <Button
                    onClick={onClose}
                    sx={{ color: '#3F3F46', textTransform: 'none', fontWeight: 600, fontSize: '13px', px: 3, py: 1, border: '1px solid #E4E4E7', borderRadius: '10px', backgroundColor: '#FFFFFF', '&:hover': { backgroundColor: '#F4F4F5' } }}
                >
                    Cancelar
                </Button>
                <Button
                    variant="contained"
                    onClick={onClose}
                    startIcon={<PersonAddAlt1RoundedIcon sx={{ fontSize: 16 }} />}
                    sx={{ backgroundColor: '#056CF2', textTransform: 'none', fontWeight: 600, fontSize: '13px', px: 3, py: 1, borderRadius: '10px', boxShadow: 'none', '&:hover': { backgroundColor: '#0597F2', boxShadow: 'none' } }}
                >
                    Inscribir estudiante
                </Button>
            </DialogActions>

        </Dialog >
    )
}
