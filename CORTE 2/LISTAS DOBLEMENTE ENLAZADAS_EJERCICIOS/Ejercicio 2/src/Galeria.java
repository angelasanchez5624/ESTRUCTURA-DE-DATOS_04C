public class Galeria {
    Fotografia cabeza;
    Fotografia cola;

    public Galeria() {
        this.cabeza = null;
        this.cola = null;
    }

    // Agregar foto al final
    public void agregarFoto(Fotografia foto) {
        if (cabeza == null) {
            cabeza = foto;
            cola = foto;
        } else {
            cola.siguiente = foto;
            foto.anterior = cola;
            cola = foto;
        }
    }

    // Siguiente foto
    public Fotografia siguiente(Fotografia actual) {
        if (actual.siguiente == null) {
            System.out.println("No hay más fotos adelante.");
            return actual;
        }
        return actual.siguiente;
    }

    // Foto anterior
    public Fotografia anterior(Fotografia actual) {
        if (actual.anterior == null) {
            System.out.println("No hay más fotos atrás.");
            return actual;
        }
        return actual.anterior;
    }

    // Recorrer toda la galería
    public void reproducirGaleria() {
        if (cabeza == null) {
            System.out.println("La galería está vacía.");
            return;
        }

        System.out.println("\n--- Recorrido hacia adelante ---");
        Fotografia temp = cabeza;
        while (temp != null) {
            System.out.println("Foto: " + temp.nombreArchivo +
                               " | Tamaño: " + temp.tamanoMB + "MB" +
                               " | Resolución: " + temp.resolucion);
            temp = temp.siguiente;
        }

        System.out.println("\n--- Recorrido hacia atrás ---");
        temp = cola;
        while (temp != null) {
            System.out.println("Foto: " + temp.nombreArchivo +
                               " | Tamaño: " + temp.tamanoMB + "MB" +
                               " | Resolución: " + temp.resolucion);
            temp = temp.anterior;
        }
    }
}