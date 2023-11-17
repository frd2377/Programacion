package practica5Hilos;

import java.io.IOException;

import patron.Archivos;
import patron.Generica;

public class Main {
	
	public static void main(String[] args) {
		Archivos file = new Archivos("src/files/marcas");
		Generica<String,?> datos = new Generica<>();
		/*try {
			datos.atributoArray1 = file.readerFile().split(";");
			for (String marca : datos.atributoArray1) {
				System.out.println(marca);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		Thread[] vehiculos = new Thread[50];
		
		try {
			datos.atributoArray1 = file.readerFile().split(";");
			for (int i = 0; i < vehiculos.length; i++) {
				vehiculos[i] = new GeneradorPlacas(datos.atributoArray1);
			}
			
			for (Thread vehiculo : vehiculos) {
				vehiculo.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
