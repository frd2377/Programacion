package ejemplo5;

import javax.swing.DefaultListModel;

import patron_generico.Generica;

public class Empleado {
	
	private Generica<String> datos1_ejmpl;
	private Generica<Long> datos2_ejpml;
	private Generica<Integer> datos3_ejmpl;
	private Generica<Empleado> empleados;
	
	public Empleado() {
		empleados = new Generica<Empleado>();
	}
	
	public Empleado(String nombre, long cedula, int edad) {
		datos1_ejmpl = new Generica<String>(nombre);
		datos2_ejpml = new Generica<Long>(cedula);
		datos3_ejmpl = new Generica<Integer>(edad);
		//empleados = new Generica<Empleado>();
	}
	
	public void setDireccion(String direccion) {
		datos1_ejmpl.setAtributo2(direccion);
	}
	
	public void setCodigoAcceso(long codigo) {
		datos2_ejpml.setAtributo2(codigo);
	}
	
	public String getNombre() {
		return datos1_ejmpl.getAtributo1();
	}
	
	public long getCedula() {
		return datos2_ejpml.getAtributo1();
	}
	
	public int getEdad() {
		return datos3_ejmpl.getAtributo1();
	}
	
	public String getDireccion() {
		return datos1_ejmpl.getAtributo2();
	}
	
	public long getCodigoAcceso() {
		return datos2_ejpml.getAtributo2();
	}
	
	public void listar() {
		empleados.listarElementos(empleados.getElementos());
	}
	
	public boolean add(Empleado empl) {
		return empleados.addElemntos(empl);
	}
	
	public DefaultListModel cargarEmpleados() {
		return empleados.listarElementosList(empleados.getElementos());
	}
	
	@Override
	public String toString() {
		return getNombre()+", "+getCedula()+", "+getCodigoAcceso()+", "+getEdad()+", "+getDireccion();
	}
	
}
