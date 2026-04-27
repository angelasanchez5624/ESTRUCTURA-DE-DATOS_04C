public class Historial {
    Comando cabeza;
    Comando cola;
    Comando cursor;

    public Historial() {
        cabeza = null;
        cola = null;
        cursor = null;
    }

    public boolean estaVacio() {
        return cabeza == null;
    }

    public void agregarComando(String texto, boolean exitoso, String directorio) {
        Comando nuevo = new Comando(texto, exitoso, directorio);

        if (estaVacio()) {
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
            cabeza = nuevo;
            cola = nuevo;
            cursor = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cola = nuevo;
        }
    }

    // Flecha arriba
    public void arriba() {
        if (!estaVacio()) {
            cursor = cursor.anterior;
        }
    }

    // Flecha abajo
    public void abajo() {
        if (!estaVacio()) {
            cursor = cursor.siguiente;
        }
    }

    public void mostrarCursor() {
        if (estaVacio()) {
            System.out.println("Historial vacío.");
            return;
        }

        System.out.println("\nComando actual:");
        System.out.println("Texto: " + cursor.texto);
        System.out.println("Directorio: " + cursor.directorio);
        System.out.println("Estado: " + (cursor.exitoso ? "Exitoso" : "Fallido"));
    }

    public void eliminarActual() {
        if (estaVacio()) return;

        System.out.println("Comando eliminado: " + cursor.texto);

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            cursor = null;
        } else {
            cursor.anterior.siguiente = cursor.siguiente;
            cursor.siguiente.anterior = cursor.anterior;

            if (cursor == cabeza) cabeza = cursor.siguiente;
            if (cursor == cola) cola = cursor.anterior;

            cursor = cursor.siguiente;
        }
    }

    public void mostrarHistorial() {
        if (estaVacio()) {
            System.out.println("Historial vacío.");
            return;
        }

        System.out.println("\n=== Historial de comandos ===");
        Comando actual = cabeza;
        int i = 1;

        do {
            String marca = (actual == cursor) ? "  <-- CURSOR" : "";
            System.out.println(i + ". " + actual.texto + marca);
            actual = actual.siguiente;
            i++;
        } while (actual != cabeza);
    }
}