#  Configuración del entorno - NEXA UCA 

¡Bienvenida al equipo! Para trabajar en este proyecto, es necesario configurar tu entorno local y tener acceso a nuestras herramientas de firebase.

## 1. Requisitos Previos
- Node.js: Asegúrate de tener instalar la versión LTS más reciente 20.20.2. [!Descargar Node JS 20.20.2](https://nodejs.org/en/download/current)
- Firebase CLI: Necesitas instalar la herramienta de linea de comandos de Firebase para gestionar el despliegue y la configuración.

## 2. Instalación de Firebase CLI

Ejecuta el siguiente comando en tu terminal para instalar Firebase de forma global

```bash 
    npm install -g firebase-tools
```
Una vez instalado, inicia sesión con tu cuenta de Google

```bash
    firebase login
```

## 3. Acceso al Proyecto 

Para que puedas trabajar , ya te he enviado una invitación a través de la consola de Firebase
como **Editor** por favor:

1. Revisa tu correo electrónico (incluyendo la carpeta spam)
2. Acepta la invitación a proyecto en la Consola de Firebase

## 4. Configuración inicial del Proyecto 
Una vez que tengas acceso y el CLI instalado, sigue estos pasos: 

1. **Clona el repositorio (si aún no lo has hecho)**
2. **Instala las dependencias**

```bash
    npm install
```
3. **Vincula el proyecto de Firebase**
En la raiz del projecto, ejecuta 

```bash
    firebase use --add
```
Selecciona nuestro proyecto de la lista 

4. Comandos para deployar archivos generales 

```bash 
    ## Comando para deployar archivos generales como gets , create mutations que no tengan información 
    firebase deploy --only dataconnect
    
    archivos de ejemplo:
    
    query GetProjectType @auth(level: USER){
    projectTypes {
        id
        name
        }
    }

    
    ## Comando para deployar un archivo en especifico con datos
     firebase dataconnect:execute .\dataconnect\nexa\nombre_de_archivo.gql    
     archivo de ejemplo: 
     mutation SeedProjectType @auth (level: NO_ACCESS){

    servicio_interno: projectType_insert(data: {name: "Servicio Interno"})
    servicio_externo: projectType_insert(data: {name: "Servicio Externo"})
    }
    
    ## Comando para traer actualizaciones de la base 
    
    firebase dataconnect:sdk:generate
    
    ## Comando para inicializar emuladores (solo si aplica)
    firebase emulators:start     
```

**Nota**: Cualquier duda con respecto al manejo de los comandos o de como inicializar las cosas puedes comunicarte conmigo