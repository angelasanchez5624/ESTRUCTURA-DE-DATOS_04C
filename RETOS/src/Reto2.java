//Reto2. Fintech: Análisis de Transacciones

// Un banco registra transacciones. Tienes una lista de cuentasVIP ordenada (ej: 10, 25, 40, 80, 150).

// Entrada de Datos:
// El usuario debe ingresar los montos y los números de cuenta de las últimas 5 transacciones del cajero automático.

// El Reto:
// i. Busca linealmente cualquier transacción cuyo monto supere los $5,000.
// ii. Para cada cuenta que supere ese monto, verifica con Búsqueda Binaria si pertenece a las cuentasVIP.
//  Si no es VIP, imprime: "Alerta de fraude: Cuenta no autorizada para montos altos".

// ¿Por qué ambos?
// Las ventas ocurren en desorden, pero la verificación de estatus VIP es una consulta de base de datos indexada.

import java.util.Scanner;

public class Reto2 {

    public static boolean busquedaBinaria(int[] lista, int objetivo) {
        int inicio = 0;
        int fin = lista.length - 1;

        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;

            if (lista[medio] == objetivo) {
                return true;
            } else if (lista[medio] < objetivo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] cuentasVIP = {10, 25, 40, 80, 150};

        int[] cuentas = new int[5];
        double[] montos = new double[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese el número de cuenta: ");
            cuentas[i] = sc.nextInt();

            System.out.print("Ingrese el monto de la transacción: ");
            montos[i] = sc.nextDouble();
        }

        for (int i = 0; i < 5; i++) {
            if (montos[i] > 5000) {
                if (!busquedaBinaria(cuentasVIP, cuentas[i])) {
                    System.out.println("Alerta de fraude: Cuenta no autorizada para montos altos");
                }
            }
        }

        sc.close();
    }
