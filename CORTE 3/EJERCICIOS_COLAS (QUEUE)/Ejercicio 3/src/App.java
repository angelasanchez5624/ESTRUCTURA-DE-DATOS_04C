// 3. Impresora Compartida (Red de Oficina)
// En una oficina de arquitectura, varias computadoras comparten una única impresora de gran formato. Cada vez que alguien envía un documento, este se agrega al final de la cola de impresión. La impresora procesa los trabajos en el orden exacto en que fueron recibidos.

// La Clase Documento (Nodo): Debe contener nombreArchivo (String), usuario (String), numeroPaginas (int) y esColor (boolean).
// El Problema: Antes de imprimir, el jefe de oficina quiere saber cuántas páginas en total tiene la cola de impresión pendiente.
// Reto: Implementa un método calcularPaginasTotales() que recorra la cola y retorne la suma de numeroPaginas de todos los documentos en espera, sin alterar la cola.

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ColaImpresion documentos = new ColaImpresion();
        Scanner scanner = new Scanner(System.in);
        
        //  Datos de prueba
        documentos.enqueue(new Documento("PlanoCasa.pdf", "Juan", 15, true));
        documentos.enqueue(new Documento("Informe.docx", "Maria", 8, false));
        documentos.enqueue(new Documento("Diseño3D.pdf", "Carlos", 20, true));

        int opcion;

        do {

            System.out.println("\n--- SISTEMA DE IMPRESIÓN ---");
            System.out.println("1. Ver cola de impresión");
            System.out.println("2. Agregar documento");
            System.out.println("3. Imprimir documento");
            System.out.println("4. Calcular páginas totales");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    documentos.imprimir();

                    break;

                case 2:

                    System.out.print("Nombre del archivo: ");
                    String archivo = scanner.nextLine();

                    System.out.print("Usuario: ");
                    String usuario = scanner.nextLine();

                    System.out.print("Número de páginas: ");
                    int paginas = scanner.nextInt();

                    System.out.print("¿Es a color? (true/false): ");
                    boolean color = scanner.nextBoolean();
                    scanner.nextLine();

                    documentos.enqueue(
                        new Documento(archivo, usuario, paginas, color)
                    );

                    System.out.println("Documento agregado correctamente.");

                    break;

                case 3:

                    Documento impreso = documentos.dequeue();

                    if (impreso != null) {

                        System.out.println("\nDocumento impreso:");
                        System.out.println(
                            "Archivo: " + impreso.nombreArchivo +
                            " | Usuario: " + impreso.usuario +
                            " | Páginas: " + impreso.numeroPaginas +
                            " | Color: " + impreso.esColor
                        );
                    }

                    break;

                case 4:

                    int total = documentos.calcularPaginasTotales();

                    System.out.println("Total de páginas pendientes: " + total);

                    break;

                case 5:

                    System.out.println("Saliendo del sistema...");
                    break;

                default:

                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}