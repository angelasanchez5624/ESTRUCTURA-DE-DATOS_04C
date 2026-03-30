// Ejercicio 1 — Recibo de compra
// Pide al usuario el nombre de un producto, la cantidad comprada y el precio unitario. 
// Calcula el subtotal, aplica un IVA del 19% y muestra el recibo con el total a pagar.

// Datos de entrada:

// String nombre del producto
// int cantidad
// double precio unitario

import java.util.Scanner;
public class E1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la cantidad: ");
        int cantidad = sc.nextInt();
        System.out.print("Ingrese el precio unitario: ");
        double precioUnitario = sc.nextDouble();
        double subtotal = cantidad * precioUnitario;
        double iva = subtotal * 0.19;
        double total = subtotal + iva;
        
        System.out.println("\n===== Recibo =====");
        System.out.printf("Producto  : %s%n", nombre);
        System.out.printf("Cantidad  : %d%n", cantidad);
        System.out.printf("Precio c/u: $%.2f%n", precioUnitario);
        System.out.printf("Subtotal  : $%.2f%n", subtotal);
        System.out.printf("IVA (19%%) : $%.2f%n", iva);
        System.out.printf("Total     : $%.2f%n", total);
        
        sc.close();
    }
}