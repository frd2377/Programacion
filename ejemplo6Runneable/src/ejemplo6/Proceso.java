package ejemplo6;

import java.io.File;
import java.util.Date;
import java.util.Random;

import patron.Archivos;
import patron.Generica;

public class Proceso implements Runnable{
	private Thread hilo;
	private Archivos file;
	private Generica<Integer, String> valores;
	
	public Proceso(int valor,String msg) {
		file = new Archivos("src/logs");
		file.create(0); // Crear Directorio
		valores = new Generica<>(valor);
		hilo = new Thread(msg);
	}
	
	private Integer getValor() {
		return (int) (Math.random()*valores.getAtributo1());
	}
	
	public void run() {
		file.setFile(new File(file.getFile().getAbsolutePath()+"/"+hilo.getName()+".txt"));
		file.create(1);
		valores.setAtributo2(getValor());
		System.out.println(hilo.getName()+", Valores: "+valores.getAtributo2());
		try {
			hilo.sleep(2000);
			file.writerFile("Created: "+new Date(), false);
			valores.setAtributo3("");
			for (int i = 0; i < valores.getAtributo2(); i++) {
				file.writerFile(i+",", false); //Escribir al final sin sobrescritura
				valores.setAtributo3(valores.getAtributo3()+","+i);
				hilo.sleep(1000);
			}
			file.writerFile((String) valores.getAtributo3(), false);
			System.out.println(hilo.getName()+" Finalizado");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
