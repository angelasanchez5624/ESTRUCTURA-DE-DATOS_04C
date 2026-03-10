// 4. Control de Acceso (Gimnasio)
// Un gimnasio tiene una lista de códigos de acceso de los socios que pagaron la mensualidad. La lista está ordenada de menor a mayor.

// El Problema: Cuando un socio digita su código, el sistema debe validar si el código está en la lista de "pagos al día". Si no está, se le niega la entrada.
// Algoritmo a usar: Búsqueda Binaria. Es eficiente para buscar códigos numéricos en una lista que ya está organizada.

import java.util.Scanner;

public class E4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] codigos = {1001, 1020, 1050, 1100, 1200, 1300, 1400, 1500, 1600, 1700};

        System.out.print("Ingrese su código de acceso: ");
        int codigoIngresado = sc.nextInt();

        int inicio = 0;
        int fin = codigos.length - 1;
        boolean encontrado = false;

        while (inicio <= fin) {

            int medio = (inicio + fin) / 2;

            if (codigos[medio] == codigoIngresado) {
                encontrado = true;
                break;
            } 
            else if (codigoIngresado < codigos[medio]) {
                fin = medio - 1;
            } 
            else {
                inicio = medio + 1;
            }
        }

        if (encontrado) {
            System.out.println("Acceso permitido.");
        } else {
            System.out.println("Acceso denegado.");
        }

        sc.close();
    }
}