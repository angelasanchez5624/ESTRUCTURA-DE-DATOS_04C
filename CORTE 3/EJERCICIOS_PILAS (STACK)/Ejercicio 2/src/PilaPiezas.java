public class PilaPiezas {

    private Pieza tope;
    private int tamanio;

    public PilaPiezas() {

        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {

        return tope == null;
    }

    public int getTamanio() {

        return tamanio;
    }

    public void push(Pieza nueva) {

        nueva.siguiente = tope;
        tope = nueva;
        tamanio++;
    }

    public Pieza pop() {

        if (estaVacia()) {
            return null;
        }

        Pieza aux = tope;
        tope = tope.siguiente;
        tamanio--;

        aux.siguiente = null;

        return aux;
    }

    public Pieza peek() {

        return tope;
    }

    public void imprimir() {

        if (estaVacia()) {

            System.out.println("Pila vacía.");
            return;
        }

        Pieza actual = tope;

        System.out.println("=== LÍNEA DE ENSAMBLAJE ===");

        while (actual != null) {

            if (actual == tope) {
                System.out.print("TOPE -> ");
            } else {
                System.out.print("         ");
            }

            System.out.println(actual);

            actual = actual.siguiente;
        }

        System.out.println("===========================");
    }

    public void limpiarHastaDefecto() {

        if (estaVacia()) {

            System.out.println("La pila está vacía.");
            return;
        }

        while (tope != null && !tope.esDefectuosa) {

            Pieza retirada = pop();

            System.out.println("Pieza buena descartada: " + retirada.nombrePieza);
        }

        if (tope != null && tope.esDefectuosa) {

            System.out.println("Se encontró pieza defectuosa: " + tope.nombrePieza);

        } else {

            System.out.println("No se encontró ninguna pieza defectuosa.");
        }
    }
}