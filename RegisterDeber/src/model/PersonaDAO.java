package model;

import java.io.File;
import java.io.IOException;
import java.util.List;

import patron_generico.*;

public class PersonaDAO  implements Configurable{
	private Archivos file = new Archivos(ruta);
	private Generica<Persona, String> datosDAO = new Generica<Persona, String>();;
	
	public PersonaDAO() {
		
	}

	public boolean savePersona(Persona persona) throws IOException{
		file.create(0);
		file.setFile(new File(file.getFile().getAbsolutePath()+"\\"+persona.getDni()+".txt"));
		if (file.writerFile(persona.toString(), true)) {
			file.setFile(new File(ruta));
			return true;
		}
		return false;
	}
	
	public Persona serchPerson(String dni) throws IOException{
		List<String> namesFiles = file.listFilesoDirectory(0);
		for (String nameFile : namesFiles) {
			if (nameFile.equals(dni+".txt")) {
				file.setFile(new File(file.getFile().getAbsolutePath()+"/"+nameFile));
				datosDAO.setAtributoArray2(file.readerFile().split(";"));
				datosDAO.setAtributo1(new Persona(datosDAO.getAtributoArray2()[0], Long.parseLong(datosDAO.getAtributoArray2()[1]), datosDAO.getAtributoArray2()[2], Integer.parseInt(datosDAO.getAtributoArray2()[3])));
				file.setFile(new File(ruta));
			}
		}
		return datosDAO.getAtributo1();
	}
	
}
