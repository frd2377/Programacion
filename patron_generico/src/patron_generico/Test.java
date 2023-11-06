package patron_generico;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		Archivos a1 = new Archivos("C:\\Respaldo\\Grupo2-ProgramacionAplicada\\Frd\\patron_generico\\doc");
		//a1.create(0);
		/*try {
			a1.writerFile("prueba 3", false);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		/*try {
			System.out.println(a1.readerFile());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		
		/*if (a1.validacionByER("171957700-1", "[01]\\d{8}-?\\d$")) {
			System.out.println("Accept");
		}else {
			System.out.println("No accept");
		}*/
		
		/*try {
			a1.writerFile(a1.searchReplace(a1.readerFile(), "testeo", "pruebas"), true);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		//a1.create(1);
		
		/*try {
			a1.writerFile("Existen tres modos verbales: indicativo, subjuntivo e imperativo. El modo indicativo se utiliza para narrar hechos, procesos o estados que se consideran reales. El modo subjuntivo se utiliza para expresar sentimientos, pensamientos, emociones, deseos, pedidos, dudas y suposiciones. El modo imperativo se utiliza para dar órdenes y consejos.\r\n"
					+ "\r\n"
					+ "Fuente: https://www.ejemplos.co/parrafos-cortos/#ixzz8HjiCPXEQ", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Generica<String, ?> datos = new Generica<>();
		/*try {
			datos.setElementos(a1.findWords(a1.readerFile(),"^\\w{4}$"));
			datos.listarElementos(datos.getElementos());
			System.out.println(datos.getElementos().size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*datos.setElementos(a1.listFilesoDirectory(0));
		datos.listarElementos(datos.getElementos());*/
		
		a1.getFileChooser(null, "txt");
		try {
			System.out.println(a1.readerFile());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
