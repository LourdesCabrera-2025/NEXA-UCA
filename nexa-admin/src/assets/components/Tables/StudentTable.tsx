import * as React from 'react';
import { Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Paper, TextField, MenuItem, IconButton, Pagination, Box } from '@mui/material';
import SearchRoundedIcon from '@mui/icons-material/SearchRounded';
import MoreVertRoundedIcon from '@mui/icons-material/MoreVertRounded';
import FilterAltRoundedIcon from '@mui/icons-material/FilterAltRounded';

interface Student {
    id:  string;
    nombre: string;
    cuenta: string;
    carnet: string;
    carrera: string; 
    programaActual: string;
    estado: 'En curso' | 'Atrasado' | 'Completo';
    horasAcumuladas: number;
}

interface StudentTableProps {
    students: Student[];
    onSelectStudent: (student: Student) => void;
    selectedId?: string;
}

export default function StudentTable({ students, onSelectStudent, selectedId }: StudentTableProps) {
  const [search, setSearch] = React.useState('');

  const filteredStudents = students.filter(s => 
    s.nombre.toLowerCase().includes(search.toLowerCase()) || s.carnet.includes(search)
  );

  return (
    <div className="bg-white border border-zinc-200 rounded-2xl p-4 shadow-sm flex flex-col gap-4 flex-1 mt-6">
      {/* Barra de Filtros */}
      <div className="flex flex-wrap items-center gap-3">
        <TextField
          size="small"
          placeholder="Buscar por nombre o carnet..."
          value={search}
          onChange={(e) => setSearch(e.target.value)}
          slotProps={{
             input: {
                startAdornment:  <SearchRoundedIcon sx={{ color: '#71717A', mr: 1, fontSize: 18 }} />
             }
          }}
          sx={{ backgroundColor: '#FFFFFF', maxWidth: '280px', flex: 1, '& .MuiOutlinedInput-root': { borderRadius: '12px', fontFamily: '"Inter", sans-serif', fontSize: '13px' } }}
        />
        <TextField select size="small" defaultValue="all" sx={{ width: 160, '& .MuiOutlinedInput-root': { borderRadius: '12px', fontFamily: '"Inter", sans-serif', fontSize: '13px' } }}>
          <MenuItem value="all">Todos los programas</MenuItem>
        </TextField>
        <TextField select size="small" defaultValue="all" sx={{ width: 140, '& .MuiOutlinedInput-root': { borderRadius: '12px', fontFamily: '"Inter", sans-serif', fontSize: '13px' } }}>
          <MenuItem value="all">Todos los estados</MenuItem>
        </TextField>
        <button className="flex items-center gap-1.5 border border-zinc-200 text-zinc-600 text-xs font-semibold px-3 h-9 rounded-xl hover:bg-zinc-50">
          <FilterAltRoundedIcon sx={{ fontSize: 16 }} /> Filtros
        </button>
      </div>

      {/* Tabla */}
      <TableContainer component={Paper} elevation={0} sx={{ border: 'none' }}>
        <Table size="medium">
          <TableHead>
            <TableRow sx={{ '& th': { fontFamily: '"Inter", sans-serif', fontSize: '12px', fontWeight: 600, color: '#71717A', borderBottom: '1px solid #F4F4F5', py: 1.5 } }}>
              <TableCell className='px-6 py-3 text-left text-xs font-medium text-gray-500  tracking-wider min-w-[230px]'>Estudiante</TableCell>
              <TableCell className='px-6 py-3 text-left text-xs font-medium text-gray-500 tracking-wider min-w-[100px]'>Carnet</TableCell>
              <TableCell className='px-6 py-3 text-left text-xs font-medium text-gray-500 tracking-wider min-w-[160px]'>Carrera</TableCell>
              <TableCell className='px-6 py-3 text-left text-xs font-medium text-gray-500 tracking-wider min-w-[200px]'>Programa actual</TableCell>
              <TableCell className='px-6 py-3 text-left text-xs font-medium text-gray-500 tracking-wider min-w-[150px] ' align='center'>Estado</TableCell>
              <TableCell className='px-6 py-3 text-left text-xs font-medium text-gray-500 tracking-wider min-w-[180px]' align='center'>Horas acumuladas</TableCell>
              <TableCell align="center"></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {filteredStudents.map((row) => {
              const isSelected = row.id === selectedId;
              return (
                <TableRow 
                  key={row.id}
                  onClick={() => onSelectStudent(row)}
                  className={`cursor-pointer transition-colors ${isSelected ? 'bg-blue-50/40 hover:bg-blue-50/60' : 'hover:bg-zinc-50/80'}`}
                  sx={{ '& td': { borderBottom: '1px solid #F4F4F5', py: 1.5, fontFamily: '"Inter", sans-serif', fontSize: '13px', color: '#18181B' } }}
                >
                  <TableCell className='whitespace-nowrap'>
                    <div className="flex items-center gap-3">
                      <div className="w-8 h-8 rounded-full bg-zinc-100 flex items-center justify-center font-bold text-zinc-500 text-xs">U</div>
                      <div className="flex flex-col">
                        <span className="font-bold">{row.nombre}</span>
                        <span className="text-[11px] text-zinc-400">{row.cuenta}</span>
                      </div>
                    </div>
                  </TableCell>
                  <TableCell className="text-zinc-500   whitespace-nowrap">{row.carnet}</TableCell>
                  <TableCell className="text-zinc-500  whitespace-nowrap">{row.carrera}</TableCell>
                  <TableCell className="font-medium text-zinc-700  whitespace-nowrap">{row.programaActual}</TableCell>
                  <TableCell align="center" className='whitespace-nowrap'>
                    <span className={`px-2 py-0.5 rounded-full text-[11px] font-bold border ${
                      row.estado === 'En curso' ? 'bg-amber-50 border-amber-200 text-amber-600' :
                      row.estado === 'Atrasado' ? 'bg-red-50 border-red-200 text-red-500' :
                      'bg-green-50 border-green-200 text-green-600'
                    }`}>
                      • {row.estado}
                    </span>
                  </TableCell>
                  <TableCell align="center" className="font-bold whitespace-nowrap">{row.horasAcumuladas}h</TableCell>
                  <TableCell align="center" onClick={(e) => e.stopPropagation()}>
                    <IconButton size="small"><MoreVertRoundedIcon sx={{ fontSize: 18, color: '#A1A1AA' }} /></IconButton>
                  </TableCell>
                </TableRow>
              );
            })}
          </TableBody>
        </Table>
      </TableContainer>

      {/* Paginación */}
      <div className="flex justify-between items-center mt-2 pt-2 border-t border-zinc-100 text-xs text-zinc-400">
        <span>Mostrando 1 a {filteredStudents.length} de {filteredStudents.length} estudiantes</span>
        <Pagination count={7} size="small" shape="rounded" color="primary" sx={{ '& .MuiPaginationItem-root': { fontFamily: '"Inter", sans-serif', fontSize: '12px' } }} />
      </div>
    </div>
  );
}