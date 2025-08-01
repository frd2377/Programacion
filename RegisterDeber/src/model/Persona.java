package model;

import java.util.Date;

import patron_generico.*;

public class Persona {
	
	private Generica<String, Long> datos1 = new Generica<String, Long>();
	private Generica<Integer, Date> datos2 = new Generica<Integer, Date>();
	
	
	public Persona(String names,Long dni,String email, Integer age) {
		datos1 = new Generica<String, Long>(names, email, dni);
		datos2.setAtributo1(age);
		datos2.setAtributo3(new Date());
	}

	public String getNames() {
		return datos1.getAtributo1();
	}


	public void setNames(String names) {
		datos1.setAtributo1(names);
	}

	public Long getDni() {
		return datos1.getAtributo3();
	}

	public void setDni(Long dni) {
		datos1.setAtributo3(dni);
	}


	public String getEmail() {
		return datos1.getAtributo2();
	}


	public void setEmail(String email) {
		datos1.setAtributo2(email);
	}


	public Integer getAge() {
		return datos2.getAtributo1();
	}


	public void setAge(Integer age) {
		datos2.setAtributo1(age);
	}
	
	@Override
	public String toString() {
		return String.format("%s;%d;%s;%d;%n Created:%s", getNames(),getDni(),getEmail(),getAge(),getCreated());
	}


	private Date getCreated() {
		return datos2.getAtributo3();
	}
	
}
