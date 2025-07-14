package controller;

import java.util.ArrayList;

public class winners {

	private int position=1;
	public ArrayList<String> jugadores = new ArrayList<String>();
	
	public synchronized void winner(String name) {
		System.out.printf("Winner: %s Position: %d %n",name,position);
		jugadores.add(name);
		position++;
	}
	
}
