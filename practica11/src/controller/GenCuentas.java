package controller;

import model.CuentaDAO;

public class GenCuentas extends Thread{

	private CuentaDAO cuentaDAO;
	
	@Override
	public void run() {
		cuentaDAO = new CuentaDAO();
		for (int i = 0; i < 100; i++) {
			cuentaDAO.registerCuenta();
		}
	}
	
}
