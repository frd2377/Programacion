package controllers;

import java.io.IOException;

import models.vehiculo;
import patron_V10.archivos;
import patron_V10.generica;

public class registroPlacas extends Thread implements parametrizable{
	private archivos file;
	private generica<String,?>dt_r;
	private generica<Double,?>gases;
	
	public registroPlacas(String...marcas) {
		try {
			file=new archivos("src/datos/vehiculos.txt");
			file.create(1);//Creación del archivo vehiculos
			file.writerFile("MARCA \t PLACA \t LAMBDA \t 02 \t N2O \t CO2#", true);
			dt_r=new generica<>();
			dt_r.atributoArray=marcas;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private int getIndexMarca() {
		return (int)(Math.random()*dt_r.atributoArray.length);
	}
	private int getNumeroPlaca() {
		return (int)(Math.random()*10);
	}
	private int getLetraPlaca() {
		return (int)(Math.random()*26);//26 por las letras del abcedario
	}
	private int getLetraInicioPlaca() {
		return (int)(Math.random()*24);//24 por las provincias
	}
	//Obtiene el valor aleatorio de lambda
	public double getValGases(int umbral) {
		return (Math.random()*umbral);
	}
	
	public void run() {
		dt_r.setAtributo1(dt_r.atributoArray[getIndexMarca()]);//Obtener la marca
		dt_r.setAtributo2(prov.split(",")[getLetraInicioPlaca()].toUpperCase());
		for(int i=0;i<2;i++) {
			dt_r.setAtributo2(dt_r.getAtributo2()+abc.split(",")[getLetraPlaca()].toUpperCase());
		}
		dt_r.setAtributo2(dt_r.getAtributo2()+"-");
		for(int i=0;i<4;i++) {
			dt_r.setAtributo2(dt_r.getAtributo2()+getNumeroPlaca());//Placa completa
		}
		vehiculo v=new vehiculo(
				dt_r.getAtributo1(),//Marca
				dt_r.getAtributo2(),//Placa
				getValGases(2),//Lambda
				getValGases(4),//O2
				getValGases(80),//N2O
				getValGases(30)//CO2
				);
		try {
			file.writerFile(v.toString(), false);
//			file.writerFile(dt_r.getAtributo1()+" "+dt_r.getAtributo2(), false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
