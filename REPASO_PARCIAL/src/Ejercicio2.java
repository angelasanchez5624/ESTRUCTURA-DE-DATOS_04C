// Ejercicio 2: Competencia de Atletismo (Inserción)
// Objetivo: Ingresar puntajes y organizarlos de mayor a menor para determinar el podio.
// ¿Qué debes hacer?
// 1. Entrada: Pide al usuario que ingrese 6 puntajes (números enteros) por teclado.
// 2. Ordenamiento: Usa Inserción (Insertion Sort) para ordenar los puntajes de mayor a menor.
// 3. Búsqueda: Pide un puntaje al usuario y búscalo usando Búsqueda Lineal. Indica en qué posición (lugar) de la
// tabla quedó.

import java.util.Scanner;

public class Ejercicio2 {

    public static void insertionSort(int[] puntajes) {

        for (int i = 1; i < puntajes.length; i++) {

            int aux = puntajes[i];
            int j = i - 1;

            while (j >= 0 && puntajes[j] < aux) {
                puntajes[j + 1] = puntajes[j];
                j--;
            }

            puntajes[j + 1] = aux;
        }
    }

    public static int busquedaLineal(int[] puntajes, int buscar) {

        for (int i = 0; i < puntajes.length; i++) {
            if (puntajes[i] == buscar)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int[] puntajes = new int[6];
        int suma = 0;

        System.out.println("--- INGRESO DE PUNTAJES ---");

        for (int i = 0; i < puntajes.length; i++) {

            System.out.print("Puntaje del intento " + (i + 1) + ": ");
            puntajes[i] = leer.nextInt();

            suma += puntajes[i];
        }

        insertionSort(puntajes);

        System.out.println("\n--- TABLA DE RESULTADOS ---");

        for (int i = 0; i < puntajes.length; i++) {
            System.out.println((i + 1) + "° Lugar: " + puntajes[i]);
        }

        double promedio = (double) suma / puntajes.length;
        System.out.println("\nEl promedio total fue: " + promedio);

        System.out.print("\nIngrese puntaje a buscar: ");
        int buscar = leer.nextInt();

        int pos = busquedaLineal(puntajes, buscar);

        if (pos != -1)
            System.out.println("El puntaje " + buscar + " está en el " + (pos + 1) + "° lugar.");
        else
            System.out.println("Puntaje no encontrado");

        leer.close();
    }
}