package patron_generico;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public interface Configurable {

	public final String nombreCarpeta = "proyectosP63G2";
	
	public default void msg(JFrame view, String msg) {
		JOptionPane.showConfirmDialog(view, msg);
	}
	
	/*
	 * Metodo para generar una ventana de informacion
	 * @param data
	 * @param head
	 * @return DefaultTableModel
	 * */
	public default DefaultTableModel loadDataTable(String[][] data, String... head) {
		DefaultTableModel modelo = new DefaultTableModel(null,head);
		
		for (int i = 0; i < data.length; i++) {
			modelo.addRow(data[i]);
		}
		
		return modelo;
	}
	
}
