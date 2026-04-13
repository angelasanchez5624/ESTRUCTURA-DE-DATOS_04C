// 2. Carrusel de Imágenes (Galería Interactiva)
// Simula el comportamiento de una galería de fotos en una aplicación móvil.

// La Clase Fotografia (Nodo): Debe contener nombreArchivo (String), tamanoMB (double) y resolucion (String).
// El Problema: El usuario puede avanzar a la "Siguiente Foto" o retroceder a la "Foto Anterior". Si llega al final, no puede avanzar más (a menos que sea circular, pero por ahora manténlo lineal).
// Reto: Crea un método reproducirGaleria() que recorra toda la lista hacia adelante y luego toda la lista hacia atrás para mostrar todas las fotos.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        Galeria galeria = new Galeria();
        Fotografia fotoActual = null;

        do {
            System.out.println("\n==============================================");
            System.out.println("        Galería de Imágenes — Menú");
            System.out.println("==============================================");
            System.out.println("  [1] Agregar Foto");
            System.out.println("  [2] Siguiente Foto");
            System.out.println("  [3] Foto Anterior");
            System.out.println("  [4] Reproducir Galería");
            System.out.println();
            System.out.println("  [0] Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            System.out.println();

            switch (opcion) {
                case 1:
                    sc.nextLine();
                    System.out.print("Nombre del archivo: ");
                    String nombre = sc.nextLine();

                    System.out.print("Tamaño en MB: ");
                    double tamano = sc.nextDouble();

                    sc.nextLine();
                    System.out.print("Resolución: ");
                    String resolucion = sc.nextLine();

                    Fotografia nueva = new Fotografia(nombre, tamano, resolucion);
                    galeria.agregarFoto(nueva);
                    fotoActual = nueva;

                    break;

                case 2:
                    if (fotoActual != null) {
                        System.out.println("Foto actual: " + fotoActual.nombreArchivo);
                        fotoActual = galeria.siguiente(fotoActual);
                        System.out.println("Nueva foto: " + fotoActual.nombreArchivo);
                    } else {
                        System.out.println("No hay fotos.");
                    }
                    break;

                case 3:
                    if (fotoActual != null) {
                        System.out.println("Foto actual: " + fotoActual.nombreArchivo);
                        fotoActual = galeria.anterior(fotoActual);
                        System.out.println("Nueva foto: " + fotoActual.nombreArchivo);
                    } else {
                        System.out.println("No hay fotos.");
                    }
                    break;

                case 4:
                    galeria.reproducirGaleria();
                    break;

                case 0:
                    System.out.println("¡Saliendo de la galería!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
