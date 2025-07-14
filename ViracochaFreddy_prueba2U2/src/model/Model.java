package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import patron.Archivos;
import patron.Generica;

public class Model {
	public Generica<String,Date> datos = new Generica<>();
	public Archivos file = new Archivos("C:\\Respaldo\\Grupo2-ProgramacionAplicada\\Frd\\ViracochaFreddy_prueba2U2\\src\\doc\\info.txt");

	public Model(String texto) {
		datos.setAtributo1(texto);
	}
	
}
