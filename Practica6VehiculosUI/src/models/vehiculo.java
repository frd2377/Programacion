package models;

import patron_V10.generica;

public class vehiculo {
	private generica<String,?>dt_v;
	private generica<Double,Double>gases;
	public vehiculo(String marca, String placa,Double...gases_v) {
		dt_v=new generica<>(marca, placa);
		dt_v.setAtributo2(placa);
		gases=new generica<>();
		gases.atributoArray=gases_v;
	}
	public String getMarca() {
		return dt_v.getAtributo1();
	}
	public String getPlaca() {
		return dt_v.getAtributo2();
	}
	public double getLambda() {
		return gases.atributoArray[0];
	}
	public double getO2() {
		return gases.atributoArray[1];
	}
	public double getN2O() {
		return gases.atributoArray[2];
	}
	public double getCO2() {
		return gases.atributoArray[3];
	}
	public String toString() {
		return String.format("%s;%s;%.2f;%.2f;%.2f;%.2f#", 
				getMarca(), getPlaca(),getLambda(),getO2(),getN2O(),getCO2());
	}

	public String printMsg(){
		return String.format("%s \t %s \t %.2f \t %.2f \t %.2f \t %.2f", 
				getMarca(), getPlaca(),getLambda(),getO2(),getN2O(),getCO2());
	}
}
