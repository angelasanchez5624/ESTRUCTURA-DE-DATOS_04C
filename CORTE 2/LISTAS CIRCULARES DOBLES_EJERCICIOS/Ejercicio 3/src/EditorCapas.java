public class EditorCapas {
    Capa cabeza;
    Capa cola;
    Capa capaActiva;

    public EditorCapas() {
        cabeza = null;
        cola = null;
        capaActiva = null;
    }

    public boolean estaVacio() {
        return cabeza == null;
    }

    public void agregarCapa(String nombre, boolean visible, String tipo) {
        Capa nueva = new Capa(nombre, visible, tipo);

        if (estaVacio()) {
            nueva.siguiente = nueva;
            nueva.anterior = nueva;
            cabeza = nueva;
            cola = nueva;
            capaActiva = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cola = nueva;
        }
    }

    // Subir capa (siguiente)
    public void subirCapa() {
        if (!estaVacio()) {
            capaActiva = capaActiva.siguiente;
        }
    }

    // Bajar capa (anterior)
    public void bajarCapa() {
        if (!estaVacio()) {
            capaActiva = capaActiva.anterior;
        }
    }

    // Mostrar / ocultar capa activa
    public void toggleVisibilidad() {
        if (!estaVacio()) {
            capaActiva.visible = !capaActiva.visible;
            System.out.println("Visibilidad cambiada.");
        }
    }

    // Eliminar capa activa
    public void eliminarActiva() {
        if (estaVacio()) return;

        System.out.println("Capa eliminada: " + capaActiva.nombre);

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            capaActiva = null;
        } else {
            capaActiva.anterior.siguiente = capaActiva.siguiente;
            capaActiva.siguiente.anterior = capaActiva.anterior;

            if (capaActiva == cabeza) cabeza = capaActiva.siguiente;
            if (capaActiva == cola) cola = capaActiva.anterior;

            capaActiva = capaActiva.siguiente;
        }
    }

    // Mostrar todas las capas
    public void mostrarCapas() {
        if (estaVacio()) {
            System.out.println("No hay capas.");
            return;
        }

        System.out.println("\n=== Capas del Editor ===");
        Capa actual = cabeza;
        int i = 1;

        do {
            String activa = (actual == capaActiva) ? "[✓] " : "[ ] ";
            String vis = actual.visible ? "Visible" : "Oculta";

            System.out.println(i + ". " + activa + actual.nombre +
                    " | Tipo: " + actual.tipo +
                    " | " + vis);

            actual = actual.siguiente;
            i++;
        } while (actual != cabeza);
    }
}