package practica2;

import clase_generica.Generica;

public class Juguete extends Almacen{
	
	private Generica<Double,String> datosJuguete;
	
	public Juguete(Long idEmpresa,String nombreEmpresa,String nombreJuguete,Double precio,Integer stock) {
		super(idEmpresa,nombreEmpresa);
		datosJuguete = new Generica<Double, String>(precio,nombreJuguete);
		datosJuguete.setAtributo3(stock.doubleValue());
	}
	
	public double getPrecio() {
		return unboxingDouble(datosJuguete.getAtributo1());
	}
	
	public String getNombre() {
		return datosJuguete.getAtributo2();
	}
	
	public Integer getStock() {
		return boxingInteger(datosJuguete.getAtributo3().intValue());
	}
	
	public void reStock(Integer cant) {
		datosJuguete.setAtributo3(cant.doubleValue());
	}
	
	public void ventas(Integer cantidadComprar) {
		Double Iva = getPrecio()*0.12;
		Double totalIva = getPrecio()+Iva;
		print("Factura Jugueteria","\n","Valor Unitario: ",String.valueOf(getPrecio())," Iva 12%: ",String.valueOf(totalIva)," Unidades Compradas: #",String.valueOf(cantidadComprar)," Precio A Pagar: $",String.valueOf(cantidadComprar*totalIva),"\n");
	}
	
	public void mostrarDatos() {
		print("Id.-",String.valueOf(getID())," Fabrica: ",getNombreEmpr()," Designacion: ",getNombre()," Precio: ",String.valueOf(getPrecio())," Stock: "+String.valueOf(getStock())," Precio Final (Incl Iva): ",String.valueOf(getPrecio()*0.12),"\n");
	}
	
	public Integer boxingInteger(int dato) {
		return Integer.valueOf(dato);
	}
	
	public double unboxingDouble(Double dato) {
		return dato.doubleValue();
	}
	
	private void print(String... args) {
		for (String arg : args) {
			System.out.print(arg);
		}
	}
	
	
}
