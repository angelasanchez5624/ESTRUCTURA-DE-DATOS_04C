// Ejercicio 7 — Inventario compartido
// Un almacén tiene un arreglo con el stock de 5 productos. 
// El sistema de ventas y el sistema de reportes apuntan al mismo arreglo.

// Crea el arreglo stockAlmacen con valores iniciales.
// Asigna stockReportes = stockAlmacen.
// Simula una venta reduciendo el stock de un producto desde stockReportes.
// Muestra que stockAlmacen también cambió y explica en comentarios por qué.

public class Ejercicio_7 {
    public static void main(String[] args) {

        int[] stockAlmacen = {10, 20, 15, 8, 12};
        int[] stockReportes = stockAlmacen;

        // Simula una venta del producto en la posición 2
        stockReportes[2] -= 5;

        System.out.println("Stock almacen:");
        for (int s : stockAlmacen) {
            System.out.print(s + " ");
        }

        // Los arreglos son objetos.
        // Ambas variables apuntan al mismo espacio en memoria.
        // Cambiar uno afecta al otro.
    }
}