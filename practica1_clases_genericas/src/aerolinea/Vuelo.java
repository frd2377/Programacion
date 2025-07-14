package aerolinea;

import clase_generica.Generica;

public class Vuelo {
	private Generica<String, Integer> datos_vuelo;
	
	public Vuelo(String pais_origen,String pais_destino,Integer num_vuelo){
		datos_vuelo = new Generica<String, Integer>(pais_origen, num_vuelo, pais_destino);
	}
	
	public String getOrigen() {
		return datos_vuelo.getAtributo1();
	}
	
	public String getDestino() {
		return datos_vuelo.getAtributo3();
	}
	
	public Integer getNumVuelo() {
		return datos_vuelo.getAtributo2();
	}

}
