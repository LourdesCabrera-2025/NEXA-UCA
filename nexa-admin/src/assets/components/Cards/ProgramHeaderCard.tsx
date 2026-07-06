import * as React from 'react';
import '../../../styles/index.css';
import { Card, Box, Typography, Chip } from '@mui/material';
import AccessTimeRoundedIcon from '@mui/icons-material/AccessTimeRounded';
import PersonRoundedIcon from '@mui/icons-material/PersonRounded';
import MyLocationRoundedIcon from '@mui/icons-material/MyLocationRounded';


interface ProgramHeaderCardProps {
    title: string;
    description: string;
    status: string;
    type: string;
    supervisor: string;
    coordinates: string;
    maxHoursPerDay: number;
}

export default function ProgramHeaderCard({
    title,
    description,
    status,
    type,
    supervisor,
    coordinates,
    maxHoursPerDay
}: ProgramHeaderCardProps) {
    return (
        
            <Box sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
                {/* Tarjeta Principal de Encabezado (Blanca) */}
                <Card
                    elevation={0}
                    sx={{
                        display: 'flex',
                        justifyContent: 'space-between',
                        alignItems: 'start',
                        backgroundColor: '#FFFFFF',
                        p: 3,
                        borderRadius: '16px',
                        border: '1px solid #E4E4E7', // zinc-200
                    }}
                >
                    <Box sx={{ display: 'flex', flexDirection: 'column', gap: 0.5 }}>
                        <Box sx={{ display: 'flex', alignItems: 'center', gap: 1.5 }}>
                            <Typography variant="h5" sx={{ fontWeight: 'bold', color: '#18181B' , fontFamily: '"Inter", sans-serif'}}>
                                {title}
                            </Typography>
                            <Chip
                                label={status}
                                size="small"
                                sx={{
                                    backgroundColor: '#DCFCE7', // green-100
                                    color: '#166534', // green-800
                                    fontWeight: 600,
                                    fontSize: '12px',
                                    border: '1px solid #BBF7D0',
                                    fontFamily: '"Inter", sans-serif'
                                }}
                            />
                        </Box>
                        <Typography sx={{ fontSize: '14px', color: '#71717A', maxWidth: '42rem', mt: 1 , fontFamily: '"Inter", sans-serif'}}>
                            {description}
                        </Typography>
                    </Box>

                    <Chip
                        label={type}
                        variant="outlined"
                        sx={{
                            backgroundColor: '#F4F4F5', // zinc-100
                            color: '#3F3F46', // zinc-700
                            fontWeight: 500,
                            fontSize: '12px',
                            borderRadius: '8px',
                            border: '1px solid #E4E4E7',
                            flexShrink: 0,
                            fontFamily: '"Inter", sans-serif',

                        }}
                    />
                </Card>

                {/* Barra de Detalle Secundario (Blanca) */}
                <Card
                    elevation={0}
                    sx={{
                        backgroundColor: '#FFFFFF',
                        px: 3,
                        py: 1.75,
                        borderRadius: '16px',
                        border: '1px solid #E4E4E7',
                        display: 'flex',
                        flexWrap: 'wrap',
                        columnGap: 4,
                        rowGap: 1,
                        fontFamily: '"Inter", sans-serif'
                    }}
                >
                    <Box sx={{ display: 'flex', alignItems: 'center', gap: 1, fontSize: '13px', color: '#52525B' }}>
                        <PersonRoundedIcon sx={{ fontSize: 18, color: '#A1A1AA' }} />
                        Supervisor: <span style={{ color: '#18181B', fontWeight: 600 }}>{supervisor}</span>
                    </Box>
                    <Box sx={{ display: 'flex', alignItems: 'center', gap: 1, fontSize: '13px', color: '#18181B', fontWeight: 600 }}>
                        <MyLocationRoundedIcon sx={{ fontSize: 18, color: '#A1A1AA' }} />
                        {coordinates}
                    </Box>
                    <Box sx={{ display: 'flex', alignItems: 'center', gap: 1, fontSize: '13px', color: '#52525B' }}>
                        <AccessTimeRoundedIcon sx={{ fontSize: 18, color: '#A1A1AA' }} />
                        Máx. <span style={{ color: '#18181B', fontWeight: 600 }}>{maxHoursPerDay}h</span> /día
                    </Box>
                </Card>
            </Box>
        )
}