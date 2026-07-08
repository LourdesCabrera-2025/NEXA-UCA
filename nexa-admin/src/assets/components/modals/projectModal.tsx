import '../../../styles/index.css';
import React, { useEffect, useState } from 'react';

import { createTheme, styled, ThemeProvider, alpha, type SxProps } from '@mui/material/styles';
import MuiDialog from '@mui/material/Dialog';
import MuiDialogTitle from '@mui/material/DialogTitle';
import MuiDialogContent from '@mui/material/DialogContent';
import MuiDialogActions from '@mui/material/DialogActions';
import TextField from '@mui/material/TextField';
import Autocomplete from '@mui/material/Autocomplete';
import CreateNewFolderOutlinedIcon from '@mui/icons-material/CreateNewFolderOutlined';
import CloseRoundedIcon from '@mui/icons-material/CloseRounded';
import CheckBoxIcon from '@mui/icons-material/CheckBox';
import CheckBoxOutlineBlankIcon from '@mui/icons-material/CheckBoxOutlineBlank';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { DatePicker } from '@mui/x-date-pickers/DatePicker';
import { Dayjs } from 'dayjs';
import type { } from '@mui/x-date-pickers/themeAugmentation';
import ShareLocationIcon from '@mui/icons-material/ShareLocation';
import Switch from '@mui/material/Switch';
import SaveRoundedIcon from '@mui/icons-material/SaveRounded';
import ModalMap from './mapContent';
import type { projectType } from '@/models/typeProgram';
import type { Career } from '@/models/Careers';
import { ProgramService } from '@/services/firebase/programService';
import { authService } from '@/services/firebase/authService';
import type { Project } from '@/models/Program';


interface ModalProps {
    isOpen: boolean;
    onClose: () => void;

    onSuccess: (
        type: "success" | "error",
        title: string,
        message: string
    ) => void;
    onProjectCreated: (newProject: any) => void;

}

export default function ModalProject({ isOpen, onClose, onSuccess, onProjectCreated, ...props }: ModalProps) {
    const [startDate, setStartDate] = useState<Dayjs | null>(null);
    const [endDate, setEndDate] = useState<Dayjs | null>(null);
    const [modalOpenMap, setmodalOpenMap] = useState(false);
    const [programType, setProgramType] = useState<projectType[]>([])
    const [careers, setCareers] = useState<Career[]>([])
    const [selectedProgram, setSelectedProgram] = useState<string>('')
    const [selectedCareer, setSelectedCareer] = useState<Career[]>([])
    const [latitude, setLatitude] = useState<string>("");
    const [longitude, setLongitude] = useState<string>("");
    const [radius, setRadius] = useState<string>("");
    const [isCapturing, setIsCapturing] = useState<boolean>(false);
    const [name, setName] = useState<string>("");
    const [description, setDescription] = useState<string>("");
    const [maxStudents, setMaxStudents] = useState<number>(0);
    const [totalHours, setTotalHours] = useState<number>(0);
    const [maxHoursDay, setMaxHoursDay] = useState<number>(5);
    const [isActive, setIsActive] = useState<boolean>(false);
    const [supervisorId, setSupervisorId] = useState<string>("");
    const [supervisorName, setSupervisorName] = useState<string>("");
    const [isSaving, setIsSaving] = useState(false);

    const handleSubmit = async () => {
        if (!name.trim() || selectedCareer.length === 0 || !selectedProgram) {
            onSuccess("error", "Campos incompletos", "Por favor llena los campos obligatorios.");
            return;
        }

        setIsSaving(true);

        try {
            const projectData: Project = {
                name,
                description,
                projectTypeId: selectedProgram,
                supervisorId,
                startDate: startDate ? startDate.toDate() : new Date(),
                endDate: endDate ? endDate.toDate() : new Date(),
                latitude: parseFloat(latitude),
                longitude: parseFloat(longitude),
                allowedRadius: parseFloat(radius),
                maxStudents: Number(maxStudents),
                totalRequiredHours: Number(totalHours),
                maxHoursPerDay: Number(maxHoursDay),
                isActive,
            };

            const result = await ProgramService.createProgramWithCareers(projectData, selectedCareer);

            // Buscamos el tipo de programa real seleccionado en el Autocomplete,
            // en vez de dejar un texto genérico hardcodeado.
            const selectedProgramType = programType.find(pt => pt.id === selectedProgram);

            // Creamos el objeto para "inyectarlo" en la lista del padre
            const newProject = {
                ...projectData,
                id: result.projectId,
                projectType: { name: selectedProgramType?.name ?? "Tipo de Programa" }
            };

            // Pasamos el nuevo objeto al padre
            if (onProjectCreated) {
                onProjectCreated(newProject);
            }

            onSuccess("success", "Éxito", "Programa registrado correctamente.");
            setTimeout(() => onClose(), 500);

        } catch (error) {
            console.error(error);
            onSuccess("error", "Error", "Ocurrió un error al registrar el programa.");
        } finally {
            setIsSaving(false);
        }
    };

    const handleLocationSelect = (lat: number, lng: number, rad: number) => {
        setLatitude(lat.toFixed(6));
        setLongitude(lng.toFixed(6));
        setRadius(rad.toString());
    };

    useEffect(() => {
        const loadFormData = async () => {
            try {
                const typesData = await ProgramService.getAllProgramsType();
                const careerData = await ProgramService.getAllCareers();
                const user = await authService.getCurrentPostgressUser();

                if (user) {
                    setSupervisorId(user.id);
                    setSupervisorName(user.fullName);
                }

                setProgramType(typesData);
                setCareers(careerData);
            } catch (error) {
                console.error("error al cargar datos en el formulario")
            }
        };
        if (isOpen) {
            loadFormData();
        }
    }, [isOpen]);

    const datePickerTheme = createTheme({
        typography: {
            fontFamily: '"Inter", sans-serif',
        },
        components: {
            MuiPickersTextField: {
                styleOverrides: {
                    root: {
                        fontFamily: '"Inter", sans-serif',
                    },
                },
            },
            MuiPickersInputBase: {
                styleOverrides: {
                    input: {
                        fontFamily: '"Inter", sans-serif',
                        fontSize: '13px',
                        color: '#3f3f46',
                    },
                },
            },
            MuiIconButton: {
                styleOverrides: {
                    root: {
                        color: '#94a3b8',
                        padding: '4px',
                        transition: 'all 0.15s ease-in-out',
                        '&:hover': {
                            color: 'rgba(20, 71, 239, 0.7)',
                            backgroundColor: 'rgba(20, 71, 239, 0.04)',
                        },
                    },
                },
            },
            MuiPickerDay: {
                styleOverrides: {
                    root: {
                        '&:hover': {
                            backgroundColor: 'rgba(20, 71, 239, 0.08)',
                        },
                        '&.Mui-selected': {
                            backgroundColor: 'rgba(20, 71, 239, 0.9)',
                        },
                    },
                },
            },
        },
    });

    const unifiedInputStyles: SxProps = {
        width: '100%',
        '& .MuiOutlinedInput-root': {
            borderRadius: '8px',
            minHeight: '40px',
            backgroundColor: '#fff',
            '&:hover .MuiOutlinedInput-notchedOutline': {
                borderColor: 'rgba(20, 71, 239, 0.7) !important',
            },
            '&.Mui-focused .MuiOutlinedInput-notchedOutline': {
                borderColor: 'rgba(20, 71, 239, 0.7) !important',
                borderWidth: '1px !important',
            },
        },
        '& .MuiOutlinedInput-notchedOutline': {
            borderColor: '#e4e4e7',
            transition: 'border-color 0.15s ease-in-out',
        },
        '& .MuiInputBase-input': {
            fontFamily: '"Inter", sans-serif !important',
            fontSize: '13px !important',
            color: '#3f3f46 !important',
            padding: '10px 14px !important',
        },
        '& input::placeholder': {
            fontFamily: '"Inter", sans-serif !important',
            color: '#a1a1aa !important',
            opacity: 1,
        },
    };

    const label = {
        slotProps: {
            input: {
                'aria-label': 'Switch demo'
            }
        }
    };

    const PurpleSwitch = styled(Switch)(({ theme }) => ({
        '& .MuiSwitch-switchBase.Mui-checked': {
            color: '#1A00CC',
            '&:hover': {
                backgroundColor: alpha('#1A00CC', theme.palette.action.hoverOpacity),
            },
            '& .MuiSwitch-switchBase.Mui-checked + .MuiSwitch-track': {
                backgroundColor: '#1A00CC',
            }
        },
    }));



    useEffect(() => {
        if (!isOpen) {
            // Se ejecuta cuando el modal se cierra, reseteando los estados
            setIsActive(false);
            setName("");
            setDescription("");
            setStartDate(null);
            setEndDate(null);
            setSelectedProgram('');
            setSelectedCareer([]);
            setLatitude("");
            setLongitude("");
            setRadius("");
            setMaxStudents(0);
            setTotalHours(0);
            setMaxHoursDay(5);
        }
    }, [isOpen]);




    return (
        <>
            <div style={{ position: 'relative', zIndex: 1000 }}>
                <ThemeProvider theme={datePickerTheme}>
                    <LocalizationProvider dateAdapter={AdapterDayjs}>
                        <MuiDialog
                            className="fixed inset-0 bg-black/60 backdrop-blur-sm z-50 flex items-center justify-center p-4 animate-fade-in "
                            open={isOpen}
                            onClose={onClose}
                            disableEnforceFocus

                            scroll='paper'
                            maxWidth="lg"
                            fullWidth
                            sx={{
                                zIndex: 1200,
                                '& .MuiPaper-root': {
                                    borderRadius: '16px',
                                    background: '#ffffff',
                                    boxShadow: '0px 20px 25px -5px rgba(0,0,0,0.1), 0 8px 10px -6px rgba(0,0,0,0.1)',
                                },
                            }}
                        >
                            <MuiDialogTitle
                                sx={{
                                    display: 'flex',
                                    alignItems: 'center',
                                    gap: '12px',
                                    padding: '20px 24px',
                                    borderBottom: '1px solid rgba(144,161,185, 0.5)',
                                }}
                            >
                                <div className="flex items-center gap-3 flex-1">
                                    <CreateNewFolderOutlinedIcon className="text-gray-500" sx={{ fontSize: 22 }} />
                                    <span
                                        className="text-lg font-bold text-gray-900 tracking-tight"
                                        style={{ fontFamily: '"Inter", sans-serif' }}
                                    >
                                        Nuevo programa
                                    </span>
                                </div>
                                <button
                                    onClick={onClose}
                                    className="flex items-center justify-center w-8 h-8 rounded-lg border border-gray-200 text-gray-400 hover:bg-gray-50 hover:text-gray-600 transition-all duration-150 cursor-pointer"
                                    aria-label="Cerrar modal"
                                >
                                    <CloseRoundedIcon sx={{ fontSize: 18 }} />
                                </button>
                            </MuiDialogTitle>

                            <MuiDialogContent sx={{ padding: '30px' }} className="max-w-7xl">
                                <div className="flex flex-col items-start justify-start m-5">
                                    <div className="border-b border-gray-100 pb-2">
                                        <span
                                            className="text-sm text-zinc-500 font-semibold"
                                            style={{ fontFamily: '"Inter", sans-serif' }}
                                        >
                                            INFORMACIÓN GENERAL
                                        </span>
                                    </div>

                                    <div className="grid grid-cols-2 gap-6 w-full items-start mt-5">
                                        <div className="flex flex-col gap-2 w-full">
                                            <span
                                                className="text-xs text-zinc-500 font-medium"
                                                style={{ fontFamily: '"Inter", sans-serif' }}
                                            >
                                                Nombre de programa <span className="text-red-600">*</span>
                                            </span>
                                            <TextField
                                                placeholder="Biblioteca de Teología"
                                                size="small"
                                                fullWidth
                                                value={name}
                                                onChange={(e) => setName(e.target.value)}
                                                sx={unifiedInputStyles}
                                            />
                                        </div>

                                        <div className="flex flex-col gap-2 w-full">
                                            <span
                                                className="text-xs text-zinc-500 font-medium"
                                                style={{ fontFamily: '"Inter", sans-serif' }}
                                            >
                                                Tipo de programa <span className="text-red-600">*</span>
                                            </span>
                                            <Autocomplete
                                                size="small"
                                                options={programType}
                                                getOptionLabel={(option) => option.name}
                                                value={programType.find(opt => opt.id === selectedProgram) || null}
                                                isOptionEqualToValue={(option, value) => option.id === value.id}
                                                onChange={(event, newValue) => {
                                                    if (newValue) {
                                                        setSelectedProgram(newValue.id);
                                                        console.log("ID del programa seleccionado: ", newValue.id, "nombre:", newValue.name)
                                                    } else {
                                                        setSelectedProgram('');
                                                    }
                                                }}
                                                slotProps={{
                                                    paper: {
                                                        sx: {
                                                            borderRadius: '8px',
                                                            boxShadow: '0 4px 12px rgba(0,0,0,0.15)',
                                                            '& .MuiAutocomplete-option': {
                                                                fontFamily: '"Inter", sans-serif',
                                                                fontSize: '13px',
                                                                color: '#3f3f46',
                                                            },
                                                        },
                                                    },
                                                }}
                                                sx={{
                                                    width: '100%',
                                                    '& .MuiAutocomplete-popupIndicator, .MuiAutocomplete-clearIndicator': {
                                                        color: 'rgba(20,71,239,0.7)',
                                                    },
                                                    '& .MuiInputBase-input': {
                                                        padding: '0px 14px !important',
                                                        height: '100% !important',
                                                    }
                                                }}
                                                renderInput={(params) => (
                                                    <TextField {...params} placeholder="Seleccionar opción" sx={unifiedInputStyles} />
                                                )}
                                            />
                                        </div>
                                    </div>

                                    <div className="flex flex-col gap-2 w-full mt-4">
                                        <label
                                            className="text-xs text-zinc-500 font-medium"
                                            style={{ fontFamily: '"Inter", sans-serif' }}
                                        >
                                            Descripción <span className="text-zinc-400 font-normal">(Opcional)</span>
                                        </label>
                                        <TextField
                                            value={description}
                                            onChange={(e) => setDescription(e.target.value)}
                                            placeholder="Escribe una breve descripción del programa..."
                                            multiline
                                            rows={4}
                                            fullWidth
                                            sx={{
                                                '& .MuiOutlinedInput-root': {
                                                    borderRadius: '8px',
                                                    padding: '12px 14px',
                                                    fontFamily: '"Inter", sans-serif',
                                                    fontSize: '13px',
                                                    '&:hover .MuiOutlinedInput-notchedOutline': {
                                                        borderColor: 'rgba(20,71,239,0.7) !important',
                                                    },
                                                    '&.Mui-focused .MuiOutlinedInput-notchedOutline': {
                                                        borderColor: 'rgba(20,71,239,0.7) !important',
                                                    },
                                                },
                                                '& .MuiOutlinedInput-input': {
                                                    fontFamily: '"Inter", sans-serif',
                                                    fontSize: '13px',
                                                    color: '#3f3f46',
                                                    lineHeight: '1.5',
                                                },
                                                '& .MuiOutlinedInput-notchedOutline': {
                                                    borderColor: '#e4e4e7',
                                                },
                                                '& ::placeholder': {
                                                    fontSize: '12px',
                                                    fontFamily: '"Inter", sans-serif',
                                                    color: '#a1a1aa',
                                                },
                                            }}
                                        />
                                    </div>

                                    <div className="flex gap-6 w-full mt-4">
                                        <div className="flex flex-col w-full">
                                            <span
                                                className="text-xs text-zinc-500 font-medium mb-2"
                                                style={{ fontFamily: '"Inter", sans-serif' }}
                                            >
                                                Carrera asociada
                                            </span>
                                            <Autocomplete<Career, true>
                                                multiple
                                                size="small"
                                                options={careers}
                                                disableCloseOnSelect
                                                getOptionLabel={(option) => option.name}
                                                value={selectedCareer}
                                                isOptionEqualToValue={(option, value) => option.id === value.id}
                                                onChange={(event, newValue) => {
                                                    setSelectedCareer(newValue);
                                                }}
                                                renderOption={(props, option, { selected }) => {
                                                    const { key, ...optionProps } = props as any;
                                                    const SelectionIcon = selected
                                                        ? CheckBoxIcon
                                                        : CheckBoxOutlineBlankIcon;
                                                    return (
                                                        <li key={key} {...optionProps} className={`${optionProps.className} flex items-center`}>
                                                            <SelectionIcon
                                                                fontSize="small"
                                                                style={{ marginRight: 8, padding: 9, boxSizing: 'content-box' }}
                                                            />
                                                            {option.name}
                                                        </li>
                                                    );
                                                }}
                                                slotProps={{
                                                    paper: {
                                                        sx: {
                                                            borderRadius: '8px',
                                                            boxShadow: '0 4px 12px rgba(0,0,0,0.15)',
                                                            '& .MuiAutocomplete-option': {
                                                                fontFamily: '"Inter", sans-serif',
                                                                fontSize: '13px',
                                                                color: '#3f3f46',
                                                            },
                                                        },
                                                    },
                                                }}
                                                sx={{
                                                    width: '100%',
                                                    '& .MuiAutocomplete-popupIndicator, .MuiAutocomplete-clearIndicator': {
                                                        color: 'rgba(20,71,239,0.7)',
                                                    },
                                                }}
                                                renderInput={(params) => (
                                                    <TextField
                                                        {...params}
                                                        placeholder={selectedCareer.length === 0 ? "Seleccionar carreras" : ""}
                                                        sx={{
                                                            ...unifiedInputStyles,
                                                            '& .MuiOutlinedInput-root': {
                                                                ...(unifiedInputStyles as any)['& .MuiOutlinedInput-root'],
                                                                minHeight: '40px',
                                                                paddingTop: '2px !important',
                                                                paddingBottom: '2px !important',
                                                            },
                                                        }}
                                                    />
                                                )}
                                            />
                                        </div>

                                        <div className="flex flex-col w-full">
                                            <span
                                                className="text-xs text-zinc-500 font-medium mb-2"
                                                style={{ fontFamily: '"Inter", sans-serif' }}
                                            >
                                                Nombre del supervisor
                                            </span>
                                            <TextField
                                                disabled
                                                value={supervisorName}
                                                placeholder="Cargando..."
                                                size="small"
                                                fullWidth
                                                sx={unifiedInputStyles}
                                            />
                                        </div>
                                    </div>

                                    <div className="border border-gray-200 w-full mt-4" />
                                    <div className="border-b border-gray-100 mt-4 pb-2">
                                        <span
                                            className="text-sm text-zinc-500 font-semibold"
                                            style={{ fontFamily: '"Inter", sans-serif' }}
                                        >
                                            FECHAS Y LÍMITES
                                        </span>
                                    </div>

                                    <div className="grid grid-cols-3 gap-6 w-full items-end mt-5">
                                        <div className="flex flex-col gap-2 w-full">
                                            <span className="text-xs text-zinc-500 font-medium">
                                                Fecha de inicio <span className="text-red-500">*</span>
                                            </span>
                                            <DatePicker
                                                value={startDate}
                                                onChange={(newValue) => setStartDate(newValue)}
                                                slotProps={{
                                                    textField: {
                                                        size: 'small',
                                                        fullWidth: true,
                                                        sx: unifiedInputStyles,
                                                    },
                                                }}
                                            />
                                        </div>

                                        <div className="flex flex-col gap-2 w-full">
                                            <span className="text-xs text-zinc-500 font-medium">
                                                Fecha de fin <span className="text-red-500">*</span>
                                            </span>
                                            <DatePicker
                                                value={endDate}
                                                onChange={(newValue) => setEndDate(newValue)}
                                                slotProps={{
                                                    textField: {
                                                        size: 'small',
                                                        fullWidth: true,
                                                        sx: unifiedInputStyles,
                                                    },
                                                }}
                                            />
                                        </div>

                                        <div className="flex flex-col gap-2 w-full">
                                            <span className="text-xs text-zinc-500 font-medium">
                                                Máx. estudiantes <span className="text-red-500">*</span>
                                            </span>
                                            <TextField
                                                type="number"
                                                placeholder="0"
                                                value={maxStudents}
                                                onChange={(e) => setMaxStudents(Number(e.target.value))}
                                                size="small"
                                                fullWidth
                                                slotProps={{
                                                    htmlInput: { min: 0 },
                                                }}
                                                sx={unifiedInputStyles}
                                            />
                                        </div>
                                    </div>

                                    <div className='flex gap-6 w-full mt-4'>
                                        <div className='flex flex-col w-full '>
                                            <span className='text-xs text-zinc-500 font-medium mb-2'>Horas requeridas totales <span className='text-red-500'>*</span></span>
                                            <TextField
                                                type='number'
                                                placeholder='0'
                                                value={totalHours}
                                                onChange={(e) => setTotalHours(Number(e.target.value))}
                                                size='small'
                                                slotProps={{
                                                    htmlInput: { min: 0 },
                                                }}
                                                sx={unifiedInputStyles} />
                                            <span className='text-xs text-zinc-500 font-medium mt-2'>Meta total de horas por estudiante</span>
                                        </div>
                                        <div className='flex flex-col w-full '>
                                            <span className='text-xs text-zinc-500 font-medium mb-2'>Max. horas por día <span className='text-red-500'>*</span></span>
                                            <TextField
                                                type='number'
                                                placeholder='0'
                                                value={maxHoursDay}
                                                onChange={(e) => setMaxHoursDay(Number(e.target.value))}
                                                size='small'
                                                slotProps={{
                                                    htmlInput: { min: 0 },
                                                }}
                                                sx={unifiedInputStyles} />
                                            <span className='text-xs text-zinc-500 font-medium mt-2'>Límite diario por estudiante</span>
                                        </div>
                                    </div>

                                    <div className="border border-gray-200 w-full mt-4" />
                                    <div className="flex border-b border-gray-100 mt-4 pb-2">
                                        <span
                                            className="text-sm text-zinc-500 font-semibold"
                                            style={{ fontFamily: '"Inter", sans-serif' }}
                                        >
                                            GEOLOCALIZACIÓN
                                        </span>
                                        <div className='ml-4 h-6 border-l border-zinc-300'></div>
                                        <div className='flex items-center gap-3  w-full '>
                                            <span className='flex items-center ml-4 px-2.5 py-1 text-xs font-bold tracking-wide rounded-md bg-blue-600 text-white border border-zinc-200 uppercase'
                                                style={{ fontFamily: '"Inter", sans-serif' }}>
                                                <ShareLocationIcon sx={{ fontSize: 20 }} />
                                                VALIDACIÓN GPS</span>
                                        </div>
                                    </div>

                                    <div className='grid grid-cols-3 gap-6 w-full items-end mt-5'>
                                        <div className={`flex flex-col gap-2 w-full transition-all duration-300 ${isCapturing ? 'animate-pulse opacity-60' : ''}`}>
                                            <span className='text-sm text-zinc-500 font-semibold' id='span-config'>
                                                {isCapturing ? 'Capturando Latitud...' : <>Latitud<span className='text-red-500'>*</span></>}
                                            </span>
                                            <TextField
                                                type="number"
                                                placeholder={isCapturing ? "Leyendo GPS..." : "13.671940"}
                                                size="small"
                                                fullWidth
                                                value={latitude}
                                                onChange={(e) => setLatitude(e.target.value)}
                                                disabled={isCapturing}
                                                sx={{
                                                    ...unifiedInputStyles,
                                                    '& .MuiOutlinedInput-root': {
                                                        ...(unifiedInputStyles as any)?.['& .MuiOutlinedInput-root'],
                                                        backgroundColor: isCapturing ? '#f0fdf4' : '#fff',
                                                    }
                                                }}
                                            />
                                        </div>
                                        <div className='flex flex-col gap-2 w-full'>
                                            <button
                                                type='button'
                                                onClick={() => setmodalOpenMap(true)}
                                                disabled={isCapturing}
                                                className={`flex items-center justify-center w-full h-[40px] bg-[#031B3F] hover:bg-[#01388A] rounded-md text-white cursor-pointer transition-all ${isCapturing ? 'opacity-50 cursor-not-allowed' : ''}`}
                                            >
                                                <ShareLocationIcon style={{ fontSize: 22 }} />
                                                <span className='px-4 text-[12px]' style={{ fontFamily: '"Inter", sans-serif' }}>
                                                    {isCapturing ? 'Procesando...' : 'Usar ubicación'}
                                                </span>
                                            </button>
                                        </div>
                                        <div className={`flex flex-col gap-2 w-full transition-all duration-300 ${isCapturing ? 'animate-pulse opacity-60' : ''}`}>
                                            <span className='text-sm text-zinc-500 font-semibold' id='span-config'>
                                                {isCapturing ? 'Capturando Longitud...' : <>Longitud <span className='text-red-500'>*</span></>}
                                            </span>
                                            <TextField
                                                placeholder={isCapturing ? "Leyendo GPS..." : "-89.279420"}
                                                type="number"
                                                size="small"
                                                fullWidth
                                                value={longitude}
                                                onChange={(e) => setLongitude(e.target.value)}
                                                disabled={isCapturing}
                                                sx={{
                                                    ...unifiedInputStyles,
                                                    '& .MuiOutlinedInput-root': {
                                                        ...(unifiedInputStyles as any)?.['& .MuiOutlinedInput-root'],
                                                        backgroundColor: isCapturing ? '#f0fdf4' : '#fff',
                                                    }
                                                }}
                                            />
                                        </div>
                                    </div>

                                    <div className='flex flex-col gap-2 w-full mt-5'>
                                        <span className='text-sm text-zinc-500 font-semibold' id='span-config'>Radio permitido (metros) <span className='text-red-500'>*</span></span>
                                        <TextField
                                            type="number"
                                            placeholder="Ej. 100"
                                            size="small"
                                            fullWidth
                                            value={radius}
                                            onChange={(e) => setRadius(e.target.value)}
                                            disabled={isCapturing}
                                            sx={unifiedInputStyles}
                                        />
                                    </div>

                                    <div className="border border-gray-200 w-full mt-4" />
                                    <div className='border border-gray-200 w-full mt-4 bg-gray-200 rounded-md p-4'>
                                        <div className='flex gap-6 w-full'>
                                            <div className='flex flex-col gap-2 justify-between w-full'>
                                                <span className='text-sm text-[13px] font-semibold' style={{ fontFamily: '"Inter", sans-serif' }}>
                                                    Proyecto activo
                                                </span>
                                                <span className='text-xs text-[10px] font-bold text-gray-500' style={{ fontFamily: '"Inter" , sans-serig' }}>
                                                    Los estudiantes pueden registrar horas en este proyecto
                                                </span>
                                            </div>
                                            <div className='flex flex-col gap-7 items-end w-full'>
                                                <PurpleSwitch checked={isActive} onChange={(e) => setIsActive(e.target.checked)} {...label} />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </MuiDialogContent>

                            <MuiDialogActions sx={{
                                display: 'flex',
                                alignItems: 'end',
                                gap: '12px',
                                padding: '20px 24px',
                                borderTop: '1px solid rgba(144,161,185, 0.5)',
                            }}>
                                <button type='button' className='relative group overflow-hidden rounded-lg border border-zinc-300 px-6 py-2 text-black transition-all duration-300 cursor-pointer' onClick={onClose}>
                                    <span className='absolute inset-0 top-1/2 left-1/2 flex h-0 w-0 -translate-x-1/2 -translate-y-1/2 rounded-full bg-rose-700 duration-300 ease-out group-hover:h-56 group-hover:w-56'></span>
                                    <span className='relative text-sm font-semibold p-2 transition-colors duration-300 group-hover:text-white'>Cancelar</span>
                                </button>
                                <button
                                    type='button'
                                    onClick={handleSubmit}
                                    disabled={isSaving}
                                    className='relative group overflow-hidden rounded-lg border border-zinc-300 px-6 py-2 text-black transition-all duration-300 cursor-pointer disabled:opacity-50'
                                >
                                    <span className='absolute inset-0 top-1/2 left-1/2 flex h-0 w-0 -translate-x-1/2 -translate-y-1/2 rounded-full bg-[#1F2836] duration-300 ease-out group-hover:h-56 group-hover:w-56'></span>
                                    <SaveRoundedIcon className='relative transition-colors duration-300 group-hover:text-white' />
                                    <span className='relative text-sm font-semibold p-2 transition-colors duration-300 group-hover:text-white'>
                                        {isSaving ? "Guardando..." : "Registrar programa"}
                                    </span>
                                </button>
                            </MuiDialogActions>
                        </MuiDialog>
                    </LocalizationProvider>
                </ThemeProvider>

                <ModalMap
                    open={modalOpenMap}
                    onClose={() => setmodalOpenMap(false)}
                    onSelectLocation={handleLocationSelect}
                    initialLat={latitude !== "" ? latitude : 13.7942}
                    initialLng={longitude !== "" ? longitude : -88.8965}
                    initialRadius={radius !== "" ? radius : 100}
                />

            </div>

        </>
    );
}