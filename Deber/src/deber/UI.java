package deber;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel validacionUI;

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

	public UI() {
		setTitle("UI");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 449);
		validacionUI = new JPanel();
		validacionUI.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(validacionUI);
		validacionUI.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombres:");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel.setBounds(20, 33, 89, 35);
		validacionUI.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CI:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(20, 84, 89, 35);
		validacionUI.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Correo:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1_1.setBounds(20, 130, 89, 35);
		validacionUI.add(lblNewLabel_1_1);
		
		JTextField textNombre = new JTextField();
		textNombre.setBounds(119, 33, 406, 35);
		validacionUI.add(textNombre);
		textNombre.setColumns(10);
		
		JTextField textCI = new JTextField();
		textCI.setColumns(10);
		textCI.setBounds(119, 84, 406, 35);
		validacionUI.add(textCI);
		
		JTextField textCorreo = new JTextField();
		textCorreo.setColumns(10);
		textCorreo.setBounds(119, 130, 406, 35);
		validacionUI.add(textCorreo);
		
		JLabel lblNewLabel_1_2 = new JLabel("Telefono:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1_2.setBounds(20, 176, 89, 35);
		validacionUI.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Celular:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1_3.setBounds(119, 176, 89, 35);
		validacionUI.add(lblNewLabel_1_3);
		
		JTextField textCelular = new JTextField();
		textCelular.setColumns(10);
		textCelular.setBounds(218, 176, 307, 35);
		validacionUI.add(textCelular);
		
		JLabel lblNewLabel_1_4 = new JLabel("Casa:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_1_4.setBounds(119, 222, 89, 35);
		validacionUI.add(lblNewLabel_1_4);
		
		JTextField textCasa = new JTextField();
		textCasa.setColumns(10);
		textCasa.setBounds(218, 222, 307, 35);
		validacionUI.add(textCasa);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.setFont(new Font("Tahoma", Font.ITALIC, 15));
		btnValidar.setBounds(381, 268, 144, 44);
		validacionUI.add(btnValidar);
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Identificacion identificacion = new Identificacion(textNombre.getText(), textCI.getText(), textCorreo.getText(), textCelular.getText(), textCasa.getText());
				
				if (identificacion.validarNombre()) {
					textNombre.setBackground(Color.GREEN);
				}else {
					textNombre.setBackground(Color.RED);
				}
				if (identificacion.validarDni()) {
					textCI.setBackground(Color.GREEN);
				}else {
					textCI.setBackground(Color.RED);
				}
				
				if (identificacion.validarCorreo()) {
					textCorreo.setBackground(Color.GREEN);
				}else {
					textCorreo.setBackground(Color.RED);
				}
				
				if (identificacion.validarCelular()) {
					textCelular.setBackground(Color.GREEN);
				}else {
					textCelular.setBackground(Color.RED);
				}

				if (identificacion.validarCasa()) {
					textCasa.setBackground(Color.GREEN);
				}else {
					textCasa.setBackground(Color.RED);
				}
				
			}
		});
	}
}
