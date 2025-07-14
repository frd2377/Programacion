package aerolinea;

import clase_generica.Generica;

public class Pasajero {
	
	private Generica<String, Integer> datos_pasajero;
	
	public Pasajero(String nombre, Integer cedula){
		datos_pasajero = new Generica<String, Integer>(nombre, cedula);
	}
	
	public String getNombre() {
		return datos_pasajero.getAtributo1();
	}
	
	public Integer getCedula() {
		return datos_pasajero.getAtributo2();
	}

}
