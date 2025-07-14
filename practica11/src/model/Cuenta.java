package model;

import patron_generico.Generica;

public class Cuenta {
	
	private Generica<String, String> datosCuenta;
	private int id;
	
	public Cuenta(int id, Long numCuenta, String tipo, int dni, double saldo) {
		this.id = id;
		datosCuenta = new Generica<String, String>();
		datosCuenta.setAtributo1(String.valueOf(numCuenta));
		datosCuenta.setAtributo2(tipo);
		datosCuenta.setAtributo3(String.valueOf(dni));
		datosCuenta.setAtributo4(String.valueOf(saldo));
	}
	
	public Cuenta(Long numCuenta, String tipo, int dni, double saldo) {
		datosCuenta = new Generica<String, String>();
		datosCuenta.setAtributo1(String.valueOf(numCuenta));
		datosCuenta.setAtributo2(tipo);
		datosCuenta.setAtributo3(String.valueOf(dni));
		datosCuenta.setAtributo4(String.valueOf(saldo));
	}
    
    public Long getNumCuenta() {
    	return Long.parseLong(datosCuenta.getAtributo1());
    }
    
    public String getTipo() {
    	return datosCuenta.getAtributo2();
    }
    
    public int getDni() {
    	return Integer.parseInt(datosCuenta.getAtributo3());
    }
    
    public double getSaldo() {
    	return Double.valueOf(datosCuenta.getAtributo4());
    }
    
    public void setSaldo(double saldo) {
    	datosCuenta.setAtributo4(String.valueOf(saldo));
    }
    
    public int getId() {
    	return id;
    }
    
}
