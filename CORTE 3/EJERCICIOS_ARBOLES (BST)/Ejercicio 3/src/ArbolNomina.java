public class ArbolNomina {

    private Empleado raiz;

    public ArbolNomina() {
        raiz = null;
    }

    private Empleado insertar(Empleado nodo, long cedula, String nombre, String cargo, double salario) {
        if (nodo == null)
            return new Empleado(cedula, nombre, cargo, salario);

        if (cedula < nodo.cedula)
            nodo.izquierdo = insertar(nodo.izquierdo, cedula, nombre, cargo, salario);
        else if (cedula > nodo.cedula)
            nodo.derecho = insertar(nodo.derecho, cedula, nombre, cargo, salario);

        return nodo;
    }

    public void insertar(long cedula, String nombre, String cargo, double salario) {
        raiz = insertar(raiz, cedula, nombre, cargo, salario);
    }

    private Empleado buscarMinimo(Empleado nodo) {
        if (nodo == null) return null;
        if (nodo.izquierdo == null) return nodo;
        return buscarMinimo(nodo.izquierdo);
    }

    public Empleado buscarMinimo() {
        return buscarMinimo(raiz);
    }

    private Empleado buscarMaximo(Empleado nodo) {
        if (nodo == null) return null;
        if (nodo.derecho == null) return nodo;
        return buscarMaximo(nodo.derecho);
    }

    public Empleado buscarMaximo() {
        return buscarMaximo(raiz);
    }

    private int altura(Empleado nodo) {
        if (nodo == null) return -1;
        return 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }

    public int altura() {
        return altura(raiz);
    }

    private int contarHojas(Empleado nodo) {
        if (nodo == null) return 0;
        if (nodo.izquierdo == null && nodo.derecho == null) return 1;
        return contarHojas(nodo.izquierdo) + contarHojas(nodo.derecho);
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    public void reporteEficiencia() {
        System.out.println("Altura del arbol: " + altura());
        System.out.println("Numero de hojas: " + contarHojas());
    }
}
