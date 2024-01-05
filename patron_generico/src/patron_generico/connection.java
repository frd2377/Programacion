package patron_generico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class connection implements Configurable{

	private Archivos file;
	private Connection coneccion;
	private Statement statement;
	private ResultSet resultSet;
	private Generica<String, String> datosConeccion;
	
	public connection(String proyecto) {
		this.datosConeccion = new Generica<String, String>(proyecto);
		onInit();
	}

	private void onInit() {
		if (System.getProperty("os.name").split(" ")[0].equals("Windows")) {
			file = new Archivos("C:/"+nombreCarpeta);
		}else {
			file = new Archivos("/home/"+nombreCarpeta);
		}
		file.create(0);
		file = new Archivos(file.getFile().getAbsolutePath()+"/"+datosConeccion.getAtributo1()+".txt");
		if (file.create(1)) {
			String datos = "Proyecto="+datosConeccion.getAtributo1()+";ip=;port=;name=;user=;pasw=;driver=com.mysql.cj.jdbc.Driver;";
			try {
				file.writerFile(datos, true);
				runInitial();
			} catch (Exception e) {
				System.out.println("Error al escribir en e archivo: "+e);
			}
		}
		
	}

	private void runInitial() {
		try {
			
			datosConeccion.atributoArray1 = file.readerFile().split(";");
			String[] campos = {"PROYECT:","IP:","PORT:","NAME DATA BASE:","USER:","PASW:"};
			Scanner in = new Scanner(System.in);
			
			String dataProyect = "";
			while(true) {
				dataProyect = "";
				System.out.println("INGRESE LA SIGUIENTE INFORMACION: ");
				for (int i = 0; i < datosConeccion.atributoArray1.length; i++) {
					if (i == 0) {
						System.out.println(campos[i]+"="+datosConeccion.getAtributo1());
						dataProyect+= datosConeccion.atributoArray1[i].split("=")[0]+"="+datosConeccion.getAtributo1()+";";
					} else if (i>=1 && i<5) {
						System.out.println(campos[i]);
						dataProyect+= datosConeccion.atributoArray1[i].split("=")[0]+"="+in.next()+";"; 
					}else if (i==5) {
						System.out.println("PASSWORD?(Y/N):");
						if (in.next().toLowerCase().equals("y")) {
							System.out.println(campos[i]);
							dataProyect+= datosConeccion.atributoArray1[i].split("=")[0]+"="+in.next()+";"; 
						}else {
							dataProyect+= datosConeccion.atributoArray1[i].split("=")[0]+"= ;"; 
						}
					}else if (i==6) {
						dataProyect+=datosConeccion.atributoArray1[i]+";";
					}
					
				}
				System.out.println("ESTA ES LA INFORMACION PROPORCIONADA");
				for (String dato : dataProyect.split(";")) {
					System.out.println(dato);
				}
				System.out.println("LA INFORMACION ES CORRECTA? (Y/N):");
				if (in.next().toLowerCase().equals("y")) {
					break;
				}
			}
			
			System.out.println("EL SISTEMA PROCEDE A CREAR EL NUEVO ARCHIVO DE CONFIGURACION DE: "+datosConeccion.getAtributo1());
			file.writerFile(dataProyect, true);
			
		} catch (Exception e) {
			System.out.println("ERROR AL LEER EL ARCHIVO DEL PROYECTO: "+datosConeccion.getAtributo1());
		}
		
	}
	
	private String getUrl() {
		if (datosConeccion.atributoArray1[5].split("=")[1].equals(" ")) {
			datosConeccion.atributoArray1[5].split("=")[1] = "";
		}
		return String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s&useSSL=false&serverTimezone=UTC",
				datosConeccion.atributoArray1[1].split("=")[1],
				datosConeccion.atributoArray1[2].split("=")[1],
				datosConeccion.atributoArray1[3].split("=")[1],
				datosConeccion.atributoArray1[4].split("=")[1],
				datosConeccion.atributoArray1[5].split("=")[1]
				);
	}
	
	
	public Connection openConection() {
		try {
			datosConeccion.atributoArray1 = file.readerFile().split(";");
			Class.forName(datosConeccion.atributoArray1[6].split("=")[1]);
			coneccion = DriverManager.getConnection(getUrl());
			if (coneccion!=null) {
				System.out.println("Conexion Establecida");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coneccion;
	}
	
	
	public boolean setQuery(String query) {
		try {
			statement = openConection().createStatement();
			statement.execute(query);
			closeConn();
			return true;
		} catch (SQLException e) {
			System.out.println("Error al actualizar la bbdd"+e);
			return false;
		}
	}
	
	public boolean closeConn() { //Cerrar la coneccion a la bd
		if (coneccion != null) {
			try {
				coneccion.close();
				if (statement != null) {
					statement.close();
					return true;
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}else {
			return false;
		}
	}
	
	public ResultSet getQuery(String query) {
		try {
			statement = openConection().createStatement();
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Error al actualizar la bbdd"+e);
		}
		return resultSet;
	}
	
	
}
