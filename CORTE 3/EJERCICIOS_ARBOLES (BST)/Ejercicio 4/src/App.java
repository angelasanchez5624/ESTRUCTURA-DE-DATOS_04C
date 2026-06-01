// 4. Torneo de Ajedrez (Sistema de Rankings ELO)
// Una plataforma de ajedrez en línea gestiona el ranking ELO de sus jugadores en un BST. A medida que los jugadores completan partidas, su ELO se actualiza y se reinsertan en el árbol. El director del torneo necesita obtener la lista de jugadores que clasifican a la siguiente ronda, es decir, todos aquellos cuyo ELO se encuentre dentro de un rango específico.

// La Clase Jugador (Nodo): Debe contener elo (int, clave del BST), nombreUsuario (String), pais (String) y partidasJugadas (int).
// El Problema: Para la ronda de clasificación, el director fija un rango mínimo y máximo de ELO (por ejemplo, entre 1800 y 2200). Todos los jugadores en ese rango deben ser listados de menor a mayor ELO para armar los emparejamientos.
// Reto: Implementa el método listarEnRango(int eloMin, int eloMax) que recorra el árbol e imprima los datos de todos los jugadores cuyo elo esté dentro del rango [eloMin, eloMax] en orden ascendente. Usa la propiedad del BST para podar: si el nodo actual es menor que eloMin, solo explora el subárbol derecho; si es mayor que eloMax, solo explora el izquierdo.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArbolJugadores arbol = new ArbolJugadores();
        Scanner sc = new Scanner(System.in);

        // Datos de prueba
        arbol.insertar(1750, "reyNegro", "Colombia", 120);
        arbol.insertar(1900, "alfilRojo", "Argentina", 210);
        arbol.insertar(2000, "damaVerde", "Chile", 300);
        arbol.insertar(2200, "torreBlanca", "España", 400);
        arbol.insertar(2300, "granMaestro", "Rusia", 520);
        arbol.insertar(1800, "caballoAzul", "México", 160);

        int opcion;
        do {
            System.out.println("\n--- TORNEO DE AJEDREZ (BST ELO) ---");
            System.out.println("1. Ver ranking por rango de ELO");
            System.out.println("2. Insertar nuevo jugador");
            System.out.println("3. Buscar jugador por ELO");
            System.out.println("4. Ver ranking completo (ordenado por ELO)");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ELO mínimo: ");
                    int min = sc.nextInt();
                    System.out.print("ELO máximo: ");
                    int max = sc.nextInt();
                    sc.nextLine();
                    arbol.listarEnRango(min, max);
                    break;

                case 2:
                    System.out.print("ELO: ");
                    int elo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Usuario: ");
                    String usuario = sc.nextLine();
                    System.out.print("País: ");
                    String pais = sc.nextLine();
                    System.out.print("Partidas jugadas: ");
                    int partidas = sc.nextInt();
                    sc.nextLine();
                    arbol.insertar(elo, usuario, pais, partidas);
                    break;

                case 3:
                    System.out.print("ELO a buscar: ");
                    int buscar = sc.nextInt();
                    sc.nextLine();
                    Jugador j = arbol.buscar(buscar);
                    if (j != null)
                        System.out.println(j);
                    else
                        System.out.println("Jugador no encontrado");
                    break;

                case 4:
                    arbol.inOrden();
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);

        sc.close();
    }
}