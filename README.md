
# Proyecto Java Cliente-Servidor con RPC y EJB

## Descripción
Este proyecto consiste en una aplicación distribuida usando la arquitectura Cliente-Servidor, implementada en Java. La aplicación permite la gestión de usuarios mediante una interfaz de cliente que se comunica con un servidor que maneja la lógica de negocio y el acceso a datos. Todo esto mediante RPC (Remote Procedure Call - Llamada a Procedimiento Remoto). Es un protocolo que permite al programa ejecutar un procedimiento o método en un espacio de direcciones diferente, que puede estar en otro ordenador. En esencia, facilita la comunicación entre procesos distribuidos en diferentes sistemas operativos y hardware

## Estructura del Proyecto
El proyecto está dividido en dos componentes principales: el cliente y el servidor.

### Cliente
- **Main**: El directorio Main incluye Main.java, que actúa como el punto de entrada de la aplicación cliente. Este archivo inicializa la configuración del cliente y establece la conexión inicial con el servidor.
- **Model**: Este directorio alberga la definición de entidades, como Usuario.java, que mapea la estructura de datos de los usuarios que la aplicación gestionará. Esto incluye atributos como nombre, identificador, y permisos.
- **Service**: Incluye ServicioUsuarioRemoto.java, que es una interfaz para definir los servicios que el cliente puede invocar de manera remota en el servidor. Estos servicios incluyen operaciones como crear y listar usuarios.

### Servidor
- **Controller**: Controlador.java en este directorio centraliza la lógica de negocio, actuando como el mediador entre la interfaz de usuario del cliente y el manejo de datos en el servidor. Controla las transacciones y asegura que los datos del usuario se manejen de manera segura y eficiente.
- **Model**: También contiene Usuario.java, asegurando una representación consistente de la entidad usuario en todo el proyecto, facilitando la integración entre cliente y servidor.
- **Service**: Compuesto por ServicioUsuario.java, ServicioUsuarioLocal.java, y ServicioUsuarioRemoto.java, este directorio define las interfaces y clases que implementan los servicios ofrecidos por el servidor. ServicioUsuario.java y ServicioUsuarioLocal.java son utilizados internamente en el servidor, mientras que ServicioUsuarioRemoto.java facilita la interacción con el cliente.

## Tecnologías Utilizadas
- **Java EE**: Utilizado para el desarrollo de los componentes de EJB y servicios.
- **EJB (Enterprise Java Beans)**: Para la gestión de la lógica de negocio y la persistencia de datos.
- **Java RMI (Remote Method Invocation)**: Para la comunicación entre el cliente y el servidor.

## Interfaz Gráfica de Usuario (GUI)
La interfaz gráfica de usuario está construida utilizando Java Swing, proporcionando una forma visual y interactiva de interactuar con la aplicación. Aquí está el detalle de cómo está organizada y su funcionalidad:

- **Ventana Principal**: Se crea una ventana (`JFrame`) titulada "Registro de Usuario" con un tamaño de 400x600 píxeles. Esta ventana es el contenedor principal para todos los componentes de la interfaz.
- **Panel de Formulario**: Dentro de la ventana principal, hay un panel (`JPanel`) que utiliza un diseño de cuadrícula (`GridLayout`) para organizar los componentes de entrada. Este panel incluye campos de texto para ingresar datos del usuario como cédula, nombre, correo, celular, auto y tipo de sangre.
- **Botones de Acción**: Se proporcionan dos botones, "Registrar" y "Listar". Al hacer clic en "Registrar", se invoca el método para registrar un usuario con los datos ingresados. El botón "Listar" muestra la lista de usuarios registrados en el área de texto central.
- **Área de Texto**: Una área de texto (`JTextArea`) se usa para mostrar mensajes de resultado después de las operaciones de registro y listado, así como cualquier error que pueda ocurrir.

## Comunicación y Datos
La comunicación entre la interfaz de usuario y el servidor se maneja mediante llamadas a métodos remotos a través de Java RMI, utilizando EJB (Enterprise Java Beans). Aquí está cómo funciona:

- **Inicialización**: Al iniciar la aplicación, se configura el contexto JNDI para localizar el bean remoto en el servidor utilizando propiedades como la fábrica de contexto inicial y la URL del proveedor. Una vez localizado, se obtiene una referencia al servicio remoto (`ServicioUsuarioRemoto`).
- **Registro de Usuario**: Al enviar el formulario de registro, se crea una instancia de `Usuario` con los datos proporcionados y se llama al método `crearUsuario` del bean remoto para guardar el usuario en el servidor. Los mensajes de éxito o error se muestran en la interfaz.
- **Listado de Usuarios**: Al presionar "Listar", se hace una llamada al método `listarUsuarios` del servicio remoto, que recupera una lista de todos los usuarios registrados. Esta lista se muestra en el área de texto, proporcionando una visualización en tiempo real de los datos del servidor.

## Cómo Ejecutar
### Servidor
1. Navega al directorio donde se encuentra el servidor.
2. Desplegar el servidor usando Wildfly 32.0.1

### Cliente
1. Navega al directorio del cliente.
2. Compila el archivo Main.java

## Video Youtube
### https://youtu.be/OxWMqpqqL9c
