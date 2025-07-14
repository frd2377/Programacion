package practica2;

import clase_generica.Generica;

public class Almacen {
	private Generica<Long, String> datosAlmacen;
	public Almacen(Long idEmpresa, String nombreEmpresa) {
		datosAlmacen = new Generica<Long, String>(idEmpresa,nombreEmpresa);
	}
	
	public Long getID() {
		return datosAlmacen.getAtributo1();
	}
	
	public String getNombreEmpr() {
		return datosAlmacen.getAtributo2();
	}
	
	public void setID(Long id) {
		datosAlmacen.setAtributo1(id);
	}
	
	public void setNombreEmpr(String nombreEmpresa) {
		datosAlmacen.setAtributo2(nombreEmpresa);
	}
	
}
