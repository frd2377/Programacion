package UI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.logicViewMecanica;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class VehiculosUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnLoad;
	public JProgressBar progressBar;
	public JComboBox comboBoxMecanicos;
	public JComboBox comboBoxVehiculos;
	public JTextArea textAreaEstado;

	public VehiculosUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CARGAR VEHICULOS");
		lblNewLabel.setBounds(10, 29, 138, 34);
		contentPane.add(lblNewLabel);
		
		btnLoad = new JButton("LOAD");
		btnLoad.setBounds(158, 28, 146, 35);
		contentPane.add(btnLoad);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(314, 29, 327, 34);
		contentPane.add(progressBar);
		
		JLabel lblMecanicos = new JLabel("MECANICOS");
		lblMecanicos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMecanicos.setBounds(10, 85, 138, 21);
		contentPane.add(lblMecanicos);
		
		comboBoxMecanicos = new JComboBox();
		comboBoxMecanicos.setEnabled(false);
		comboBoxMecanicos.setBounds(158, 84, 483, 28);
		contentPane.add(comboBoxMecanicos);
		
		JLabel lblNewLabel_1_1 = new JLabel("VEHICULOS");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(10, 138, 138, 21);
		contentPane.add(lblNewLabel_1_1);
		
		comboBoxVehiculos = new JComboBox();
		comboBoxVehiculos.setEnabled(false);
		comboBoxVehiculos.setBounds(158, 137, 483, 28);
		contentPane.add(comboBoxVehiculos);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ESTADO");
		lblNewLabel_1_1_1.setBounds(10, 199, 138, 21);
		contentPane.add(lblNewLabel_1_1_1);
		
		textAreaEstado = new JTextArea();
		textAreaEstado.setEditable(false);
		textAreaEstado.setBounds(10, 222, 631, 177);
		contentPane.add(textAreaEstado);
		logicViewMecanica logicViewMecanica = new logicViewMecanica(this);		
		
	}
}
