package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public interface configurable {

	
	public default void msg(JFrame view, String msg) {
		JOptionPane.showMessageDialog(view, msg);
	}
	
}
