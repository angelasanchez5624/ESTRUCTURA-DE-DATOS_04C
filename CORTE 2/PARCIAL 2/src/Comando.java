public class Comando {
    String texto;
    String hora;
    Comando siguiente;
    Comando anterior;

    public Comando(String texto, String hora) {
        this.texto = texto;
        this.hora = hora;
        this.siguiente = this;
        this.anterior = this;
    }
}