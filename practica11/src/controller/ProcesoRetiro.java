package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.Cuenta;
import model.CuentaDAO;
import patron_generico.Configurable;
import view.ViewMain;

public class ProcesoRetiro extends Thread implements Configurable{
	
	
	private CuentaDAO cuentaDAO;
	private ViewMain viewMain;
	private Cuenta cuenta;
	
	public ProcesoRetiro(ViewMain viewMain) {
		this.viewMain = viewMain;
		cuentaDAO = new CuentaDAO();
	}
	
	@Override
	public void run() {
		List<Cuenta> cuentas = cuentaDAO.getCuentas();
		boolean encontrado = false;
		for (Cuenta elemento : cuentas) {
			if (viewMain.textFieldDni.getText().equals(String.valueOf(elemento.getDni()))) {
				cuenta = elemento;
				encontrado = true;
			}
		}
		
		if (encontrado) {
			if (Double.parseDouble(viewMain.textFieldMonto.getText())>0.0 && Double.parseDouble(viewMain.textFieldMonto.getText())<=cuenta.getSaldo()) {
				double saldo = cuenta.getSaldo();
				double monto = Double.parseDouble(viewMain.textFieldMonto.getText());
				double saldoTotal = saldo-=monto;
				cuenta.setSaldo(saldoTotal);
				cuentaDAO.setCuenta(cuenta);
				if (cuentaDAO.updateCuenta()) {
					viewMain.lblSaldo.setText(String.valueOf(saldoTotal));
					JOptionPane.showMessageDialog(viewMain, "Saldo Actualizado");
				}
			}else {
				JOptionPane.showMessageDialog(viewMain, "Monto no valido");
			}
		}
	}

}
