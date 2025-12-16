package juego;

import java.util.Random;

public class JugadorComputadora extends Jugador {
    private Random random;

    public JugadorComputadora(char simbolo, String nombre) {
        super(simbolo, nombre);
        this.random = new Random();
    }

    @Override
    public int[] obtenerMovimiento(Tablero tablero) {
        int[] movimiento = new int[2];
        boolean movimientoEncontrado = false;

        // Primero intentar ganar
        movimientoEncontrado = intentarMovimientoGanador(tablero, movimiento);

        // Si no puede ganar, bloquear al oponente
        if (!movimientoEncontrado) {
            movimientoEncontrado = bloquearOponente(tablero, movimiento);
        }

        // Si no hay nada crítico, movimiento aleatorio
        if (!movimientoEncontrado) {
            do {
                movimiento[0] = random.nextInt(3);
                movimiento[1] = random.nextInt(3);
            } while (!tablero.movimientoValido(movimiento[0], movimiento[1]));
        }

        System.out.println("\nLa computadora elige: [" + movimiento[0] + ", " + movimiento[1] + "]");
        return movimiento;
    }

    private boolean intentarMovimientoGanador(Tablero tablero, int[] movimiento) {
        return buscarMovimientoEstrategico(tablero, movimiento, simbolo);
    }

    private boolean bloquearOponente(Tablero tablero, int[] movimiento) {
        char oponente = (simbolo == 'X') ? 'O' : 'X';
        return buscarMovimientoEstrategico(tablero, movimiento, oponente);
    }

    private boolean buscarMovimientoEstrategico(Tablero tablero, int[] movimiento, char jugador) {
        char[][] celdas = tablero.getCeldas();

        // Revisar filas, columnas y diagonales
        for (int i = 0; i < 3; i++) {
            // Filas
            if (celdas[i][0] == jugador && celdas[i][1] == jugador && celdas[i][2] == ' ') {
                movimiento[0] = i; movimiento[1] = 2; return true;
            }
            if (celdas[i][0] == jugador && celdas[i][2] == jugador && celdas[i][1] == ' ') {
                movimiento[0] = i; movimiento[1] = 1; return true;
            }
            if (celdas[i][1] == jugador && celdas[i][2] == jugador && celdas[i][0] == ' ') {
                movimiento[0] = i; movimiento[1] = 0; return true;
            }

            // Columnas
            if (celdas[0][i] == jugador && celdas[1][i] == jugador && celdas[2][i] == ' ') {
                movimiento[0] = 2; movimiento[1] = i; return true;
            }
            if (celdas[0][i] == jugador && celdas[2][i] == jugador && celdas[1][i] == ' ') {
                movimiento[0] = 1; movimiento[1] = i; return true;
            }
            if (celdas[1][i] == jugador && celdas[2][i] == jugador && celdas[0][i] == ' ') {
                movimiento[0] = 0; movimiento[1] = i; return true;
            }
        }

        // Diagonales
        if (celdas[0][0] == jugador && celdas[1][1] == jugador && celdas[2][2] == ' ') {
            movimiento[0] = 2; movimiento[1] = 2; return true;
        }
        if (celdas[0][0] == jugador && celdas[2][2] == jugador && celdas[1][1] == ' ') {
            movimiento[0] = 1; movimiento[1] = 1; return true;
        }
        if (celdas[1][1] == jugador && celdas[2][2] == jugador && celdas[0][0] == ' ') {
            movimiento[0] = 0; movimiento[1] = 0; return true;
        }

        if (celdas[0][2] == jugador && celdas[1][1] == jugador && celdas[2][0] == ' ') {
            movimiento[0] = 2; movimiento[1] = 0; return true;
        }
        if (celdas[0][2] == jugador && celdas[2][0] == jugador && celdas[1][1] == ' ') {
            movimiento[0] = 1; movimiento[1] = 1; return true;
        }
        if (celdas[1][1] == jugador && celdas[2][0] == jugador && celdas[0][2] == ' ') {
            movimiento[0] = 0; movimiento[1] = 2; return true;
        }

        return false;
    }
}