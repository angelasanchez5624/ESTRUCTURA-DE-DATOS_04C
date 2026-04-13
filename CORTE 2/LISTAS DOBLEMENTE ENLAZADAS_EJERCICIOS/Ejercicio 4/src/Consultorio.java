public class Consultorio {
    Paciente cabeza;
    Paciente cola;

    public Consultorio() {
        this.cabeza = null;
        this.cola = null;
    }

    // Agregar paciente
    public void agregarPaciente(Paciente p) {
        if (cabeza == null) {
            cabeza = p;
            cola = p;
        } else {
            // Si es emergencia (nivel 5) va después de la cabeza
            if (p.nivelUrgencia == 5) {
                p.siguiente = cabeza.siguiente;
                p.anterior = cabeza;

                if (cabeza.siguiente != null) {
                    cabeza.siguiente.anterior = p;
                } else {
                    cola = p;
                }

                cabeza.siguiente = p;
            } else {
                // Se agrega normal al final
                cola.siguiente = p;
                p.anterior = cola;
                cola = p;
            }
        }
    }

    // Mostrar pacientes
    public void mostrarPacientes() {
        if (cabeza == null) {
            System.out.println("No hay pacientes.");
            return;
        }

        Paciente temp = cabeza;
        while (temp != null) {
            System.out.println("Nombre: " + temp.nombre +
                               " | Edad: " + temp.edad +
                               " | Urgencia: " + temp.nivelUrgencia);
            temp = temp.siguiente;
        }
    }

    // Buscar paciente de mayor edad (desde cola hacia cabeza)
    public void mayorEdad() {
        if (cola == null) {
            System.out.println("No hay pacientes.");
            return;
        }

        Paciente temp = cola;
        Paciente mayor = cola;

        while (temp != null) {
            if (temp.edad > mayor.edad) {
                mayor = temp;
            }
            temp = temp.anterior;
        }

        System.out.println("\nPaciente de mayor edad:");
        System.out.println("Nombre: " + mayor.nombre +
                           " | Edad: " + mayor.edad +
                           " | Urgencia: " + mayor.nivelUrgencia);
    }
}