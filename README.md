
# Proyecto Java Cliente-Servidor

## Descripción
Este proyecto consiste en una aplicación distribuida usando la arquitectura Cliente-Servidor, implementada en Java. La aplicación permite la gestión de usuarios mediante una interfaz de cliente que se comunica con un servidor que maneja la lógica de negocio y el acceso a datos.

## Estructura del Proyecto
El proyecto está dividido en dos componentes principales: el cliente y el servidor.

### Cliente
- **EJB**: Beans de sesión utilizados para la lógica de negocio del lado del cliente.
- **Main**: Contiene el archivo `Main.java`, que es el punto de entrada de la aplicación cliente.
- **Model**: Incluye la clase `Usuario.java` que define el modelo de datos del usuario.
- **Service**: Contiene `ServicioUsuarioRemoto.java`, la interfaz para los servicios remotos accesibles por el cliente.

### Servidor
- **Controller**: Contiene `Controlador.java` para la gestión de la lógica de negocio.
- **EJB**: Beans de sesión para el servidor.
- **Model**: Define igualmente la clase `Usuario.java`.
- **Service**: Incluye las interfaces y clases `ServicioUsuario.java`, `ServicioUsuarioLocal.java`, y `ServicioUsuarioRemoto.java`, que gestionan los servicios del usuario.

## Tecnologías Utilizadas
- **Java EE**: Utilizado para el desarrollo de los componentes de EJB y servicios.
- **EJB (Enterprise Java Beans)**: Para la gestión de la lógica de negocio y la persistencia de datos.
- **Java RMI (Remote Method Invocation)**: Para la comunicación entre el cliente y el servidor.

## Cómo Ejecutar
### Servidor
1. Navega al directorio donde se encuentra el servidor.
2. Compila los archivos Java usando el comando:
   ```
   javac -d . *.java
   ```
3. Ejecuta el servidor usando:
   ```
   java java.ejb.Server.Server
   ```

### Cliente
1. Navega al directorio del cliente.
2. Compila los archivos Java:
   ```
   javac -d . *.java
   ```
3. Inicia la aplicación cliente usando:
   ```
   java java.main.Main
   ```
