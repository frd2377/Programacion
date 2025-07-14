package practica5Hilos;

import patron.Archivos;
import patron.Generica;

public class GeneradorPlacas extends Thread implements Parametrizable{

	private Generica<String, ?> datos = new Generica<>();
	private Archivos file;
	
	public GeneradorPlacas(String... marcas) {
		file = new Archivos("src/files/vehiculos.txt");
		file.create(1); //crear el archivo vehiculos.txt
		datos.atributoArray1 = marcas; //Obtener las marcas 
	}
	
	private Integer getIndexMarca() {
		return (int)(Math.random()*datos.atributoArray1.length);
	}
	
	private Integer getInicialPlaca() {
		return (int)(Math.random()*prov.split(",").length);
	}
	
	public Integer getIndexPlaca() {
		return (int)(Math.random()*abc.split(",").length);
	}
	
	public Integer getNumPlaca() {
		return (int) (Math.random()*10);
	}
	
	@Override
	public void run() {
		datos.setAtributo1(datos.atributoArray1[getIndexMarca()]); //imprime la marca del vehiculo
		datos.setAtributo2(prov.split(",")[getInicialPlaca()].toUpperCase()); //Imprime valor inicial placa
		
		for (int i = 0; i < 2; i++) {			
			datos.setAtributo2(datos.getAtributo2()+abc.split(",")[getIndexPlaca()].toUpperCase()); 
		}
		
		datos.setAtributo2(datos.getAtributo2()+"-");
		for (int i = 0; i < 4; i++) {
			datos.setAtributo2(datos.getAtributo2()+getNumPlaca());
		}
		
		Vehiculo vehiculo = new Vehiculo(datos.getAtributo1(), datos.getAtributo2());
		
		try {
			sleep(2000);
			file.writerFile(vehiculo.toString(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
