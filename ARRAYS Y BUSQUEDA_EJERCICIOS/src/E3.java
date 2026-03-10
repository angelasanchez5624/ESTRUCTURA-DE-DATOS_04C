// 3. Sensor de Temperatura (Control de Calidad)
// Una máquina industrial registra la temperatura cada 10 minutos y guarda los datos en un arreglo.

// El Problema: Al final del día, el supervisor quiere saber cuál fue la temperatura más alta registrada para asegurarse de que la máquina no se recalentó.
// Algoritmo a usar: Búsqueda Lineal de Máximo. Debes recorrer todo el arreglo comparando cada valor para encontrar el mayor de todos.

public class E3 {
    public static void main(String[] args) {
        double[] temperaturas = {60.5, 72.3, 68.9, 80.1, 75.0};

        double max = temperaturas[0];

        for (int i = 1; i < temperaturas.length; i++) {
            if (temperaturas[i] > max) {
                max = temperaturas[i];
            }
        }

        System.out.println("La temperatura más alta fue: " + max);
    }
}