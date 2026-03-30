// 5. Spotify Lite (Lista de Reproducción)
// Crea un reproductor de música simplificado que gestione una lista de canciones.

// La Clase Cancion (Nodo): Debe contener titulo (String), artista (String), duracionSegundos (int) y genero (String).
// El Problema: El usuario puede agregar canciones "A continuación" (insertar después de la actual) o "Al final de la cola".
// Reto: Implementa un método que sume la duración de todas las canciones y muestre el tiempo total de la lista en formato MM:SS.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        ListaCanciones lista = new ListaCanciones();

        do {
            System.out.println("\n==============================================");
            System.out.println("                 SPOTIFY LITE");
            System.out.println("==============================================");
            System.out.println("1. Agregar canción al final");
            System.out.println("2. Agregar canción a continuación");
            System.out.println("3. Mostrar lista");
            System.out.println("4. Duración total");
            System.out.println("0. Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    sc.nextLine();
                    System.out.print("Título: ");
                    String t = sc.nextLine();

                    System.out.print("Artista: ");
                    String a = sc.nextLine();

                    System.out.print("Duración (segundos): ");
                    int d = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Género: ");
                    String g = sc.nextLine();

                    lista.agregarFinal(new Cancion(t, a, d, g));
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Título: ");
                    String t2 = sc.nextLine();

                    System.out.print("Artista: ");
                    String a2 = sc.nextLine();

                    System.out.print("Duración (segundos): ");
                    int d2 = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Género: ");
                    String g2 = sc.nextLine();

                    lista.agregarDespuesActual(new Cancion(t2, a2, d2, g2));
                    break;

                case 3:
                    lista.mostrar();
                    break;

                case 4:
                    lista.tiempoTotal();
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}