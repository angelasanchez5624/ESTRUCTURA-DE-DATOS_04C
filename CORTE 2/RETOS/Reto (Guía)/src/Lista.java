public class Lista {
    Nodos cabeza;
    Nodos actual;

    public Lista(){
        cabeza = null;
        actual = null;
    }

    public void agregarLista(Nodos nuevoNodo){
        if(cabeza == null){
            cabeza = nuevoNodo;
        }else{
            Nodos actual = cabeza;
            while (actual.siguiente != null) 
            {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    public int contarNodos(){
        int contador = 0;
        Nodos actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        return contador;
    }
    
}
