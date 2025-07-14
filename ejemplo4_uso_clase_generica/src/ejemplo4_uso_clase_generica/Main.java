package ejemplo4_uso_clase_generica;

import ejemplo3_arraylist.Generica;

public class Main {
	public static void main(String[] args) {
		Generica<String> gen = new Generica<String>("mskd");
		System.out.println(gen.atributoUno);
	}
}
