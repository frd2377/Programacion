package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;

import patron.Archivos;
import UI.UI;
import model.Datos;

public class Controller implements ActionListener{

	private UI ui;
	private Archivos file;
	
	public Controller(UI ui) {
		this.ui = ui;
		this.ui.btnSeleccion.addActionListener(this);
		file = new Archivos("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ui.btnSeleccion)) {
			file.getFileChooser(ui, "txt");
			Datos model = new Datos(file);
			List<String> lista = model.filtrarNumeros();
			System.out.println(lista.get(0));
		}
	}

	private void msg(String text) {
		JOptionPane.showMessageDialog(ui, text);
	}
	
}