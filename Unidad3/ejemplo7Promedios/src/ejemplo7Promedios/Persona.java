package ejemplo7Promedios;

import patron.Generica;

public class Persona {
	
	private Generica<String, Long> datos;
	
	public Persona(String nombre, Long dni) {
		datos.setAtributo1(nombre);
		datos.setAtributo3(dni);
	}
	
	public String getNames() {
		return datos.getAtributo1();
	}
	
	public Long getDni() {
		return datos.getAtributo3();
	}
	
	private String state(Double promedio) {
		if (promedio > 14) {
			return "APROBADO";
		}else if (promedio > 12 && promedio<14) {
			return "SUPLETORIO";
		}else {
			return "REPROBADO";
		}
	}
	
	public Double promedio(double... notas) {
		Double promedio = 0.0;
		for (double nota : notas) {
			promedio+=nota;
		}
		
		return promedio/notas.length;
	}
	
	public String toString() {
		return String.format("ESTUDIANTE:%s%nDNI:%d", getNames(),getDni());
	}
	
}
