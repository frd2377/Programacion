package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SelectViewController;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;

public class SelectView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JRadioButton rdbtnMovies;
	public JRadioButton rdbtnGenre;
	public JTextField textFieldSql;
	public JTable tableData;
	public JButton btnNewGenre;
	public JButton btnNewMovie;
	public JTextField textFieldFilter;
	public JButton btnQuery;
	public ButtonGroup buttonGroup;
	public JRadioButton rdbtnSql;
	
	public SelectView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnMovies = new JRadioButton("MOVIES");
		rdbtnMovies.setBounds(6, 7, 109, 23);
		contentPane.add(rdbtnMovies);
		
		rdbtnGenre = new JRadioButton("GENRE");
		rdbtnGenre.setBounds(6, 33, 109, 23);
		contentPane.add(rdbtnGenre);
		
		textFieldSql = new JTextField();
		textFieldSql.setBounds(80, 63, 420, 28);
		contentPane.add(textFieldSql);
		textFieldSql.setColumns(10);
		
		btnQuery = new JButton("SQL");
		btnQuery.setBounds(510, 63, 89, 28);
		contentPane.add(btnQuery);
		
		tableData = new JTable();
		tableData.setBounds(6, 102, 593, 215);
		contentPane.add(tableData);
		
		btnNewGenre = new JButton("NEW GENRE");
		btnNewGenre.setBounds(312, 328, 122, 28);
		contentPane.add(btnNewGenre);
		
		btnNewMovie = new JButton("NEW MOVIE");
		btnNewMovie.setBounds(444, 328, 122, 28);
		contentPane.add(btnNewMovie);
		
		textFieldFilter = new JTextField();
		textFieldFilter.setEnabled(false);
		textFieldFilter.setColumns(10);
		textFieldFilter.setBounds(193, 328, 109, 28);
		contentPane.add(textFieldFilter);
		
		JLabel lblNewLabel = new JLabel("FILTER:");
		lblNewLabel.setBounds(137, 335, 46, 14);
		contentPane.add(lblNewLabel);
		
		rdbtnSql = new JRadioButton("SQL");
		rdbtnSql.setBounds(6, 59, 68, 32);
		contentPane.add(rdbtnSql);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnMovies);
		buttonGroup.add(rdbtnGenre);
		buttonGroup.add(rdbtnSql);
		
		SelectViewController selectViewController = new SelectViewController(this);
		
	}
}
