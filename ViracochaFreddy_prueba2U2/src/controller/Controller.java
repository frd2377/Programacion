package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.Model;
import patron.Archivos;
import patron.Generica;
import ui.UI;


public class Controller implements ActionListener {

	private UI ui;
	private Generica<String, ?> datos = new Generica<>();
	private Archivos archivo = new Archivos("");
	private Model modelo = new Model("");
	
	public Controller(UI ui) {
		this.ui = ui;
		ui.btnLeer.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ui.btnLeer)) {
			archivo.getFileChooser(ui, "txt");
			try {
				modelo= new Model(archivo.readerFile());
				datos.setAtributo1(archivo.readerFile());
				for (String palabra : datos.getAtributo1().split(" ")) {
					if (archivo.validacionByER(palabra, "[\\w]{1,}@[\\w.]{1,}[\\w]+")) {
						
					}else if (archivo.validacionByER(palabra, "[a-zA-Zá-úÁ-Ú]{4}")) {
						
					}else if (archivo.validacionByER(palabra, "(0|1)[0-9]{8}-?[0-9]{1}")) {
						
					}
					
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
}

