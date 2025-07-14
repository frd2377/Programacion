package ejemplo2InterfazRunneable;

public class Proceso implements Runnable{
	
	private Thread hilo;
	
	public Proceso(String msg) {
		hilo = new Thread(msg);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread: "+hilo.getName()+" index: "+i);
		}
	}
	
}
