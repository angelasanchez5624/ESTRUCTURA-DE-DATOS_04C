// Ejercicio 3 — Sensor de temperatura
// Un sensor industrial registra temperaturas. El sistema recibe:

// Temperatura actual en Celsius (double)
// Nombre del sensor (String)
// Número de lectura (int)
// Si la temperatura supera el límite de 80°C, una variable boolean llamada enAlarma debe ser true.

import java.util.Scanner;

public class Ejercicio_3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del sensor: ");
        String nombreSensor = sc.nextLine();

        System.out.print("Ingrese el número de lectura: ");
        int numeroLectura = sc.nextInt();

        System.out.print("Ingrese la temperatura: ");
        double temperatura = sc.nextDouble();

        boolean enAlarma = temperatura > 80;

        System.out.println("\n=== Estado del Sensor ===");
        System.out.println("Sensor: " + nombreSensor);
        System.out.println("Lectura: " + numeroLectura);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("En alarma: " + enAlarma);
        
           sc.close();
    }
}