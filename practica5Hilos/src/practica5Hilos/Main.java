package practica5Hilos;

import patron.Archivos;
import patron.Generica;

public class Main {
	
	public static void main(String[] args) {
		Archivos file = new Archivos("src/files/marcas");
		Generica<String,?> datos = new Generica<>();
		Thread[] generarPlacas = new Thread[50];
		
		try {
			datos.atributoArray1 = file.readerFile().split(";");
			for (int i = 0; i < generarPlacas.length; i++) {
				generarPlacas[i] = new GeneradorPlacas(datos.atributoArray1);
				generarPlacas[i].start();
			}
			
			for (Thread vehiculo : generarPlacas) {
				vehiculo.join();
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread[] informes = new Thread[10];
		
		try {
			String[] mecanicos = new Archivos("src/files/mecanicos").readerFile().split(";");
			String[] vehiculos = new Archivos("src/files/vehiculos.txt").readerFile().split("\n");
			
			int c= 0;
			for (int i = 0; i < mecanicos.length; i++) {
				informes[i] = new GeneradorInformes(mecanicos[i], vehiculos, c);
				informes[i].start();
				c+=5;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
