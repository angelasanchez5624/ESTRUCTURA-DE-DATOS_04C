// Ejercicio 1 — Ficha de un estudiante
// Un sistema universitario necesita registrar la información básica de un estudiante: 
// nombre completo, código (número entero), semestre actual, promedio acumulado y si está matriculado o no.

// Declara las variables con los tipos de datos apropiados.

import java.util.Scanner;

public class Ejercicio_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre completo: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese el código: ");
        int codigo = sc.nextInt();

        System.out.print("Ingrese el semestre: ");
        int semestre = sc.nextInt();

        System.out.print("Ingrese el promedio: ");
        double promedio = sc.nextDouble();

        System.out.print("¿Está matriculado? (true/false): ");
        boolean matriculado = sc.nextBoolean();

        System.out.println("\n=== Ficha del Estudiante ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Código: " + codigo);
        System.out.println("Semestre: " + semestre);
        System.out.println("Promedio: " + promedio);
        System.out.println("Matriculado: " + matriculado);

           sc.close();
    }
}