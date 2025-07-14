package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import patron_v_10.archivos;
import view.view_run;
import view.view_selection;

public class logic_view_slection implements ActionListener{
	private view_selection vs;
	private view_run vr=new view_run();
	private archivos file ;
	
	public logic_view_slection(view_selection vs) {
		super();
		file=new archivos("src/datos/selected.txt");
		file.create(1);
		this.vs=vs;
		this.vs.btn_mario.addActionListener(this);
		this.vs.btn_monkey.addActionListener(this);
		this.vs.btn_yoshi.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(vs.btn_mario)) {
			System.out.println("mario");
			try {
				file.writerFile("mario",true);
				vs.dispose();
				vr.setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(e.getSource().equals(vs.btn_monkey)) {
			System.out.println("monkey");
			try {
				file.writerFile("monkey",true);
				vs.dispose();
				vr.setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource().equals(vs.btn_yoshi)) {
			System.out.println("yoshi");
			try {
				file.writerFile("yoshi",true);
				vs.dispose();
				vr.setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} 
	}

}
