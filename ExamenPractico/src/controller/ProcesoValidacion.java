package controller;

import java.awt.Color;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Cliente;
import patron.Archivos;
import view.RegistroUi;

public class ProcesoValidacion extends Thread implements Parametrizable{
	
	private Archivos file = new Archivos(path);
	private RegistroUi registroUi;

	public ProcesoValidacion(Archivos file, RegistroUi registroUi) {
		this.file = file;
		this.registroUi = registroUi;
	}
	
	@Override
	public void run() {
		Boolean existe = false;
		try {
			String [] clientes = file.readerFile().split("\n");
			if (clientes.length > 1) {
				for (String string : clientes) {
					if (string.split(";")[2].trim().equals(registroUi.textFieldCorreo.getText().trim())) {
						existe = true;
					}
				}
			}
			
			if (validarCampos().equals(true) && existe.equals(false)){
				Cliente cliente = new Cliente(registroUi.textFieldNombre.getText(), registroUi.textFieldCedula.getText(), registroUi.textFieldCorreo.getText());
				cliente.registrarCliente();
				msg(registroUi, "Usuario Registrado");
				registroUi.textFieldCedula.setText("");
				registroUi.textFieldCorreo.setText("");
				registroUi.textFieldNombre.setText("");
				
			}else {
				if (existe) {
					msg(registroUi, "Error Usuario ya registrado");
				}else {
					msg(registroUi, "Campos no validos");
				}
			}
		
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public Boolean validarCampos() {
		Boolean camposValidos = true;
		
		if (ValidarCampos.validarNombres(registroUi.textFieldNombre.getText())) {
			registroUi.textFieldNombre.setBackground(Color.white);
		}else {
			camposValidos = false;
			registroUi.textFieldNombre.setBackground(Color.red);
		}
		
		if (ValidarCampos.validarCedula(registroUi.textFieldCedula.getText())) {
			registroUi.textFieldCedula.setBackground(Color.white);
		}else {
			camposValidos = false;
			registroUi.textFieldCedula.setBackground(Color.red);
		}
		
		if (ValidarCampos.validarCorreo(registroUi.textFieldCorreo.getText())) {
			registroUi.textFieldCorreo.setBackground(Color.white);
		}else {
			camposValidos = false;
			registroUi.textFieldCorreo.setBackground(Color.red);
		}
		
		return camposValidos;
	
	}
	
}
