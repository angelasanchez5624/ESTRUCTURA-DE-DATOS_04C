public class Consola {
    private Comando cabeza;
    private Comando cursor;

    public void agregar(String texto, String hora) {
        Comando nuevo = new Comando(texto, hora);

        if (cabeza == null) {
            cabeza = nuevo;
            cursor = nuevo;
        } else {
            Comando ultimo = cabeza.anterior;

            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;

            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;

            cursor = nuevo;
        }
    }

    public void anterior() {
        if (cursor != null) {
            cursor = cursor.anterior;
            mostrarCursor();
        }
    }

    public void siguiente() {
        if (cursor != null) {
            cursor = cursor.siguiente;
            mostrarCursor();
        }
    }

    public void borrarActual() {
        if (cursor == null) return;

        if (cursor.siguiente == cursor) {
            cabeza = null;
            cursor = null;
        } else {
            Comando anterior = cursor.anterior;
            Comando siguiente = cursor.siguiente;

            anterior.siguiente = siguiente;
            siguiente.anterior = anterior;

            if (cursor == cabeza) {
                cabeza = siguiente;
            }

            cursor = siguiente;
        }
    }

    public void buscar(String texto) {
        if (cabeza == null) return;

        Comando temp = cabeza;
        do {
            if (temp.texto.equalsIgnoreCase(texto)) {
                cursor = temp;
                mostrarCursor();
                return;
            }
            temp = temp.siguiente;
        } while (temp != cabeza);

        System.out.println("Comando no encontrado");
    }

    public void mostrarCursor() {
        if (cursor != null) {
            System.out.println("Cursor en: '" + cursor.texto + "' (" + cursor.hora + ")");
        } else {
            System.out.println("Historial vacío");
        }
    }

    public void mostrarHistorial() {
        if (cabeza == null) {
            System.out.println("Historial vacío");
            return;
        }

        System.out.println("--- Historial Completo ---");

        Comando temp = cabeza;
        do {
            System.out.print(temp.texto + " <-> ");
            temp = temp.siguiente;
        } while (temp != cabeza);

        System.out.println(cabeza.texto);
    }
}