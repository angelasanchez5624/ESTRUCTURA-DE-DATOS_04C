// 4. Peaje Inteligente (Control de Tráfico)
// En una autopista de peaje, los vehículos ingresan a un carril y avanzan en fila hasta la cabina de cobro. El sistema registra automáticamente cada vehículo al entrar al carril. El cajero cobra en el orden estricto de llegada.

// La Clase Vehiculo (Nodo): Debe contener placa (String), tipoVehiculo (String), tarifa (double) y esExento (boolean).
// El Problema: Al cerrar el turno, el sistema debe calcular el total recaudado, ignorando los vehículos exentos de pago.
// Reto: Implementa un método cerrarTurno() que extraiga (dequeue) todos los vehículos de la cola, acumule la tarifa solo de los que tengan esExento = false e imprima el total recaudado al finalizar.

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ColaVehiculos vehiculos = new ColaVehiculos();
        Scanner scanner = new Scanner(System.in);
        
        //  Datos de prueba
        vehiculos.enqueue(new Vehiculo("ABC123", "Carro", 12000, false));
        vehiculos.enqueue(new Vehiculo("XYZ456", "Moto", 6000, false));
        vehiculos.enqueue(new Vehiculo("GOV789", "Oficial", 0, true));

        int opcion;

        do {

            System.out.println("\n--- SISTEMA DE PEAJE ---");
            System.out.println("1. Ver vehículos en cola");
            System.out.println("2. Registrar vehículo");
            System.out.println("3. Atender vehículo");
            System.out.println("4. Cerrar turno");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    vehiculos.imprimir();

                    break;

                case 2:

                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();

                    System.out.print("Tipo de vehículo: ");
                    String tipo = scanner.nextLine();

                    System.out.print("Tarifa: ");
                    double tarifa = scanner.nextDouble();

                    System.out.print("¿Es exento? (true/false): ");
                    boolean exento = scanner.nextBoolean();
                    scanner.nextLine();

                    vehiculos.enqueue(
                        new Vehiculo(placa, tipo, tarifa, exento)
                    );

                    System.out.println("Vehículo registrado correctamente.");

                    break;

                case 3:

                    Vehiculo atendido = vehiculos.dequeue();

                    if (atendido != null) {

                        System.out.println("\nVehículo atendido:");
                        System.out.println(
                            "Placa: " + atendido.placa +
                            " | Tipo: " + atendido.tipoVehiculo +
                            " | Tarifa: " + atendido.tarifa +
                            " | Exento: " + atendido.esExento
                        );
                    }

                    break;

                case 4:

                    vehiculos.cerrarTurno();

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