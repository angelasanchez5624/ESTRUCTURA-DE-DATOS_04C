public class ArbolRepuestos {

    private Repuesto raiz;

    public void insertar(int codigo, String descripcion, String marca, int stock) {
        raiz = insertarRec(raiz, codigo, descripcion, marca, stock);
    }

    private Repuesto insertarRec(Repuesto nodo, int codigo, String descripcion, String marca, int stock) {
        if (nodo == null)
            return new Repuesto(codigo, descripcion, marca, stock);

        if (codigo < nodo.codigoRef)
            nodo.izquierdo = insertarRec(nodo.izquierdo, codigo, descripcion, marca, stock);
        else if (codigo > nodo.codigoRef)
            nodo.derecho = insertarRec(nodo.derecho, codigo, descripcion, marca, stock);

        return nodo;
    }

    public void backupPreOrden() {
        preOrdenRec(raiz);
    }

    private void preOrdenRec(Repuesto nodo) {
        if (nodo == null) return;
        System.out.println(nodo);
        preOrdenRec(nodo.izquierdo);
        preOrdenRec(nodo.derecho);
    }

    public void reporteRepuestosUnicos() {
        int hojas = contarHojas(raiz);
        System.out.println("Repuestos sin variantes: " + hojas);
    }

    private int contarHojas(Repuesto nodo) {
        if (nodo == null) return 0;
        if (nodo.izquierdo == null && nodo.derecho == null) return 1;
        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }
}
