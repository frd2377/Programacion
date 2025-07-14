package UI;

import java.io.IOException;

import controllers.registroPlacas;
import controllers.revision;
import patron.Archivos;
import patron.Generica;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Archivos file=new Archivos("src/datos/marcas");
		Generica<String,?>datos=new Generica<>();
		try {
			datos.atributoArray1=file.readerFile().split(";");
			Thread [] vehiculos=new Thread[50];
			for(int i=0;i<vehiculos.length;i++) {
				vehiculos[i]=new registroPlacas(datos.atributoArray1);
			}
			for(Thread hilo: vehiculos) {
				hilo.start();
				hilo.join();
			}
			Thread proceso=new revision();
			proceso.start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		VehiculosUI vehiculosUI = new VehiculosUI();
		vehiculosUI.setVisible(true);

	}

}
