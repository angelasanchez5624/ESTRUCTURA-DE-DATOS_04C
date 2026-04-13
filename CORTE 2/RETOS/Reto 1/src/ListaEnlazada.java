public class ListaEnlazada {

    Nodo cabeza;

    public ListaEnlazada() {
        cabeza = null;
    }

    // Insertar al final
    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
    }

    // Contar nodos
    public int contarNodos() {
        int contador = 0;
        Nodo temp = cabeza;

        while (temp != null) {
            contador++;
            temp = temp.siguiente;
        }

        return contador;
    }
}