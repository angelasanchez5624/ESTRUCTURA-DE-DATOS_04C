import java.util.Scanner;

public class E2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de libros: ");
        int n = sc.nextInt();

        int[] libros = new int[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Ingrese el codigo del libro: ");
            libros[i] = sc.nextInt();

            int clave = libros[i];
            int j = i - 1;

            // Ordenamiento por inserción
            while (j >= 0 && libros[j] > clave) {
                libros[j + 1] = libros[j];
                j--;
            }

            libros[j + 1] = clave;

            // Mostrar paso
            System.out.print("Paso " + (i + 1) + ": [");

            for (int k = 0; k < n; k++) {
                System.out.print(libros[k]);
                if (k < n - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println("]");
        }

        sc.close();
    }
}