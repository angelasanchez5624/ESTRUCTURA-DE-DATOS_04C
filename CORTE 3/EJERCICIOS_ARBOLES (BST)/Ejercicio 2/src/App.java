// 2. Catálogo Digital (Biblioteca Universitaria)
// La biblioteca de la universidad organiza su colección de libros en un BST usando el ISBN como clave única. Cada vez que ingresa un libro nuevo, se inserta automáticamente en el árbol. El sistema debe poder confirmar si un ISBN ya existe antes de registrar un nuevo ejemplar y listar toda la colección ordenada por ISBN.

// La Clase Libro (Nodo): Debe contener isbn (long, clave del BST), titulo (String), autor (String) y anioPublicacion (int).
// El Problema: Al final del semestre, el bibliotecario necesita imprimir el inventario completo ordenado de menor a mayor por ISBN para enviarlo a la sede central. También debe verificar si un ISBN específico ya existe en el catálogo antes de registrar una donación.
// Reto: Implementa el método imprimirCatalogo() usando el recorrido InOrden para listar todos los libros en orden ascendente de ISBN (imprime isbn - titulo - autor). Además, implementa existeISBN(long isbn) que retorne true si el libro ya está registrado y false en caso contrario.

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        ArbolBiblioteca biblioteca = new ArbolBiblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Datos de prueba
        biblioteca.insertar(9780134685991L, "Effective Java", "Joshua Bloch", 2018);
        biblioteca.insertar(9780132350884L, "Clean Code", "Robert C. Martin", 2008);
        biblioteca.insertar(9780201633610L, "Design Patterns", "GoF", 1994);
        biblioteca.insertar(9780134494166L, "Clean Architecture", "Robert C. Martin", 2017);

        do {
            System.out.println("\n--- CATALOGO DIGITAL (BST) ---");
            System.out.println("1. Insertar libro");
            System.out.println("2. Imprimir catalogo ordenado por ISBN");
            System.out.println("3. Verificar ISBN");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ISBN: ");
                    long isbn = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Titulo: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Anio de publicacion: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();
                    biblioteca.insertar(isbn, titulo, autor, anio);
                    break;

                case 2:
                    biblioteca.imprimirCatalogo();
                    break;

                case 3:
                    System.out.print("ISBN a buscar: ");
                    long buscar = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println(biblioteca.existeISBN(buscar));
                    break;

                case 4:
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }
}