package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Persona;
import model.PersonaDAO;
import patron.Archivos;
import view.ViewRegister;

public class ViewController implements ActionListener {

	private ViewRegister ui;
	private PersonaDAO personaDAO = new PersonaDAO();
	private Persona persona = new Persona("", 0L, "", 0);
	private Archivos file = new Archivos("src\\");
	
	public ViewController(ViewRegister ui) {
		this.ui = ui;
		ui.btnSave.addActionListener(this);
		ui.btnSearch.addActionListener(this);
		ui.btnImage.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ui.btnSearch)) {
			//JOptionPane.showMessageDialog(ui, "Search Controller Connected");
			try {
				persona = personaDAO.serchPerson(ui.textSearch.getText());
				ui.textNames.setText(persona.getNames());
				ui.textDni.setText(persona.getDni().toString());
				ui.textEmail.setText(persona.getEmail());
				ui.spinnerEdad.setValue(persona.getAge());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				msg("Error al leer el archivo");
			}
		}else if(e.getSource().equals(ui.btnSave)) {
			//JOptionPane.showMessageDialog(ui, "Save Controller Connected");
			persona = new Persona(ui.textNames.getText(), Long.parseLong(ui.textDni.getText()), ui.textEmail.getText(), Integer.parseInt(ui.spinnerEdad.getValue().toString()));
			try {
				if (personaDAO.savePersona(persona)) {
					msg("Persona Registrada");
				}else {
					msg("Persona no registrada");
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if (e.getSource().equals(ui.btnImage)) {
			file.getFileChooser(ui, "png");
			ui.ImageLbl.setIcon(new ImageIcon(file.getFile().getAbsolutePath()));
		}
	}
	
	private void msg(String text) {
		JOptionPane.showMessageDialog(ui, text);
	}
	
	
}
