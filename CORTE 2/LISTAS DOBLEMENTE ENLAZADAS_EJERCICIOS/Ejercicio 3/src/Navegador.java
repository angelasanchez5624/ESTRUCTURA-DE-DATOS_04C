public class Navegador {
    Pestana cabeza;
    Pestana cola;

    public Navegador() {
        this.cabeza = null;
        this.cola = null;
    }

    // Agregar pestaña al final
    public void agregarPestana(Pestana p) {
        if (cabeza == null) {
            cabeza = p;
            cola = p;
        } else {
            cola.siguiente = p;
            p.anterior = cola;
            cola = p;
        }
    }

    // Cerrar pestaña por URL
    public Pestana cerrarPestanaActual(String url, Pestana actual) {
        Pestana temp = cabeza;

        // Buscar la pestaña
        while (temp != null) {
            if (temp.url.equals(url)) {

                // Caso 1: es la única pestaña
                if (cabeza == cola) {
                    cabeza = null;
                    cola = null;
                    return null;
                }

                // Caso 2: es la cabeza
                if (temp == cabeza) {
                    cabeza = temp.siguiente;
                    cabeza.anterior = null;
                    return cabeza;
                }

                // Caso 3: es la cola
                if (temp == cola) {
                    cola = temp.anterior;
                    cola.siguiente = null;
                    return cola;
                }

                // Caso 4: está en medio
                temp.anterior.siguiente = temp.siguiente;
                temp.siguiente.anterior = temp.anterior;

                // Retornar la anterior como nueva actual
                return temp.anterior;
            }
            temp = temp.siguiente;
        }

        System.out.println("No se encontró la pestaña.");
        return actual;
    }

    // Mostrar pestañas
    public void mostrarPestanas() {
        if (cabeza == null) {
            System.out.println("No hay pestañas abiertas.");
            return;
        }

        Pestana temp = cabeza;
        while (temp != null) {
            System.out.println("Título: " + temp.tituloPagina +
                               " | URL: " + temp.url +
                               " | Hora: " + temp.horaApertura);
            temp = temp.siguiente;
        }
    }
}