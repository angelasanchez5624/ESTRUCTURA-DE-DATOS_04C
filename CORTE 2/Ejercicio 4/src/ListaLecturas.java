public class ListaLecturas {

    Lectura cabeza;

    public void agregarInicio(Lectura nueva) {
        nueva.siguiente = cabeza;
        cabeza = nueva;
    }

    public void mostrar() {
        Lectura actual = cabeza;

        while (actual != null) {
            System.out.println("[" + actual.idSensor + " | " + actual.temperatura + "°C | " + actual.presion + " | " + actual.hora + "]");
            actual = actual.siguiente;
        }
    }

    public void temperaturaMaxima() {

        if (cabeza == null) return;

        Lectura actual = cabeza;
        Lectura max = cabeza;

        while (actual != null) {
            if (actual.temperatura > max.temperatura) {
                max = actual;
            }
            actual = actual.siguiente;
        }

        System.out.println("Mayor temperatura:");
        System.out.println("[" + max.idSensor + " | " + max.temperatura + "°C | " + max.hora + "]");
    }
}