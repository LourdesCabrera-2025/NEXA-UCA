# App Screens

Esta carpeta contiene las pantallas principales de la aplicación móvil NEXA UCA.

La estructura está organizado por módulos funcionales. Cada pantalla mantiene separado el diseño 
visual de la lógica de presentación mediente archivos `screen` y `view_model`

## Estructura general 

```text
app_screens/
|--- activities_screen/
|--- login_screen/
|--- menu_selection_screen/
|--- notifications_screen/
|--- productivity_screen/
|--- register_hours_screen/
|--- settings_screen/
|--- splash_screen/
```

----

# Módulos

| Archivo               | Descripción                                                                              | Archivos contenidos                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   | 
|-----------------------|------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| activities_screen     | Pantalla encargada de mostrar el historial de actividades registradas  por el estudiante | **activities_screen.dart:** Contiene el diseño visual de la pantalla de actividades <br/>**activities_view_model.dart:**  Contiene la logica relacionada con la carga, filtrado y manejo de actividades                                                                                                                                                                                                                                                                                                                                                               |
| login_screen          | Pantalla encargada del inicio de sesión del usuario                                      | **login_screen.dart:** Contiene el disueño visual del login <br/>**login_view_model.dart:** Maneja la logica de autenticació, estado de carga y redirección posterior al inicio de sesion                                                                                                                                                                                                                                                                                                                                                                             |
| menu_selection_screen | Pantalla principal del estudiante despues de iniciar sesión                              | **menu_selection_screen.dart:** Contiene el diseño del menu principañ y accesos a las funciones principales <br/>**menu_selection_view_model.dart:** Maneja la información principal del estudiante, progreso general y navegación                                                                                                                                                                                                                                                                                                                                    |
| notifications_screen  | Pantalla encargada de mostrar notificaciones de notificaciones                           | **notification_screen.dart:**  Contiene el diseño visual de la pantalla de notificaciones <br/>**notification_view_model.dart:** Maneja la carga, lectura y estado de las notificaciones                                                                                                                                                                                                                                                                                                                                                                              |
| productivity_screen   | Pantalla encargada de mostrar métricas, estadísticas y productividad del estudiante      | **productivity_screen.dart:** Contiene el diseño visual del dashboard de productividad <br/>**productivity_view_model.dart:** Maneja la lógica relacionado con estadística, progreso y actividades recientes                                                                                                                                                                                                                                                                                                                                                          |
| register_hours_screen | Módulo encargado del registro de horas sociales                                          | **register_hours_screen.dart:** Pantalla principal del registro de horas sociales <br/>**gps_validation_modal.dart:** Modal envargado de mostrar el resultado de la validación de ubicación <br/>**active_timer_screen.dart:** Pantalla encargada de mostrar la jornada activa y el temporizador en tiempo real <br/>**approval_request_modal.dart:** Modal utilizado para enviar la solicitud de aprobación de horas <br/>**register_hours_view_model.dart:** Maneja la lógica de validación GPS, inicio de jornada, temporizador, finalización y envió de solicitud |
| settings_screen       | Pantalla encargada de la configuración general de la cuenta                              | **settings_screen.dart:** Contiene el diseño visual de la pantalla de configuración <br/>**settings_view_model.dart:** Maneja preferencias,datos de usuario y acciones relacionadas con la cuenta                                                                                                                                                                                                                                                                                                                                                                     |
| splash_screen         | Pantalla inicial de carga de la aplicación                                               | **splash_screen.dart:** Contiene el diseño del splash screen <br/>**splash_view_model.dart:** Maneja la verificación de sesión activa y redirección inicial                                                                                                                                                                                                                                                                                                                                                                                                           |


--------------------------------------

# Convención utilizada 

Cada módulo sigue una estructura basada en MVVM: 

```text
Screen
-> ViewModel
-> Repository
-> Service / Firebase
```
### Screen: Se encarga de mostrar la interfaz visual
### ViewModel: Se encarga de manejar estados, validaciones y llamadas a repositorios
### Repository: Se encarga de organizar el acceso a datos
### Service: Se encarga de comunicarse con servicios externos como Firebase, GPS o notificaciones

----

# Objetivo 

Esta organización permite mantener una estructura clara, modular y escalable, facilitando el mantenimiento de la aplicación y evitando mezcla la interfaz visual con la lógica del sistema
