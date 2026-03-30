// 4. Monitoreo Industrial (Sensores en Tiempo Real)
// Una planta química registra lecturas de sus tanques cada hora en una lista enlazada para auditoría.

// La Clase Lectura (Nodo): Debe contener idSensor (int), temperatura (double), presion (double) y hora (String).
// El Problema: Las lecturas se van agregando al inicio para que la más reciente sea siempre la primera que vea el supervisor.
// Reto: Implementa un método que busque y muestre la lectura con la temperatura más alta registrada en el historial.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        ListaLecturas lista = new ListaLecturas();

        do {
            System.out.println("\n==============================================");
            System.out.println("            MONITOREO INDUSTRIAL");
            System.out.println("==============================================");
            System.out.println("1. Agregar lectura");
            System.out.println("2. Mostrar lecturas");
            System.out.println("3. Mostrar temperatura más alta");
            System.out.println("0. Salir");
            System.out.println("==============================================");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID Sensor: ");
                    int id = sc.nextInt();

                    System.out.print("Temperatura: ");
                    double temp = sc.nextDouble();

                    System.out.print("Presión: ");
                    double pres = sc.nextDouble();

                    sc.nextLine();
                    System.out.print("Hora: ");
                    String hora = sc.nextLine();

                    Lectura nueva = new Lectura(id, temp, pres, hora);
                    lista.agregarInicio(nueva);
                    break;

                case 2:
                    lista.mostrar();
                    break;

                case 3:
                    lista.temperaturaMaxima();
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}