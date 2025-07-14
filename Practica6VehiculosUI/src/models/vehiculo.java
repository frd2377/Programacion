package models;

import patron.Generica;

public class vehiculo {
	private Generica<String,?>dt_v;
	private Generica<Double,Double>gases;
	public vehiculo(String marca, String placa,Double...gases_v) {
		dt_v=new Generica<>(marca, placa);
		dt_v.setAtributo2(placa);
		gases=new Generica<>();
		gases.atributoArray1=gases_v;
	}
	public String getMarca() {
		return dt_v.getAtributo1();
	}
	public String getPlaca() {
		return dt_v.getAtributo2();
	}
	public double getLambda() {
		return gases.atributoArray1[0];
	}
	public double getO2() {
		return gases.atributoArray1[1];
	}
	public double getN2O() {
		return gases.atributoArray1[2];
	}
	public double getCO2() {
		return gases.atributoArray1[3];
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
