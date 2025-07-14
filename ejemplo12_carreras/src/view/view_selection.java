package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.logic_view_run;
import controller.logic_view_slection;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class view_selection extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btn_mario;
	public JButton btn_yoshi;
	public JButton btn_monkey;

	public view_selection() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 212);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn_mario = new JButton("");
		btn_mario.setIcon(new ImageIcon(view_selection.class.getResource("/multimedia/mario.png")));
		btn_mario.setBounds(10, 11, 159, 154);
		contentPane.add(btn_mario);
		
		btn_yoshi = new JButton("");
		btn_yoshi.setIcon(new ImageIcon(view_selection.class.getResource("/multimedia/yoshi.png")));
		btn_yoshi.setBounds(179, 11, 159, 154);
		contentPane.add(btn_yoshi);
		
		btn_monkey = new JButton("");
		btn_monkey.setIcon(new ImageIcon(view_selection.class.getResource("/multimedia/monkey.png")));
		btn_monkey.setBounds(348, 11, 159, 154);
		contentPane.add(btn_monkey);
		logic_view_slection lvr=new logic_view_slection(this);
	}
}
