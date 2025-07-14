package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import patron_v_10.archivos;
import view.view_run;
import view.view_selection;
import view.lienzo;

public class logic_view_run implements ActionListener,configurable, KeyListener{

	private view_run vr;
	private view_selection vs;
	private archivos filer=new archivos("src/datos/selected.txt");
	private lienzo lienzo;//Declarar la clase lienzo
	private int cont=0;
	private boolean flag=false;//controlar la salida del vehiculo
	private Thread car1, car2,car4,car5,car6,begin;//Carros del computador
	private proceso_carrera car3,cart1, cart2;//Jugador
	
	
	public logic_view_run(view_run vr) {
		super();
		
		this.vr = vr;
		this.vr.btn_pause.addActionListener(this);
		this.vr.btn_start.addActionListener(this);
		this.vr.btn_resume.addActionListener(this);
		this.vr.btn_start.addKeyListener(this);
		this.lienzo=vr.pn_lienzo;//Instanciar la clase lienzo
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vr.btn_pause) {
//			msg(vr, "PAUSE");
//			flag=false;
			car1.suspend();
			car2.suspend();
			car3.suspend();
			car4.suspend();
			car5.suspend();
			car6.suspend();
		}else if(e.getSource()==vr.btn_start) {
//			msg(vr, "START");
//			vr.btn_start.setEnabled(false);//bloqueo del boton
			inicio();//setear la posición del jugador
			winners win=new winners();
			flag=true;//habilitar al juegador
			begin=new proceso_begin(lienzo);//Invoca la instancia al hilo proceso_begin
			car1=new proceso_carrera("mario_kart",lienzo,vr,win);
			car2=new proceso_carrera("monkey_kart",lienzo,vr,win);
			car3=new proceso_carrera("yoshi_kart",lienzo,vr,win);
			car4=new proceso_carrera("toad_kart",lienzo,vr,win);
			car5=new proceso_carrera("peach_kart",lienzo,vr,win);
			car6=new proceso_carrera("bowser_kart",lienzo,vr,win);
			
			
			begin.start();
			car1.start();
			car2.start();
			vr.btn_resume.setEnabled(false);
			car3.start();
			car4.start();
			car5.start();
			car6.start();
			
		}else if(e.getSource()==vr.btn_resume) {
//			msg(vr, "RESUME");
//			flag=true;
			car1.resume();
			car2.resume();
			car3.resume();
			car4.resume();
			car5.resume();
			car6.resume();
			
//			vr.btn_resume.setEnabled(false);
//			vr.btn_pause.setEnabled(true);
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==e.VK_RIGHT && flag) {
			try {
				if(filer.readerFile().equals("yoshi\n")) {
					car3.setValJugador(1);
				}else if(filer.readerFile().equals("monkey\n")) {
					((proceso_carrera) car2).setValJugador(1);
				}else if(filer.readerFile().equals("mario\n")) {
					((proceso_carrera) car1).setValJugador(1);
				}
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void inicio() {
		cont=0;
		this.lienzo.setX3(cont);
	}
	
}
