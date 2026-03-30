// Ejercicio 10 — Intercambio de valores
// Pide dos números enteros x e y. 
// Intercambia sus valores usando una variable auxiliar temp. 
// Muestra los valores antes y después del intercambio.

// Datos de entrada: int x, int y

import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese x: ");
        int x = sc.nextInt();

        System.out.print("Ingrese y: ");
        int y = sc.nextInt();

        System.out.println("Antes  → x=" + x + ", y=" + y);

        int temp = x;
        x = y;
        y = temp;

        System.out.println("Después→ x=" + x + ", y=" + y);

        sc.close();
    }
}