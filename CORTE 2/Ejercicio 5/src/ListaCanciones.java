public class ListaCanciones {

    Cancion cabeza;
    Cancion actual;

    public void agregarFinal(Cancion nueva) {
        if (cabeza == null) {
            cabeza = nueva;
            actual = nueva;
        } else {
            Cancion aux = cabeza;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nueva;
        }
    }

    public void agregarDespuesActual(Cancion nueva) {
        if (actual == null) {
            cabeza = nueva;
            actual = nueva;
        } else {
            nueva.siguiente = actual.siguiente;
            actual.siguiente = nueva;
        }
    }

    public void mostrar() {
        Cancion aux = cabeza;

        while (aux != null) {
            System.out.println("[" + aux.titulo + " | " + aux.artista + " | " + aux.duracionSegundos + "s | " + aux.genero + "]");
            aux = aux.siguiente;
        }
    }

    public void tiempoTotal() {

        int total = 0;
        Cancion aux = cabeza;

        while (aux != null) {
            total += aux.duracionSegundos;
            aux = aux.siguiente;
        }

        int minutos = total / 60;
        int segundos = total % 60;

        System.out.println("Duración total: " + minutos + ":" + segundos);
    }
}