// Ejercicio 3 — Promedio de notas
// Pide al usuario su nombre y 4 notas de un curso. 
// Calcula el promedio y determina si aprobó (promedio >= 3.0).

// Datos de entrada:

// String nombre
// double nota1, nota2, nota3, nota4

import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la nota 1: ");
        double n1 = sc.nextDouble();
        System.out.print("Ingrese la nota 2: ");
        double n2 = sc.nextDouble();
        System.out.print("Ingrese la nota 3: ");
        double n3 = sc.nextDouble();
        System.out.print("Ingrese la nota 4: ");
        double n4 = sc.nextDouble();

        double promedio = (n1 + n2 + n3 + n4) / 4;
        boolean aprobado = promedio >= 3.0;

        System.out.println("\nEstudiante: " + nombre);
        System.out.printf("Promedio  : %.2f\n", promedio);
        System.out.println("Estado    : " + (aprobado ? "APROBADO" : "REPROBADO"));

        sc.close();
    }
}
