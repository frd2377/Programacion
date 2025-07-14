package practica4;

import javax.swing.DefaultListModel;

import patron_generico.Generica;

public class Lenguaje {
	
	private Generica<String> datosLenguaje = new Generica<String>();
	
	public Lenguaje(String texto, String expresion) {
		datosLenguaje.setAtributo1(texto);
		datosLenguaje.setAtributo2(expresion);
	}
	
	public String getText() {
		return datosLenguaje.getAtributo1();
	}
	
	public String getExpresion() {
		return datosLenguaje.getAtributo2();
	}
	
	public Integer contarPalabras() {
		return Validar.contar(getText(), getExpresion());
	}
	
	public DefaultListModel listarPalabras(){
		return datosLenguaje.listarElementosList(Validar.listar(getText(), getExpresion()));
	}
	
}