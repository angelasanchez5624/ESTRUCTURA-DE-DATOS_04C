// 5. El Inspector de Eficiencia (Duelo de Métodos)
// Algoritmos obligatorios: Selección vs Inserción

// Contexto: Un analista de sistemas quiere saber cuál algoritmo es más "pesado" en términos de operaciones para un caso específico.
// Detalle del ejercicio: El usuario debe ingresar 6 números enteros desordenados. El programa aplicará AMBOS métodos al mismo conjunto de datos (puedes usar una copia del arreglo original).
// Lógica de Conteo:
// En Selección: Cuenta cada vez que ocurre un swap (intercambio físico de posiciones).
// En Inserción: Cuenta cada vez que un elemento se "mueve" hacia la izquierda dentro del bucle interno.
// Resultado esperado: El programa debe imprimir cuántos intercambios hizo Selección y cuántos movimientos hizo Inserción. El estudiante debe concluir cuál fue más eficiente para esos datos ingresados por el teclado.

import java.util.Scanner;

public class E5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 6;
        int[] numeros = new int[n];
        int[] copia1 = new int[n];
        int[] copia2 = new int[n];

        System.out.println("Ingrese 6 numeros enteros:");

        for (int i = 0; i < n; i++) {
            numeros[i] = sc.nextInt();
            copia1[i] = numeros[i];
            copia2[i] = numeros[i];
        }

        int intercambios = 0;

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (copia1[j] < copia1[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int temp = copia1[i];
                copia1[i] = copia1[min];
                copia1[min] = temp;
                intercambios++;
            }
        }

        int movimientos = 0;

        for (int i = 1; i < n; i++) {
            int clave = copia2[i];
            int j = i - 1;

            while (j >= 0 && copia2[j] > clave) {
                copia2[j + 1] = copia2[j];
                j--;
                movimientos++;
            }

            copia2[j + 1] = clave;
        }

        System.out.println("\nIntercambios en Selection Sort: " + intercambios);
        System.out.println("Movimientos en Insertion Sort: " + movimientos);

        if (intercambios < movimientos) {
            System.out.println("Selection Sort fue mas eficiente para estos datos.");
        } else if (movimientos < intercambios) {
            System.out.println("Insertion Sort fue mas eficiente para estos datos.");
        } else {
            System.out.println("Ambos algoritmos tuvieron la misma eficiencia.");
        }
        
        sc.close();
    }
}