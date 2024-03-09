# TaskApp
ProyectoTask es una aplicación de gestión de proyectos que te permite organizar y supervisar tus proyectos de manera eficiente. Con esta herramienta, puedes crear, editar y seguir el progreso de tus proyectos desde una interfaz intuitiva.

Características Principales:

Creación de Proyectos:
Puedes crear proyectos con detalles como nombre, descripción, fecha de inicio y fecha de finalización.
Cada proyecto se etiqueta con una categoría relevante para facilitar la búsqueda y clasificación.
División en Tareas:
Los proyectos se dividen en tareas, lo que te permite desglosar el trabajo en unidades manejables.
Cada tarea tiene una fecha de inicio y una fecha de finalización, lo que te ayuda a planificar y cumplir con los plazos.
Inicio de Sesión Seguro:
Aunque actualmente no cuenta con una seguridad robusta, el inicio de sesión está implementado con restricciones de expresiones regulares (regex) en JavaScript.
En futuras versiones, considera agregar autenticación y autorización más sólidas para proteger los datos de los usuarios.

Tecnologías Utilizadas:
Frontend:
Desarrollado con Vanilla JavaScript, HTML y CSS.
Backend:
Implementado en Java con Spring Boot siguiendo una arquitectura API REST.
La comunicación entre el frontend y el backend se realiza mediante APIs.
Base de Datos:
Se utiliza una base de datos relacional PostgreSQL para almacenar la información de los proyectos y tareas.
Documentación:
En el repositorio de Git, encontrarás el query para crear la estructura de la base de datos.
También se incluye un diagrama relacional generado con StarUML para visualizar la relación entre las entidades.
