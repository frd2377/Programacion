package controller;

import view.view_run;

public class proceso_timer extends Thread{

	private view_run vr;

	public proceso_timer(view_run vr) {
		super();
		this.vr = vr;
	}
	
	public void run() {
		for(int min=1;min<5;min++) {
			for(int seg=0;seg<60;seg++) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(seg<10) {
					vr.lbl_seg.setText("0"+seg);
				}else {
					vr.lbl_seg.setText(String.valueOf(seg));
				}
				
			}
			vr.lbl_min.setText("0"+min);
		}
	}
}
