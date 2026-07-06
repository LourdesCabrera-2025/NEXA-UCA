import { useNavigate } from 'react-router-dom';
import { ShieldAlert } from 'lucide-react'; // O cualquier icono de tu librería

export default function UnauthorizedPage() {
  const navigate = useNavigate();

  return (
    <div className="min-h-screen bg-slate-50 flex flex-col items-center justify-center p-6 text-center">
      <div className="bg-white p-8 rounded-2xl shadow-xl max-w-md w-full border border-slate-100 flex flex-col items-center">
        
        {/* Icono de Alerta de Seguridad */}
        <div className="bg-red-50 p-4 rounded-full text-red-500 mb-5 animate-bounce">
          <ShieldAlert size={48} />
        </div>

        <h1 className="text-3xl font-extrabold text-slate-900 mb-2">
          Acceso Restringido
        </h1>
        
        <p className="text-slate-500 mb-6 text-sm leading-relaxed">
          Lo sentimos, esta plataforma es de uso exclusivo para <span className='text-slate-950 font-medium tracking-wide'>Supervisores. </span> 
          Tu cuenta institucional no cuenta con los permisos necesarios para ingresar aquí.
        </p>

        <button
          onClick={() => navigate('/login')}
          className="w-full bg-slate-900 hover:bg-slate-700 text-white font-medium py-3 px-4 rounded-xl transition-all duration-200 shadow-md cursor-pointer"
        >
          Volver al Login
        </button>
      </div>
    </div>
  );
}