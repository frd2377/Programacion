package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.RegistroController;

public class RegistroUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	public JTextField textFieldCorreo;
	public JTextField textFieldCedula;
	public JTextField textFieldNombre;
	public JButton btnRegistrar;

	public RegistroUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO DE CLIENTES");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 196, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOMBRE:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 56, 96, 35);
		contentPane.add(lblNewLabel_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(116, 58, 361, 35);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		lblNewLabel_2 = new JLabel("CEDULA:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 104, 96, 35);
		contentPane.add(lblNewLabel_2);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setColumns(10);
		textFieldCedula.setBounds(116, 106, 361, 35);
		contentPane.add(textFieldCedula);
		
		lblNewLabel_3 = new JLabel("CORREO:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 150, 96, 35);
		contentPane.add(lblNewLabel_3);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(116, 152, 361, 35);
		contentPane.add(textFieldCorreo);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setBounds(336, 217, 141, 35);
		contentPane.add(btnRegistrar);
		
		RegistroController registroController = new RegistroController(this);
		
	}
}
