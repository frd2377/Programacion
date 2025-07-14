package aerolinea;

import java.util.Date;

import clase_generica.Generica;

public class Boleto extends Vuelo{
	private Generica<Date, Integer> datos_boleto;
	private Pasajero pasajero;
	
	public Boleto(String pais_origen,String pais_destino,Integer num_vuelo,Date fecha,Date hora,Integer num_asiento,Pasajero pasajero) {
		super(pais_origen, pais_destino, num_vuelo);
		datos_boleto = new Generica<Date, Integer>(fecha, num_asiento,hora);
		this.pasajero = pasajero;
	}
	
	@Override
	public String toString() {
		return "Pasajero: "+pasajero.getNombre()+"\ncedula: "+pasajero.getCedula()+"\nnum: "+getNumVuelo()+"\ndest: "+getDestino()+"\nfecha: "+datos_boleto.getAtributo1()+"\nSalida: "+datos_boleto.getAtributo3()+"\nasiento: "+datos_boleto.getAtributo2()+"\n";
	}
	
	public Integer getCedula() {
		return pasajero.getCedula();
	}
	
}
