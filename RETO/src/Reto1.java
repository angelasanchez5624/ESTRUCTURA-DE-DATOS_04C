// Reto 1: El Cajero del Supermercado (Vectores y Sumatorias)

// Objetivo: Llenar un vector manualmente y procesar la información.

// El Problema: El usuario debe ingresar los precios de 5 productos que compró en el mercado para calcular el total.

// Instrucciones:

// Crea un vector double[] precios = new double[5];

// Usa un ciclo for y Scanner para pedirle al usuario que ingrese los 5 precios uno por uno.

// Tarea A: Calcula la suma total de los precios ingresados.

// Tarea B: Encuentra cuál fue el precio más alto que se ingresó y muéstralo.

// Tarea C: Si el total supera los 20.000, muestra un mensaje:
// "¡Tienes un descuento de 2.000!".
// Resta ese valor y muestra el total final a pagar.

import java.util.Scanner;

public class Reto1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Crear el vector
        double[] precios = new double[5];

        double suma = 0;
        double precioMayor = 0;

        // Pedir los precios
        for (int i = 0; i < precios.length; i++) {
            System.out.print("Ingrese el precio del producto " + (i + 1) + ": ");
            precios[i] = sc.nextDouble();

            suma += precios[i];

            if (i == 0 || precios[i] > precioMayor) {
                precioMayor = precios[i];
            }
        }

        System.out.println("\nTotal de la compra: " + suma);
        System.out.println("Precio más alto: " + precioMayor);

        // Descuento
        if (suma > 20000) {
            System.out.println("¡Tienes un descuento de 2000!");
            suma -= 2000;
        }

        System.out.println("Total final a pagar: " + suma);

        sc.close();
    }
}
