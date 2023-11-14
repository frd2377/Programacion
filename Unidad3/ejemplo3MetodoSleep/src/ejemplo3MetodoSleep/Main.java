package ejemplo3MetodoSleep;


public class Main {
	
	public static void main(String[] args) {
		Thread hilo1 = new Proceso("Hilo 1");
		Thread hilo2 = new Proceso("Hilo 2");
		Thread hilo3 = new Proceso("Hilo 3");
		
		try {
			hilo1.start();
			hilo1.sleep(4000);
			hilo2.start();
			hilo2.sleep(4000);
			hilo3.start();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
