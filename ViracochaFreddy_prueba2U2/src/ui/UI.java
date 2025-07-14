package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;

public class UI extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextArea textArea;
	public JButton btnLeer;

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
		setBounds(100, 100, 549, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 46, 298, 396);
		contentPane.add(textArea);
		
		btnLeer = new JButton("Listar");
		btnLeer.setBounds(321, 46, 110, 42);
		contentPane.add(btnLeer);
		
		JLabel lblNewLabel = new JLabel("Palabras encontradas");
		lblNewLabel.setBounds(10, 21, 120, 14);
		contentPane.add(lblNewLabel);
		
		Controller controller = new Controller(this);
	}
	
}
