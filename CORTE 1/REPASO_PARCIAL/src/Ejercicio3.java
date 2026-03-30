// Ejercicio 3: Control de Notas (Selección)
// Objetivo: Gestionar las notas de un grupo, encontrar los valores extremos y ordenar la lista.
// ¿Qué debes hacer?
// 1. Entrada: Pide al usuario 5 notas (números decimales) por teclado.
// 2. Estadísticas: Recorre el arreglo para encontrar cuál es la nota más alta y cuál la más baja del grupo.
// 3. Ordenamiento: Ordena las notas de menor a mayor usando Selección (Selection Sort).

import java.util.Scanner;

public class Ejercicio3 {

    public static void selectionSort(double[] notas) {

        for (int i = 0; i < notas.length - 1; i++) {

            int min = i;

            for (int j = i + 1; j < notas.length; j++) {

                if (notas[j] < notas[min])
                    min = j;
            }

            double aux = notas[i];
            notas[i] = notas[min];
            notas[min] = aux;
        }
    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        leer.useLocale(java.util.Locale.US); // Permite usar punto para decimales

        double[] notas = new double[5];

        System.out.println("--- REGISTRO DE NOTAS ---");

        for (int i = 0; i < notas.length; i++) {

            System.out.print("Ingrese nota del estudiante " + (i + 1) + ": ");
            notas[i] = leer.nextDouble();
        }

        double mayor = notas[0];
        double menor = notas[0];

        for (double n : notas) {

            if (n > mayor)
                mayor = n;

            if (n < menor)
                menor = n;
        }

        selectionSort(notas);

        System.out.println("\n--- INFORME ACADÉMICO ---");
        System.out.println("La nota más ALTA del grupo es: " + mayor);
        System.out.println("La nota más BAJA del grupo es: " + menor);

        System.out.println("\n--- LISTA DE NOTAS ORDENADA ---");

        System.out.print("[");
        for (int i = 0; i < notas.length; i++) {

            System.out.print(notas[i]);

            if (i < notas.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");

        leer.close();
    }
}