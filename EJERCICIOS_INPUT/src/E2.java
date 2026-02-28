// Ejercicio 2 — Conversor de temperatura
// Pide al usuario una temperatura en Celsius y conviértela a Fahrenheit y Kelvin.

// Fórmulas:

// F = (C × 9/5) + 32
// K = C + 273.15
// Dato de entrada: double temperatura en Celsius

import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la temperatura en Celsius: ");
        double celsius = sc.nextDouble();

        double fahrenheit = (celsius * 9 / 5) + 32;
        double kelvin = celsius + 273.15;

        System.out.println(celsius + " °C = " + fahrenheit + " °F = " + kelvin + " K");

        sc.close();
    }
}
