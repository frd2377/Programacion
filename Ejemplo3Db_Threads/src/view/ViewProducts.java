package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.LogicViewProduct;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;

public class ViewProducts extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldProduct;
	public JTextField textFieldPrice;
	public JTextField textFieldDescription;
	public JButton btnCreate;
	public JButton btnSelect;
	public JButton btnUpdate;
	public JButton btnDelete;
	public JSpinner spinnerUnits;
	public JTable tableWarning;
	private JScrollPane jScrollPaneWarning;

	public ViewProducts() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("View Register");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 422, 358);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRODUCT:");
		lblNewLabel.setBounds(10, 11, 90, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DESCRIPTION:");
		lblNewLabel_1.setBounds(10, 46, 90, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblPrice = new JLabel("PRICE:");
		lblPrice.setBounds(10, 92, 90, 14);
		panel.add(lblPrice);
		
		JLabel lblUnit = new JLabel("UNIT:");
		lblUnit.setBounds(218, 92, 57, 14);
		panel.add(lblUnit);
		
		textFieldProduct = new JTextField();
		textFieldProduct.setBounds(110, 8, 266, 28);
		panel.add(textFieldProduct);
		textFieldProduct.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(110, 85, 98, 28);
		panel.add(textFieldPrice);
		
		textFieldDescription = new JTextField();
		textFieldDescription.setColumns(10);
		textFieldDescription.setBounds(110, 43, 266, 28);
		panel.add(textFieldDescription);
		
		spinnerUnits = new JSpinner();
		spinnerUnits.setBounds(285, 85, 91, 28);
		panel.add(spinnerUnits);
		
		btnCreate = new JButton("CREATE");
		btnCreate.setBounds(10, 143, 89, 28);
		panel.add(btnCreate);
		
		btnSelect = new JButton("SELECT");
		btnSelect.setBounds(110, 143, 89, 28);
		panel.add(btnSelect);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(218, 143, 89, 28);
		panel.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.setBounds(317, 143, 89, 28);
		panel.add(btnDelete);
		
		JLabel lblWarning = new JLabel("WARNING");
		lblWarning.setBounds(10, 192, 90, 14);
		panel.add(lblWarning);
		
		tableWarning = new JTable();
		tableWarning.setForeground(new Color(0, 0, 0));
		tableWarning.setBounds(10, 217, 402, 130);
		panel.add(tableWarning);
		
		jScrollPaneWarning = new JScrollPane(tableWarning);
		jScrollPaneWarning.setBounds(tableWarning.getBounds());
		panel.add(jScrollPaneWarning);
		
		LogicViewProduct logicViewProduct  = new LogicViewProduct(this);
	}
}
