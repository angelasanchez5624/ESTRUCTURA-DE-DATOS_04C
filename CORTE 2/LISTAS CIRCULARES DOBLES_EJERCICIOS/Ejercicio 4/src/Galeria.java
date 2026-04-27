public class Galeria {
    Foto cabeza;
    Foto cola;
    Foto actual;

    public Galeria() {
        cabeza = null;
        cola = null;
        actual = null;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public void agregarFoto(String titulo, String fecha) {
        Foto nueva = new Foto(titulo, fecha);

        if (estaVacia()) {
            nueva.siguiente = nueva;
            nueva.anterior = nueva;
            cabeza = nueva;
            cola = nueva;
            actual = nueva;
        } else {
            cola.siguiente = nueva;
            nueva.anterior = cola;
            nueva.siguiente = cabeza;
            cabeza.anterior = nueva;
            cola = nueva;
        }
    }

    // Ir a la siguiente foto
    public void siguiente() {
        if (!estaVacia()) {
            actual = actual.siguiente;
        }
    }

    // Ir a la foto anterior
    public void anterior() {
        if (!estaVacia()) {
            actual = actual.anterior;
        }
    }

    // Marcar / desmarcar como favorita
    public void toggleFavorita() {
        if (!estaVacia()) {
            actual.esFavorita = !actual.esFavorita;
            System.out.println("Estado de favorita cambiado.");
        }
    }

    // Eliminar foto actual
    public void eliminarActual() {
        if (estaVacia()) return;

        System.out.println("Foto eliminada: " + actual.titulo);

        if (cabeza == cola) {
            cabeza = null;
            cola = null;
            actual = null;
        } else {
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;

            if (actual == cabeza) cabeza = actual.siguiente;
            if (actual == cola) cola = actual.anterior;

            actual = actual.siguiente;
        }
    }

    // Mostrar galería completa
    public void mostrarGaleria() {
        if (estaVacia()) {
            System.out.println("La galería está vacía.");
            return;
        }

        System.out.println("\n=== Galería de Fotos ===");
        Foto aux = cabeza;
        int i = 1;

        do {
            String actualMarca = (aux == actual) ? "[▶] " : "    ";
            String favMarca = aux.esFavorita ? "[★] " : "[ ] ";

            System.out.println(i + ". " + actualMarca + favMarca +
                    aux.titulo + " (" + aux.fecha + ")");

            aux = aux.siguiente;
            i++;
        } while (aux != cabeza);
    }
}
