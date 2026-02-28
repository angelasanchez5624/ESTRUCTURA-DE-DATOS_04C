// Ejercicio 10 — Copiando configuración
// Una app tiene un objeto int[] configuracion = {1920, 1080, 60} (resolución y FPS).

// Crea una copia real del arreglo (no una referencia) usando un nuevo arreglo y copiando elemento por elemento.
// Modifica la copia y demuestra que el original no cambia.
// Comenta la diferencia con la asignación directa.

public class Ejercicio_10 {
    public static void main(String[] args) {

        int[] configuracion = {1920, 1080, 60};
        int[] copiaConfiguracion = new int[configuracion.length];

        // Copia elemento por elemento
        for (int i = 0; i < configuracion.length; i++) {
            copiaConfiguracion[i] = configuracion[i];
        }

        // Modificar la copia
        copiaConfiguracion[2] = 144;

        System.out.println("Configuracion original:");
        for (int c : configuracion) {
            System.out.print(c + " ");
        }

        System.out.println("\nCopia modificada:");
        for (int c : copiaConfiguracion) {
            System.out.print(c + " ");
        }

        // Aquí sí existen dos arreglos diferentes en memoria.
        // La asignación directa solo copia la referencia,
        // pero esta copia crea un arreglo nuevo.
    }
}