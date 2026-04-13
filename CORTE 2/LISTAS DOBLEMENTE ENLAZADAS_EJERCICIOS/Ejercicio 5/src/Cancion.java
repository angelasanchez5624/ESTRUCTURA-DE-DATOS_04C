// La Clase Cancion (Nodo): contiene titulo, artista y duracion
public class Cancion {
    String titulo;
    String artista;
    int duracion; // en segundos

    Cancion siguiente;
    Cancion anterior;

    public Cancion(String titulo, String artista, int duracion) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.siguiente = null;
        this.anterior = null;
    }
}