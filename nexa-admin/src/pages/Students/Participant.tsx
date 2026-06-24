import StudentStats from '@/assets/components/Cards/StudentStats';
import '../../styles/index.css';
import * as React from 'react';
import StudentTable from '@assets/components/Tables/StudentTable';
import StudentDetailSide from '@/assets/components/Cards/StudentDetailSide';

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

export default function Alumns() {
    const listaEstudiantes: Student[] = [
        { id: '1', nombre: 'Gabriela Maldonado', cuenta: '#NXS0001', carnet: '20191234', carrera: 'Teología', programaActual: 'Biblioteca de Teología', estado: 'En curso', horasAcumuladas: 72 },
        { id: '2', nombre: 'María de Leon', cuenta: '#NXS0034', carnet: '20201245', carrera: 'Psicología', programaActual: 'Biblioteca de Teología', estado: 'Atrasado', horasAcumuladas: 20 },
        { id: '3', nombre: 'José Carbajal', cuenta: '#NXS0034', carnet: '20191111', carrera: 'Comunicación', programaActual: 'Radio YSUCA', estado: 'Atrasado', horasAcumuladas: 40 },
        { id: '4', nombre: 'Ana López', cuenta: '#NXS0045', carnet: '20201321', carrera: 'Derecho', programaActual: 'IUDOP', estado: 'En curso', horasAcumuladas: 120 },
        { id: '5', nombre: 'Carlos Mejía', cuenta: '#NXS0078', carnet: '20191567', carrera: 'Economía', programaActual: 'Radio YSUCA', estado: 'En curso', horasAcumuladas: 85 },
        { id: '6', nombre: 'Lucía Hernández', cuenta: '#NXS0089', carnet: '20201123', carrera: 'Ingeniería Industrial', programaActual: 'IUDOP', estado: 'Completo', horasAcumuladas: 300 },
        { id: '7', nombre: 'Daniel Rivera', cuenta: '#NXS0091', carnet: '20191098', carrera: 'Informática', programaActual: 'Biblioteca de Teología', estado: 'En curso', horasAcumuladas: 60 }
    ];
    const [selectedStudent, setSelectedStudent] = React.useState<Student | null>(listaEstudiantes[0]);
    return (
        <>
            <div className="flex gap-2 justify-between">
                <div className="flex flex-col items-start justify-between">
                    <span className='text-2xl font-bold text-gray-700 leading-snug' id='span-config'>Estudiantes</span>
                    <p className='text-xs text-zinc-400 mt-0.5' id='span-config'>Gestiona y consulta la información de los estudiantes inscritos en tus programas</p>
                    <span className='w-full border border-gray-200 mt-2' />
                </div>
                <button className='flex items-center gap-2 bg-[#056CF2] hover:bg-[#0597F2] text-white text-xs font-semibold h-9 px-4 rounded-xl shadow-sm transition-all'>
                    Exportar
                </button>
            </div>
            <StudentStats />
            <div className='flex flex-col md:flex-row gap-5 items-center'>
                <StudentTable
                    students={listaEstudiantes}
                    onSelectStudent={(student) => setSelectedStudent(student)}
                    selectedId={selectedStudent?.id}
                />
                {selectedStudent && (
                    <StudentDetailSide
                        student={selectedStudent}
                        onClose={() => setSelectedStudent(null)}
                    />
                )}
            </div>
        </>
    )
}