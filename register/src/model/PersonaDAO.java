package model;

import java.io.File;
import java.io.IOException;

import patron.Archivos;
import patron.Generica;

public class PersonaDAO {
	private Archivos file;
	private Generica<Persona, String> datosDAO;
	
	public PersonaDAO() {
		file = new Archivos("src/files");
		datosDAO = new Generica<Persona, String>();
	}

	public boolean savePersona(Persona persona) throws IOException{
		file.setFile(new File(file.getFile().getAbsolutePath()+persona.getDni()+".txt"));
		file.create(1);
		if (file.writerFile(persona.toString(), true)) {
			return true;
		}
		return false;
	}
	
}
