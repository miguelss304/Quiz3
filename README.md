# Quiz 3 - Snake Game

Este proyecto es una implementación básica del clásico juego de la serpiente en Java, desarrollada como ejercicio de estructuras de datos.

## Objetivo

Aplicar conceptos de programación orientada a objetos y manejo de estructuras dinámicas para simular el movimiento y comportamiento de una serpiente en un tablero.

## Características

- Representación de la serpiente mediante segmentos.
- Manejo de posiciones en el tablero con la clase `Position`.
- Uso de `DynamicArray` para almacenar elementos de manera dinámica.
- Lógica principal del juego en `Snake`.
- Punto de entrada del programa en `Main`.

## Estructura del proyecto

```text
Quiz3/
├── src/
│   ├── DynamicArray.java
│   ├── Main.java
│   ├── Position.java
│   └── Snake.java
└── README.md
```

## Descripción de clases

- `Main`: contiene la ejecución principal del programa.
- `Snake`: gestiona el movimiento, crecimiento y control de la serpiente.
- `Position`: guarda coordenadas de una celda o posición del tablero.
- `DynamicArray`: estructura dinámica para almacenar elementos sin tamaño fijo.

## Cómo ejecutar

Desde la carpeta principal del proyecto, ejecuta:

```bash
javac src/*.java
java -cp src Main
```

## Requisitos

- Java JDK instalado.
- Consola o terminal para compilar y ejecutar el programa.

## Nota

Este repositorio corresponde a un ejercicio académico de estructuras de datos y programación en Java.
