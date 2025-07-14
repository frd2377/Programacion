package model;

import patron_generico.Generica;

public class Product {
	
	private Generica<String, String> datosProducto = new Generica<String, String>();
	private Integer id = 0;

	public Product(Integer id, String name, String description, Double price, Integer stock) {
		datosProducto.setAtributo1(name);
		datosProducto.setAtributo2(description);
		datosProducto.setAtributo3(price.toString());
		datosProducto.setAtributo4(stock.toString());
		this.id = id;
	}
	
	public Product() {
		datosProducto.setAtributo1("");
		datosProducto.setAtributo2("");
		datosProducto.setAtributo3("0");
		datosProducto.setAtributo4("0");
	}

	public String getName() {
		return datosProducto.getAtributo1();
	}

	public String getDesc() {
		return datosProducto.getAtributo2();
	}

	public Double getPrice() {
		return Double.parseDouble(datosProducto.getAtributo3());
	}

	public Integer getStock() {
		return Integer.parseInt(datosProducto.getAtributo4());
	}

	public Integer getId() {
		return id;
	}

}
