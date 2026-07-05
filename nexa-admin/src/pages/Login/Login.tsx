import '../../styles/index.css';
import HistoryRoundedIcon from '@mui/icons-material/HistoryRounded';


export default function Login() {
    return (
        <main className='min-h-screen w-full flex flex-col lg:flex-row bg-white'>
            <div className='flex flex-col flex-1 items-start justify-start px-6 py-12 sm:px-12 lg:flex-none lg:w-1/2' id='Container'>
                <div className='w-full max-w-sm space-y-6 '>
                    <div className="flex items-center gap-3">
                        <div className='bg-blue-100/10 rounded-lg w-12 h-12 flex items-center justify-center  text-blue-600'>
                            <HistoryRoundedIcon className='table-icon-landing' />
                        </div>
                        <span className='text-md  font-medium text-white '>NEXA UCA</span>
                    </div>
                    <div className='flex items-center mt-3 mb-3 '>
                        <h3 className='text-4xl font-bold text-white' id='title-login'>Gestión de horas sociales, sin fricción.</h3>
                    </div>
                </div>
            </div>
            <div className='hidden lg:flex lg:flex-1 items-center justify-center bg-[#30302E] p-12'>

            </div>
        </main>
    )
}