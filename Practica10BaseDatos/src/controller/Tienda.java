package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Producto;
import view.FrameTienda;

public class Tienda implements ItemListener,ActionListener{

	private FrameTienda frameTienda;
	private Producto producto = new Producto();
	
	public Tienda(FrameTienda frameTienda) {
		this.frameTienda = frameTienda;
		frameTienda.comboBoxProducts.addItemListener(this);
		frameTienda.btnAddProduct.addActionListener(this);
		loadProducts();
		loadPrice();
		loadTable();
		loadDataBuy();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(frameTienda.btnAddProduct)) {
			Double subtotal = Double.parseDouble(frameTienda.lblPrice.getText())*Double.parseDouble(frameTienda.textFieldAmount.getText());
			if (producto.saveBuy(Integer.parseInt(frameTienda.textFieldAmount.getText()), String.valueOf(frameTienda.comboBoxProducts.getSelectedItem()), Double.parseDouble(frameTienda.lblPrice.getText()), subtotal)) {
				JOptionPane.showConfirmDialog(frameTienda, "Save");
			}
			loadTable();
			loadDataBuy();
		}
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
	    if (e.getStateChange() == ItemEvent.SELECTED) {
	        System.out.println(frameTienda.comboBoxProducts.getSelectedItem());
	        loadPrice();
	    }
	}
	
	public void loadProducts() {
		ResultSet resultSet = producto.getProducts();
		try {
			while(resultSet.next()) {
				frameTienda.comboBoxProducts.addItem(resultSet.getObject(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void loadPrice() {
		ResultSet resultSet = producto.getPrice(frameTienda.comboBoxProducts.getSelectedItem().toString());
		try {
			while(resultSet.next()) {
				frameTienda.lblPrice.setText(resultSet.getObject(3).toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void loadTable() {
		ResultSet resultSet = producto.getBuys();
		
		try {
			DefaultTableModel defaultTableModel = loadDataTableFromResultSet(resultSet);
			frameTienda.table.setModel(defaultTableModel);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public DefaultTableModel loadDataTableFromResultSet(ResultSet resultSet, String... head) throws SQLException {
		ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
		
		String[] columnNames = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i);
        }
		      
		DefaultTableModel modelo = new DefaultTableModel(null, columnNames);

        while (resultSet.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            modelo.addRow(rowData);
        }
        
        return modelo;
    }
	
	public void loadDataBuy() {
		ResultSet resultSet = producto.getBuys();
		Double subtotal  = 0.0;
		Double iva =0.0;
		Double total =0.0;
		try {
			while(resultSet.next()) {
				System.out.println(resultSet.getDouble(4));
				subtotal += resultSet.getDouble(5);
			}
			
			iva = subtotal*0.12;
			total = subtotal + iva;
			frameTienda.lblSubtotal.setText(subtotal.toString());
			frameTienda.lbliva.setText(iva.toString());
			frameTienda.lblTotal.setText(total.toString());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
