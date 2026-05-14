# Repositories
 
Esta carpeta contiene los repositories encargados de gestionar el acceso y organización de los datos
dentro de la aplicación móvil NEXA UCA.

Los repositories funcionan como una capa intermedia entre: 
- las pantallas y view models (`app_screens`)
- los servicios externos (`backend_services`).

Su objetivo es centralizar la lógica relacionada con la obtención, consulta , actualización y manejo 
de información dentro del sistema.

---

# Responsabilidades principales

Los repositories se encargan de : 

- Obtener información desde Firebase
- Organizar consultas y respuestas de datos 
- Centralizar lógica relacionada con usuarios y sesiones
- Gestionar actividades y solicitudes de aprobación 
- Facilitar comunicaión entre la app y la base de datos 
- Evitar acceso directo a Firebase desde las pantallas 

---

```text
Screen
-> ViewModel
-> Repository
-> Backend Service
-> Firebase / APIs externas 
```
---
# Archivos
## activity_repository.dart 

Repositorio encargado del manejo de actividades mostradas dentro de la aplicación 

### Funciones principales 

- Obtener actividades registradas 
- Consultar actividades recientes 
- Mostrar historial de actividades 
- Gestionar información relacionada con productividad y actividad del estudiante 

---

## approval_repository.dart

Repositorio encargado del flujo de solicitudes y aprobaciones de horas sociales 

### Funciones principales

- Enviar solicitudes de aprobación 
- Consultar estados de aprobación 
- Obtener historial de solicitudes enviadas 
- Gestionar información relacionada con horas aprobadas o pendientes

---

## authentication_repository.dart 

Repositorio encargado del flujo de autenticación de usuarios

### Funciones principales

- Inicio de sesion 
- Cierre de sesión 
- Verificación de sesión activa 
- Obtener usuario autenticado 
- Integración con Microsoft Authentication 

---

## notification_repository.dart

Repositorio encargado de la gestión de notificaciones del sistema 

### Funciones principales

- Obtener notificaciones del estudiante 
- Consultar historial de notificaciones 
- Gestionar estados de lectura 
- Sincronizar notificaciones entre la plataforma web y la aplicación móvil 

---

## session_repository.dart

Repositorio encargado del manejo de sesiones activas deñ estudiante dentro de la aplicación 

### Funciones principales 

- Gestionar estado de sesión del usuario 
- Validar sesiones activas
- Registrar inicio y cierre de jornadas
- Registrar inicio y cierre de jornadas 
- Gestionar tiempo activo dentro del sistema 

---

## user_repository.dart 

Repositorio encargado de la información del estudiante autenticado 

### Funciones principales

- Obtener información del estudiante 
- Consultar datos del perfil
- Obtener rol del usuario 
- Gestionar información básica de cuenta 

---

# Objetivo 

Esta estructura permite mantener una arquitectura modular y escalable. separando: 

- Interfaz visual
- Lógica de presentación 
- acceso a datos,
- comunicación con servicios externos 

Facilitando así el mantenimiento y crecimiento futuro del proyecto **NEXA UCA**

