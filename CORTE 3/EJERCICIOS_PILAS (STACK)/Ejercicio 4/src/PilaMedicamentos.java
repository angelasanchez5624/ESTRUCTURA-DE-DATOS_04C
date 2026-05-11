public class PilaMedicamentos {

    private Medicamento tope;
    private int tamanio;

    public PilaMedicamentos() {

        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {

        return tope == null;
    }

    public int getTamanio() {

        return tamanio;
    }

    public void push(Medicamento nuevo) {

        nuevo.siguiente = tope;
        tope = nuevo;
        tamanio++;
    }

    public Medicamento pop() {

        if (estaVacia()) {
            return null;
        }

        Medicamento aux = tope;
        tope = tope.siguiente;
        tamanio--;

        aux.siguiente = null;

        return aux;
    }

    public Medicamento peek() {

        return tope;
    }

    public void imprimir() {

        if (estaVacia()) {

            System.out.println("Pila vacía.");
            return;
        }

        Medicamento actual = tope;

        System.out.println("=== MEDICAMENTOS EN EL DISPENSADOR ===");

        while (actual != null) {

            if (actual == tope) {
                System.out.print("TOPE -> ");
            } else {
                System.out.print("         ");
            }

            System.out.println(actual);

            actual = actual.siguiente;
        }

        System.out.println("======================================");
    }

    public void validarDespacho() {

        if (estaVacia()) {

            System.out.println("No hay medicamentos.");
            return;
        }

        while (tope != null && tope.diasParaVencer < 10) {

            Medicamento vencido = pop();

            System.out.println("Medicamento retirado por vencimiento próximo: " + vencido.nombre);
        }

        if (tope != null) {

            System.out.println("Medicamento seguro para despacho: " + tope.nombre);

        } else {

            System.out.println("No quedan medicamentos seguros.");
        }
    }
}
