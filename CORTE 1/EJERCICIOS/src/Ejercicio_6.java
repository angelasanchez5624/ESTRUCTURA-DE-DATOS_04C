// Ejercicio 6 — Turno en un banco
// Un cajero de banco trabaja con el número del turno actual. 
// Se crea una variable turnoActual y se asigna a turnoEnPantalla.

// Demuestra con código que cambiar turnoEnPantalla no afecta a turnoActual (comportamiento por valor).
// Explica en un comentario por qué ocurre esto.

public class Ejercicio_6 {
    public static void main(String[] args) {

        int turnoActual = 25;
        int turnoEnPantalla = turnoActual;

        turnoEnPantalla = 26;

        System.out.println("Turno actual: " + turnoActual);
        System.out.println("Turno en pantalla: " + turnoEnPantalla);

        // Los tipos primitivos (int, double, etc.) se copian por valor.
        // Al asignar turnoActual a turnoEnPantalla, se crea una copia.
        // Cambiar uno no afecta al otro.
    }
}

