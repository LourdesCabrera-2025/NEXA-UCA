import React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CheckIcon from '@mui/icons-material/Check';



interface CarRoleProps {
    title: string;
    description: string;
    icon:  React.ReactNode;
    features?: string[];
    isDark?: boolean;
}

export default function CardRole({
    title = "",
    description = "",
    icon,
    features = [],
    isDark = false
}: CarRoleProps) {

    return(
        <Card 
        className='Card-Role'
        sx={{
            width: '100%',
            backgroundColor: isDark ? '#121212' : '#ffffff',
            borderRadius: '16px',
            boxShadow: isDark ? '0 10px 25px -5px rgba(0,0,0,0.3)' : '0 4p 6px -1px rgba(0,0,0,0.5)',
            border: isDark ?'1px solid  #222222'  : '1px solid #E2E8f0',
            padding: '32px 24px',
            transition: 'transform 0.2s ease-in-out',
            '&hover': {
                transform : 'translateY(-4px)'
            }
        }}>

            <CardContent className='flex flex-col items-start p-0 pb-0 last:pb-0'>
                <div className={`rounded-xl w-12 h-12 flex items-center justify-center ${
                    isDark ? 'bg-zinc-800 text-white' : 'bg-gray-100 text-gray-700'
                } `}>
                    {icon}
                </div>

                <h4 className={`text-xl font-bold mt-6 mb-3 ${isDark? 'text-white' : 'text-gray-900'}`}>
                    {title}
                </h4>
                <p className={`text-sm font-normal leading-relaxed text-start mb-6 ${isDark? 'text-zinc-400' : 'text-gray-500'}`}>
                    {description}
                </p>

                <div className={`w-full h-[1px] mb-4> ${isDark? 'bg-zinc-800' : 'bg-gray-100'}`}></div>

                <ul className='w-full flex flex-col gap-3 mt-2'> 
                    {features.map((feature, index) => (
                        <li key={index} className='felx items-start gap-3 text-sm text-start'>
                            <CheckIcon 
                            sx={{
                                fontSize:16,
                                margintTop:'3px',
                                color: isDark ? '#52525b' : '#cbd5e1'
                            }}
                            />
                            <span className={isDark ? 'text-zinc-300' : 'text-gray-600'}>
                                {feature}
                            </span>
                        </li>
                    ))}
                </ul>
            </CardContent>

        </Card>
    );
}