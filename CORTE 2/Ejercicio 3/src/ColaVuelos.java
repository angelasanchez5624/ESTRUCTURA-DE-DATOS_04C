public class ColaVuelos {

    Vuelo cabeza;

    public void agregarVuelo(Vuelo nuevo) {
        if (nuevo.combustibleRestante < 10) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                Vuelo actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
            }
        }
    }

    public void reportarEmergencia(String numero) {

        if (cabeza == null) return;

        if (cabeza.numeroVuelo.equals(numero)) return;

        Vuelo actual = cabeza;

        while (actual.siguiente != null) {
            if (actual.siguiente.numeroVuelo.equals(numero)) {
                Vuelo emergencia = actual.siguiente;
                actual.siguiente = emergencia.siguiente;

                emergencia.siguiente = cabeza;
                cabeza = emergencia;
                break;
            }
            actual = actual.siguiente;
        }
    }

    public void mostrar() {
        Vuelo actual = cabeza;

        while (actual != null) {
            System.out.println("[" + actual.numeroVuelo + " | " + actual.aerolinea + " | Comb: " + actual.combustibleRestante + "]");
            actual = actual.siguiente;
        }
    }
}
