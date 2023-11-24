package controllers;

import UI.VehiculosUI;

public class ProcesoBarra extends Thread implements parametrizable{

	private VehiculosUI view;
	
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
		view.comboBoxMecanicos.setEnabled(true);
		view.comboBoxVehiculos.setEnabled(true);
	}
}
