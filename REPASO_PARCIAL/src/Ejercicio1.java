// Ejercicio 1: Inventario "TecnoStore" (Shell Sort)
// Objetivo: Registrar productos y ordenarlos por su ID para realizar búsquedas rápidas.
// ¿Qué debes hacer?
// 1. Clase: Crea una clase Producto con: id (int), nombre (String), precio (double) y stock (int).
// 2. Entrada de Datos: Pide al usuario que ingrese los datos de 5 productos por teclado y guárdalos en un arreglo
// Producto[] .
// 3. Ordenamiento: Usa Shell Sort para ordenar los productos de menor a mayor según su id .
// 4. Búsqueda: Pide un id al usuario y búscalo usando Búsqueda Binaria.

import java.util.Scanner;

public class Ejercicio1 {

    public static void shellSort(Producto[] productos) {

        int n = productos.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {

                Producto temp = productos[i];
                int j = i;

                while (j >= gap && productos[j - gap].id > temp.id) {
                    productos[j] = productos[j - gap];
                    j -= gap;
                }

                productos[j] = temp;
            }
        }
    }

    public static int busquedaBinaria(Producto[] productos, int idBuscar) {

        int inicio = 0;
        int fin = productos.length - 1;

        while (inicio <= fin) {

            int medio = (inicio + fin) / 2;

            if (productos[medio].id == idBuscar)
                return medio;

            if (productos[medio].id < idBuscar)
                inicio = medio + 1;
            else
                fin = medio - 1;
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        Producto[] productos = new Producto[5];

        System.out.println("--- REGISTRO DE PRODUCTOS ---");

        for (int i = 0; i < productos.length; i++) {

            System.out.println("Producto " + (i + 1));

            System.out.print("Ingrese ID: ");
            int id = leer.nextInt();
            leer.nextLine();

            System.out.print("Ingrese Nombre: ");
            String nombre = leer.nextLine();

            System.out.print("Ingrese Precio: ");
            double precio = leer.nextDouble();

            System.out.print("Ingrese Stock: ");
            int stock = leer.nextInt();

            productos[i] = new Producto(id, nombre, precio, stock);
        }

        shellSort(productos);

        System.out.println("\n--- INVENTARIO ORDENADO ---");

        for (Producto p : productos) {
            System.out.println("ID: " + p.id + " | Nombre: " + p.nombre +
                    " | Precio: " + p.precio + " | Stock: " + p.stock);
        }

        System.out.print("\nIngrese ID a buscar: ");
        int buscar = leer.nextInt();

        int pos = busquedaBinaria(productos, buscar);

        if (pos != -1) {
            Producto p = productos[pos];
            System.out.println(">> PRODUCTO ENCONTRADO: " + p.nombre +
                    " - Precio: $" + p.precio + " - Stock: " + p.stock);
        } else {
            System.out.println("Producto no encontrado");
        }

        leer.close();
    }
}