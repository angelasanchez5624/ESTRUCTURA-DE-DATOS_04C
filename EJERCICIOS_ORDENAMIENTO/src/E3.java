// 3. El Salto de Shell (Optimización de Datos)
// Algoritmo obligatorio: Ordenamiento Shell (Shell Sort)

// Contexto: Una empresa de logística maneja paquetes con diferentes pesos y necesita ordenarlos de forma más eficiente que el método de burbuja o inserción simple.
// Detalle del ejercicio: Solicita al usuario el peso de N paquetes (se recomienda probar con al menos 10 para notar el efecto).
// Lógica de Shell: Implementa el algoritmo usando el salto (gap) inicial de 
// N
// /
// 2
// . El estudiante debe explicar en comentarios por qué este método es generalmente más rápido que la inserción simple al trabajar con elementos que están muy lejos de su posición final.
// Resultado esperado: Mostrar el arreglo original y el arreglo final ordenado después de aplicar todas las fases de reducción de saltos.

import java.util.Scanner;

public class E3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de paquetes: ");
        int n = sc.nextInt();

        double[] pesos = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el peso del paquete " + (i + 1) + ": ");
            pesos[i] = sc.nextDouble();
        }

        System.out.println("\nArreglo original:");
        for (int i = 0; i < n; i++) {
            System.out.print(pesos[i] + " ");
        }

        int gap = n / 2;

        // Shell Sort usa saltos (gap) para comparar elementos lejanos
        // Esto es más rápido que inserción simple porque mueve los
        // elementos grandes más cerca de su posición final desde el inicio

        while (gap > 0) {

            for (int i = gap; i < n; i++) {
                double temp = pesos[i];
                int j = i;

                while (j >= gap && pesos[j - gap] > temp) {
                    pesos[j] = pesos[j - gap];
                    j -= gap;
                }

                pesos[j] = temp;
            }

            gap = gap / 2;
        }

        System.out.println("\nArreglo ordenado:");
        for (int i = 0; i < n; i++) {
            System.out.print(pesos[i] + " ");
        }

        sc.close();
    }
}