import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Torneo {
    Equipo cabeza;
    Equipo cola;
    int size = 0;

    public void agregarEquipo(Equipo e) {
        if (cabeza == null) {
            cabeza = e;
            cola = e;
            e.siguiente = cabeza;
        } else {
            cola.siguiente = e;
            e.siguiente = cabeza;
            cola = e;
        }
        size++;
    }

    public void mostrarEquipos() {
        if (cabeza == null) {
            System.out.println("No hay equipos.");
            return;
        }

        Equipo actual = cabeza;
        do {
            System.out.println(actual.nombre + " - " + actual.ciudad);
            actual = actual.siguiente;
        } while (actual != cabeza);
    }

    public void generarFixture() {
        if (size != 6) {
            System.out.println("Deben haber exactamente 6 equipos.");
            return;
        }

        // Pasar a lista para manejar rotación más fácil
        ArrayList<Equipo> lista = new ArrayList<>();
        Equipo actual = cabeza;

        do {
            lista.add(actual);
            actual = actual.siguiente;
        } while (actual != cabeza);

        int jornadas = lista.size() - 1;

        for (int j = 0; j < jornadas; j++) {
            System.out.println("\n===== Jornada " + (j + 1) + " =====");

            for (int i = 0; i < lista.size() / 2; i++) {
                Equipo local = lista.get(i);
                Equipo visitante = lista.get(lista.size() - 1 - i);

                System.out.println(local.nombre + " vs " + visitante.nombre);

                // Simulación simple de resultado
                int golesLocal = (int)(Math.random() * 5);
                int golesVisitante = (int)(Math.random() * 5);

                local.golesFavor += golesLocal;
                visitante.golesFavor += golesVisitante;

                if (golesLocal > golesVisitante) {
                    local.puntos += 3;
                } else if (golesVisitante > golesLocal) {
                    visitante.puntos += 3;
                } else {
                    local.puntos += 1;
                    visitante.puntos += 1;
                }
            }

            // Rotación (excepto el primero)
            Equipo fijo = lista.get(0);
            Equipo ultimo = lista.remove(lista.size() - 1);
            lista.add(1, ultimo);
        }

        mostrarTabla(lista);
    }

    private void mostrarTabla(ArrayList<Equipo> lista) {
        Collections.sort(lista, new Comparator<Equipo>() {
            public int compare(Equipo a, Equipo b) {
                return b.puntos - a.puntos;
            }
        });

        System.out.println("\n===== TABLA DE POSICIONES =====");
        for (Equipo e : lista) {
            System.out.println(e.nombre +
                    " | Puntos: " + e.puntos +
                    " | Goles: " + e.golesFavor);
        }
    }
}
