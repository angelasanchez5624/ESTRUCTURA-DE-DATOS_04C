// 5. Reproductor de Música Premium
// Mejora el ejercicio de Spotify de la semana pasada usando listas dobles.

// La Clase Cancion (Nodo): Debe contener titulo (String), artista (String) y duracion (int).
// El Problema: El reproductor ahora permite la función "Canción Anterior" de manera eficiente sin tener que recorrer toda la lista desde el principio.
// Reto: Implementa un método saltarAtras() que retroceda una posición y saltarAdelante() que avance una. Si se intenta saltar atrás desde la primera canción, debe mostrar un mensaje de error.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        Reproductor reproductor = new Reproductor();
        Cancion cancionActual = null;

        do {
            System.out.println("\n==============================================");
            System.out.println("        Reproductor de Música Premium");
            System.out.println("==============================================");
            System.out.println("  [1] Agregar Canción");
            System.out.println("  [2] Canción Anterior");
            System.out.println("  [3] Canción Siguiente");
            System.out.println("  [4] Mostrar Lista");
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

                    System.out.print("Ingrese el artista: ");
                    String artista = sc.nextLine();

                    System.out.print("Ingrese la duración (segundos): ");
                    int duracion = sc.nextInt();

                    Cancion nueva = new Cancion(titulo, artista, duracion);
                    reproductor.agregarCancion(nueva);
                    cancionActual = nueva;
                    break;

                case 2:
                    if (cancionActual != null) {
                        System.out.println("Canción actual: " + cancionActual.titulo);
                        cancionActual = reproductor.saltarAtras(cancionActual);
                        System.out.println("Nueva canción: " + cancionActual.titulo);
                    } else {
                        System.out.println("No hay canciones.");
                    }
                    break;

                case 3:
                    if (cancionActual != null) {
                        System.out.println("Canción actual: " + cancionActual.titulo);
                        cancionActual = reproductor.saltarAdelante(cancionActual);
                        System.out.println("Nueva canción: " + cancionActual.titulo);
                    } else {
                        System.out.println("No hay canciones.");
                    }
                    break;

                case 4:
                    reproductor.mostrarLista();
                    break;

                case 0:
                    System.out.println("¡Saliendo del reproductor!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}