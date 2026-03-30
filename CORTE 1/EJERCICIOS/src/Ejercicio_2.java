// Ejercicio 2 — Calculadora de una tienda
// Una tienda de barrio vende productos al por menor. El cajero necesita calcular:

// Precio unitario de un producto (double)
// Cantidad comprada (int)
// Descuento aplicado en porcentaje (double)
// Total a pagar después del descuento

import java.util.Scanner;

public class Ejercicio_2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el precio unitario: ");
        double precioUnitario = sc.nextDouble();

        System.out.print("Ingrese la cantidad: ");
        int cantidad = sc.nextInt();

        System.out.print("Ingrese el descuento (%): ");
        double descuento = sc.nextDouble();

        double subtotal = precioUnitario * cantidad;
        double totalPagar = subtotal - (subtotal * descuento / 100);

        System.out.println("\nTotal a pagar: " + totalPagar);
        
           sc.close();
    }
}
