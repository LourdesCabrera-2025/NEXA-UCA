# Backend Services 

Esta carpeta contiene los servicios encargados de la comunicación entre la aplicación móvil y herramientas
externas utilizadas por NEXA UCA 

Los servicios gestionan procesos relacionados con autenticación, Firebase, GPS , 
notificaciones y funcionalidades de soporte técnico 

El objetivo es separar la lógica de comunicación externa de la interfaz visual y mantener una 
arquitectura más limpia y escalable.

-----------------------------------------------------------------------------
## Responsabilidades 

1. Comunicación con Firebase
2. Autenticación de usuarios
3. Manejo de Geolocalización
4. Gestión de notificaciones
5. Control de temporizadores y sesiones activas 

------------------------------------------------------------------------------
## Archivos Pricipales 

| Archivos                    | Funcionalidad                                                                                                | Descripción                                                    |
|-----------------------------|--------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------|
| firebase_service.dart       | 1. Inicialización Firebase<br/>2.Firestore<br/>3.Storage<br/>Configuración global                            | Configuración relacionada con Firebase                         |
| authentication_service.dart | 1. Inicio de sesion<br/>2. Cierre de Sesión<br/>3. Validación de sesión<br/>4. Integración con Microsoft 365 | Procesos relacionados con autenticación                        |
| gps_service.dart            | 1. Obtención de ubicación actual<br/>2.Validación geográfica<br/>3. Verificación de rango permitido          | Gestión de geolocalización y permisos GPS                      |
| notification_service.dart   | 1. Notificaciones locales<br/>2.Alertas<br/>3.Actualización de estados                                       | Gestiona las notificaciones utilizadas                         |
| timer_service.dart          | 1.Inicio de temporizador<br/>2.Pausa<br/>3.Finalización<br/>Cálculo de duración                              | Gestiona el termporizador utilizado durante las horas sociales |