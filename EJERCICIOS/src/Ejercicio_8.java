// Ejercicio 8 — Historial de mensajes
// Un chat guarda el último mensaje enviado. 
// Se usan dos variables String:

// ultimoMensaje = "Hola"
// copiaTexto = ultimoMensaje
// Luego copiaTexto se cambia a "¿Cómo estás?"
// Muestra ambas variables y explica en un comentario por qué ultimoMensaje no cambió (inmutabilidad de String).

public class Ejercicio_8 {
    public static void main(String[] args) {

        String ultimoMensaje = "Hola";
        String copiaTexto = ultimoMensaje;

        copiaTexto = "¿Cómo estás?";

        System.out.println("Ultimo mensaje: " + ultimoMensaje);
        System.out.println("Copia texto: " + copiaTexto);

        // String es inmutable.
        // Al cambiar copiaTexto, se crea un nuevo objeto.
        // ultimoMensaje sigue apuntando al texto original.
    }
}