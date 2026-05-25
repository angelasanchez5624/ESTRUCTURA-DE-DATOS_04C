public class ColaPacientes {

    private Paciente salida;
    private Paciente entrada;
    private int tamanio;

    public ColaPacientes() {
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

    public void enqueue(Paciente paciente) {

        Paciente nuevo = paciente;

        if (isEmpty()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }

        tamanio++;
    }

    public Paciente dequeue() {

        if (isEmpty()) {
            System.out.println("No hay pacientes en espera.");
            return null;
        }

        Paciente dato = salida;
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

        System.out.println("Pacientes en espera:");

        Paciente actual = salida;

        while (actual != null) {

            System.out.println(
                "CC: " + actual.cedula +
                " | Nombre: " + actual.nombreCompleto +
                " | Edad: " + actual.edad +
                " | Síntoma: " + actual.sintomaPrincipal
            );

            actual = actual.siguiente;
        }
    }

    public void atenderTodos() {

        int contador = 0;

        while (!isEmpty()) {

            Paciente atendido = dequeue();

            System.out.println("\nPaciente atendido:");
            System.out.println(
                "CC: " + atendido.cedula +
                " | Nombre: " + atendido.nombreCompleto +
                " | Edad: " + atendido.edad +
                " | Síntoma: " + atendido.sintomaPrincipal
            );

            contador++;
        }

        System.out.println("\nTotal de pacientes atendidos: " + contador);
    }
}