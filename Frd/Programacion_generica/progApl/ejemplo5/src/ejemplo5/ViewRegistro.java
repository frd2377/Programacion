package ejemplo5;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ViewRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombres;
	private JTextField textCedula;
	
	//-- --
	private JSpinner spinnerEdad;
	private JTextArea textDireccion;
	
	private Empleado empleado = new Empleado();
	private JTextField textCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewRegistro frame = new ViewRegistro();
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
	public ViewRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 325);
		setResizable(false);
		setTitle("Registro de Empleados");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelRegistro = new JPanel();
		panelRegistro.setBackground(SystemColor.inactiveCaptionBorder);
		panelRegistro.setBounds(0, 0, 438, 301);
		contentPane.add(panelRegistro);
		panelRegistro.setLayout(null);
		
		JLabel nombres = new JLabel("Nombres:");
		nombres.setHorizontalAlignment(SwingConstants.CENTER);
		nombres.setBounds(23, 11, 83, 38);
		panelRegistro.add(nombres);
		
		JLabel cedula = new JLabel("Cedula:");
		cedula.setHorizontalAlignment(SwingConstants.CENTER);
		cedula.setBounds(23, 60, 83, 38);
		panelRegistro.add(cedula);
		
		JLabel codigo = new JLabel("Codigo:");
		codigo.setHorizontalAlignment(SwingConstants.CENTER);
		codigo.setBounds(193, 109, 52, 38);
		panelRegistro.add(codigo);
		
		textNombres = new JTextField();
		textNombres.setBounds(116, 16, 270, 29);
		panelRegistro.add(textNombres);
		textNombres.setColumns(10);
		
		textCedula = new JTextField();
		textCedula.setColumns(10);
		textCedula.setBounds(116, 65, 270, 29);
		panelRegistro.add(textCedula);
		
		spinnerEdad = new JSpinner();
		spinnerEdad.setBounds(116, 114, 71, 29);
		panelRegistro.add(spinnerEdad);
		
		JButton btnAgregar = new JButton("Add");
		
		
		
		btnAgregar.setBounds(228, 225, 71, 29);
		panelRegistro.add(btnAgregar);
		
		JButton btnListar = new JButton("List");
		
		btnListar.setBounds(309, 225, 77, 29);
		panelRegistro.add(btnListar);
		
		JLabel edad = new JLabel("Edad:");
		edad.setHorizontalAlignment(SwingConstants.CENTER);
		edad.setBounds(23, 109, 83, 38);
		panelRegistro.add(edad);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(243, 114, 144, 29);
		panelRegistro.add(textCodigo);
		
		JLabel direccion = new JLabel("Direccion: ");
		direccion.setHorizontalAlignment(SwingConstants.CENTER);
		direccion.setBounds(33, 158, 73, 29);
		panelRegistro.add(direccion);
		
		textDireccion = new JTextArea();
		textDireccion.setBounds(116, 158, 276, 59);
		panelRegistro.add(textDireccion);
		
		JPanel panelRegistrados = new JPanel();
		panelRegistrados.setBounds(448, 0, 442, 290);
		contentPane.add(panelRegistrados);
		panelRegistrados.setLayout(null);
		
		JList listaEmpleados = new JList();
		listaEmpleados.setBounds(142, 56, 1, 1);
		panelRegistrados.add(listaEmpleados);
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleado tmp = new Empleado(textNombres.getText(),Long.parseLong(textCedula.getText()), Integer.parseInt(spinnerEdad.getNextValue().toString()));
				tmp.setCodigoAcceso(Long.parseLong(textCodigo.getText()));
				tmp.setDireccion(textDireccion.getText());
				empleado.add(tmp);
				clear();
				listaEmpleados.setModel(tmp.cargarEmpleados());
				
			}
		});
		
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empleado.listar();
			}
		});
		
	}
	
	public void clear() {
		textNombres.setText("");
		textCedula.setText("");
		spinnerEdad.setValue(0);
		textCodigo.setText("");
		textDireccion.setText("");
	}
}
