// Ejercicio 4 — Placa de un vehículo
// El RUNT almacena datos básicos de vehículos. Modela la información de un carro con:

// Placa (String)
// Año de fabricación (int)
// Cilindraje en cc (int)
// Precio de compra (double)
// Inicial del color (char)
// Si tiene SOAT vigente (boolean)

import java.util.Scanner;

public class Ejercicio_4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la placa: ");
        String placa = sc.nextLine();

        System.out.print("Ingrese el año de fabricación: ");
        int anio = sc.nextInt();

        System.out.print("Ingrese el cilindraje: ");
        int cilindraje = sc.nextInt();

        System.out.print("Ingrese el precio de compra: ");
        double precioCompra = sc.nextDouble();

        System.out.print("Ingrese la inicial del color: ");
        char color = sc.next().charAt(0);

        System.out.print("¿Tiene SOAT vigente? (true/false): ");
        boolean soatVigente = sc.nextBoolean();

        System.out.println("\n=== Datos del Vehículo ===");
        System.out.println("Placa: " + placa);
        System.out.println("Año: " + anio);
        System.out.println("Cilindraje: " + cilindraje);
        System.out.println("Precio: " + precioCompra);
        System.out.println("Color inicial: " + color);
        System.out.println("SOAT vigente: " + soatVigente);

           sc.close();
    }
}