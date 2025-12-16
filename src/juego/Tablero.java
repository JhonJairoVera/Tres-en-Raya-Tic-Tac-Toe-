package juego;

import util.ConsoleColors;

public class Tablero {
    private char[][] celdas;
    private static final int TAMANO = 3;

    public Tablero() {
        celdas = new char[TAMANO][TAMANO];
        inicializar();
    }

    public void inicializar() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                celdas[i][j] = ' ';
            }
        }
    }

    public boolean realizarMovimiento(int fila, int columna, char jugador) {
        if (movimientoValido(fila, columna)) {
            celdas[fila][columna] = jugador;
            return true;
        }
        return false;
    }

    public boolean movimientoValido(int fila, int columna) {
        return fila >= 0 && fila < TAMANO &&
                columna >= 0 && columna < TAMANO &&
                celdas[fila][columna] == ' ';
    }

    public EstadoJuego verificarEstado() {
        // Verificar si X gana
        if (hayGanador('X')) {
            return EstadoJuego.GANADOR_X;
        }

        // Verificar si O gana
        if (hayGanador('O')) {
            return EstadoJuego.GANADOR_O;
        }

        // Verificar empate
        if (estaLleno()) {
            return EstadoJuego.EMPATE;
        }

        return EstadoJuego.EN_CURSO;
    }

    private boolean hayGanador(char jugador) {
        // Verificar filas y columnas
        for (int i = 0; i < TAMANO; i++) {
            // Filas
            if (celdas[i][0] == jugador && celdas[i][1] == jugador && celdas[i][2] == jugador) {
                return true;
            }
            // Columnas
            if (celdas[0][i] == jugador && celdas[1][i] == jugador && celdas[2][i] == jugador) {
                return true;
            }
        }

        // Diagonales
        if (celdas[0][0] == jugador && celdas[1][1] == jugador && celdas[2][2] == jugador) {
            return true;
        }
        if (celdas[0][2] == jugador && celdas[1][1] == jugador && celdas[2][0] == jugador) {
            return true;
        }

        return false;
    }

    public boolean estaLleno() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (celdas[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void mostrar() {
        System.out.println("\n" + ConsoleColors.CYAN_BOLD + "    0   1   2" + ConsoleColors.RESET);
        System.out.println("  " + ConsoleColors.CYAN + "═══════════════" + ConsoleColors.RESET);

        for (int i = 0; i < TAMANO; i++) {
            System.out.print(ConsoleColors.CYAN_BOLD + i + " " + ConsoleColors.RESET);
            System.out.print(ConsoleColors.CYAN + "║ " + ConsoleColors.RESET);

            for (int j = 0; j < TAMANO; j++) {
                char celda = celdas[i][j];
                String simbolo = " ";

                if (celda == 'X') {
                    simbolo = ConsoleColors.RED_BOLD + "X" + ConsoleColors.RESET;
                } else if (celda == 'O') {
                    simbolo = ConsoleColors.BLUE_BOLD + "O" + ConsoleColors.RESET;
                }

                System.out.print(simbolo);

                if (j < TAMANO - 1) {
                    System.out.print(ConsoleColors.CYAN + " ║ " + ConsoleColors.RESET);
                }
            }

            System.out.println(ConsoleColors.CYAN + " ║" + ConsoleColors.RESET);

            if (i < TAMANO - 1) {
                System.out.println("  " + ConsoleColors.CYAN + "═══╬═══╬═══" + ConsoleColors.RESET);
            }
        }

        System.out.println("  " + ConsoleColors.CYAN + "═══════════════" + ConsoleColors.RESET);
    }

    public char[][] getCeldas() {
        return celdas.clone(); // Retorna copia para proteger el estado interno
    }

    public int getTamano() {
        return TAMANO;
    }
}