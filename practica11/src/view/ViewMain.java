package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LogicView;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class ViewMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldDni;
	public JTextField textFieldMonto;
	public JButton btnRealizar;
	public JLabel lblNumCuenta;
	public JLabel lblTipo;
	public JLabel lblSaldo;
	public JRadioButton rdbtnRetiro;
	public JRadioButton rdbtnDeposito;
	public ButtonGroup buttonGroup;
	public JButton btnBuscar;

	public ViewMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CEDULA:");
		lblNewLabel.setBounds(10, 11, 92, 37);
		contentPane.add(lblNewLabel);
		
		textFieldDni = new JTextField();
		textFieldDni.setBounds(112, 11, 235, 34);
		contentPane.add(textFieldDni);
		textFieldDni.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CUENTA:");
		lblNewLabel_1.setBounds(10, 59, 92, 37);
		contentPane.add(lblNewLabel_1);
		
		lblNumCuenta = new JLabel("0");
		lblNumCuenta.setBounds(112, 59, 92, 37);
		contentPane.add(lblNumCuenta);
		
		lblTipo = new JLabel("");
		lblTipo.setBounds(112, 107, 92, 37);
		contentPane.add(lblTipo);
		
		JLabel lblNewLabel_1_1 = new JLabel("TIPO:");
		lblNewLabel_1_1.setBounds(10, 107, 92, 37);
		contentPane.add(lblNewLabel_1_1);
		
		lblSaldo = new JLabel("0");
		lblSaldo.setBounds(112, 155, 92, 37);
		contentPane.add(lblSaldo);
		
		JLabel lblNewLabel_1_2 = new JLabel("SALDO:");
		lblNewLabel_1_2.setBounds(10, 155, 92, 37);
		contentPane.add(lblNewLabel_1_2);
		
		rdbtnRetiro = new JRadioButton("RETIRO");
		rdbtnRetiro.setBounds(210, 162, 109, 23);
		contentPane.add(rdbtnRetiro);
		
		rdbtnDeposito = new JRadioButton("DEPOSITO");
		rdbtnDeposito.setBounds(321, 162, 109, 23);
		contentPane.add(rdbtnDeposito);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnDeposito);
		buttonGroup.add(rdbtnRetiro);
		
		rdbtnRetiro.setSelected(true);
		
		textFieldMonto = new JTextField();
		textFieldMonto.setColumns(10);
		textFieldMonto.setBounds(112, 203, 92, 34);
		contentPane.add(textFieldMonto);
		
		JLabel lblMonto = new JLabel("MONTO: $");
		lblMonto.setBounds(10, 203, 92, 37);
		contentPane.add(lblMonto);
		
		btnRealizar = new JButton("REALIZAR");
		btnRealizar.setBounds(218, 203, 117, 34);
		contentPane.add(btnRealizar);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(357, 11, 117, 34);
		contentPane.add(btnBuscar);
		
		LogicView logicView = new LogicView(this);
	}
}
