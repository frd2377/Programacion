package ejemplo4_uso_clase_generica;

public class Main {
    public static void main(String[] args) {
        Inventario p1 = new Inventario(123, "producto1", "si", 23.5, 5);
        Inventario p2 = new Inventario(13, "producto2", "no", 22.5, 1);
        Inventario p3 = new Inventario(1233, "producto3", "si", 23.5, 5);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
    }
}
