package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Cliente;
import patron.Archivos;
import view.RegistroUi;

public class RegistroController implements ActionListener{
	
	private RegistroUi registroUi;
	private Archivos file = new Archivos("src/docs/clientes.txt");
	
	public RegistroController(RegistroUi registroUi) {
		this.registroUi = registroUi;
		registroUi.btnRegistrar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(registroUi.btnRegistrar)) {
			ProcesoValidacion procesoValidacion = new ProcesoValidacion(file, registroUi);
			procesoValidacion.start();
		}
	}

}
