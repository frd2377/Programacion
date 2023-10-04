package ejemplo4_uso_clase_generica;
import ejemplo3_arraylist.Generica;

public class Inventario {
	Generica <String> producto;
    Generica <Integer> cod_und;
    Generica <Double> precio;
    public Inventario (int cod, String name_prod, String des, Double precioSiniVA, int unidad){
        cod_und = new Generica<Integer>(cod);
        producto = new Generica<String>(des);
        precio = new Generica<Double>(precioSiniVA);
    }

   @Override
   public String toString() {
       return "cod: "+cod_und.atributoUno+" nombre: "+cod_und.atributoUno+" precio: "+precio.atributoUno;
   }
}
