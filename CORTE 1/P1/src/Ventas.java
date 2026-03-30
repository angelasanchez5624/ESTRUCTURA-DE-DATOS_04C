// EJERCICIO 1. VENTAS
// Objetivo: Gestionar ingresos, organizar y buscar montos.
// ¿qué debes hacer?
// 1. entrada: pide 5 montos (double) y guardalos en un arreglo.
// 2.ordenamiento: usa burbuja (bubble sort) para ordenar de menor a mayor.
// 3.busqueda: pide un monto y buscalo con busqueda lineal.
// 4.calculo: muestra la suma total de las ventas.

// Ejemplo de Consola:
// venta 1: 150.50 | venta 2: 80.00
// ---ventas ordenadas---
// [80.0, 150.5, 210.25]
// total ventas: $760.75

import java.util.Scanner;

public class Ventas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[] ventas = new double[5];
        double suma = 0;

        for (int i = 0; i < ventas.length; i++) {
            System.out.print("Venta " + (i + 1) + ": ");
            ventas[i] = sc.nextDouble();
        }

        for (int i = 0; i < ventas.length - 1; i++) {
            for (int j = 0; j < ventas.length - 1 - i; j++) {
                if (ventas[j] > ventas[j + 1]) {
                    double aux = ventas[j];
                    ventas[j] = ventas[j + 1];
                    ventas[j + 1] = aux;
                }
            }
        }

        System.out.println("\n--- Ventas ordenadas ---");
        for (int i = 0; i < ventas.length; i++) {
            if (i < ventas.length - 1) {
                System.out.print(ventas[i] + ", ");
            } else {
                System.out.print(ventas[i]);
            }
        }

        System.out.print("\n\nIngrese monto a buscar: ");
        double buscar = sc.nextDouble();
        boolean encontrado = false;

        for (int i = 0; i < ventas.length; i++) {
            if (ventas[i] == buscar) {
                System.out.println("Monto encontrado en la posición: " + i);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Monto no encontrado.");
        }

        for (int i = 0; i < ventas.length; i++) {
            suma += ventas[i];
        }

        System.out.println("Total ventas: $" + suma);

        sc.close();
    }
}