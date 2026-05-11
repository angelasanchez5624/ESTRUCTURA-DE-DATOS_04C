// Ejercicio 1. Inventario de Almacen 
// objetivo: gestionar stock de productos con listas simples.
// que debes hacer?
// 1. estructura (3 archivos): Producto.java (nodo), Almacen.java (logica) y App.java (Menu)
// 2. menu interactivo: implementa un switch con:
// a. registrar producto: agregar al final con codigo, nombre, cantidad y precio.
// b. buscar y editar: buscar por codigo y permitir actualizar la cantidad (sumar o restar stock)
// c. valor del inventario: msotrar lista completa y el valor total (suma de cantidad * precio de todos)
// d. eliminar producto: pedir el codigo de un producto y eliminarlo de la lista (manejar correctamente si es la cabeza, el medio o el final)
// 3. validacion: no permitir cantidades negativas ni codigos duplicados.
//  Ejemplo de Consola:
//  1. registrar | 2. editar stock | 3. valor total | 4. eliminar | 5. salir
//  opcion: 4
//  ingrese codigo a eliminar: 001
//  producto 'mouse' eliminado del inventario.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Almacen almacen = new Almacen();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("             INVENTARIO DE ALMACEN");
            System.out.println("==============================================");
            System.out.println("\n1. Registrar | 2. Editar stock | 3. Valor total | 4. Eliminar | 5. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Codigo: ");
                    String cod = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nom = sc.nextLine();

                    System.out.print("Cantidad: ");
                    int cant = sc.nextInt();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();

                    almacen.registrar(cod, nom, cant, precio);
                    break;

                case 2:
                    System.out.print("Codigo: ");
                    String c = sc.nextLine();

                    System.out.print("Cantidad a sumar/restar: ");
                    int cambio = sc.nextInt();

                    almacen.editarStock(c, cambio);
                    break;

                case 3:
                    almacen.mostrarInventario();
                    break;

                case 4:
                    System.out.print("Ingrese codigo a eliminar: ");
                    String ce = sc.nextLine();

                    almacen.eliminar(ce);
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 5);

        sc.close();
    }
}



