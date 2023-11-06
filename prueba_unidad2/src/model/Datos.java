package model;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import patron.Archivos;
import patron.Generica;

public class Datos {
	public Archivos file = new Archivos("");
	private Generica<String, File> datos = new Generica<String,File>();
	
	public Datos(Archivos file) {
		this.file = file;
	}
	
	public List<String> filtrarNumeros() {
		String tmp;
		try {
			String palabras = file.readerFile();
			for (String palabra : palabras.split(";")) {
				if (palabra.matches("[+][0-9]{1,3}[0-9]{3}-?[0-9]{3}-?[0-9]{4}")) {
					tmp = palabra;
					datos.addElemntos(tmp);
					System.out.println(palabra);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datos.getElementos();
	}
	
}
