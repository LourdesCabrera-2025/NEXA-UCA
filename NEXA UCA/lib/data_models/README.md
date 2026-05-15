# Data Models

Esta carpeta contiene los modelos principales de datos utilizados dentro de la aplicación NEXA UCA 

Los modelos representan la estructura de la información utilizada por Firebase, la lógica de negocio 
y la interfaz visual 

El objetivo de esta sección es mantener una representación organizada y consistente de los datos 
utilizados dentro del sistema 

----
## Responsabilidades 

- Representación estructurada de datos 
- Conversión entre Firebase y objetos Dart
- Organización de entidades principales del sistema
- Centralización de estructuras de información 

---

## Modelos principales 

| Modelos                     | Descripción                                                        | ¿Qué trabaja                                                                                   | 
|-----------------------------|--------------------------------------------------------------------|------------------------------------------------------------------------------------------------|
| user_model.dart             | Representa la información de un usuario dentro del sistema         | 1.UID <br/>2. Nombre <br/>3. Correo Institucional <br/>4. Rol <br/>5. Estado de cuenta         |
| project_model.dart          | Representa un proyecto de horas sociales                           | 1.Nombre del proyecto <br/>2.Ubicación <br/>3. Radio permitido <br/>4. Encargado               |
| activity_model.dart         | Representa las actividades realizadas por un estudiante            | 1.Descripción <br/>2.Fecha <br/>3.Horas realizadas <br/>4.Estado                               |
| active_session_modal.dart   | Representa una sesioón activa de horas sociales                    | 1.Hora de inicio <br/> 2.Hora de finalización <br/> 3.Tiempo acumulado <br/>4.Estado de sesión |
| approval_request_model.dart | Representa una solicitud enviada para aprobación de horas sociales | 1.Actividad realizada <br/>2.Tiempo acumulado <br/>3.Estado de aprobación <br/> 4.Commentarios |
| notification_model.dar      | Representa notificaciones generadas dentro del sistema             | 1.Tipo de notificación <br/>2.Mensaje <br/>3.Fecha <br/>4.Estado de lectura                    |

