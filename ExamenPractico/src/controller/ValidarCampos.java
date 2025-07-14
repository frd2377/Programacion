package controller;

public class ValidarCampos {
	
	public static boolean validarNombres(String nombre) {
		if (nombre.matches("([A-ZÁ-Ú][a-zA-Zá-úÁ-Ú]+[\s]*){3,4}")) {
			return true;
		}
		return false;
	}
	
	public static boolean validarCedula(String cedula) {
		if (cedula.matches("(0|1)[0-9]{8}[-]?[0-9]{1}")) {
			return true;
		}
		return false;
	}
	
	public static boolean validarCorreo(String correo) {
		if (correo.matches("[\\w]+[@][a-zA-Z]+([.][a-zA-Zá-úÁ-Ú]+){1,2}")) {
			return true;
		}
		return false;
	}
	
}
