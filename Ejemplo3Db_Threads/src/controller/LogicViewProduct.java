package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Product;
import model.ProductDAO;
import patron_generico.Configurable;
import view.ViewProducts;

public class LogicViewProduct implements ActionListener,Configurable{

	private ViewProducts viewProducts;
	private ProductDAO productDAO = new ProductDAO();
	
	public LogicViewProduct(ViewProducts viewProducts) {
		this.viewProducts = viewProducts;
		viewProducts.btnCreate.addActionListener(this);
		viewProducts.btnSelect.addActionListener(this);
		viewProducts.btnUpdate.addActionListener(this);
		viewProducts.btnDelete.addActionListener(this);
		Thread process1 = new ProcessStock(viewProducts);
		process1.start();
	}
	
	// 1.- Al presionar select debemos pedir el id del producto a buscar y pintar los datos en la pantalla
	// 2.- clear dates
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(viewProducts.btnCreate)) {
			
			if (checkTextFields()) {
				productDAO = new ProductDAO(new Product(
						1,
						viewProducts.textFieldProduct.getText(),
						viewProducts.textFieldDescription.getText(),
						Double.parseDouble(viewProducts.textFieldPrice.getText()),
						Integer.parseInt(viewProducts.spinnerUnits.getValue().toString())
						));
				if (productDAO.registerProduct()) {
					msg(viewProducts, "Producto Registrado");
					clear();
				}
			}
		}
		
		else if (e.getSource().equals(viewProducts.btnSelect)) {
			String id = input();
			Product selectProduct = productDAO.getProductById(id);
			viewProducts.textFieldProduct.setText(selectProduct.getName());
			viewProducts.textFieldDescription.setText(selectProduct.getDesc());
			viewProducts.textFieldPrice.setText(selectProduct.getPrice().toString());
			viewProducts.spinnerUnits.setValue(selectProduct.getStock());
		}
		
		else if (e.getSource().equals(viewProducts.btnUpdate)) {
			String id = input();
			productDAO = new ProductDAO(new Product(
					Integer.parseInt(id), 
					viewProducts.textFieldProduct.getText(), 
					viewProducts.textFieldDescription.getText(), 
					Double.parseDouble(viewProducts.textFieldPrice.getText()), 
					Integer.parseInt(viewProducts.spinnerUnits.getValue().toString())
					));
			
			if (productDAO.updateProduct()) {
				msg(viewProducts, "Product update");
				clear();
			}else {
				msg(viewProducts, "Error update");
			}
		}
		
		else if (e.getSource().equals(viewProducts.btnDelete)) {
			String id = input();
			Product selectProduct = productDAO.getProductById(id);
			viewProducts.textFieldProduct.setText(selectProduct.getName());
			viewProducts.textFieldDescription.setText(selectProduct.getDesc());
			viewProducts.textFieldPrice.setText(selectProduct.getPrice().toString());
			viewProducts.spinnerUnits.setValue(selectProduct.getStock());
			int opcion = JOptionPane.showConfirmDialog(viewProducts, "Delete Product?");
			if (opcion==0) {
				productDAO.deleteProduct();
				msg(viewProducts, "Product Delete");
				clear();
			}else {
				clear();
			}
			
		}
		
	}
	
	public void clear() {
		viewProducts.textFieldProduct.setText("");
		viewProducts.textFieldDescription.setText("");
		viewProducts.textFieldPrice.setText("");
		viewProducts.spinnerUnits.setValue(0);
	}
	
	public String input() {
		String val = JOptionPane.showInputDialog(viewProducts,"Ingrese el id: ");
		return val;
	}
	
	public boolean checkTextFields() {
	    if (isNullOrEmptyOrWhitespace(viewProducts.textFieldProduct.getText()) ||
	        isNullOrEmptyOrWhitespace(viewProducts.textFieldDescription.getText()) ||
	        isNullOrEmptyOrWhitespace(viewProducts.textFieldPrice.getText())) {
	        return false;
	    }
	    return true;
	}

	private boolean isNullOrEmptyOrWhitespace(String text) {
	    return text == null || text.trim().isEmpty();
	}
	
	@Override
	public void msg(JFrame view, String msg) {
		JOptionPane.showMessageDialog(view, msg);
	}

}
