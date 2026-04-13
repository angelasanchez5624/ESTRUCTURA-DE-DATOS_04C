public class Reproductor {
    Cancion cabeza;
    Cancion cola;

    public Reproductor() {
        this.cabeza = null;
        this.cola = null;
    }

    // Agregar canción al final
    public void agregarCancion(Cancion c) {
        if (cabeza == null) {
            cabeza = c;
            cola = c;
        } else {
            cola.siguiente = c;
            c.anterior = cola;
            cola = c;
        }
    }

    // Saltar atrás
    public Cancion saltarAtras(Cancion actual) {
        if (actual.anterior == null) {
            System.out.println("No hay canción anterior.");
            return actual;
        }
        return actual.anterior;
    }

    // Saltar adelante
    public Cancion saltarAdelante(Cancion actual) {
        if (actual.siguiente == null) {
            System.out.println("No hay siguiente canción.");
            return actual;
        }
        return actual.siguiente;
    }

    // Mostrar lista de canciones
    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("No hay canciones.");
            return;
        }

        Cancion temp = cabeza;
        while (temp != null) {
            System.out.println("Título: " + temp.titulo +
                               " | Artista: " + temp.artista +
                               " | Duración: " + temp.duracion + " seg");
            temp = temp.siguiente;
        }
    }
}
