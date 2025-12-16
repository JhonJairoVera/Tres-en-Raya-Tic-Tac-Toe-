package juego;

import util.ConsoleColors;  // AÑADE ESTE IMPORT
import java.util.Scanner;
public class TresEnRaya {
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;
    private boolean juegoContraComputadora;
    private Scanner scanner;
    private int partidasGanadasX;
    private int partidasGanadasO;
    private int partidasEmpatadas;

    public TresEnRaya() {
        scanner = new Scanner(System.in);
        tablero = new Tablero();
        partidasGanadasX = 0;
        partidasGanadasO = 0;
        partidasEmpatadas = 0;
    }

    public void iniciar() {
        mostrarTitulo();
        configurarJuego();

        boolean jugarOtraVez = true;

        while (jugarOtraVez) {
            jugarPartida();
            mostrarEstadisticas();
            jugarOtraVez = preguntarOtraPartida();

            if (jugarOtraVez) {
                tablero.inicializar();
                alternarPrimerJugador();
            }
        }

        System.out.println(ConsoleColors.GREEN + "\n¡Gracias por jugar! Hasta pronto." + ConsoleColors.RESET);
        scanner.close();
    }

    private void mostrarTitulo() {
        System.out.println(ConsoleColors.PURPLE_BOLD + "══════════════════════════════════════════" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "         TRES EN RAYA - JAVA EDITION" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.PURPLE_BOLD + "══════════════════════════════════════════" + ConsoleColors.RESET);
        System.out.println();
    }

    private void configurarJuego() {
        System.out.println(ConsoleColors.YELLOW_BOLD + "CONFIGURACIÓN DEL JUEGO" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW + "══════════════════════════" + ConsoleColors.RESET);

        // Seleccionar modo de juego
        System.out.println("\nSelecciona el modo de juego:");
        System.out.println("1. " + ConsoleColors.GREEN + "Jugador vs Jugador" + ConsoleColors.RESET);
        System.out.println("2. " + ConsoleColors.BLUE + "Jugador vs Computadora" + ConsoleColors.RESET);

        int opcion = 0;
        while (opcion < 1 || opcion > 2) {
            try {
                System.out.print(ConsoleColors.YELLOW + "Opción (1-2): " + ConsoleColors.RESET);
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                if (opcion < 1 || opcion > 2) {
                    System.out.println(ConsoleColors.RED + "¡Opción inválida! Selecciona 1 o 2." + ConsoleColors.RESET);
                }
            } catch (Exception e) {
                System.out.println(ConsoleColors.RED + "¡Entrada inválida! Ingresa un número." + ConsoleColors.RESET);
                scanner.nextLine();
            }
        }

        juegoContraComputadora = (opcion == 2);

        // Configurar jugadores
        if (juegoContraComputadora) {
            System.out.print("\n" + ConsoleColors.YELLOW + "Ingresa tu nombre: " + ConsoleColors.RESET);
            String nombreJugador = scanner.nextLine();

            jugador1 = new JugadorHumano('X', nombreJugador, scanner);
            jugador2 = new JugadorComputadora('O', "Computadora");
        } else {
            System.out.print("\n" + ConsoleColors.YELLOW + "Nombre del Jugador 1 (X): " + ConsoleColors.RESET);
            String nombre1 = scanner.nextLine();

            System.out.print(ConsoleColors.YELLOW + "Nombre del Jugador 2 (O): " + ConsoleColors.RESET);
            String nombre2 = scanner.nextLine();

            jugador1 = new JugadorHumano('X', nombre1, scanner);
            jugador2 = new JugadorHumano('O', nombre2, scanner);
        }

        jugadorActual = jugador1;

        System.out.println(ConsoleColors.GREEN + "\n¡Configuración completada! Presiona Enter para comenzar..." + ConsoleColors.RESET);
        scanner.nextLine();
    }

    private void jugarPartida() {
        System.out.println(ConsoleColors.CYAN_BOLD + "\n══════════════════════════════════════════" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "           INICIO DE PARTIDA" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "══════════════════════════════════════════" + ConsoleColors.RESET);

        while (true) {
            System.out.println("\n" + ConsoleColors.WHITE_BOLD + "Turno de: " + jugadorActual + ConsoleColors.RESET);
            tablero.mostrar();

            int[] movimiento = jugadorActual.obtenerMovimiento(tablero);
            int fila = movimiento[0];
            int columna = movimiento[1];

            // Realizar movimiento
            while (!tablero.realizarMovimiento(fila, columna, jugadorActual.getSimbolo())) {
                System.out.println(ConsoleColors.RED + "¡Casilla ocupada! Elige otra." + ConsoleColors.RESET);
                movimiento = jugadorActual.obtenerMovimiento(tablero);
                fila = movimiento[0];
                columna = movimiento[1];
            }

            // Verificar estado del juego
            EstadoJuego estado = tablero.verificarEstado();

            if (estado != EstadoJuego.EN_CURSO) {
                tablero.mostrar();
                mostrarResultado(estado);
                actualizarEstadisticas(estado);
                break;
            }

            // Cambiar jugador
            cambiarJugador();
        }
    }

    private void cambiarJugador() {
        jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
    }

    private void alternarPrimerJugador() {
        jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
        System.out.println(ConsoleColors.YELLOW + "\n" + jugadorActual.getNombre() + " comienza la nueva partida." + ConsoleColors.RESET);
    }

    private void mostrarResultado(EstadoJuego estado) {
        System.out.println(ConsoleColors.PURPLE_BOLD + "\n══════════════════════════════════════════" + ConsoleColors.RESET);

        switch (estado) {
            case GANADOR_X:
                String ganadorX = (jugador1.getSimbolo() == 'X') ? jugador1.getNombre() : jugador2.getNombre();
                System.out.println(ConsoleColors.GREEN_BOLD + "   ¡" + ganadorX + " (X) GANA LA PARTIDA!" + ConsoleColors.RESET);
                break;
            case GANADOR_O:
                String ganadorO = (jugador1.getSimbolo() == 'O') ? jugador1.getNombre() : jugador2.getNombre();
                System.out.println(ConsoleColors.GREEN_BOLD + "   ¡" + ganadorO + " (O) GANA LA PARTIDA!" + ConsoleColors.RESET);
                break;
            case EMPATE:
                System.out.println(ConsoleColors.YELLOW_BOLD + "          ¡EMPATE!" + ConsoleColors.RESET);
                break;
            default:
                break;
        }

        System.out.println(ConsoleColors.PURPLE_BOLD + "══════════════════════════════════════════" + ConsoleColors.RESET);
    }

    private void actualizarEstadisticas(EstadoJuego estado) {
        switch (estado) {
            case GANADOR_X:
                partidasGanadasX++;
                break;
            case GANADOR_O:
                partidasGanadasO++;
                break;
            case EMPATE:
                partidasEmpatadas++;
                break;
            default:
                break;
        }
    }

    private void mostrarEstadisticas() {
        System.out.println(ConsoleColors.CYAN_BOLD + "\n══════════════════════════════════════════" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "             ESTADÍSTICAS" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.CYAN_BOLD + "══════════════════════════════════════════" + ConsoleColors.RESET);

        System.out.println(ConsoleColors.GREEN + "Victorias de X: " + partidasGanadasX + ConsoleColors.RESET);
        System.out.println(ConsoleColors.BLUE + "Victorias de O: " + partidasGanadasO + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW + "Empates: " + partidasEmpatadas + ConsoleColors.RESET);

        int totalPartidas = partidasGanadasX + partidasGanadasO + partidasEmpatadas;
        if (totalPartidas > 0) {
            System.out.println(ConsoleColors.PURPLE + "Total de partidas: " + totalPartidas + ConsoleColors.RESET);
        }
    }

    private boolean preguntarOtraPartida() {
        System.out.print(ConsoleColors.YELLOW + "\n¿Jugar otra partida? (S/N): " + ConsoleColors.RESET);
        String respuesta = scanner.nextLine().trim().toUpperCase();

        while (!respuesta.equals("S") && !respuesta.equals("N")) {
            System.out.print(ConsoleColors.RED + "Respuesta inválida. Ingresa S o N: " + ConsoleColors.RESET);
            respuesta = scanner.nextLine().trim().toUpperCase();
        }

        return respuesta.equals("S");
    }
}