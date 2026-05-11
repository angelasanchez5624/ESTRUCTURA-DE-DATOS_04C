// Ejercicio 2: Historial de Comandos 
// objetivo: simular un historial de terminal (flecha arriba/ abajo) con listas circulares dobles
// que debes hacer?
// 1. estructura (3 archivos): Comando.java, Consola.java  y App.java
// 2. menu interactivo: implementa un switch con:
// a. nuevo comando: agregar un comando (texto, hora) al final de la lista circular
// b. comando anterior: mover el cursor hacia atras (simula flecha arriba)
// c. comando siguiente: mover el cursor hacia adelante (simula flecha abajo)
// d. borrar actual: eliminar el comando donde esta el cursor y reconectar la lista en O(1)
// e. buscar comando: buscar por texto y mover el cursor directamente a esa posicion 
// 3. validacion circular: al navegar o listar el historial, debe mostrarse visualmente que la lista se cierra sobre si misma.por ejemplo: ls <-> cd.. <-> git status <-> ls
// ejemplo de consola:
//  cursor en: 'git status' (10:15am)
//  [flecha arriba]-> cursor en: 'cd Documents'
//  ---Historial Completo ---
//  ls <-> cd Documents <-> git status <-> ls

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Consola consola = new Consola();
        int opcion;

        do {
            System.out.println("\n==============================================");
            System.out.println("             HISTORIAL DE COMANDOS");
            System.out.println("==============================================");
            System.out.println("\n1. Nuevo comando");
            System.out.println("2. Comando anterior");
            System.out.println("3. Comando siguiente");
            System.out.println("4. Borrar actual");
            System.out.println("5. Buscar comando");
            System.out.println("6. Mostrar historial");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese comando: ");
                    String texto = sc.nextLine();
                    System.out.print("Hora: ");
                    String hora = sc.nextLine();
                    consola.agregar(texto, hora);
                    break;
                case 2:
                    consola.anterior();
                    break;
                case 3:
                    consola.siguiente();
                    break;
                case 4:
                    consola.borrarActual();
                    break;
                case 5:
                    System.out.print("Buscar: ");
                    String buscar = sc.nextLine();
                    consola.buscar(buscar);
                    break;
                case 6:
                    consola.mostrarHistorial();
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }
}