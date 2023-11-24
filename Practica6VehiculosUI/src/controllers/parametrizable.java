package controllers;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public interface parametrizable {
	
	public  String abc="a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z",
						prov="a,b,u,c,x,h,o,e,w,g,i,l,r,m,v,n,s,p,q,k,t,z,y,j";
	
	public default void msg(JFrame view,String texto) {
		JOptionPane.showMessageDialog(view, texto);
	}

}
