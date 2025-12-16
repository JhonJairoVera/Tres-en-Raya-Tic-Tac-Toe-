# 🎮 Tres en Raya (Triki / Tic Tac Toe)

Juego clásico de **Tres en Raya (Triki)** desarrollado en **Java**, ejecutado por consola y basado en principios de **Programación Orientada a Objetos**.  
El proyecto forma parte de la asignatura **Programación II** de la **Universidad de Pamplona**.

---

## 📌 Descripción del Proyecto

Tres en Raya es un juego tradicional que se desarrolla en un tablero de **3x3**, donde dos jugadores se turnan para colocar sus símbolos (**X** y **O**) con el objetivo de completar una línea horizontal, vertical o diagonal.

El sistema permite:
- Juego **Jugador vs Jugador**
- Juego **Jugador vs Computadora (IA básica)**
- Validación completa de movimientos
- Detección automática de ganador o empate
- Interfaz de consola con colores ANSI

---

## 🏫 Información Académica

- **Universidad:** Universidad de Pamplona  
- **Facultad:** Ingenierías y Arquitecturas  
- **Programa:** Ingeniería de Sistemas  
- **Asignatura:** Programación II  
- **Semestre:** Segundo Semestre – 2025  

---

## 👨‍💻 Equipo de Desarrollo

| Rol | Nombre |
|---|---|
| **Developer** | Jhon Jairo Vera Acevedo |
| **Developer** | Aylin Yuleni Estupiñán González |
| **Scrum Master** | Danna Sofia Clavijo Plata |
| **Product Owner** | Laura Sofía Monterrey Gutiérrez |

---

## 🛠️ Tecnologías Utilizadas

- **Lenguaje:** Java SE 17 (JDK 17 LTS)
- **IDE:** IntelliJ IDEA Community Edition
- **Paradigma:** Programación Orientada a Objetos (POO)
- **Control de versiones:** Git
- **Repositorio:** GitHub
- **Sistema Operativo:** Windows / Linux / macOS

---

## 📁 Estructura del Proyecto
src/
├── Main.java # Punto de entrada del programa
├── juego/
│ ├── TresEnRaya.java # Controlador principal
│ ├── Tablero.java # Modelo del tablero
│ ├── Jugador.java # Clase abstracta
│ ├── JugadorHumano.java # Jugador por consola
│ ├── JugadorComputadora.java # IA básica
│ └── EstadoJuego.java # Estados del juego
└── util/
└── ConsoleColors.java # Colores ANSI en consola

---

## 🚀 Instalación y Ejecución

### 1️⃣ Clonar el repositorio
```bash
git clone https://github.com/JhonJairoVera/Tres-en-Raya-Tic-Tac-Toe-
2️⃣ Abrir el proyecto

Abrir IntelliJ IDEA

Seleccionar Open

Elegir la carpeta del proyecto

3️⃣ Configurar Java

Ir a File → Project Structure

Seleccionar Project SDK: Java 17

4️⃣ Ejecutar el juego

Abrir Main.java

Clic derecho → Run 'Main'

El juego se ejecutará en la consola

🎮 Cómo Jugar

El tablero se muestra en consola

El jugador ingresa las coordenadas (fila y columna)

Valores válidos: 0 a 2

El sistema valida el movimiento

El turno cambia automáticamente

El juego termina cuando hay:

Ganador

Empate

🎨 Interfaz en Consola
Colores Utilizados

🔴 Rojo: Jugador X

🔵 Azul: Jugador O

🟢 Verde: Mensajes correctos

🟡 Amarillo: Advertencias

🔷 Cian: Tablero

🧪 Pruebas Realizadas

Validación de movimientos

Casillas ocupadas

Coordenadas inválidas

Victoria horizontal, vertical y diagonal

Empate por tablero lleno

Cambio correcto de turnos

📈 Métricas del Proyecto

Líneas de código: ~626

Clases Java: 8

Métodos: 42

Paquetes: 3

Tiempo de desarrollo: 11 días hábiles

🎯 Logros Técnicos

✅ Arquitectura MVC no estricta
✅ Uso de herencia y polimorfismo
✅ Patrón Template Method
✅ Manejo robusto de errores
✅ IA básica (ganar – bloquear – aleatorio)
✅ Interfaz de consola mejorada

🔮 Mejoras Futuras

Interfaz gráfica con JavaFX

Niveles de dificultad

Multijugador en red

Guardado de partidas

Migración a Maven o Gradle

📄 Documentación

Guía de Instalación

Manual de Usuario

Informe Técnico

(Disponibles como documentos Word para fines académicos)

📜 Licencia

Este proyecto fue desarrollado con fines académicos.
Uso libre para aprendizaje y práctica.

⭐ Autor

Jhon Jairo Vera Acevedo
Estudiante de Ingeniería de Sistemas
Universidad de Pamplona – 2025

---



