public class Producto {
    String codigo;
    String nombre;
    int cantidad;
    double precio;
    Producto siguiente;

    public Producto(String codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.siguiente = null;
    }
}
