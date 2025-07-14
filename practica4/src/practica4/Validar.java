package practica4;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Validar {
	
	public static Integer contar(String texto,String expresion) {
		Pattern pattern = Pattern.compile(expresion);
		String[] palabras = texto.split(" ");
		int num = 0;
		
		for (String palabra : palabras) {
			if (pattern.matcher(palabra).matches()) {
				num++;
			}
		}
		
		return num;
	}
	
	
	public static ArrayList<String> listar(String texto, String expresion){
		Pattern pattern = Pattern.compile(expresion);
		String[] palabras = texto.split(" ");
		ArrayList<String> lista = new ArrayList<String>();
		
		for (String palabra : palabras) {
			if (pattern.matcher(palabra).matches()) {
				lista.add(palabra);
			}
		}
		
		return lista;
	}
	
}
