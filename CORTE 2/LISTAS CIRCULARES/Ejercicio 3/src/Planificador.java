public class Planificador {
    Proceso cabeza;
    Proceso cola;

    public Planificador() {
        cabeza = null;
        cola = null;
    }

    public void agregarProceso(Proceso p) {
        if (cabeza == null) {
            cabeza = p;
            cola = p;
            p.siguiente = cabeza;
        } else {
            cola.siguiente = p;
            p.siguiente = cabeza;
            cola = p;
        }
    }

    public void mostrarProcesos() {
        if (cabeza == null) {
            System.out.println("No hay procesos.");
            return;
        }

        Proceso actual = cabeza;
        do {
            System.out.println("Nombre: " + actual.nombre +
                    ", PID: " + actual.pid +
                    ", Tiempo: " + actual.tiempoRestante +
                    ", Prioridad: " + actual.prioridad);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void ejecutar(int quantum) {
        if (cabeza == null) {
            System.out.println("No hay procesos para ejecutar.");
            return;
        }

        Proceso actual = cabeza;
        String ordenFinalizacion = "";

        while (cabeza != null) {
            System.out.println("\nEjecutando: " + actual.nombre +
                    " (PID: " + actual.pid + ")");

            actual.tiempoRestante -= quantum;

            if (actual.tiempoRestante > 0) {
                System.out.println("Tiempo restante: " + actual.tiempoRestante);
                actual = actual.siguiente;
            } else {
                System.out.println("Proceso terminado: " + actual.nombre);

                ordenFinalizacion += actual.nombre + " -> ";

                Proceso siguiente = actual.siguiente;
                eliminarProceso(actual);

                if (cabeza == null) break;

                actual = siguiente;
            }
        }

        System.out.println("\n===== RESULTADO FINAL =====");
        System.out.println("Orden de finalización:");
        System.out.println(ordenFinalizacion + "FIN");
    }

    private void eliminarProceso(Proceso p) {
        if (cabeza == null || p == null) return;

        if (cabeza == p && cabeza == cola) {
            cabeza = null;
            cola = null;
        } else if (cabeza == p) {
            cabeza = cabeza.siguiente;
            cola.siguiente = cabeza;
        } else {
            Proceso actual = cabeza;

            while (actual.siguiente != p) {
                actual = actual.siguiente;
            }

            actual.siguiente = p.siguiente;

            if (p == cola) {
                cola = actual;
            }
        }
    }
}