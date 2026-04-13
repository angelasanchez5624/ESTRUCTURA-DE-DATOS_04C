// 3. Navegación de Pestañas de Navegador
// Imagina un navegador donde puedes moverte entre pestañas abiertas.

// La Clase Pestana (Nodo): Debe contener tituloPagina (String), url (String) y horaApertura (String).
// El Problema: Las pestañas se abren una tras otra. A veces el usuario quiere cerrar la pestaña actual y el foco debe pasar a la pestaña anterior.
// Reto: Implementar el método cerrarPestanaActual(String url) que busque la pestaña por URL, la elimine de la lista y reconecte el nodo anterior con el siguiente correctamente (¡Cuidado con la Cabeza y la Cola!).

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        Navegador navegador = new Navegador();
        Pestana pestanaActual = null;

        do {
            System.out.println("\n==============================================");
            System.out.println("        Navegador_Menú de Pestañas");
            System.out.println("==============================================");
            System.out.println("  [1] Abrir Pestaña");
            System.out.println("  [2] Cerrar Pestaña");
            System.out.println("  [3] Mostrar Pestañas");
            System.out.println();
            System.out.println("  [0] Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título: ");
                    sc.nextLine();
                    String titulo = sc.nextLine();

                    System.out.print("Ingrese la URL: ");
                    String url = sc.nextLine();

                    System.out.print("Ingrese la hora de apertura: ");
                    String hora = sc.nextLine();

                    Pestana nueva = new Pestana(titulo, url, hora);
                    navegador.agregarPestana(nueva);
                    pestanaActual = nueva;
                    break;

                case 2:
                    if (pestanaActual != null) {
                        System.out.print("Ingrese la URL de la pestaña a cerrar: ");
                        sc.nextLine();
                        String urlCerrar = sc.nextLine();

                        pestanaActual = navegador.cerrarPestanaActual(urlCerrar, pestanaActual);
                    } else {
                        System.out.println("No hay pestañas abiertas.");
                    }
                    break;

                case 3:
                    navegador.mostrarPestanas();
                    break;

                case 0:
                    System.out.println("¡Saliendo del navegador!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}