public class Restaurante {
    Grupo cabeza;
    Grupo cola;

    public Restaurante() {
        cabeza = null;
        cola = null;
    }

    public void agregarGrupo(Grupo g) {
        if (cabeza == null) {
            cabeza = g;
            cola = g;
            g.siguiente = cabeza;
        } else {
            cola.siguiente = g;
            g.siguiente = cabeza;
            cola = g;
        }
    }

    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("No hay grupos en espera.");
            return;
        }

        Grupo actual = cabeza;
        do {
            System.out.println("Reserva: " + actual.nombreReserva +
                    ", Personas: " + actual.numeroPersonas +
                    ", VIP: " + actual.esVip +
                    ", Minutos esperando: " + actual.minutosEsperando);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void atenderSiguiente() {
        if (cabeza == null) {
            System.out.println("No hay grupos para atender.");
            return;
        }

        Grupo atendido = cabeza;

        System.out.println("\nAtendiendo grupo:");
        System.out.println("Reserva: " + atendido.nombreReserva +
                ", Personas: " + atendido.numeroPersonas +
                ", VIP: " + atendido.esVip);

        if (atendido.esVip) {
            // Se mueve al final
            cabeza = cabeza.siguiente;
            cola = atendido;
        } else {
            eliminarGrupo(atendido);
        }

        System.out.println("\nEstado actual de la lista:");
        mostrarLista();
    }

    private void eliminarGrupo(Grupo g) {
        if (cabeza == null || g == null) return;

        if (cabeza == g && cabeza == cola) {
            cabeza = null;
            cola = null;
        } else if (cabeza == g) {
            cabeza = cabeza.siguiente;
            cola.siguiente = cabeza;
        } else {
            Grupo actual = cabeza;

            while (actual.siguiente != g) {
                actual = actual.siguiente;
            }

            actual.siguiente = g.siguiente;

            if (g == cola) {
                cola = actual;
            }
        }
    }

    // Simulación de 6 turnos
    public void simularAtenciones() {
        for (int i = 0; i < 6; i++) {
            if (cabeza == null) {
                System.out.println("\nYa no hay grupos en espera.");
                break;
            }
            System.out.println("\n--- Turno " + (i + 1) + " ---");
            atenderSiguiente();
        }
    }
}
