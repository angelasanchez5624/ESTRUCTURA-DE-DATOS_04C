// 1. Línea de Metro Circular
// Una ciudad tiene una línea de metro que forma un anillo cerrado: después de la última estación el tren vuelve automáticamente a la primera. Los pasajeros pueden viajar en cualquier dirección y el sistema debe mostrar cuántas paradas hay en cada sentido entre dos estaciones.

// La Clase Estacion (Nodo): Debe contener nombre (String), zona (int — del 1 al 3) y pasajerosDiarios (int).
// El Problema: Dado el nombre de una estación de origen y una de destino, el sistema cuenta las paradas yendo hacia adelante (siguiente) y las paradas yendo hacia atrás (anterior), e imprime cuál ruta es más corta.
// Reto: Implementa el método rutaMasCorta(String origen, String destino) que imprima las dos rutas con sus estaciones y número de paradas, y anuncie cuál es la más corta. Si ambas son iguales, indícalo. Usa al menos 6 estaciones para la simulación.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArbolTemperaturas arbol = new ArbolTemperaturas();
        Scanner scanner = new Scanner(System.in);

        // Datos de prueba
        arbol.insertar(28.5, "2026-01-10", "Estacion Norte",  65.0);
        arbol.insertar(34.2, "2026-01-11", "Estacion Sur",    58.3);
        arbol.insertar(21.0, "2026-01-12", "Estacion Este",   72.1);
        arbol.insertar(36.8, "2026-01-13", "Estacion Oeste",  50.0);
        arbol.insertar(19.3, "2026-01-14", "Estacion Norte",  80.5);
        arbol.insertar(31.7, "2026-01-15", "Estacion Sur",    61.4);
        arbol.insertar(40.1, "2026-01-16", "Estacion Central",45.2);
        arbol.insertar(25.6, "2026-01-17", "Estacion Este",   69.8);

        int opcion;
        do {
            System.out.println("\n--- SISTEMA DE REGISTRO METEOROLÓGICO (BST) ---");
            System.out.println("1. Ver registros ordenados por temperatura (InOrden)");
            System.out.println("2. Ver árbol en PreOrden");
            System.out.println("3. Insertar nuevo registro");
            System.out.println("4. Buscar registro por temperatura");
            System.out.println("5. Contar registros sobre un umbral de temperatura");
            System.out.println("6. Propiedades del árbol (altura y hojas)");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println();
                    arbol.inOrden();
                    break;

                case 2:
                    System.out.println();
                    arbol.preOrden();
                    break;

                case 3:
                    System.out.print("Temperatura (°C): ");
                    double temp = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Fecha (AAAA-MM-DD): ");
                    String fecha = scanner.nextLine();
                    System.out.print("Nombre de la estación: ");
                    String estacion = scanner.nextLine();
                    System.out.print("Humedad (%): ");
                    double humedad = scanner.nextDouble();
                    scanner.nextLine();
                    arbol.insertar(temp, fecha, estacion, humedad);
                    System.out.println("Registro insertado correctamente.");
                    break;

                case 4:
                    System.out.print("Temperatura a buscar (°C): ");
                    double busqueda = scanner.nextDouble();
                    scanner.nextLine();
                    Registro encontrado = arbol.buscar(busqueda);
                    if (encontrado != null)
                        System.out.println("Registro encontrado: " + encontrado);
                    else
                        System.out.println("No se encontró ningún registro con " + busqueda + "°C.");
                    break;

                case 5:
                    System.out.print("Ingrese el umbral de temperatura (°C): ");
                    double umbral = scanner.nextDouble();
                    scanner.nextLine();
                    int cantidad = arbol.contarSobre(umbral);
                    System.out.println("Registros con temperatura superior a " + umbral + "°C: " + cantidad);
                    if (cantidad > 0)
                        System.out.println("ALERTA: Se recomienda emitir advertencia de calor extremo.");
                    else
                        System.out.println("Sin alertas. Todas las temperaturas están dentro del rango normal.");
                    break;

                case 6:
                    System.out.println("Altura del árbol:  " + arbol.altura());
                    System.out.println("Nodos hoja:        " + arbol.contarHojas());
                    break;

                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}