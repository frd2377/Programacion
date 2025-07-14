package model;

import java.sql.ResultSet;

import patron_generico.Generica;
import patron_generico.connection;

public class Producto {

	public Generica<String, String> datosProducto = new Generica<String, String>();
	public connection connection = new connection("practica10");
	
	public Producto() {
		
	}
	
	public ResultSet getProducts() {
		return connection.getQuery("select * from tienda.productos");
	}
	
	public ResultSet getPrice(String producto) {
		return connection.getQuery("select * from tienda.productos where nombre= '"+producto+"' limit 1");
	}
	
	public ResultSet getBuys() {
		return connection.getQuery("select * from tienda.compras");
	}
	
	public boolean saveBuy(Integer cantidad, String desc, Double valU, Double subtotal) {
		return connection.setQuery("insert into tienda.compras values(null, " + cantidad + ", '" + desc + "', " + valU + ", " + subtotal + ")");
	}
	
}
