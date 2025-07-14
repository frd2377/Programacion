package controller;
import java.awt.Color;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import patron_v_10.archivos;
import view.lienzo;
import view.view_run;
public class proceso_carrera extends Thread{

	private lienzo lienzo;
	private int cont=0, jugador=0;
	private view_run vr;
	private archivos file;
	private archivos filer=new archivos("src/datos/selected.txt");
	private Thread timer;
	private proceso_audio audio;
	private winners win;
	public proceso_carrera(String car, lienzo lienzo,view_run vr, winners win) {
		super(car);
		timer=new proceso_timer(vr);
		this.lienzo=lienzo;
		this.vr=vr;
		this.win=win;
		file=new archivos("src/data/winners.txt");
		try {
			file.writerFile("WINNERS",true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int valor() {
		cont+=(int)(Math.random()*30);//1.3
		return cont;
	}
	
	public void run() {
		try {
			sleep(5000);//tiempo de espera para los vehiculos
			if(getName().equals("mario_kart")) {
				audio=new proceso_audio("src/multimedia/audio/kart-mario.wav");
				timer.start();
				audio.start();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<35;i++) {//5000
			try {
				if(filer.readerFile().equals("yoshi\n")) {
					switch(getName()) {
					case "mario_kart"->lienzo.setX1(valor());
					case "monkey_kart"->lienzo.setX2(valor());
					case "yoshi_kart"->lienzo.setX3(jugador);
					case "toad_kart"->lienzo.setX4(valor());
					case "peach_kart"->lienzo.setX5(valor());
					case "bowser_kart"->lienzo.setX6(valor());
					}
					lienzo.repaint();
					try {
						sleep(1000);//
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(jugador>=512 || cont>=512) {
						break;
					}
				}else if(filer.readerFile().equals("monkey\n")) {
					switch(getName()) {
					case "mario_kart"->lienzo.setX1(valor());
					case "monkey_kart"->lienzo.setX2(jugador);
					case "yoshi_kart"->lienzo.setX3(valor());
					case "toad_kart"->lienzo.setX4(valor());
					case "peach_kart"->lienzo.setX5(valor());
					case "bowser_kart"->lienzo.setX6(valor());
					}
					lienzo.repaint();
					try {
						sleep(1000);//
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(jugador>=512 || cont>=512) {
						break;
					}
				}else if(filer.readerFile().equals("mario\n")) {
					switch(getName()) {
					case "mario_kart"->lienzo.setX1(jugador);
					case "monkey_kart"->lienzo.setX2(valor());
					case "yoshi_kart"->lienzo.setX3(valor());
					case "toad_kart"->lienzo.setX4(valor());
					case "peach_kart"->lienzo.setX5(valor());
					case "bowser_kart"->lienzo.setX6(valor());
					}
					lienzo.repaint();
					try {
						sleep(1000);//
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(jugador>=512 || cont>=512) {
						break;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
//		vr.btn_start.setEnabled(true);//activar el boton
		win.winner(getName());//Llama al metodo sync
		if (win.jugadores.size() == 5) {
			System.out.println(win.jugadores.get(0));
			JOptionPane.showMessageDialog(lienzo, win.jugadores.get(0), "Ganador:", JOptionPane.PLAIN_MESSAGE, new ImageIcon("src/multimedia/"+win.jugadores.get(0)+"_sf.png"));
			vr.lbl_min.setText("00".toString());
			vr.lbl_seg.setText("00".toString());
			vr.lbl_min_1.setText(":".toString());
			lienzo.setX1(0);
			lienzo.setX2(0);
			lienzo.setX3(0);
			lienzo.setX4(0);
			lienzo.setX5(0);
			lienzo.setX6(0);
			lienzo.setColor1(Color.white);
			lienzo.setColor2(Color.white);
			lienzo.setColor3(Color.white);
			lienzo.setColor4(Color.white);
			lienzo.setColor5(Color.white);
			lienzo.setColor6(Color.white);
			lienzo.repaint();
		}
		
//		try {
//			
//			file.writerFile(getName(), false);
//			String [] win=file.readerFile().split("\n");
////			timer.suspend();//suspende el hilo
////			audio.mute();//metodo para detener el audio
////			JOptionPane.showMessageDialog(lienzo,"WIN:"+win[1]);
//			lienzo.setWinner_photo(win[1]+"_sf");
//			sleep(2000);//para limpiar los campos
//			lienzo.setX1(0);
//			lienzo.setX2(0);
//			lienzo.setX3(0);
////			lienzo.setWinner_photo("");
//			lienzo.repaint();
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void setValJugador(int val) {
		this.jugador+=val;
	}
}
