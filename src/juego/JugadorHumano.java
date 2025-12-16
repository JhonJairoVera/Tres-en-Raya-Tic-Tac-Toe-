package juego;



import util.ConsoleColors;  // AÑADE ESTE IMPORT
import java.util.Scanner;

public class JugadorHumano extends Jugador {
    private Scanner scanner;

    public JugadorHumano(char simbolo, String nombre, Scanner scanner) {
        super(simbolo, nombre);
        this.scanner = scanner;
    }

    @Override
    public int[] obtenerMovimiento(Tablero tablero) {
        int[] movimiento = new int[2];
        boolean movimientoValido = false;

        while (!movimientoValido) {
            try {
                System.out.print(ConsoleColors.YELLOW + "\n" + nombre + ", ingresa fila (0-2): " + ConsoleColors.RESET);
                movimiento[0] = scanner.nextInt();

                System.out.print(ConsoleColors.YELLOW + nombre + ", ingresa columna (0-2): " + ConsoleColors.RESET);
                movimiento[1] = scanner.nextInt();

                if (movimiento[0] >= 0 && movimiento[0] < 3 &&
                        movimiento[1] >= 0 && movimiento[1] < 3) {
                    movimientoValido = true;
                } else {
                    System.out.println(ConsoleColors.RED + "¡Coordenadas fuera de rango! Usa números entre 0 y 2." + ConsoleColors.RESET);
                }
            } catch (Exception e) {
                System.out.println(ConsoleColors.RED + "¡Entrada inválida! Ingresa números enteros." + ConsoleColors.RESET);
                scanner.nextLine(); // Limpiar buffer
            }
        }

        return movimiento;
    }
}