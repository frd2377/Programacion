package ejemplo4SleepRunneable;

public class Proceso implements Runnable{

	public Thread hilo;
	
	public Proceso(String msg) {
		hilo = new Thread(msg);
	}
	
	@Override
	public void run() {
		System.out.println("Inicia: "+hilo.getName());
		try {
			hilo.sleep(2000);
			for (int i = 0; i < 5; i++) {
				hilo.sleep(2000);
				System.out.println(hilo.currentThread()+" index: "+i);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
