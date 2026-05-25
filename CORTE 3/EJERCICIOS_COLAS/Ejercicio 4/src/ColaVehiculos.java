public class ColaVehiculos {

    private Vehiculo salida;
    private Vehiculo entrada;
    private int tamanio;

    public ColaVehiculos() {
        salida = null;
        entrada = null;
        tamanio = 0;
    }

    public boolean isEmpty() {
        return salida == null;
    }

    public int size() {
        return tamanio;
    }

    public void enqueue(Vehiculo vehiculo) {

        Vehiculo nuevo = vehiculo;

        if (isEmpty()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }

        tamanio++;
    }

    public Vehiculo dequeue() {

        if (isEmpty()) {
            System.out.println("No hay vehículos en la cola.");
            return null;
        }

        Vehiculo dato = salida;
        salida = salida.siguiente;

        if (salida == null) {
            entrada = null;
        }

        tamanio--;

        return dato;
    }

    public void imprimir() {

        if (isEmpty()) {
            System.out.println("[ Cola vacía ]");
            return;
        }

        Vehiculo actual = salida;

        while (actual != null) {

            System.out.println(
                "Placa: " + actual.placa +
                " | Tipo: " + actual.tipoVehiculo +
                " | Tarifa: " + actual.tarifa +
                " | Exento: " + actual.esExento
            );

            actual = actual.siguiente;
        }
    }

    public void cerrarTurno() {

        double total = 0;

        while (!isEmpty()) {

            Vehiculo atendido = dequeue();

            System.out.println(
                "Vehículo atendido: " +
                atendido.placa +
                " | Tipo: " + atendido.tipoVehiculo
            );

            if (!atendido.esExento) {
                total += atendido.tarifa;
            }
        }

        System.out.println("\nTotal recaudado: $" + total);
    }
}
