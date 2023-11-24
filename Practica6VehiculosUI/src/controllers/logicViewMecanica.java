package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import UI.VehiculosUI;
import patron.Archivos;

public class logicViewMecanica implements ActionListener,parametrizable{
	
	private VehiculosUI view;
	private Thread procesoBarra;
	private Archivos file = new Archivos("src/datos/vehiculos.txt");
	
	public logicViewMecanica(VehiculosUI view) {
		this.view = view;
		this.view.btnLoad.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(view.btnLoad)) {
			
			file.getFileChooser(view, abc);
			try {
				System.out.println(file.readerFile());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			procesoBarra = new ProcesoBarra(view);
			procesoBarra.start();
		}
		
	}

}
