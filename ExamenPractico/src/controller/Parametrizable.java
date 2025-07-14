package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public interface Parametrizable {
	
	public final String path = "src/docs/clientes.txt";
	
	public default void msg(JFrame view, String text) {
		JOptionPane.showMessageDialog(view, text);
	}

}
