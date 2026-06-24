import { IconButton, LinearProgress, Typography, Box } from '@mui/material';
import CloseRoundedIcon from '@mui/icons-material/CloseRounded';
import MailOutlineRoundedIcon from '@mui/icons-material/MailOutlineRounded';
import LocalPhoneRoundedIcon from '@mui/icons-material/LocalPhoneRounded';

interface Student {
  id: string;
  nombre: string;
  cuenta: string;
  carnet: string;
  carrera: string;
  programaActual: string;
  estado: 'En curso' | 'Atrasado' | 'Completo';
  horasAcumuladas: number;
}

interface StudentDetailSideProps {
  student: Student;
  onClose: () => void;
}

export default function StudentDetailSide({ student, onClose }: StudentDetailSideProps) {
  const progressPercent = Math.round((student.horasAcumuladas / 300) * 100);

  return (
    <div className="w-full md:w-[360px] bg-white border border-zinc-200 rounded-2xl p-5 shadow-sm flex flex-col gap-5 sticky top-4 shrink-0 h-fit animate-fade-in" style={{ fontFamily: '"Inter", sans-serif' }}>
      {/* Cabecera Detail */}
      <div className="flex justify-between items-start">
        <div className="flex items-center gap-3">
          <div className="w-12 h-12 rounded-full bg-zinc-200 font-bold flex items-center justify-center text-zinc-600 text-base">
            {student.nombre.split(' ').map(n => n[0]).join('')}
          </div>
          <div className="flex flex-col">
            <h4 className="text-sm font-bold text-zinc-900 leading-tight">{student.nombre}</h4>
            <span className="text-xs text-zinc-400">{student.cuenta}</span>
            <span className={`w-fit mt-1 px-2 py-0.5 rounded-full text-[10px] font-bold border ${
              student.estado === 'En curso' ? 'bg-amber-50 border-amber-200 text-amber-600' :
              student.estado === 'Atrasado' ? 'bg-red-50 border-red-200 text-red-500' :
              'bg-green-50 border-green-200 text-green-600'
            }`}>
              {student.estado}
            </span>
          </div>
        </div>
        <IconButton onClick={onClose} size="small" sx={{ color: '#A1A1AA' }}><CloseRoundedIcon sx={{ fontSize: 18 }} /></IconButton>
      </div>

      <hr className="border-zinc-100" />

      {/* Sección 1: Información Personal */}
      <div className="flex flex-col gap-2.5">
        <h5 className="text-xs font-bold text-zinc-800 flex items-center gap-1.5">👤 Información personal</h5>
        <div className="grid grid-cols-3 text-xs gap-y-2 text-zinc-500">
          <span className="col-span-1 font-medium">Carrera</span>
          <span className="col-span-2 text-zinc-800 font-medium text-right">{student.carrera}</span>
          <span className="col-span-1 font-medium">Correo</span>
          <span className="col-span-2 text-zinc-800 font-medium text-right break-all text-[11px]">{student.nombre.toLowerCase().replace(/ /g, '')}@est.uca.edu.sv</span>
          <span className="col-span-1 font-medium">Teléfono</span>
          <span className="col-span-2 text-zinc-800 font-medium text-right">+503 7123 4567</span>
        </div>
      </div>

      <hr className="border-zinc-100" />

      {/* Sección 2: Programa Actual */}
      <div className="flex flex-col gap-2.5">
        <h5 className="text-xs font-bold text-zinc-800 flex items-center gap-1.5">📋 Programa actual</h5>
        <div className="grid grid-cols-3 text-xs gap-y-2 text-zinc-500">
          <span className="col-span-1 font-medium">Programa</span>
          <span className="col-span-2 text-zinc-800 font-bold text-right line-clamp-1">{student.programaActual}</span>
          <span className="col-span-1 font-medium">Inscripción</span>
          <span className="col-span-2 text-zinc-800 font-medium text-right">12 ene 2025</span>
          <span className="col-span-1 font-medium">Horas req.</span>
          <span className="col-span-2 text-zinc-800 font-medium text-right">300h</span>
          <span className="col-span-1 font-medium">Acumuladas</span>
          <span className="col-span-2 text-zinc-800 font-bold text-right">{student.horasAcumuladas}h ({progressPercent}%)</span>
        </div>
        <Box sx={{ width: '100%', mt: 0.5 }}>
          <LinearProgress variant="determinate" value={progressPercent > 100 ? 100 : progressPercent} sx={{ height: 6, borderRadius: 3, backgroundColor: '#E4E4E7', '& .MuiLinearProgress-bar': { borderRadius: 3, backgroundColor: student.estado === 'Atrasado' ? '#EF4444' : '#056CF2' } }} />
        </Box>
      </div>

      <hr className="border-zinc-100" />

      {/* Sección 3: Horarios */}
      <div className="flex flex-col gap-2.5">
        <h5 className="text-xs font-bold text-zinc-800 flex items-center gap-1.5">⏰ Horario asignado</h5>
        <div className="flex flex-col gap-2">
          {[['LUN', '08:00 AM - 11:00 AM'], ['MIÉ', '01:00 PM - 04:00 PM'], ['VIE', '08:00 AM - 12:00 PM']].map(([dia, hora]) => (
            <div key={dia} className="flex items-center justify-between text-xs">
              <span className="bg-blue-50 text-blue-600 font-bold px-2 py-0.5 rounded text-[10px]">{dia}</span>
              <span className="text-zinc-700 font-medium">{hora}</span>
            </div>
          ))}
        </div>
      </div>

      <button className="w-full mt-2 border border-zinc-200 text-zinc-700 font-semibold text-xs py-2.5 rounded-xl hover:bg-zinc-50 transition-colors">
        Ver perfil completo ›
      </button>
    </div>
  );
}