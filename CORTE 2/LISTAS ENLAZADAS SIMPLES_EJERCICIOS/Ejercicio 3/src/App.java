// 3. Torre de Control (Aterrizajes de Emergencia)
// Simula la cola de aviones esperando para aterrizar en un aeropuerto congestionado.

// La Clase Vuelo (Nodo): Debe contener numeroVuelo (String), aerolinea (String), combustibleRestante (int) y pasajeros (int).
// El Problema: Normalmente los vuelos se forman al final de la cola. 
// Sin embargo, si un vuelo reporta menos de 10 unidades de combustible, debe ser movido inmediatamente al inicio de la lista (Cabeza).
// Reto: Implementar el método reportarEmergencia(String numeroVuelo) que busque un vuelo en la cola y lo mueva al principio.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        ColaVuelos cola = new ColaVuelos();

        do {
            System.out.println("\n==============================================");
            System.out.println("               TORRE DE CONTROL");
            System.out.println("==============================================");
            System.out.println("1. Agregar vuelo");
            System.out.println("2. Reportar emergencia");
            System.out.println("3. Mostrar vuelos");
            System.out.println("0. Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    sc.nextLine();
                    System.out.print("Número de vuelo: ");
                    String num = sc.nextLine();

                    System.out.print("Aerolínea: ");
                    String aero = sc.nextLine();

                    System.out.print("Combustible: ");
                    int comb = sc.nextInt();

                    System.out.print("Pasajeros: ");
                    int pas = sc.nextInt();

                    Vuelo v = new Vuelo(num, aero, comb, pas);
                    cola.agregarVuelo(v);
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Número de vuelo en emergencia: ");
                    String buscar = sc.nextLine();
                    cola.reportarEmergencia(buscar);
                    break;

                case 3:
                    cola.mostrar();
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
