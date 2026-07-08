import * as React from 'react';
import { Dialog, DialogTitle, DialogContent, DialogActions, Button, TextField, MenuItem, Box } from '@mui/material';

interface Schedule {
    day: string;
    start: string;
    end: string;
}

interface ModalAddScheduleProps {
    open: boolean;
    onClose: () => void;
    onAdd: (schedule: Schedule) => void;
}
export default function ModalAddSchedule({ open, onClose, onAdd } : ModalAddScheduleProps) {
    const [day, setDay] = React.useState('Lunes');
    const [start, setStart] = React.useState('08:00');
    const [end, setEnd] = React.useState('11:00');

    return (
        <Dialog open={open} onClose={onClose} maxWidth="xs" fullWidth>
            <DialogTitle sx={{ fontWeight: 'bold', fontSize: '16px' }}>Agregar nuevo horario</DialogTitle>
            <DialogContent sx={{ display: 'flex', flexDirection: 'column', gap: 4, pt: 9 }} className='p-4'>
                <TextField select label="Día" value={day} onChange={(e) => setDay(e.target.value)} size="small" fullWidth>
                    {['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'].map(d => (
                        <MenuItem key={d} value={d}>{d}</MenuItem>
                    ))}
                </TextField>
                <TextField label="Hora Inicio" type="time" value={start} onChange={(e) => setStart(e.target.value)} size="small" fullWidth slotProps={{
                    inputLabel: { shrink: true }}} />
                <TextField label="Hora Fin" type="time" value={end} onChange={(e) => setEnd(e.target.value)} size="small" fullWidth slotProps={{
                    inputLabel: { shrink: true }}} />
            </DialogContent>
            <DialogActions sx={{ p: 2 }}>
                <Button onClick={onClose} sx={{ color: '#71717A' }}>Cancelar</Button>
                <Button onClick={() => { onAdd({ day, start, end }); onClose(); }} variant="contained" sx={{ backgroundColor: '#056CF2', boxShadow: 'none' }}>
                    Confirmar
                </Button>
            </DialogActions>
        </Dialog>
    );
}