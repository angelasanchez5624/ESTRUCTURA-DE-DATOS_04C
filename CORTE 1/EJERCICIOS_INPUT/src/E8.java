// Ejercicio 8 — Copia real vs referencia
// Pide al usuario 3 calificaciones para llenar notas[]. 
// Crea una copia real en notasRespaldo[] copiando elemento por elemento. 
// Modifica notas[0] con un valor que el usuario ingrese. 
// Muestra ambos arreglos y verifica que notasRespaldo no cambió.

// Datos de entrada: double × 3 notas, double nuevo valor para notas[0]

import java.util.Scanner;

public class E8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] notas = new double[3];
        double[] notasRespaldo = new double[3];

        for (int i = 0; i < notas.length; i++) {
            System.out.print("Ingrese la nota " + i + ": ");
            notas[i] = sc.nextDouble();
            notasRespaldo[i] = notas[i];
        }

        System.out.print("Ingrese el nuevo valor para notas[0]: ");
        notas[0] = sc.nextDouble();

        System.out.println("notas[0]         = " + notas[0] + "  ← cambió");
        System.out.println("notasRespaldo[0] = " + notasRespaldo[0] + "  ← no cambió");

        sc.close();
    }
}
