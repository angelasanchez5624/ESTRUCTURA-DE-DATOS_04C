public class Almacen {
    Producto cabeza;

    public boolean existeCodigo(String codigo) {
        Producto actual = cabeza;
        while (actual != null) {
            if (actual.codigo.equals(codigo)) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public void registrar(String codigo, String nombre, int cantidad, double precio) {
        if (cantidad < 0) {
            System.out.println("No se permiten cantidades negativas.");
            return;
        }

        if (existeCodigo(codigo)) {
            System.out.println("Codigo duplicado.");
            return;
        }

        Producto nuevo = new Producto(codigo, nombre, cantidad, precio);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Producto actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }

        System.out.println("Producto registrado.");
    }

    public void editarStock(String codigo, int cantidadCambio) {
        Producto actual = cabeza;

        while (actual != null) {
            if (actual.codigo.equals(codigo)) {
                int nuevaCantidad = actual.cantidad + cantidadCambio;

                if (nuevaCantidad < 0) {
                    System.out.println("No se puede dejar cantidad negativa.");
                    return;
                }

                actual.cantidad = nuevaCantidad;
                System.out.println("Stock actualizado.");
                return;
            }
            actual = actual.siguiente;
        }

        System.out.println("Producto no encontrado.");
    }

    public void mostrarInventario() {
        Producto actual = cabeza;
        double total = 0;

        if (actual == null) {
            System.out.println("Inventario vacío.");
            return;
        }

        while (actual != null) {
            double valor = actual.cantidad * actual.precio;
            total += valor;

            System.out.println("Codigo: " + actual.codigo +
                               " | Nombre: " + actual.nombre +
                               " | Cantidad: " + actual.cantidad +
                               " | Precio: " + actual.precio +
                               " | Valor: " + valor);

            actual = actual.siguiente;
        }

        System.out.println("Valor total del inventario: " + total);
    }

    public void eliminar(String codigo) {
        if (cabeza == null) {
            System.out.println("Inventario vacío.");
            return;
        }

        if (cabeza.codigo.equals(codigo)) {
            System.out.println("Producto '" + cabeza.nombre + "' eliminado.");
            cabeza = cabeza.siguiente;
            return;
        }

        Producto actual = cabeza;
        Producto anterior = null;

        while (actual != null && !actual.codigo.equals(codigo)) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("Producto no encontrado.");
        } else {
            anterior.siguiente = actual.siguiente;
            System.out.println("Producto '" + actual.nombre + "' eliminado.");
        }
    }
}
