// EJERCICIO 2. INVENTARIO 
// Objetivo: Administrar con POO y busqueda eficiente.
// // ¿qué debes hacer?
// 1. clase: dispositivo con id (int), marca (string)y precio (double).
// 2. entrada: pide datos de 6 dispositivos y guardalos en dispositivo[]
// 3. ordenamiento: usa shell sort para ordenar por id (menor a mayor).
// 4. busqueda: pide un id y buscalo con busqueda binaria. muestra toda su info.
// 5. maximo: indica la marca y precio del dispositivo mas costoso.
// Ejemplo de consola:
// id: 502 | marca: samsung | $1200
// ---ordenado por id--- (shell)---
// id: 101| apple| $1500
import java.util.Scanner;

class Dispositivo {
    int id;
    String marca;
    double precio;

    public Dispositivo(int id, String marca, double precio) {
        this.id = id;
        this.marca = marca;
        this.precio = precio;
    }
}

public class Inventario {

    public static void shellSort(Dispositivo[] arr) {
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                Dispositivo temp = arr[i];
                int j = i;

                while (j >= gap && arr[j - gap].id > temp.id) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    public static int busquedaBinaria(Dispositivo[] arr, int idBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (arr[medio].id == idBuscado) {
                return medio;
            } else if (arr[medio].id < idBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Dispositivo[] dispositivos = new Dispositivo[6];

        for (int i = 0; i < 6; i++) {
            System.out.println("Dispositivo " + (i + 1));

            System.out.print("ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Marca: ");
            String marca = sc.nextLine();

            System.out.print("Precio: ");
            double precio = sc.nextDouble();

            dispositivos[i] = new Dispositivo(id, marca, precio);
        }

        shellSort(dispositivos);

        System.out.println("\n--- ORDENADO POR ID (SHELL SORT) ---");
        for (Dispositivo d : dispositivos) {
            System.out.println("ID: " + d.id + " | Marca: " + d.marca + " | $" + d.precio);
        }

        System.out.print("\nIngrese ID a buscar: ");
        int idBuscar = sc.nextInt();

        int pos = busquedaBinaria(dispositivos, idBuscar);

        if (pos != -1) {
            System.out.println("Encontrado:");
            System.out.println("ID: " + dispositivos[pos].id +
                               " | Marca: " + dispositivos[pos].marca +
                               " | $" + dispositivos[pos].precio);
        } else {
            System.out.println("No encontrado");
        }

        Dispositivo max = dispositivos[0];

        for (int i = 1; i < dispositivos.length; i++) {
            if (dispositivos[i].precio > max.precio) {
                max = dispositivos[i];
            }
        }

        System.out.println("\nDispositivo más costoso:");
        System.out.println("Marca: " + max.marca + " | Precio: $" + max.precio);

        sc.close();
    }
}
