public class ArbolJugadores {

    private Jugador raiz;

    public void insertar(int elo, String usuario, String pais, int partidas) {
        raiz = insertarRec(raiz, elo, usuario, pais, partidas);
    }

    private Jugador insertarRec(Jugador nodo, int elo, String usuario, String pais, int partidas) {
        if (nodo == null)
            return new Jugador(elo, usuario, pais, partidas);

        if (elo < nodo.elo)
            nodo.izquierdo = insertarRec(nodo.izquierdo, elo, usuario, pais, partidas);
        else if (elo > nodo.elo)
            nodo.derecho = insertarRec(nodo.derecho, elo, usuario, pais, partidas);

        return nodo;
    }

    public Jugador buscar(int elo) {
        return buscarRec(raiz, elo);
    }

    private Jugador buscarRec(Jugador nodo, int elo) {
        if (nodo == null) return null;
        if (elo == nodo.elo) return nodo;
        return elo < nodo.elo
                ? buscarRec(nodo.izquierdo, elo)
                : buscarRec(nodo.derecho, elo);
    }

    public void listarEnRango(int eloMin, int eloMax) {
        listarEnRangoRec(raiz, eloMin, eloMax);
    }

    private void listarEnRangoRec(Jugador nodo, int eloMin, int eloMax) {
        if (nodo == null) return;

        if (nodo.elo > eloMin)
            listarEnRangoRec(nodo.izquierdo, eloMin, eloMax);

        if (nodo.elo >= eloMin && nodo.elo <= eloMax)
            System.out.println(nodo);

        if (nodo.elo < eloMax)
            listarEnRangoRec(nodo.derecho, eloMin, eloMax);
    }

    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(Jugador nodo) {
        if (nodo == null) return;
        inOrdenRec(nodo.izquierdo);
        System.out.println(nodo);
        inOrdenRec(nodo.derecho);
    }
}
