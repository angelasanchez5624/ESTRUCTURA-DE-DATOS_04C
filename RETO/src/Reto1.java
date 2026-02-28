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
