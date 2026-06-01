// 3. Sistema de Nómina (Recursos Humanos)
// Una empresa de logística administra a sus empleados en un BST organizado por número de cédula. El área de RRHH consulta frecuentemente el empleado con el menor y el mayor número de cédula para procesar los extremos de la nómina. También necesita conocer la altura del árbol para auditar si la estructura sigue siendo eficiente después de muchas incorporaciones.

// La Clase Empleado (Nodo): Debe contener cedula (long, clave del BST), nombreCompleto (String), cargo (String) y salario (double).
// El Problema: El sistema debe poder ubicar al empleado con la cédula más baja (el más antiguo en el registro) y al de cédula más alta (el más reciente), y también reportar la altura actual del árbol para verificar que las búsquedas siguen siendo eficientes.
// Reto: Implementa buscarMinimo() y buscarMaximo(), que recorran el BST siguiendo siempre el subárbol izquierdo o derecho respectivamente hasta llegar a una hoja e impriman los datos del empleado encontrado. Implementa también reporteEficiencia() que imprima la altura actual del árbol y el número total de hojas (contarHojas()).

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        ArbolNomina nomina = new ArbolNomina();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Datos de prueba
        nomina.insertar(10203040L, "Ana Torres", "Analista", 3200000);
        nomina.insertar(90807060L, "Luis Gomez", "Supervisor", 4500000);
        nomina.insertar(30405060L, "Maria Perez", "Auxiliar", 2800000);
        nomina.insertar(50607080L, "Carlos Ruiz", "Coordinador", 3800000);
        nomina.insertar(12030405L, "Laura Diaz", "Jefe RRHH", 5200000);

        do {
            System.out.println("\n--- SISTEMA DE NOMINA (BST) ---");
            System.out.println("1. Insertar empleado");
            System.out.println("2. Mostrar empleado con cedula minima");
            System.out.println("3. Mostrar empleado con cedula maxima");
            System.out.println("4. Reporte de eficiencia");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Cedula: ");
                    long cedula = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Nombre completo: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();
                    System.out.print("Salario: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine();
                    nomina.insertar(cedula, nombre, cargo, salario);
                    break;

                case 2:
                    System.out.println(nomina.buscarMinimo());
                    break;

                case 3:
                    System.out.println(nomina.buscarMaximo());
                    break;

                case 4:
                    nomina.reporteEficiencia();
                    break;

                case 5:
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }
}