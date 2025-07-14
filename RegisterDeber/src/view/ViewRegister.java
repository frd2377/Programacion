package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ViewController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;

//Conectar la UI con el controller;
public class ViewRegister extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelRegister;
	public JTextField textSearch;
	public JTextField textNames;
	public JTextField textDni;
	public JTextField textEmail;
	public JButton btnSearch;
	public JButton btnSave;
	public JSpinner spinnerEdad;
	public JButton btnImage;
	public JLabel ImageLbl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRegister frame = new ViewRegister();
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
	public ViewRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 305);
		panelRegister = new JPanel();
		panelRegister.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Register");
		setContentPane(panelRegister);
		panelRegister.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search :");
		lblNewLabel.setBounds(10, 11, 61, 14);
		panelRegister.add(lblNewLabel);
		
		textSearch = new JTextField();
		textSearch.setBounds(81, 8, 250, 27);
		panelRegister.add(textSearch);
		textSearch.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(341, 7, 101, 28);
		panelRegister.add(btnSearch);
		
		JLabel lblNewLabel_1 = new JLabel("Names :");
		lblNewLabel_1.setBounds(10, 52, 61, 14);
		panelRegister.add(lblNewLabel_1);
		
		textNames = new JTextField();
		textNames.setColumns(10);
		textNames.setBounds(81, 49, 250, 27);
		panelRegister.add(textNames);
		
		JLabel lblNewLabel_2 = new JLabel("DNI :");
		lblNewLabel_2.setBounds(10, 99, 61, 14);
		panelRegister.add(lblNewLabel_2);
		
		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(81, 93, 250, 27);
		panelRegister.add(textDni);
		
		JLabel lblNewLabel_3 = new JLabel("Age :");
		lblNewLabel_3.setBounds(348, 99, 42, 14);
		panelRegister.add(lblNewLabel_3);
		
		spinnerEdad = new JSpinner();
		spinnerEdad.setBounds(400, 96, 42, 20);
		panelRegister.add(spinnerEdad);
		
		JLabel lblNewLabel_4 = new JLabel("Email :");
		lblNewLabel_4.setBounds(10, 143, 61, 14);
		panelRegister.add(lblNewLabel_4);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(81, 140, 250, 27);
		panelRegister.add(textEmail);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(242, 178, 89, 28);
		panelRegister.add(btnSave);
		
		btnImage = new JButton("Load Image");
		btnImage.setBounds(480, 231, 119, 28);
		panelRegister.add(btnImage);
		
		ImageLbl = new JLabel("");
		ImageLbl.setBounds(480, 11, 247, 209);
		panelRegister.add(ImageLbl);
		
		ViewController controller = new ViewController(this);
		
		//formato de cedula = 1719233882
		//Controlar los errores con msg
	}
}
