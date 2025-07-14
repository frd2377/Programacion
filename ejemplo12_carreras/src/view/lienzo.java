package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class lienzo extends JPanel{

	private int x1=0, x2=0, x3=0, x4=0, x5=0, x6=0;
	private Color color1=Color.white,color2=Color.white,color3=Color.white,color4=Color.white,color5=Color.white,color6=Color.white;
	private String winner_photo="";
	
	public void setWinner_photo(String winner_photo) {
		this.winner_photo = winner_photo;
	}
	public void setColor1(Color color1) {
		this.color1 = color1;
	}
	public void setColor2(Color color2) {
		this.color2 = color2;
	}
	public void setColor3(Color color3) {
		this.color3 = color3;
	}
	public void setColor4(Color color4) {
		this.color4 = color4;
	}
	public void setColor5(Color color5) {
		this.color5 = color5;
	}
	public void setColor6(Color color6) {
		this.color6 = color6;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public void setX3(int x3) {
		this.x3 = x3;
	}
	public void setX4(int x4) {
		this.x4 = x4;
	}
	public void setX5(int x5) {
		this.x5 = x5;
	}
	public void setX6(int x6) {
		this.x6 = x6;
	}
	public lienzo() {
		this.setBounds(0,0,592,358);
		repaint();
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.magenta);
		g.setFont(new Font("Comic",Font.BOLD,20));
		g.drawString("COMPETENCIA", 200, 20);
		int [] posYpista = {25,105,185,265,345,425,505,585};
		int [] posXpista = {65,502,512,572,0,0,0,0};
		g.setColor(Color.black);
		for(int linea=0;linea<8;linea++) {
			g.fillRect(10, posYpista[linea], 572, 5);
			g.fillRect(posXpista[linea], 25, 10, 485);
		}
		
		g.setColor(color1);
		g.fillRect(10, 40, 50, 50);
		ImageIcon car1 = new ImageIcon("src/multimedia/mario_kart_sf.png");
		g.drawImage(car1.getImage(), 10+x1, 40, 50, 50, null);
		
		g.setColor(color2);
		g.fillRect(10, 120, 50, 50);
		ImageIcon car2 = new ImageIcon("src/multimedia/monkey_kart_sf.png");
		g.drawImage(car2.getImage(), 10+x2, 120, 50, 50, null);
		
		g.setColor(color3);
		int []x= {10,10,60,60};
		int []y= {250,200,200,250};
		g.fillPolygon(x, y, 4);
		ImageIcon car3 = new ImageIcon("src/multimedia/yoshi_kart_sf.png");
		g.drawImage(car3.getImage(), 10+x3, 200, 50, 50, null);
		ImageIcon img= new ImageIcon("src/multimedia/fondo.png");//IMAGEN DE FONDO
		g.drawImage(img.getImage(), 0, 520, null);
		
		g.setColor(color4);
		g.fillRect(10, 280, 50, 50);
		ImageIcon car4 = new ImageIcon("src/multimedia/toad_kart_sf.png");
		g.drawImage(car4.getImage(), 10+x4, 280, 50, 50, null);
		
		g.setColor(color5);
		g.fillRect(10, 360, 50, 50);
		ImageIcon car5 = new ImageIcon("src/multimedia/peach_kart_sf.png");
		g.drawImage(car5.getImage(), 10+x5, 360, 50, 50, null);
		
		g.setColor(color6);
		g.fillRect(10, 440, 50, 50);
		ImageIcon car6 = new ImageIcon("src/multimedia/bowser_kart_sf.png");
		g.drawImage(car6.getImage(), 10+x6, 440, 50, 50, null);
		
		if(!winner_photo.equals("")) {
			g.setColor(Color.ORANGE);
			g.setFont(new Font("Comic",Font.BOLD,30));
			g.drawString("WIN!!!"+winner_photo, 200, 70);
			ImageIcon winner=new ImageIcon("src/multimedia/"+winner_photo+".png");	
			g.drawImage(winner.getImage(), 200, 100, 200, 200, null);
		}
		
	}
	
}
