package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.Tienda;

public class FrameTienda extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTable table;
	public JPanel panel;
	public JScrollPane scrollPane;
	public JComboBox comboBoxProducts;
	public JLabel lblPrice;
	public JButton btnAddProduct;
	public JLabel lblSubtotal;
	public JLabel lbliva;
	public JLabel lblTotal;
	public JTextField textFieldAmount;

	public FrameTienda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 11, 244, 407);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("PRODUCTO:");
		lblNewLabel_3.setBounds(10, 11, 74, 24);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("PRECIO:");
		lblNewLabel_3_1.setBounds(10, 63, 74, 24);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("CANTIDAD");
		lblNewLabel_3_2.setBounds(10, 116, 74, 24);
		panel.add(lblNewLabel_3_2);
		
		comboBoxProducts = new JComboBox();
		comboBoxProducts.setBounds(94, 12, 140, 22);
		panel.add(comboBoxProducts);
		
		lblPrice = new JLabel("0");
		lblPrice.setBounds(94, 68, 46, 14);
		panel.add(lblPrice);
		
		btnAddProduct = new JButton("AGREGAR");
		btnAddProduct.setBounds(112, 157, 122, 37);
		panel.add(btnAddProduct);
		
		textFieldAmount = new JTextField();
		textFieldAmount.setBounds(94, 118, 140, 20);
		panel.add(textFieldAmount);
		textFieldAmount.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(264, 11, 313, 258);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(264, 280, 313, 138);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SUBTOTAL:");
		lblNewLabel.setBounds(10, 11, 68, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IVA(12%):");
		lblNewLabel_1.setBounds(10, 51, 68, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL:");
		lblNewLabel_2.setBounds(10, 95, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		lblSubtotal = new JLabel("0");
		lblSubtotal.setBounds(257, 11, 46, 14);
		panel_1.add(lblSubtotal);
		
		lbliva = new JLabel("0");
		lbliva.setBounds(257, 51, 46, 14);
		panel_1.add(lbliva);
		
		lblTotal = new JLabel("0");
		lblTotal.setBounds(257, 95, 46, 14);
		panel_1.add(lblTotal);
		
		Tienda tienda = new Tienda(this);
		
	}
}
