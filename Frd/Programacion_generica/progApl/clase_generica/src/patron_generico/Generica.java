package patron_generico;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Generica <T>{
	private T atributo1;
	private T atributo2;
	private ArrayList<T> elementos = new ArrayList<T>();
	
	public Generica() {
		
	}
	
	public Generica(T atributo1) {
		this.atributo1 = atributo1;
	}
	
	public Generica(T atributo1, T atributo2) {
		this.atributo1 = atributo1;
		this.atributo2 = atributo2;
	}

	public T getAtributo1() {
		return atributo1;
	}

	public void setAtributo1(T atributo1) {
		this.atributo1 = atributo1;
	}

	public T getAtributo2() {
		return atributo2;
	}

	public void setAtributo2(T atributo2) {
		this.atributo2 = atributo2;
	}
	
	//--// v0.1
	public void listarElementos(ArrayList<T> elementos) {
		for (T elemento : elementos) {
			System.out.println(elemento);
		}
	}
	
	public ArrayList<T> getElementos(){
		return elementos;
	}
	
	public Boolean addElemntos(T elemento) {
		elementos.add(elemento);
		return true;
	}
	//--//
	
	
	/*
	 * 	metodo para construir un modelo para un Jlist
	 *  @param elementos
	 *  @return DefaultListModel
	 * */
	public DefaultListModel listarElementosList (ArrayList<T> elementos) {
		DefaultListModel modelo = new DefaultListModel();
		for (T elemento : elementos) {
			modelo.addElement(elemento.toString());
		}
		return modelo;
	}
	
}
