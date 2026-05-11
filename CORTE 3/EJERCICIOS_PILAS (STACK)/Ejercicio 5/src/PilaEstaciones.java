public class PilaEstaciones {

    private Estacion tope;
    private int tamanio;

    public PilaEstaciones() {

        this.tope = null;
        this.tamanio = 0;
    }

    public boolean estaVacia() {

        return tope == null;
    }

    public int getTamanio() {

        return tamanio;
    }

    public void push(Estacion nueva) {

        nueva.siguiente = tope;
        tope = nueva;
        tamanio++;
    }

    public Estacion pop() {

        if (estaVacia()) {
            return null;
        }

        Estacion aux = tope;
        tope = tope.siguiente;
        tamanio--;

        aux.siguiente = null;

        return aux;
    }

    public Estacion peek() {

        return tope;
    }

    public void imprimir() {

        if (estaVacia()) {

            System.out.println("Pila vacía.");
            return;
        }

        Estacion actual = tope;

        System.out.println("=== ESTACIONES DE SEGURIDAD ===");

        while (actual != null) {

            if (actual == tope) {
                System.out.print("TOPE -> ");
            } else {
                System.out.print("         ");
            }

            System.out.println(actual);

            actual = actual.siguiente;
        }

        System.out.println("================================");
    }

    public void retrocederASuperficie() {

        if (estaVacia()) {

            System.out.println("No hay estaciones registradas.");
            return;
        }

        System.out.println("Iniciando regreso a la superficie...");

        while (!estaVacia()) {

            Estacion actual = pop();

            System.out.println("Pasando por estación: " + actual.nombrePunto);

            if (actual.nivelOxigeno < 18) {

                System.out.println("ALERTA: Uso de Tanque de Emergencia Requerido");
            }
        }

        System.out.println("El equipo ha salido de la cueva.");
    }
}
