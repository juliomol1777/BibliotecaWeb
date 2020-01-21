

PROYECTO BIBLIOTECA WEB PARA EL INVENTARIO DE LIBROS EN JAVA CON CONEXION A BASE DE DATOS

El proyecto es una aplicacion web con coneccion a base de datos MySQL. Se utiliza el patron MVC, con DAO para realizar las consultas a la BBDD, Servlet para procesar las peticiones y paginas JSP en la vista. 
La aplicacion fue desplegada en Apache Tomcat 8.5, y desarrolada con NetBeans IDE 10.
El modelo se diagramo con 4 tablas: Usuarios y permisos, registro de libros, registro de Categorias y registro de Editoriales.
La base de datos sql se adjunta en el paquete dataBD.
Al ingresar al sistema de acuerdo al status del Usuario (Administrador o Invitado), se lo redirige a la pagina correspondiente. 
El administrador desde un panel de administracion puede realizar los CRUD en todas las tablas , y los invitados solo pueden ver el listado de libros con informacion sobre los detalles de cada uno.
Para restringir el acceso a las diferentes paginas, segun los permisos de usuario, se utiliza un login de entrada y Sesiones.
 