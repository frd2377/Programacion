package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import UI.VehiculosUI;
import patron.Archivos;
import patron.Generica;

public class logicViewMecanica implements ActionListener,parametrizable, ItemListener{
	
	private VehiculosUI view;
	private Thread procesoBarra;
	private Archivos file = new Archivos("src/datos/vehiculos.txt");
	private Generica<String, String> datos = new Generica<>();
	
	public logicViewMecanica(VehiculosUI view) {
		this.view = view;
		this.view.btnLoad.addActionListener(this);
		this.view.comboBoxMecanicos.addItemListener(this);
		this.view.comboBoxVehiculos.addItemListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(view.btnLoad)) {
			procesoBarra = new ProcesoBarra(view);
			procesoBarra.start();
		}
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED && e.getSource().equals(view.comboBoxMecanicos)) {
			file.setFile(new File("src/datos/vehiculos.txt"));
			datos.setElementos(new ArrayList());
	        try {
	        	datos.atributoArray1 = file.readerFile().split("#");
				int num = numAleatorioRang(0, 44);
				view.comboBoxVehiculos.removeAllItems();
				for (int i = num; i < num+5; i++) {
					view.comboBoxVehiculos.addItem(datos.atributoArray1[i].split(";")[0]+" "+datos.atributoArray1[i].split(";")[1]);
					datos.addElemntos(datos.atributoArray1[i]);
				}
	        	
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    }else if(e.getStateChange() == ItemEvent.SELECTED && e.getSource().equals(view.comboBoxVehiculos)){
	    	String texto = "";
	    	for (int i = 0; i < datos.getElementos().size(); i++) {
	    		if (datos.getElementos().get(i).split(";")[0].equals(e.getItem().toString().split(" ")[0]) && datos.getElementos().get(i).split(";")[1].equals(e.getItem().toString().split(" ")[1]) ) {
					texto += "Porcentajes %";
	    			texto += "\nVehiculo: "+e.getItem().toString().split(" ")[0];
					texto += "\nPlaca: "+e.getItem().toString().split(" ")[1];
					texto += "\nL: "+controllerRevisionUi.T_lambda(Double.parseDouble(datos.getElementos().get(i).split(";")[2]))+"% "+controllerRevisionUi.msg_lambda(controllerRevisionUi.T_lambda(Double.parseDouble(datos.getElementos().get(i).split(";")[2])));
					texto += "\nO2: "+controllerRevisionUi.T_O2(Double.parseDouble(datos.getElementos().get(i).split(";")[3]))+ "% "+controllerRevisionUi.msg_O2(controllerRevisionUi.T_O2(Double.parseDouble(datos.getElementos().get(i).split(";")[3])));
					texto += "\nN2O: "+controllerRevisionUi.T_N2O(Double.parseDouble(datos.getElementos().get(i).split(";")[4]))+ "% "+controllerRevisionUi.msg_N2O(controllerRevisionUi.T_N2O(Double.parseDouble(datos.getElementos().get(i).split(";")[4])));
					texto += "\nCO2: "+controllerRevisionUi.T_CO2(Double.parseDouble(datos.getElementos().get(i).split(";")[5]))+ "% "+controllerRevisionUi.msg_CO2(controllerRevisionUi.T_CO2(Double.parseDouble(datos.getElementos().get(i).split(";")[5])));
				}
				
			}
	    	view.textAreaEstado.setText(texto);
	    }
		
	}
	
	public int numAleatorioRang(int a, int b) {
	    Random aleatorio = new Random();
	    return (int) (aleatorio.nextDouble() * (b - a + 1)) + a;
	}

}
