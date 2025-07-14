package practica5Hilos;

import java.io.File;

import patron.Archivos;
import patron.Generica;

public class GeneradorInformes extends Thread{
	
	private Generica<String,Integer> datos = new Generica<>();
	private Archivos file = new Archivos("src/files");
	
	public GeneradorInformes(String mecanico,String[] vehiculos,Integer index) {
		datos.setAtributo1(mecanico);
		datos.setAtributo3(index);
		datos.atributoArray1 = vehiculos;
		loadData();
	}
	
	@Override
	public void run () {
		file.setFile(new File(file.getFile().getPath()+"/"+datos.getAtributo1()+".txt"));
		file.create(1);
		String texto = datos.getAtributo1()+"\n";
		
		for (int i = 0; i < datos.getElementos().size(); i++) {
			texto += ((i+1)+" "+datos.getElementos().get(i)+"\n");
		}
		
		for (String fila : datos.getElementos()) {
			String[] columna = fila.split(" ");
			texto += "Porcentaje% \nVehiculo: "+columna[0]+"\nPlaca: "+columna[1]+"\n";
			
			for (int i = 0; i < columna.length; i++) {
				switch (i) {
				case 2:
					texto += "\tL: ";
					if (getPorcentaje(1.0, 2.0,Double.parseDouble(columna[i])).doubleValue() <= 70.0) {
						
						if (getPorcentaje(1.0, 2.0,Double.parseDouble(columna[i])).doubleValue() <= 0.0) {
							texto += "\t0% Pasa en Primera Revisión\n";
						}else {
							texto += "\t"+getPorcentaje(1.0, 2.0,Double.parseDouble(columna[i]))+"% Pasa en Primera Revisión\n";
						}
						
					}else if (getPorcentaje(1.0, 2.0,Double.parseDouble(columna[i])).doubleValue() > 70){
						if (getPorcentaje(1.0, 2.0,Double.parseDouble(columna[i])) >= 100 ) {
							texto += "\t100% Segunda Revisión Asignada\n";
						}else {
							texto += "\t"+getPorcentaje(1.0, 2.0,Double.parseDouble(columna[i]))+"% Segunda Revisión Asignada\n";
						}
					}
					break;
				case 3:
					texto += "\tO2 ";
					
					if (getPorcentaje(2.0, 4.0,Double.parseDouble(columna[i])).doubleValue() <= 30.0) {
						if (getPorcentaje(2.0, 4.0,Double.parseDouble(columna[i])).doubleValue() <= 0) {
							texto += "\t0% Pasa en Primera Revisión\n";
						} else {
							texto += "\t"+getPorcentaje(2.0, 4.0,Double.parseDouble(columna[i]))+"% Pasa en Primera Revisión\n";
						}
						
					}else if (getPorcentaje(2.0, 4.0,Double.parseDouble(columna[i])).doubleValue() > 30.0) {
						if (getPorcentaje(2.0, 4.0,Double.parseDouble(columna[i])) >= 100 ) {
							texto += "\t100% Segunda Revisión Asignada\n";
						}else {
							texto += "\t"+getPorcentaje(2.0, 4.0,Double.parseDouble(columna[i]))+"% Segunda Revisión Asignada\n";
						}
					}
					
					break;
				case 4:
					texto += "\tN2O ";
					if (getPorcentaje(40.0, 80.0,Double.parseDouble(columna[i])).doubleValue() <= 80.0) {
						
						if (getPorcentaje(40.0, 80.0,Double.parseDouble(columna[i])) <= 0) {
							texto += "\t0% Pasa en Primera Revisión\n";
						} else {
							texto += "\t"+getPorcentaje(40.0, 80.0,Double.parseDouble(columna[i]))+"% Pasa en Primera Revisión\n";
						}
						
						
					}else if (getPorcentaje(40.0, 80.0,Double.parseDouble(columna[i])).doubleValue() > 80.0) {
						if (getPorcentaje(40.0, 80.0,Double.parseDouble(columna[i])) >= 100 ) {
							texto += "\t100% Segunda Revisión Asignada\n";
						}else {
							texto += "\t"+getPorcentaje(40.0, 80.0,Double.parseDouble(columna[i]))+"% Segunda Revisión Asignada\n";
						}
					}
					
					break;
				case 5:
					texto += "\tCO2 ";
					if (getPorcentaje(15.0, 30.0,Double.parseDouble(columna[i])).doubleValue() <= 50.0) {
						if (getPorcentaje(15.0, 30.0,Double.parseDouble(columna[i])) <= 0) {
							texto += "\t0% Pasa en Primera Revisión\n";
						} else {
							texto += "\t"+getPorcentaje(15.0, 30.0,Double.parseDouble(columna[i]))+"% Pasa en Primera Revisión\n";
						}
					} else if (getPorcentaje(15.0, 30.0,Double.parseDouble(columna[i])).doubleValue() > 50.0) {
						if (getPorcentaje(15.0, 30.0,Double.parseDouble(columna[i])) >= 100 ) {
							texto += "\t100% Segunda Revisión Asignada\n";
						}else {
							texto += "\t"+getPorcentaje(15.0, 30.0,Double.parseDouble(columna[i]))+"% Segunda Revisión Asignada\n";
						}
					}
					break;
				}
			}
		}
		System.out.println(texto);
		try {
			file.writerFile(texto, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Double getPorcentaje(Double param, Double x1, Double x2) {
	    Double r1 = x1 - param;
	    Double r2 = x2 - param;
	    if (r2 <= 0) {
			return 0.0;
		}
	    Double porcentaje = ((r2 * 100) / r1);
	    porcentaje = Math.round(porcentaje * 100.0) / 100.0;
	    return porcentaje;
	}
	
	private void loadData() {
		for (int i = datos.getAtributo3(); i < datos.getAtributo3()+5; i++) {
			datos.addElemntos(datos.atributoArray1[i]);
		}
	}
	
}
