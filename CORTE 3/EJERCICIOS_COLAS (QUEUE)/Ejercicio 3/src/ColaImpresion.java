public class ColaImpresion {

    private Documento salida;
    private Documento entrada;
    private int tamanio;

    public ColaImpresion() {
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

    public void enqueue(Documento documento) {

        Documento nuevo = documento;

        if (isEmpty()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }

        tamanio++;
    }

    public Documento dequeue() {

        if (isEmpty()) {
            System.out.println("No hay documentos en cola.");
            return null;
        }

        Documento dato = salida;
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

        Documento actual = salida;

        while (actual != null) {

            System.out.println(
                "Archivo: " + actual.nombreArchivo +
                " | Usuario: " + actual.usuario +
                " | Páginas: " + actual.numeroPaginas +
                " | Color: " + actual.esColor
            );

            actual = actual.siguiente;
        }
    }

    public int calcularPaginasTotales() {

        int total = 0;

        Documento actual = salida;

        while (actual != null) {

            total += actual.numeroPaginas;

            actual = actual.siguiente;
        }

        return total;
    }
}
