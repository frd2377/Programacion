package ejemplo7Promedios;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import patron.Archivos;
import patron.Generica;

public class Proceso extends Thread{
	
	private Archivos file = new Archivos("src/files");
	private Generica<Double, String> datos = new Generica<>();
	private Persona persona;

	public Proceso(Persona persona,String msg) {
		super(msg);
		this.persona = persona;
		file.create(0);
	}
	
	private Double getNota(int a, int b) {
	    return (double) Math.round((Math.random() * (b - a + 1) + a) * 100) / 100;
	}
	
	public void run() {
		datos.atributoArray1 = new Double[5];
		for (int i = 0; i < 5; i++) {
			datos.atributoArray1[i] = getNota(0, 20);
		}
		file.setFile(new File(file.getFile().getAbsolutePath()+"/"+persona.getDni()+".txt"));
		file.create(1);
		try {
			file.writerFile("ESTUDIANTE: "+persona.getNames()+"\nDNI: "+persona.getDni()+"\nNOTAS: ", false);
			for (Double nota : datos.atributoArray1) {
				file.writerFile(nota.toString()+", ", false);//Escribir al final sin sobrescritura
			}
			file.writerFile("\nPROMEDIO: "+persona.promedio(datos.atributoArray1), false);
			file.writerFile("\nESTADO: "+persona.estado(persona.promedio(datos.atributoArray1)), false);
			System.out.println(getName()+" Finalizado");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
}
