package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import model.Persona;
import model.PersonaDAO;
import patron_generico.*;
import view.ViewRegister;

public class ViewController implements ActionListener {

	private ViewRegister ui;
	private PersonaDAO personaDAO = new PersonaDAO();
	private Persona persona = new Persona("", 0L, "", 0);
	private Archivos file = new Archivos("");
	
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
				if (!campoVacio(ui.textSearch.getText())) {
					persona = personaDAO.serchPerson(ui.textSearch.getText());
					ui.textNames.setText(persona.getNames());
					ui.textDni.setText(persona.getDni().toString());
					ui.textEmail.setText(persona.getEmail());
					ui.spinnerEdad.setValue(persona.getAge());
					ui.ImageLbl.setIcon(new ImageIcon("src/docs/perfil.png"));
					ui.textSearch.setBackground(null);
				}else {
					msg("Campo vacio");
				}
			} catch (Exception e1) {
				msg("Persona no registrada");
			}
		}else if(e.getSource().equals(ui.btnSave) && validarSaveField().equals(true)) {
			//JOptionPane.showMessageDialog(ui, "Save Controller Connected");
			
			if (validarSave().equals(true)) {
				persona = new Persona(ui.textNames.getText(), Long.parseLong(ui.textDni.getText()), ui.textEmail.getText(), Integer.parseInt(ui.spinnerEdad.getValue().toString()));
				try {
					if (personaDAO.savePersona(persona)) {
						msg("Persona Registrada");
						ui.textNames.setText("");
						ui.textDni.setText("");
						ui.textEmail.setText("");
						ui.spinnerEdad.setValue(0);
						ui.ImageLbl.setIcon(new ImageIcon(""));
					}else {
						msg("Persona no registrada");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else {
				msg("Formatos No validos");
			}
		}else if (e.getSource().equals(ui.btnImage)) {
			file.getFileChooser(ui, "png");
			if (file.getFile().canRead()) {
				ui.ImageLbl.setIcon(new ImageIcon(file.getFile().getAbsolutePath()));
			}else {
				msg("Imagen no seleccionada");
			}
			
		}
	}
	
	private void msg(String text) {
		JOptionPane.showMessageDialog(ui, text);
	}
	
	private boolean campoVacio(String value) {
		return value.trim().equals("");
	}
	
	private Boolean validarSave() {
		Boolean tmp1 = Archivos.validacionByER(ui.textNames.getText(), "[A-Z]{1}[a-zá-ú]+[ ]{1}[A-Z]{1}[a-zá-ú]+");
		Boolean tmp2 = Archivos.validacionByER(ui.textDni.getText(), "(0|1)[0-9]{9}");
		Boolean tmp3 = Archivos.validacionByER(ui.textEmail.getText(), "[\\w]+@[\\w]+[.][\\w]+");
		
		if (tmp1.equals(true) && tmp2.equals(true) && tmp3.equals(true)) {
			ui.textNames.setBackground(null);
			ui.textDni.setBackground(null);
			ui.textEmail.setBackground(null);
			return true;
		}
		
		if (tmp1.equals(false)) {
			ui.textNames.setBackground(Color.RED);
		}else {
			ui.textNames.setBackground(null);
		}
		
		if (tmp2.equals(false)) {
			ui.textDni.setBackground(Color.RED);
		}else {
			ui.textDni.setBackground(null);
		}
		
		if (tmp3.equals(false)) {
			ui.textEmail.setBackground(Color.RED);
		}else {
			ui.textEmail.setBackground(null);
		}
		
		return false;
	}
	
	private Boolean validarSaveField() {
		if (campoVacio(ui.textNames.getText()) || campoVacio(ui.textDni.getText()) || campoVacio(ui.textEmail.getText()) || campoVacio(ui.spinnerEdad.getValue().toString())) {
			msg("Campos Vacios");
			return false;
		}
		
		if (!file.getFile().canRead()) {
			msg("Imagen no seleccionada");
			return false;
		}
		
		return true;
		
	}
	
}