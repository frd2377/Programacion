package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Cuenta;
import model.CuentaDAO;
import patron_generico.Configurable;
import view.ViewMain;

public class LogicView implements ActionListener,Configurable{
	
	private ViewMain viewMain;
	private CuentaDAO cuentaDAO;
	private Cuenta cuenta;
	
	public LogicView(ViewMain viewMain) {
		this.viewMain = viewMain;
		cuentaDAO = new CuentaDAO();
		viewMain.btnRealizar.addActionListener(this);
		viewMain.btnBuscar.addActionListener(this);
		Thread genCuentas = new GenCuentas();
		//genCuentas.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(viewMain.btnBuscar)) {
			
			List<Cuenta> cuentas = cuentaDAO.getCuentas();
			boolean encontrado = false;
			for (Cuenta elemento : cuentas) {
				if (viewMain.textFieldDni.getText().equals(String.valueOf(elemento.getDni()))) {
					cuenta = elemento;
					encontrado = true;
				}
			}
			
			if (encontrado) {
				viewMain.lblNumCuenta.setText(cuenta.getNumCuenta().toString());
				viewMain.lblTipo.setText(cuenta.getTipo());
				viewMain.lblSaldo.setText(String.valueOf(cuenta.getSaldo()));
			}else {
				msg(viewMain, "Cuenta Not found");
				viewMain.lblNumCuenta.setText("0");
				viewMain.lblNumCuenta.setText("0");
				viewMain.lblTipo.setText("");
				viewMain.lblSaldo.setText("0");
				viewMain.textFieldMonto.setText("0");
			}
			
			
		}
		
		else if (e.getSource().equals(viewMain.btnRealizar)) {
			if (viewMain.rdbtnDeposito.isSelected()) {
				
				ProcesoDeposito procesoDeposito = new ProcesoDeposito(viewMain);
				procesoDeposito.start();
				
			}
			
			else if (viewMain.rdbtnRetiro.isSelected() && !(viewMain.textFieldDni.getText().trim().equals("")) && !(viewMain.textFieldMonto.getText().trim().equals(""))) {
				ProcesoRetiro procesoRetiro = new ProcesoRetiro(viewMain);
				procesoRetiro.start();
			}
			
		}
		
	}
	
	
	
	@Override
	public void msg(JFrame view, String msg) {
		JOptionPane.showMessageDialog(view, msg);
	}

}
