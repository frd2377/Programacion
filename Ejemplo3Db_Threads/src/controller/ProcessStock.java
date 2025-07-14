package controller;

import java.util.List;

import model.Product;
import model.ProductDAO;
import patron_generico.Configurable;
import view.ViewProducts;

public class ProcessStock extends Thread implements Configurable{

	private ViewProducts viewProducts;
	private List<Product> products;
	private ProductDAO productDAO;
	
	public ProcessStock(ViewProducts viewProducts) {
		this.viewProducts = viewProducts;
		productDAO = new ProductDAO();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				sleep(500);
				products = productDAO.getProducts();
				String [][] data = new String[products.size()][4];
				int index = 0;
				for (Product product : products) {
					if (product.getStock()>3) {
						data[index][0] = String.valueOf(product.getId());
						data[index][1] = product.getName();
						data[index][2]= String.valueOf(product.getStock());
						data[index][3]= String.valueOf(product.getDesc());
						index++;
					}
				}
				viewProducts.tableWarning.setModel(loadDataTable(data, "id","product","stock","warning"));
			} catch (Exception e) {
				System.out.println("Thread Error "+e);
			}
		}
	}
	
}
