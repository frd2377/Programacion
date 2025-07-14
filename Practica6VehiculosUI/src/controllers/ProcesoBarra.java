package controllers;

import java.io.IOException;

import UI.VehiculosUI;
import patron.Archivos;
import patron.Generica;

public class ProcesoBarra extends Thread implements parametrizable{

	private VehiculosUI view;
	private Archivos file = new Archivos("src/datos/mecanicos");
	private Generica<String, String> datos = new Generica<String, String>();
	
	public ProcesoBarra(VehiculosUI view) {
		this.view = view;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				sleep(10);
				view.progressBar.setValue(i*2+2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			datos.atributoArray1 = file.readerFile().split(";");
			for (String nombre : datos.atributoArray1) {
				view.comboBoxMecanicos.addItem(nombre);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		view.comboBoxMecanicos.setEnabled(true);
		view.comboBoxVehiculos.setEnabled(true);
		view.btnLoad.setEnabled(false);
	}
}
