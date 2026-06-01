// 5. Control de Inventario (Almacén de Repuestos)
// Un taller mecánico almacena los repuestos de su inventario en un BST organizado por código de referencia (un número entero único). Cuando un repuesto se agota, su nodo queda como hoja (no tiene hijos) porque no ha sido reemplazado por variantes. El administrador quiere saber cuántos repuestos son "únicos" (sin variantes relacionadas) y cuál es el recorrido completo del inventario en PreOrden para realizar una copia de seguridad del árbol.

// La Clase Repuesto (Nodo): Debe contener codigoRef (int, clave del BST), descripcion (String), marca (String) y stock (int).
// El Problema: El administrador necesita dos reportes: el primero lista todos los repuestos en PreOrden (para poder reconstruir el árbol en otro sistema con el mismo orden de inserción), y el segundo informa cuántos repuestos son hojas del árbol (sin variantes relacionadas).
// Reto: Implementa backupPreOrden() que imprima todos los repuestos en recorrido PreOrden con el formato [codigoRef] descripcion - marca (stock uds). Implementa también reporteRepuestosUnicos() que use contarHojas() e imprima un mensaje indicando cuántos repuestos no tienen variantes relacionadas en el catálogo.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArbolRepuestos arbol = new ArbolRepuestos();
        Scanner sc = new Scanner(System.in);

        // Datos de prueba
        arbol.insertar(300, "Filtro de aceite", "Bosch", 15);
        arbol.insertar(150, "Bujía", "NGK", 40);
        arbol.insertar(450, "Pastillas de freno", "Brembo", 20);
        arbol.insertar(100, "Correa", "Gates", 10);
        arbol.insertar(200, "Batería", "ACDelco", 8);

        int opcion;
        do {
            System.out.println("\n--- CONTROL DE INVENTARIO (BST) ---");
            System.out.println("1. Backup del inventario (PreOrden)");
            System.out.println("2. Insertar repuesto");
            System.out.println("3. Reporte de repuestos únicos");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    arbol.backupPreOrden();
                    break;

                case 2:
                    System.out.print("Código de referencia: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Descripción: ");
                    String desc = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Stock: ");
                    int stock = sc.nextInt();
                    sc.nextLine();
                    arbol.insertar(codigo, desc, marca, stock);
                    break;

                case 3:
                    arbol.reporteRepuestosUnicos();
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 4);

        sc.close();
    }
}