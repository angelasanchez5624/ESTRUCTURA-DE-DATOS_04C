public class ArbolBiblioteca {

    private Libro raiz;

    public ArbolBiblioteca() {
        raiz = null;
    }

    private Libro insertar(Libro nodo, long isbn, String titulo, String autor, int anio) {
        if (nodo == null)
            return new Libro(isbn, titulo, autor, anio);

        if (isbn < nodo.isbn)
            nodo.izquierdo = insertar(nodo.izquierdo, isbn, titulo, autor, anio);
        else if (isbn > nodo.isbn)
            nodo.derecho = insertar(nodo.derecho, isbn, titulo, autor, anio);

        return nodo;
    }

    public void insertar(long isbn, String titulo, String autor, int anio) {
        raiz = insertar(raiz, isbn, titulo, autor, anio);
    }

    private boolean existeISBN(Libro nodo, long isbn) {
        if (nodo == null) return false;
        if (isbn == nodo.isbn) return true;

        if (isbn < nodo.isbn)
            return existeISBN(nodo.izquierdo, isbn);
        else
            return existeISBN(nodo.derecho, isbn);
    }

    public boolean existeISBN(long isbn) {
        return existeISBN(raiz, isbn);
    }

    private void imprimirCatalogo(Libro nodo) {
        if (nodo != null) {
            imprimirCatalogo(nodo.izquierdo);
            System.out.println(nodo);
            imprimirCatalogo(nodo.derecho);
        }
    }

    public void imprimirCatalogo() {
        imprimirCatalogo(raiz);
    }
}