# editor_dfd_en_java
# Objetivo:
Un pequeño proyecto universitario de estudiantes de segundo año de Ingenieria Informática que tiene como objetivo facilitar el aprendizaje de pseudocodigo y DFD.
jejeje siuuuuu :D
Fecha y hora: 09/07/2026 12:45 PM
Organizamos la estructura en paquetes y clases base, también se creo una ventana en blanco funcional.
Fecha y hora: 09/07/2026 15:10 PM
Modificamos Los archivos, la estructura y distribución de las tareas.

# Editor de Diagramas de Flujo

Curso:Programacion 2  
Carrera: Ingenieria Informatica - Universidad Nacional de Piura (UNP)

## Descripcion del Proyecto
Aplicacion de escritorio desarrollada en Java puro utilizando la biblioteca javax.swing. Permite al usuario diseñar algoritmos mediante diagramas de flujo de forma interactiva, guardar el progreso en el disco duro y compilar el diseño visual para generar pseudocodigo estructurado en español.

## Caracteristicas Principales
* Interfaz grafica interactiva (Arrastrar, soltar y configurar bloques).
* Generacion de pseudocodigo a partir de representaciones graficas.
* Persistencia de datos mediante lectura y escritura de ficheros de texto.
* Arquitectura Modular y Programacion Orientada a Objetos.

## Arquitectura y Division de Trabajo

El sistema esta dividido en un nucleo central (Core) y tres modulos independientes, asignados a cada integrante del equipo para garantizar un desarrollo en paralelo sin conflictos.

# Integrante 1: Modulo de Datos y Subprocesos
* Paquete: `modulos.datos`
* Estructuras: Asignar (Procesos), Leer (Entrada) y Llamada a Funcion.
* Responsabilidad: Interfaz Swing local, logica grafica y motor de traduccion de datos.

# Integrante 2: Modulo de Control de Flujo
* Paquete: `modulos.control`
* Estructuras: Escribir (Salida), Condicional (Si-Sino) y Segun (Casos Multiples).
* Responsabilidad: Construccion de rombos de decision y bifurcaciones, validaciones UI y traduccion logica.

# Integrante 3: Modulo de Ciclos Iterativos
* Paquete: `modulos.ciclos`
* Estructuras: Mientras (While), Para (For) y Repetir (Do-While).
* Responsabilidad: Graficos ciclicos, gestion de variables iteradoras y traduccion iterativa.

# Trabajo Conjunto (Core)
* `core.vista`: Ventana Principal y Lienzo de Trabajo interactivo.
* `core.modelo`: Clase abstracta `BloqueBase` y logica de `Conexion`.
* `core.controlador`: `GestorFicheros` (Persistencia) y `GestorProyecto` (Ensamblaje final de pseudocodigo).

## Estado del Repositorio (Ramas)
El proyecto utiliza un flujo de trabajo basado en Feature Branches. Todas las ramas funcionales han sido completadas y estan listas para su integracion (Merge) a la rama principal:

* `main` (Produccion)
* `feature/core-lienzo-interfaz` (Terminado)
* `feature/core-conexiones` (Terminado)
* `feature/modulo-datos` (Terminado)
* `feature/modulo-control` (Terminado)
* `feature/modulo-ciclos` (Terminado)
* `feature/gestor-ficheros` (Terminado)
* `feature/motor-pseudocodigo` (Terminado)

## Ejecucion
Para ejecutar la aplicacion, compilar el proyecto y correr la clase `Principal.java` ubicada en el paquete `core.vista`.