public class ColaPedidos {

    private Pedido salida;
    private Pedido entrada;
    private int tamanio;

    public ColaPedidos() {
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

    public void enqueue(Pedido pedido) {

        Pedido nuevo = pedido;

        if (isEmpty()) {
            salida = nuevo;
            entrada = nuevo;
        } else {
            entrada.siguiente = nuevo;
            entrada = nuevo;
        }

        tamanio++;
    }

    public Pedido dequeue() {

        if (isEmpty()) {
            System.out.println("No hay pedidos en cola.");
            return null;
        }

        Pedido dato = salida;
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

        Pedido actual = salida;

        while (actual != null) {

            System.out.println(
                "Pedido: " + actual.numeroPedido +
                " | Cliente: " + actual.cliente +
                " | Total: " + actual.totalPagar +
                " | Cancelado: " + actual.cancelado
            );

            actual = actual.siguiente;
        }
    }

    public void procesarPedidos() {

        int despachados = 0;
        int cancelados = 0;

        while (!isEmpty()) {

            Pedido pedido = dequeue();

            if (pedido.cancelado) {

                System.out.println(
                    "Pedido cancelado: " + pedido.numeroPedido
                );

                cancelados++;

            } else {

                System.out.println(
                    "Pedido despachado: " +
                    pedido.numeroPedido +
                    " | Cliente: " + pedido.cliente +
                    " | Total: " + pedido.totalPagar
                );

                despachados++;
            }
        }

        System.out.println("\nTotal despachados: " + despachados);
        System.out.println("Total cancelados: " + cancelados);
    }
}