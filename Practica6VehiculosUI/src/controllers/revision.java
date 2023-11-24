package controllers;

import java.io.File;
import java.io.IOException;

import models.mecanica;
import models.vehiculo;
import patron.Archivos;
import patron.Generica;

public class revision extends Thread{
	
	private Archivos file;
	private Generica<String,?> datos_r;
	
	public revision() {
		file=new Archivos("src/datos/vehiculos.txt");
		datos_r=new Generica<>();
		try {
			file.writerFile(Archivos.searchReplace(file.readerFile(), ".", ","),true);
			datos_r.atributoArray1=file.readerFile().split("#");
			file.setFile(new File("src/datos/mecanicos"));
			datos_r.setAtributo1(file.readerFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
//		int cont=1;
		String mecanicos[]=datos_r.getAtributo1().split(";");
		int index_mec=0;
		for(int i=1; i<datos_r.atributoArray1.length-1;i++) {
			vehiculo[] vhs=new vehiculo[5];//almacena 5 vehiculos
			int index=0;//contine el index de recorrido
			System.out.println("MECANICO:"+mecanicos[index_mec]);
			for(int grupo=i;grupo<(i+5);grupo++) {
				String [] data_v=datos_r.atributoArray1[grupo].split(";");
				vehiculo vh=new vehiculo(
						data_v[0], 	//MARCA
						data_v[1],	//PLACA
						Double.parseDouble(data_v[2]),	//LAMBDA
						Double.parseDouble(data_v[3]),	//O2
						Double.parseDouble(data_v[4]),	//N2O
						Double.parseDouble(data_v[5]));	//CO2
				vhs[index]=vh;
				index++;//index de recorrido del array vhs
				System.out.println(vh.printMsg());
			}
			i+=4;//index para recorrer el arreglo de todos los vehiculos
			index_mec=i/5;//index para recorrer la posicion de los mecanicos
			for(vehiculo vh:vhs) {
				mecanica mc=new mecanica(vh);
				System.out.println(mc.toString());
			}

		}
	}

}
