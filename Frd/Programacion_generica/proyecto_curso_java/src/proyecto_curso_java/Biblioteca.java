package proyecto_curso_java;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    
    public static void main(String[] args) {
        Libro libro1 = new Libro(123654, "Cervantes M.", "Don Quijote de la Mancha",1615);
        Libro libro2 = new Libro(652874, "Rowling J.K.", "Harry Potter y el cáliz de fuego", 2000);
        Libro libro3 = new Libro(658749, "Carroll L.", "Las aventuras de alicia en el país de las maravillas",1915);
        libro3.disponible = "PRESTADO a: Juan Perez";
        ArrayList<Libro> inventarioLib = new ArrayList<>();
        inventarioLib.add(libro1);
        inventarioLib.add(libro2);
        inventarioLib.add(libro3);

        String isbn;
        String autor;
        String titulo;
        String año;

        Scanner input = new Scanner(System.in);

        Boolean salir = true;
        while (salir) {
            menu();
            String opcion = input.next();
            switch (opcion) {
            case "1":
                System.out.println("Ingresar libro");
                do {
                    System.out.print("Ingrese el ISBN: ");
                    isbn = input.next();
                } while (toIntOrNull(isbn) == null);

                System.out.print("Ingrese el Autor: ");
                autor = input.next();

                System.out.print("Ingrese el Titulo: ");
                titulo = input.next();

                do {
                    System.out.print("Ingrese el Año: ");
                    año = input.next();
                } while (toIntOrNull(año) == null);

                inventarioLib.add(new Libro(Integer.parseInt(isbn), autor, titulo, Integer.parseInt(año)));
                System.out.println("Se ha agredado el libro "+titulo);

                break;
            case "2":
                for (Libro lib : inventarioLib) {
                    System.out.println(lib.toString());
                }
                break;
            case "3":
                System.out.println("Prestamo");
                do {                
                    System.out.println("ISBN: ");
                    isbn = input.next();
                } while (toIntOrNull(isbn) == null);

                System.out.println("Ingrese su nombre: ");
                String nombPrest = input.next();

                for (Libro lib : inventarioLib) {
                    if (lib.isbn == Integer.parseInt(isbn)) {
                        lib.setDisponible("PRESTADO a: "+nombPrest);
                    }
                }

                System.out.println("Libro prestado");

                break;
            case "4":
                System.out.println("Devolucion");
                do {
                    System.out.println("ISBN: ");
                    isbn = input.next();
                } while (toIntOrNull(isbn) == null);

                for (Libro lib : inventarioLib) {
                    if (lib.isbn == Integer.parseInt(isbn)) {
                        lib.setDisponible("DISPONIBLE");
                    }
                }

                System.out.println("Libro prestado");
                break;
            case "0":
                salir = false;
                input.close();
                break;
            default:
                System.out.println("default");
                break;
            }
        }

    }

    static void menu(){
        System.out.print("== BIBLIOTECA MUNICIPAL ==\n1. Ingresar un libro\n2. Listar los libros\n3. Prestar un libro\n4. Devolver un libro\n0. Salir\nIngrese su opción: ");
    }

    public static Integer toIntOrNull(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
}
