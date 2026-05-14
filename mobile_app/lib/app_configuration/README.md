# App Configuration

Esta carpeta contiene toda la configuración
global utilizada dentro de la aplicación móvil NEXA UCA

El objetivo de esta sección es centralizar elementos
compartidos por toda la aplicación para mantener consistencia visual
, facilitar mantenimiento y evitar duplicación de código

## Responsabilidades 

- Configuración de colores oficiales
- Configuración del tema global 
- Manejo de rutas y navegación 
- Definición de tamaños y espaciados
- Configuración de tipografias 
- Centralización de textos constantes 

----
# Archivos Principales 

### app_colors.dart

Contiene la paleta oficial de colores utilizada en la aplicación 

Ejemplo: 

- Color principal institucional 
- Colores secundarios
- Colores de estados
- Backgrounds 
- Colores de texto
---
### app_theme.dart

Define el tema global de flutter utilizado por toda la aplicación 

Responsabilidades: 

- Tema claro
- Estilos generales
- Configuración visual global 
- Apariencia consistente 

----
### app_routes.dart

Centraliza todas las rutas de navegación utilizadas dentro de la aplicación 

Ejemplos:

- Login 
- Dashboard principal 
- Registro de horas
- Productividad 
- Configuración 

---
### app_strings.dart 

Contiene textos constantes reutilizados dentro de la aplicación.

Ejemplos:

- Titulos 
- Mensajes
- Labels 
- Estados 

----

### app_dimensions.dart

Define tamaños, márgenes, paddings y espaciados reutilizables 

Objetivo:

- Mantener consistencia visual
- Facilitar responsive design 
- Evitar valores repetidos 

---

### app_typography.dart 

Contiene estilos tipográficos reutilizables 

- Headers 
- Subtitulos 
- Texto de cards 
- Labels 
- Botones