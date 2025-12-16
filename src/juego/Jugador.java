package juego;

public abstract class Jugador {
    protected char simbolo;
    protected String nombre;

    public Jugador(char simbolo, String nombre) {
        this.simbolo = simbolo;
        this.nombre = nombre;
    }

    public abstract int[] obtenerMovimiento(Tablero tablero);

    public char getSimbolo() {
        return simbolo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + simbolo + ")";
    }
}