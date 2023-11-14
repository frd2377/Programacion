package ejemplo3MetodoSleep;

public class Proceso extends Thread{
	
	public Proceso(String msg) {
		super(msg);
	}
	
	@Override
	public void run() {
		System.out.println("Inicia: "+getName());
	
		try {
			sleep(2000);
			for (int i = 0; i < 5; i++) {
				sleep(2000);
				System.out.println(currentThread()+" index: "+i);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
