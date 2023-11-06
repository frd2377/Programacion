package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JButton;

public class UI extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JList listPalabras;
	public JButton btnSeleccion;
	public JLabel contador;
	private Controller controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numeros encontrados");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(33, 29, 150, 37);
		contentPane.add(lblNewLabel);
		
		listPalabras = new JList();
		listPalabras.setBounds(33, 65, 313, 365);
		contentPane.add(listPalabras);
		
		btnSeleccion = new JButton("Seleccionar Archivo");
		btnSeleccion.setBounds(368, 65, 165, 42);
		contentPane.add(btnSeleccion);
		
		contador = new JLabel("0");
		contador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contador.setBounds(189, 42, 48, 14);
		contentPane.add(contador);
		controller = new Controller(this);
	}
}
