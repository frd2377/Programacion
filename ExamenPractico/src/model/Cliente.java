package model;

import java.io.IOException;

import controller.Parametrizable;
import patron.Archivos;
import patron.Generica;

public class Cliente extends Thread implements Parametrizable{
	private Generica<String, String> datos = new Generica<String, String>();
	private Archivos file = new Archivos(path);

	public Cliente(String nombre, String cedula, String correo) {
		datos.addElemntos(nombre);
		datos.addElemntos(cedula);
		datos.addElemntos(correo);
	}
	
	public void registrarCliente() {
		try {
			file.writerFile(datos.getElementos().get(0)+";"+datos.getElementos().get(1)+";"+datos.getElementos().get(2)+"\n", false);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
