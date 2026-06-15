import './styles/index.css';
import MicrosoftIcon from '@mui/icons-material/Microsoft';
import CorporateFareRoundedIcon from '@mui/icons-material/CorporateFareRounded';
import RoomRoundedIcon from '@mui/icons-material/RoomRounded';
import AccessTimeFilledRoundedIcon from '@mui/icons-material/AccessTimeFilledRounded';
import SecurityRoundedIcon from '@mui/icons-material/SecurityRounded';
import CheckCircleOutlineRoundedIcon from '@mui/icons-material/CheckCircleOutlineRounded';
import LeaderboardRoundedIcon from '@mui/icons-material/LeaderboardRounded';
import PeopleAltSharpIcon from '@mui/icons-material/PeopleAltSharp';
import NotificationsRoundedIcon from '@mui/icons-material/NotificationsRounded';
import CardRole from './assets/components/Cards/CardRole';
import PersonRoundedIcon from '@mui/icons-material/PersonRounded';
import SupervisorAccountRoundedIcon from '@mui/icons-material/SupervisorAccountRounded';
import SchoolRoundedIcon from '@mui/icons-material/SchoolRounded';
import WindowsIcon from '@mui/icons-material/Window';
import React from 'react';
import {Link } from'react-router-dom';


interface AppOptions {
  date?: React.ReactNode
}


function App(props: AppOptions) {



  return (
    <>
      <header className="HeroSection w-full border-b border-gray-200 shadow-sm">
        <nav aria-label="Global" className="nav-section relative after:pointer-events-none after:absolute after:inset-x-0 after:bottom-0 after:h-px after:bg-white/10 " >
          <div className="mx-auto max-w-7xl px-2 sm:px-6 lg:px-8">
            <div className="relative flex h-26 items-center justify-between">
              <div className="flex shrink-0 items-center ">
                <a href="#" className="-m-1.3 p-1.5 flex items-center gap-x-3">
                  <span className="sr-only">Nexa</span>
                  <img className="h-26 w-auto" src="/ic_nexa.svg" alt="Nexa" />
                  <h4 className="text-xl text-uca tracking-tight">NEXA UCA</h4>
                </a>
              </div>

              <div className="flex flex-1 items-center justify-center sm:items-stretch sm:justify-start">
                <div className="hidden sm:ml-6 sm:block">
                  <div className="flex space-x-4 items-center">
                    <a href="#funciones" className="rounded-md px-3 py-2 text-sm text-uca-link ">Funciones</a>
                    <a href="#" className="rounded-md px-3 py-2 text-sm text-uca-link ">Cómo funciona</a>
                    <a href="#" className="rounded-md px-3 py-2 text-sm text-uca-link ">Para quién</a>
                    <a href="#" className="rounded-md px-3 py-2 text-sm text-uca-link ">Acceso</a>
                  </div>
                </div>
              </div>
              <div className="absolute inset-y-0 right-0 flex items-center pr-2 sm:static sm:inset-auto sm:ml-6 sm:pr-0">
                <Link to={"/Login"} className="relative rounded-full p-1 button-login ">
                  Ingresar al portal
                </Link>
              </div>
            </div>
          </div>

        </nav>
      </header>
      <main>
        <div className="mx-auto max-w-7xl px-4 py-6 sm:px-6 lg:px-8 ">
          <div className="flex w-full justify-center bg-gray-100 rounded-lg ">
            <div className="flex items-center p-4">
              <CorporateFareRoundedIcon className="text-gray-600 mr-2" />
              <h4 className="text-sub text-lg font-medium text-gray-600">Universidad Centroamericana Jóse Simón Cañas |</h4>
              <h4 className="text-sub text-lg font-medium text-gray-600 ml-4">Ciclo 01 - 2026</h4>
            </div>
          </div>

          <div className="grid grid-cols-1 lg:grid-cols-12 gap-12 items-start mt-8 pt-12">
            <div className="lg:col-span-7 flex flex-col items-start justify-center  space-y-4">
              <h1 className="title text-4xl font-bold text-gray-800 leading-tight">Control de horas sociales, <span className="text-4xl font-bold text-gray-600 ">sin fricción</span></h1>
              <p className="text-lg text-gray-600 max-w-xl leading-relaxed">NEXA UCA centraliza el registro, validación y seguimiento de las horas sociales realizadas por los estudiantes. Los supervisores aprueban en segundos cada solicitud y los estudiantes llevan su avance en tiempo real.</p>

              <div className="flex justify-between items-center mt-6 pt-5 space-x-4">
                <Link to={"/Login"} className="relative rounded-lg p-4 button-login ">
                  <MicrosoftIcon className="mr-2" />
                  Ingresar con Microsoft 365
                </Link>
                <button className="relative rounded-lg p-4 button-access ">
                  Ver cómo funciona
                </button>
              </div>
              <div className="flex justify-between items-center mt-6 pt-5 space-x-6">
                <RoomRoundedIcon className='mr-2 material-icon-landing' />
                <p className="text-sub text-sm text-gray-500 ">Validación GPS</p>
                <AccessTimeFilledRoundedIcon className="mr-2 material-icon-landing" />
                <p className='text-sub text-sm text-gray-500  '>Tiempo real</p>
                <SecurityRoundedIcon className='mr-2 material-icon-landing' />
                <p className='text-sub text-sm text-gray-500 '>Acceso Institucional</p>
              </div>
            </div>
            <div className="lg:col-span-5 flex flex-col items-center justify-center">

              <div className="relative mx-auto border-gray-800 bg-gray-800 border-[14px] rounded-[2.5rem] h-[700px] w-[340px] shadow-2xl">
                <div className="absolute top-0 inset-x-0 flex justify-center">
                  <div className="h-4 w-20 bg-gray-800 rounded-b-xl"></div>
                </div>

                <div className="rounded-[2rem] overflow-hidden w-full h-full   bg-white">
                  <img src="/productividad_estudiantes.png" alt="App Estudiantes" className="w-full h-full object-cover object-top select-none" />
                </div>
              </div>
            </div>
          </div>
        </div>

        <div className="w-full border-b border-gray-200"></div>
        <section className="relative w-full  overflow-hidden py-16 text-white my-8 bg-gray-900">
          <img src="/uca.webp" alt="Fondo Estadisticas" className='absolute inset-0 h-full w-full object-cover ' />
          <div className="absolute inset-0 bg-gradient-to-r from-[#022873]/95 via-[#022873]/90 to-[#022873]/95 mix-blend-multiply"></div>

          <div className="relative z-10 mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
            <div className="grid grid-cols-2 lg:grid-cols-4 gap-8 text-center divide-x divide-white/20">
              <div className="flex flex-col items-center p-2">
                <span className='text-sub text-5xl font-black text-white tracking-tight'>600h</span>
                <span className='text-sm font-medium text-blue-100 mt-2'>Meta de horas por estudiante</span>
              </div>
              <div className="flex flex-col items-center p-2">
                <span className='text-sub text-5xl font-black text-white tracking-tight'>97%</span>
                <span className='text-sm font-medium text-blue-100 mt-2'>Tasa de validación GPS</span>
              </div>
              <div className="flex flex-col items-center p-2">
                <span className="text-sub text-5xl  items-center  ">10</span>
                <span className='text-sm font-medium text-blue-100 mt-2'>Proyectos activos este ciclo</span>
              </div>
              <div className='flex flex-col items-center p-2'>
                <span className='text-sub text-5xl items-center '>92%</span>
                <span className='text-sm font-medium text-blue-100 mt-2'>Tasa de aprobación</span>
              </div>
            </div>
          </div>
        </section>
        <div className="w-full border-b border-gray-200"></div>

        <section id="funciones" className='w-full bg-white py-20'>
          <div className="mx-auto max-w-6xl px-4 sm:px-6 lg:px-8">
            <div className="text-left max-w-3xl mb-16">
              <div className="flex  justify-start">
                <span className='text-xs font-bold uppercase tracking-widest text-[#5E6875] bg-gray-50 py-1.5 rounded-xs px-4'>
                  Funciones
                </span>
              </div>
              <h2 className='text-4xl font-medium text-gray-900 tracking-tight mt-4 mb-4 text-table'>
                Todo lo que un supervisor necesita
              </h2>
              <div className='text-lg text-gray-500 leading-relaxed text-table'>
                Desde la aprobación de jornadas hasta el seguimiento por proyecto, todo en un solo lugar
              </div>
            </div>
          </div>
          <div className="relative z-10 mx-auto max-w-6xl px-4 sm:px-6 lg:px-8 w-full rounded-xl border-gray-200 overflow-hidden bg-white shadow-sm ">
            <div className="grid grid-cols-1 lg:grid-cols-3 py-12 divide-y lg:divide-y-0  lg:divide-x divide-gray-200 border-b border-gray-200">
              <div className='flex flex-col gap-4 items-start p-6 lg:pr-12'>
                <div className='bg-gray-100 rounded-lg w-12 h-12 flex items-center justify-center text-gray-600'>
                  <CheckCircleOutlineRoundedIcon className='table-icon-landing' />
                </div>
                <span className='text-table text-xl text-gray-900 font-bold items-center'>Aprobaciones rápidas</span>
                <span className='text-sm text-start font-normal text-gray-400'>Revisa y aprueba solicitudes de horas con un clic. Accede al detalle completo de cada jornada</span>
              </div>

              <div className="flex flex-col gap-4 items-start p-6 lg:pr-12 ">
                <div className='bg-gray-100  rounded-lg w-12 h-12 flex items-center justify-center text-gray-600'>
                  <RoomRoundedIcon className='table-icon-landing' />
                </div>
                <span className='text-table text-xl text-gray-900 font-bold items-center'>Validación por GPS</span>
                <span className='text-sm text-start font-normal text-gray-400'>Cada jornada verifica  la  ubicación del estudiante dentro del  área autorizada del campus</span>
              </div>

              <div className='flex flex-col gap-4 items-start p-6 lg:pr-12'>
                <div className="bg-gray-100 rounded-lg w-12 h-12 flex items-center justify-center text-gray-600">
                  <AccessTimeFilledRoundedIcon className='table-icon-landing' />
                </div>
                <span className='text-table text-xl text-gray-900 font-bold items-center'>Registro en tiempo real</span>
                <span className='text-sm text-start font-normal text-gray-400'>El temporizador corre desde el móvil del estudiante. Tú ves el avance al instante</span>
              </div>

            </div>
            <div className="grid grid-cols-1 lg:grid-cols-3 py-12 divive-y lg:divide-y-0 lg:divide-x divide-gray-200">
              <div className="flex flex-col gap-4 items-start p-6 lg:pr-12">
                <div className="bg-gray-100 rounded-lg w-12 h-12 flex items-center justify-center text-gray-600">
                  <LeaderboardRoundedIcon className='table-icon-landing' />
                </div>
                <span className='text-table text-xl text-gray-900 font-bold items-center'>Dashboard por proyecto</span>
                <span className='text-sm text-start font-normal text-gray-400'>Visualiza horas acumuladas, participantes activosy solicitudes pendientes por proyecto</span>
              </div>
              <div className="flex flex-col gap-4 items-start p-6 lg:pr-12">
                <div className="bg-gray-100 rounded-lg w-12 h-12 flex items-center justify-center text-gray-600">
                  <PeopleAltSharpIcon className='table-icon-landing' />
                </div>
                <span className='text-table text-xl text-gray-900 font-bold items-center'>Seguimieno individual</span>
                <span className='text-sm text-start font-normal text-gray-400'>Consulta el progreso de cada estudiante, su historial de actividades y estado académico.</span>
              </div>
              <div className="flex flex-col gap-4 items-start p-6 lg:pr-12">
                <div className="bg-gray-100 rounded-lg w-12 h-12 flex items-center justify-center text-gray-600">
                  <NotificationsRoundedIcon className='table-icon-landing' />
                </div>
                <span className='text-table text-xl text-gray-900 font-bold items-center'>Notificaciones push</span>
                <span className='text-sm text-start font-normal text-gray-400'>Recibe alertas cuando un estudiante envia una solicitud que requiere tu atención</span>
              </div>
            </div>
          </div>
        </section>

        <section id='pasos' className='w-full border-t border-gray-200 bg-[#FAFAFA] py-20'>
          <div className="mx-auto max-w-6xl px-4 sm:px-6 lg:px-8">
            <div className="text-left max-w-3xl mb-16">
              <div className="flex justify-start">
                <span className='text-xs font-bold uppercase tracking-widest text-[#5E6875] bg-gray-200/50 py-1.5 rounded-md px-4'>
                  CÓMO FUNCIONA
                </span>
              </div>
              <h2 className='text-4xl text-table text-gray-900 tracking-tight mt-4'>
                Del registro a la aprobación en 4 pasos
              </h2>
            </div>
            <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-8 lg:gap-5 divide-y sm:divide-y-0 lg:divide-x divide-gray-200">
              <div className="flex flex-col items-start pt-6 sm:pt-0 pr-4">
                <span className='text-sm font-bold font-mono text-gray-300 tracking-wider'>01</span>
                <h3 className='text-xl text-table text-gray-900 mt-3 mb-3 leading-snug'>
                  El estudiante llega al proyecto
                </h3>
                <p className='text-sm text-gray-500 leading-relaxed text-start'>
                  La app detecta su ubicación vía GPS y confirma que está en el área autorizada.
                </p>
              </div>

              <div className="flex  flex-col items-start pt-6 sm:pt-0 pr-4">
                <span className='text-sm font-bold font-mono text-gray-300 tracking-wider'>02</span>
                <h3 className='text-xl text-table text-gray-900 mt-3 mb-3 leading-snug'>
                  Inicia la jornada
                </h3>
                <p className='text-sm text-gray-500 leading-relaxed text-start'>
                  El temporizador comienza automáticamente y registra el tiempo en segundo plano.
                </p>
              </div>

              <div className='flex flex-col items-start pt-6 sm:pt-0 pr-4'>
                <span className='text-sm font-bold font-mono text-gray-300 tracking-wider'>03</span>
                <h3 className='text-xl text-table text-gray-900 mt-3 mb-3 leading-snug'>
                  Describe y envía
                </h3>
                <p className='text-sm  text-gray-500 leading-relaxed text-start'>
                  Al finalizar, el estudiante agrega una descripción y envía la solicitud de aprobación
                </p>
              </div>

              <div className='flex flex-col  items-start pt-6 sm:pt-0 pr-4'>
                <span className='text-sm font-bold font-mono  text-gray-300 tracking-wider'>04</span>
                <h3 className='text-xl text-table text-gray-900 mt-3 mb-3 leading-snug'>
                  El supervisor aprueba
                </h3>
                <p className='text-sm text-gray-500 leading-relaxed text-start'>
                  Revisas los detalles y apruebas con un clic, El estudiante recibe la notificación al instante
                </p>
              </div>
            </div>
          </div>
        </section>

        <section id='roles' className='w-full bg-white border-t border-gray-200 py-20'>
          <div className="mx-auto max-w-6xl px-4 sm:px-6 lg:px-8">
            <div className="text-left max-w-3xl mb-16">
              <div className="flex justify-start">
                <span className="text-xs uppercase font-bold tracking-widest text-[#5E6875] bg-gray-200/50 py-1.5 rounded-md px-4">
                  PARA QUIÉN
                </span>
              </div>
              <h2 className='text-4xl text-table text-gray-900 tracking-tight mt-4'>Un sistema, 3 roles</h2>
            </div>
            <div className='grid grid-cols-1 md:grid-cols-3 gap-8 items-stretch max-w-7xl'>
              {/*Card 1: Estudiantes*/}
              <CardRole
                title="Estudiante"
                description='Registra tus jornadas, consulta tu avance y recibe confirmaciones en tiempo real'
                icon={<PersonRoundedIcon />}
                features={[
                  "Registro digital de jornada",
                  "Historial de actividades",
                  "Estado de solicitudes",
                  "Progreso hacia las 600h"
                ]}
              />
              <CardRole
                title="Supervisor de proyecto"
                description='Aprueba solicitudes, gestiona participantes y monitorea el avance de cada proyecto'
                icon={<SupervisorAccountRoundedIcon />}
                features={[
                  "Panel de aprobaciones",
                  "Gestión de proyectos",
                  "Seguimientos por participante",
                  "Exportación de reportes"
                ]}
                isDark={true}
              />

              <CardRole
                title="Coordinador académico"
                description='Vista administrativa completa sobre todos los proyectos y estudiantes del ciclo'
                icon={<SchoolRoundedIcon />}
                features={[
                  "Vista global del ciclo",
                  "Estadística institucionales",
                  "Auditoría de registros",
                  "Control de accesos"
                ]}
              />

            </div>

          </div>
        </section>
        <section id="cta" className='w-full bg-white py-24 border-t border-gray-200'>
          <div className='mx-auto max-w-4xl px-4 sm:px-6 lg:px-8 texte-center flex flex-col items-center'>
            <h2 className='text-4xl sm:text-5xl font-extrabold text-gray-900 tracking-tight mb-4'>
              Listo para empezar
            </h2>

            <p className='text-base sm:txt-lg text-gray-400 font-normal max-w-xl leading-relaxed mb-10'>
              Accede con tu cuenta institucional de Microsoft 265 de la UCA
            </p>
            <div className='flex flex-col sm:flex-row items-center justify-center gap-4 w-full sm:w-auto'>
              <Link to={"/Login"} className='flex items-center justify-center gap-3 button-login font-medium text-sm py-3.5 px-6 rounded-xl transition-all w-full sm:w-auto shadow-sm active:scale[0.98]'>
                <WindowsIcon sx={{ fontSize: 16 }} />
                <span>Continuar con Microsoft 365</span>
              </Link>
            </div>
          </div>
        </section>
        <footer className='w-full bg-white py-20 border-t border-gray-200 relative overflow-hidden bg-footer'>
          <div className='mx-auto max-w-3xl px-4 sm:px-6 lg:px-8 flex flex-col items-center justify-center text-center gap-4'>
            <div className='w-18 h-18 bg-black'
              style={{
                WebkitMaskImage: 'url("/main_icon.png")',
                maskImage: 'url("/main_icon.png")',
                WebkitMaskSize: 'contain',
                maskSize: 'contain',
                WebkitMaskRepeat: 'no-repeat',
                maskRepeat: 'no-repeat',
                WebkitMaskPosition: 'center',
                maskPosition: 'center'
              }}
              aria-label='Logo Nexa UCA'
            />
            <div className="flex flex-col items-center gap-1.5">
              <span className='text-base font-black tracking-tight text-gray-900 leading-none'>
                NEXA <span className='text-gray-500'>UCA</span>
              </span>
              <span className='text-[15px] text-gray-400 font-normal mt-1'>
                Universidad Centroamericana José Simeón Cañas
              </span>
            </div>
            <div className='text-xs font-normal text-gray-400 mt-2'>
              &copy; {new window.Date().getFullYear()} Todos los derechos reservados.
            </div>
          </div>
        </footer>
      </main>
    </>
  )
}

export default App                                                      
