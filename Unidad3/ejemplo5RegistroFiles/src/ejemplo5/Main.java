package ejemplo5;

public class Main {
	public static void main(String[] args) {
		Thread [] hilos = new Thread[20];
		for (int i = 0; i < hilos.length; i++) {
			hilos[i] = new Proceso(50, "Hilo"+(i+1));
		}
		
		for (Thread hilo : hilos) {
			hilo.start();
		}
		
	}
}
