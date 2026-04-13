// Reto 1: Contar los Nodos
// A diferencia de los arreglos, que tienen la propiedad .length, en las listas enlazadas simples por lo general no sabemos la cantidad de elementos a menos que la contemos, o que llevemos una variable contadora.

// Tu misión: Implementa el método public int contarNodos() en tu clase ListaEnlazada. Este método debe recorrer toda la lista, sumando 1 por cada nodo que visite, y retornar el total de elementos. Pruébalo en tu método main insertando diferentes cantidades de elementos y mostrando el resultado por consola.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();

        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Insertar dato");
            System.out.println("2. Contar nodos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese un dato: ");
                    int dato = sc.nextInt();
                    lista.insertar(dato);
                    break;

                case 2:
                    System.out.println("Cantidad de nodos: " + lista.contarNodos());
                    break;

                case 3:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 3);

        sc.close();
    }
}