package deber;

public class Validar {
	
	public static boolean validarNombre(String nombre) {
		return nombre.matches("^[A-Z][a-z]+( [A-Z][a-z]+)+$");
	}
	
	public static boolean validarDni(String cedula) {
		return cedula.matches("(1|0)[0-9]{8}-?[0-9]{1}");
	} 

	public static boolean validarCorreo(String correo) {
		return correo.matches("[\\w]+@[\\w]+[.][a-z]+");
	}
	
	public static boolean validarCelular(String celular) {
		return celular.matches("[(]?0(8|9)[)]?-?[0-9]{4}-?[0-9]{3}");
	}
	
	public static boolean validarCasa(String telefono) {
		return telefono.matches("[(]?[+][0-9]{1,3}[)]?-?[0-9]{4}-?[0-9]{3}");
	}
	
}	