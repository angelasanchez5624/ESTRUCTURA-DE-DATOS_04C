public class ListaProductos {

    Producto cabeza;

    public ListaProductos() {
        cabeza = null;
    }

    public void agregarProducto(Producto nuevo) {

        if (nuevo.diasParaVencer < 3) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            if (cabeza == null) {
                cabeza = nuevo;
            } else {
                Producto actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevo;
            }
        }
    }

    public void imprimirProductosPorVencer() {
        Producto actual = cabeza;

        System.out.println("\nProductos con menos de 5 días para vencer:");

        while (actual != null) {
            if (actual.diasParaVencer < 5) {
                System.out.println("[" + actual.nombre + " | " + actual.cantidad + " | " + actual.diasParaVencer + " días]");
            }
            actual = actual.siguiente;
        }
    }
}