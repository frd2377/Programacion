package practica5Hilos;

import patron.Generica;

public class Vehiculo {
	
	private Generica<String, ?> datos = new Generica<>();

	public Vehiculo(String marca, String placa) {
		datos.setAtributo1(marca);
		datos.setAtributo2(placa);
	}
	
	public String getMarca() {
		return datos.getAtributo1();
	}
	
	public String getPlaca() {
		return datos.getAtributo2();
	}
	
	public String toString() {
		return String.format("%s;%s", getMarca(),getPlaca());
	}
	
}
