# Helper Functions

Esta carpeta contiene funciones auxiliares reutilizables utilizadas para apoyar 
distintos procesos internos de la aplicación NEXA UCA

El objetivo de esta sección es centralizar lógica utilitaria que pueda ser compartida entre 
múltiples módulos sin depender directamente de la interfaz visual 

Estas funciones ayudan a mantener el código mucho más limpio, organizado y reutilizable 

----

## Responsabilidades 

- Formato de datos 
- Validaciones reutilizables
- Manipulación de fechas y tiempo
- Funciones auxiliares relacionadas con GPS 
- Manejo de sesionesy estados temporales 

---

# Archivos Principales 

| Archivos                     | Funcion                                                                                                | Descripción                                                              | 
|------------------------------|--------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------|
| **_gps_helper.dart_**        | 1. Cáculo de distancia<br/>2. Verificación de rango<br/>3. Conversión de coordenadas                   | Funciones relacionadas con geolocalización                               |
| **_time_formatter.dart_**    | 1. Conversión de minutos<br/>2. Formato HH<br/>3.Duración de Jornadas                                  | Funciones relacionadas con el manejo y formato de tiempo                 |
| **_validation_helper.dart_** | 1. Validación de correo institucional<br/> 2. Validación de campos vacios<br/>3. Validación de texto   | Validaciones reutilizables utilizadas en formularios y procesos internos |
| **_session_helper.dart_**    | 1. Cálculo de tiempo transcurrido<br/> 2. Verificación de sesiones activas<br/> Conversión de duración | Funciones relacionadas con sesiones activas y control temporal           |


 