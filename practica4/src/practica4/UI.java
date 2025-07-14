package practica4;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UI extends JFrame {

	private JPanel mainPanel;
	private JTextField textFieldRegex;
	private ArrayList<String> palabras = new ArrayList<String>(); 

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
		setTitle("Practica 4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 464);
		setResizable(false);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel panelTexto = new JPanel();
		panelTexto.setBounds(10, 11, 452, 215);
		mainPanel.add(panelTexto);
		panelTexto.setLayout(null);
		
		JLabel lblArchivoTexto = new JLabel("ARCHIVO DE TEXTO");
		lblArchivoTexto.setBounds(10, 11, 111, 23);
		panelTexto.add(lblArchivoTexto);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 45, 432, 119);
		panelTexto.add(textArea);
		
		JButton btnAnalizar = new JButton("ANALIZAR");
		btnAnalizar.setBounds(346, 175, 96, 29);
		panelTexto.add(btnAnalizar);
		
		JPanel panelRegex = new JPanel();
		panelRegex.setBounds(10, 237, 452, 177);
		mainPanel.add(panelRegex);
		panelRegex.setLayout(null);
		
		JLabel lblAnalizarDatos = new JLabel("ANALIZAR DATOS");
		lblAnalizarDatos.setBounds(10, 11, 102, 23);
		panelRegex.add(lblAnalizarDatos);
		
		JLabel lblRegex = new JLabel("EXPRESION REGULAR");
		lblRegex.setBounds(10, 45, 124, 23);
		panelRegex.add(lblRegex);
		
		textFieldRegex = new JTextField();
		textFieldRegex.setBounds(153, 43, 289, 23);
		panelRegex.add(textFieldRegex);
		textFieldRegex.setColumns(10);
		
		JLabel lblPalabras = new JLabel("NUMERO PALABRAS ENCONTRADAS");
		lblPalabras.setBounds(10, 79, 195, 23);
		panelRegex.add(lblPalabras);
		
		JLabel palabrasEncontradas = new JLabel("0");
		palabrasEncontradas.setBounds(229, 77, 124, 23);
		panelRegex.add(palabrasEncontradas);
		
		JLabel lblLista = new JLabel("LISTA DE PALABRAS");
		lblLista.setBounds(10, 113, 124, 23);
		panelRegex.add(lblLista);
		
		JList listPalabras = new JList();
		listPalabras.setBounds(132, 113, 310, 53);
		panelRegex.add(listPalabras);
		
		btnAnalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lenguaje lenguaje = new Lenguaje(textArea.getText(), textFieldRegex.getText());
				listPalabras.setModel(lenguaje.listarPalabras());
				palabrasEncontradas.setText(lenguaje.contarPalabras().toString());
				palabras.add(lenguaje.listarPalabras().toString());
			}
		});
		
	}
}
