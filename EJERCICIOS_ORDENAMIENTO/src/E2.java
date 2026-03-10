// 2. Organización de Biblioteca Dinámica
// Algoritmo obligatorio: Ordenamiento por Inserción (Insertion Sort)

// Contexto: Un bibliotecario recibe una caja de libros y los va colocando uno a uno en el estante en su posición correcta.
// Detalle del ejercicio: El usuario debe ingresar la cantidad de libros y luego el código ISBN (número entero) de cada uno.
// Lógica de Inserción: A medida que el usuario ingresa un número, o una vez llenado el arreglo, el algoritmo debe simular el proceso de "insertar" el elemento comparándolo con los que ya están a su izquierda.
// Visualización Paso a Paso: En cada ciclo del ordenamiento, el programa debe imprimir cómo va quedando el arreglo (ej: [10, 25, 5, 30] -> [5, 10, 25, 30]). Esto permite al estudiante ver cómo los elementos se desplazan para abrir espacio al nuevo valor.

import java.util.Scanner;

public class E2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de libros: ");
        int n = sc.nextInt();

        int[] isbn = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el ISBN del libro " + (i + 1) + ": ");
            isbn[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int clave = isbn[i];
            int j = i - 1;

            while (j >= 0 && isbn[j] > clave) {
                isbn[j + 1] = isbn[j];
                j--;
            }

            isbn[j + 1] = clave;

            for (int k = 0; k < n; k++) {
                System.out.print(isbn[k] + " ");
            }
            System.out.println();
        }

        System.out.println("\nArreglo ordenado:");
        for (int i = 0; i < n; i++) {
            System.out.print(isbn[i] + " ");
        }

        sc.close();

    }
}