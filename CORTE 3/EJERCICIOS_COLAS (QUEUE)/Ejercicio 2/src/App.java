// 2. Urgencias Hospitalarias (Triaje)
// En la sala de urgencias de un hospital, los pacientes que llegan son registrados y colocados en una fila de atención. Dado el volumen de pacientes, el médico de guardia atiende en estricto orden de llegada. Al momento de llamar a un paciente, el sistema debe mostrar su información completa.

// La Clase Paciente (Nodo): Debe contener cedula (String), nombreCompleto (String), edad (int) y sintomaPrincipal (String).
// El Problema: Al finalizar el turno, el hospital necesita un reporte del total de pacientes atendidos y la lista completa en orden de atención.
// Reto: Implementa un método atenderTodos() que extraiga (dequeue) a cada paciente uno a uno, imprima su información al momento de ser atendido e imprima al final el total de pacientes procesados.

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ColaPacientes pacientes = new ColaPacientes();
        Scanner scanner = new Scanner(System.in);

        //  Datos de prueba
        pacientes.enqueue(new Paciente("1010", "Juan Perez", 30, "Dolor de cabeza"));
        pacientes.enqueue(new Paciente("2020", "Maria Gomez", 25, "Fiebre"));
        pacientes.enqueue(new Paciente("3030", "Carlos Ruiz", 40, "Dolor abdominal"));

        int opcion;

        do {

            System.out.println("\n--- SISTEMA DE URGENCIAS HOSPITALARIAS ---");
            System.out.println("1. Ver pacientes en espera");
            System.out.println("2. Registrar paciente");
            System.out.println("3. Atender paciente");
            System.out.println("4. Atender todos los pacientes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    pacientes.imprimir();

                    break;

                case 2:

                    System.out.print("Cedula: ");
                    String cedula = scanner.nextLine();

                    System.out.print("Nombre completo: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Sintoma principal: ");
                    String sintoma = scanner.nextLine();

                    pacientes.enqueue(
                        new Paciente(cedula, nombre, edad, sintoma)
                    );

                    System.out.println("Paciente registrado correctamente.");

                    break;

                case 3:

                    Paciente atendido = pacientes.dequeue();

                    if (atendido != null) {

                        System.out.println("\nPaciente atendido:");
                        System.out.println(
                            "CC: " + atendido.cedula +
                            " | Nombre: " + atendido.nombreCompleto +
                            " | Edad: " + atendido.edad +
                            " | Síntoma: " + atendido.sintomaPrincipal
                        );
                    }

                    break;

                case 4:

                    pacientes.atenderTodos();

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
