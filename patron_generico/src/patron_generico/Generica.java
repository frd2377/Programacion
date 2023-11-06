package patron_generico;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

public class Generica <T,S>{
	private T atributo1;
	private T atributo2;
	private S atributo3;
	private S atributo4;
	
	private List<T> elementos = new ArrayList<T>();
	public T[] atributoArray1;
	private S[] atributoArray2;
	
	public Generica() {
		
	}
	
	public Generica(T atributo1) {
		this.atributo1 = atributo1;
	}
	
	public Generica(T atributo1, T atributo2) {
		this.atributo1 = atributo1;
		this.atributo2 = atributo2;
	}
	
	public Generica(T atributo1, T atributo2,S atributo3) {
		this.atributo1 = atributo1;
		this.atributo2 = atributo2;
		this.atributo3 = atributo3;
	}
	
	public Generica(T atributo1, T atributo2,S atributo3,S atributo4) {
		this.atributo1 = atributo1;
		this.atributo2 = atributo2;
		this.atributo3 = atributo3;
		this.atributo4 = atributo4;
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
	
	// v0.1 //
	public void listarElementos(List<T> elementos) {
		for (T elemento : elementos) {
			System.out.println(elemento);
		}
	}
	
	public List<T> getElementos(){
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
	
	//V0.3//
	
	public T[] getElementsToArray(T...elementos) {
		return elementos;
	}
	
	public String[] getElementToString(T...elementos) {
		String[] datos = new String[elementos.length];
		for (int i = 0; i < elementos.length; i++) {
			datos[i] = elementos[i].toString();
		}
		return datos;
	}
	
	public void imprimirElementos(T... elementos) {
		for (T elemento : elementos) {
			System.out.println(elemento.toString());
		}
	}

	
	//v.04
	public S[] getAtributoArray2() {
		return atributoArray2;
	}

	public void setAtributoArray2(S[] atributoArray2) {
		this.atributoArray2 = atributoArray2;
	}

	public S getAtributo3() {
		return atributo3;
	}

	public void setAtributo3(S atributo3) {
		this.atributo3 = atributo3;
	}

	public S getAtributo4() {
		return atributo4;
	}

	public void setAtributo4(S atributo4) {
		this.atributo4 = atributo4;
	}
	
	//--//
	
	public void setElementos(List<T> elementos){
		this.elementos = elementos;
	}
	
}
