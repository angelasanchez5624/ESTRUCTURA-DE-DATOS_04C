// Ejercicio 4 — Perfil de usuario
// Pide al usuario los datos de su perfil: nombre, edad, ciudad, correo y si acepta términos y condiciones. 
// Muestra un resumen indicando el tipo de dato que se usó para cada campo.

// Datos de entrada: String, int, String, String, boolean

import java.util.Scanner;

public class E4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese su edad: ");
        int edad = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese su ciudad: ");
        String ciudad = sc.nextLine();
        

        System.out.print("Ingrese su correo: ");
        String correo = sc.nextLine();

        System.out.print("¿Acepta términos y condiciones? (true/false): ");
        boolean terminos = sc.nextBoolean();

        System.out.println("\n========= Perfil creado =========");
        System.out.println("Nombre  (String)  : " + nombre);
        System.out.println("Edad    (int)     : " + edad);
        System.out.println("Ciudad  (String)  : " + ciudad);
        System.out.println("Correo  (String)  : " + correo);
        System.out.println("T&C     (boolean) : " + terminos);

        sc.close();
    }
}