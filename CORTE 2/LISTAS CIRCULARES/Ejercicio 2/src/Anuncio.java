public class Anuncio {
    String titulo;
    int duracionSegundos;
    int vecesRepetido;
    String categoria;

    Anuncio siguiente; // lista circular

    public Anuncio(String titulo, int duracionSegundos, String categoria) {
        this.titulo = titulo;
        this.duracionSegundos = duracionSegundos;
        this.categoria = categoria;
        this.vecesRepetido = 0;
    }
}
