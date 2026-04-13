// La Clase Paciente (Nodo): contiene nombre, edad y nivelUrgencia
public class Paciente {
    String nombre;
    int edad;
    int nivelUrgencia; // 1 a 5

    Paciente siguiente;
    Paciente anterior;

    public Paciente(String nombre, int edad, int nivelUrgencia) {
        this.nombre = nombre;
        this.edad = edad;
        this.nivelUrgencia = nivelUrgencia;
        this.siguiente = null;
        this.anterior = null;
    }
}
