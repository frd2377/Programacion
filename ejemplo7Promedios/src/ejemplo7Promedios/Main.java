package ejemplo7Promedios;

public class Main {

	public static void main(String[] args) {
		String [] names = {"RENATA MENDEZ", "ANDREA MORALES", "PAUL CASCO", "LAURA GOMEZ"};
		long [] dnis = {1716975502,1715984425,1514954425,1715849925};
		
		Proceso [] procesos = new Proceso[4];
		
		for (int i = 0; i < procesos.length; i++) {
			procesos[i] = new Proceso(new Persona(names[i], dnis[i]), "Hilo: "+(i+1));
		}
		
		for (Proceso proceso : procesos) {
			proceso.start();
		}
		
	}
	
}
