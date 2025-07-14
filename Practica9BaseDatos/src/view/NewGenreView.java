package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.NewGenreController;
import controller.NewMovieController;

public class NewGenreView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldGenreName;
	public JButton btnSave;
	public JButton btnCancel;
	public SelectView selectView;

	
	public NewGenreView(SelectView selectView) {
		this.selectView = selectView;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 326, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("NEW GENRE");
		lblNewLabel.setBounds(10, 11, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME:");
		lblName.setBounds(10, 59, 51, 14);
		contentPane.add(lblName);
		
		textFieldGenreName = new JTextField();
		textFieldGenreName.setBounds(71, 53, 188, 23);
		contentPane.add(textFieldGenreName);
		textFieldGenreName.setColumns(10);
		
		btnSave = new JButton("SAVE");
		btnSave.setBounds(71, 104, 89, 23);
		contentPane.add(btnSave);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(170, 104, 89, 23);
		contentPane.add(btnCancel);
		
		NewGenreController newGenreController = new NewGenreController(selectView,this);
	}

}
