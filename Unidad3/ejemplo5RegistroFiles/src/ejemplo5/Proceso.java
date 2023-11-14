package ejemplo5;

import java.io.File;

import patron.Archivos;
import patron.Generica;

public class Proceso extends Thread {
	
	private Archivos file;
	private Generica<Integer, ?> valores;
	
	public Proceso(int valor,String msg) {
		super(msg);
		file = new Archivos("src/logs");
		file.create(0); // Crear Directorio
		valores = new Generica<>(valor);
	}
	
	private Integer getValor() {
		return (int) (Math.random()*valores.getAtributo1());
	}
	
	public void run() {
		file.setFile(new File(file.getFile().getAbsolutePath()+"/"+getName()+".txt"));
		file.create(1);
		valores.setAtributo2(getValor());
		System.out.println(getName()+", Valores: "+valores.getAtributo2());
		try {
			sleep(2000);
			for (int i = 0; i < valores.getAtributo2(); i++) {
				file.writerFile(i+",", false); //Escribir al final sin sobrescritura
				sleep(1000);
			}
			System.out.println(getName()+" Finalizado");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
