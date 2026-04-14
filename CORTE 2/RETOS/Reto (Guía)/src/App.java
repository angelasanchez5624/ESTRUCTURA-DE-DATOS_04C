import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Lista lista = new Lista();
        int op = 0;
        while (op != 4) {
            System.out.println("====================================");
            System.out.println("         Listas");
            System.out.println("====================================");
            System.out.println("1. Agregar");
            System.out.println("2. Contar");
            System.out.println("3. Salir");
            System.out.println("====================================");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    System.out.print("Ingrese valor ");
                    int valor = sc.nextInt();
                    Nodos Nodo = new Nodos(valor);
                    lista.agregarLista(Nodo);
                    break;
                case 2:
                    int contador=lista.contarNodos();
                    System.out.println("La cantidad de elementos que hay es :" + contador );
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        sc.close();
    }
}
