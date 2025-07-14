package ejemplo1ClaseThread;

public class Proceso extends Thread{
	
	public Proceso(String msg) {
		super(msg);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Thread: "+getName()+" index: "+i);
		}
	}
	
}
