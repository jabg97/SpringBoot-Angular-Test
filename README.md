# SpringBoot-Angular-Test
Prueba SpringBoot &amp; Angular 

# Requisitos

```
Java 8 o Superior
Netbeans o Eclipse
Spring Boot
Maven
Node JS
Npm
Angular 11
Git
```

# Instalación

*Clonar el proyecto 
Utiliza la consola paa clonar el proyecto
```
git clone https://github.com/jabg97/SpringBoot-Angular-Test.git
```

*Instalar dependencias de Angular
Accede a la carpeta de la interfaz en Angular
```
cd gui
```
Luego instala las librerias requeridas
```
npm install
```

*Iniciar Aplicacion
Una vez terminado el proceso escribe el comando para iniciar el servidor de Angular
```
ng serve --open
```

***
***

*Backend Spring Boot

Para el backend se utilizo Spring boot con una base de datos H2
No se requiere un archivo .sql para la base de datos ya que al momento de iniciar la aplicacion se cargan los Seeders para llenar la base de datos automaticamente

Para iniciar el servidor solo debes abrir el ide Netbeans o eclipse y abrir el proyecto en la carpeta api
una vez cargadas las dependencia con Maven  compilas el proyecto y  asegurate que este funcionando sobre el puerto 8080

Si no esta en el puerto 8080 se debe modificar el archivo de angular que se encuentra en la ruta 

```
gui/src/app/services/api.service.ts 
```
y modificar la variable de url especificando el puerto en el cual se este ejecutando el servidor de Java.

