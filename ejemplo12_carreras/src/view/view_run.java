package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.logic_view_run;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;

public class view_run extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public lienzo pn_lienzo;
	public JButton btn_start;
	public JButton btn_pause;
	public JButton btn_resume;
	public JPanel pn_time;
	public JPanel pn_control;
	public JLabel lbl_min;
	public JLabel lbl_seg;
	private logic_view_run lvr;
	public JLabel lbl_min_1;

	
	public view_run() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Carrera de Autos");
		setBounds(100, 100, 735, 805);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pn_control = new JPanel();
		pn_control.setBounds(10, 98, 88, 354);
		contentPane.add(pn_control);
		pn_control.setLayout(null);
		
		btn_start = new JButton("GO");
		btn_start.setForeground(SystemColor.text);
		btn_start.setBackground(new Color(0, 0, 0));
		btn_start.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_start.setBounds(0, 24, 89, 74);
		pn_control.add(btn_start);
		
		btn_pause = new JButton("||");
		btn_pause.setForeground(SystemColor.text);
		btn_pause.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_pause.setBackground(new Color(0, 0, 0));
		btn_pause.setBounds(0, 130, 89, 74);
		pn_control.add(btn_pause);
		
		btn_resume = new JButton(">");
		btn_resume.setForeground(SystemColor.text);
		btn_resume.setFont(new Font("Tahoma", Font.BOLD, 30));
		btn_resume.setBackground(new Color(0, 0, 0));
		btn_resume.setBounds(0, 236, 89, 74);
		pn_control.add(btn_resume);
		
		pn_lienzo = new lienzo();
		pn_lienzo.setBounds(97, 99, 616, 660);
		contentPane.add(pn_lienzo);
		
		pn_time = new JPanel();
		pn_time.setBounds(108, 11, 603, 74);
		contentPane.add(pn_time);
		pn_time.setLayout(null);
		
		lbl_min = new JLabel("00");
		lbl_min.setForeground(new Color(0, 0, 255));
		lbl_min.setFont(new Font("Tahoma", Font.BOLD, 80));
		lbl_min.setBounds(368, 0, 109, 74);
		pn_time.add(lbl_min);
		
		lbl_seg = new JLabel("00");
		lbl_seg.setForeground(new Color(218, 165, 32));
		lbl_seg.setFont(new Font("Tahoma", Font.BOLD, 80));
		lbl_seg.setBounds(494, 0, 109, 74);
		pn_time.add(lbl_seg);
		
		lbl_min_1 = new JLabel(":");
		lbl_min_1.setForeground(new Color(255, 255, 0));
		lbl_min_1.setFont(new Font("Tahoma", Font.BOLD, 80));
		lbl_min_1.setBounds(469, 0, 29, 74);
		pn_time.add(lbl_min_1);
		
		lvr=new logic_view_run(this);
	}
}
