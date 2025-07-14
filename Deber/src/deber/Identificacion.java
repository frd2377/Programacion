package deber;

import patron_generico.Generica;

public class Identificacion {
	
	private Generica<String> datosIdent = new Generica<String>();
	
	public Identificacion(String nombre, String cedula,String correo,String celular,String casa) {
		datosIdent.addElemntos(nombre);
		datosIdent.addElemntos(cedula);
		datosIdent.addElemntos(correo);
		datosIdent.addElemntos(celular);
		datosIdent.addElemntos(casa);
	}
	
	public Boolean validarNombre() {
		return Validar.validarNombre(datosIdent.getElementos().get(0));
	}
	
	public Boolean validarDni() {
		return Validar.validarDni(datosIdent.getElementos().get(1));
	}
	
	public Boolean validarCorreo() {
		return Validar.validarCorreo(datosIdent.getElementos().get(2));
	}
	
	public Boolean validarCelular() {
		return Validar.validarCelular(datosIdent.getElementos().get(3));
	}
	
	public Boolean validarCasa() {
		return Validar.validarCasa(datosIdent.getElementos().get(4));
	}
	
	
	
}
