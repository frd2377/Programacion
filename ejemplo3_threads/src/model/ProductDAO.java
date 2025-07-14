package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import patron_generico.Generica;
import patron_generico.connection;

public class ProductDAO {
	
	private Product product;
	private ResultSet resultSet;
	private connection connection = new connection("ejemplo3_g2");
	
	public ProductDAO(Product product) {
		this.product = product;
	}
	
	public ProductDAO() {
		
	}
	
	public boolean registerProduct() {
		return connection.setQuery(String.format("insert into tienda.product values(null,'%s','%s','%s',%d)", 
				product.getName(),
				product.getDesc(),
				String.valueOf(product.getPrice()),
				product.getStock()));
	}
	
	public List<Product> getProducts(){
		 List<Product> products = new ArrayList<Product>();
		 resultSet = connection.getQuery("select * from tienda.product");
		 try {
			while(resultSet.next()) {
				 products.add(new Product(
						 resultSet.getInt(1),
						 resultSet.getString(2),
						 resultSet.getString(3),
						 Double.parseDouble(resultSet.getString(4)),
						 resultSet.getInt(5)
						 ));
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public boolean updateProduct() {
		return connection.setQuery(String.format("update tienda.product set product='%s', description='%s', price='%s', stock=%d where id_product=%d",
				product.getName(),
				product.getDesc(),
				product.getPrice(),
				product.getStock(),
				product.getId()
				));
	}
	
	public boolean deleteProduct() {
		return connection.setQuery("delete from tienda.product where id_product="+product.getId());
	}
	
	public Product getProductById(String id){
		ResultSet resultSet = connection.getQuery("select * from tienda.product where id_product="+id);
		if (!resultSet.equals(null)) {
			try {
				while(resultSet.next()) {
					return product = new Product(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getInt(5));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return new Product();
	}
	
	
	
}



















