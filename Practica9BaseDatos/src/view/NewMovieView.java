package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.NewGenreController;
import controller.NewMovieController;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;

public class NewMovieView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnSave;
	public JButton btnCancel;
	public JTextField textFieldTitle;
	public JComboBox comboBoxGenre;
	public JTextArea textAreaSummary;
	public JSpinner spinnerYear;
	public JSpinner spinnerDuration;
	public SelectView selectView;

	public NewMovieView(SelectView selectView) {
		this.selectView = selectView;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("NEW MOVIE");
		lblNewLabel.setBounds(10, 11, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("GENRE:");
		lblName.setBounds(10, 40, 51, 14);
		contentPane.add(lblName);
		
		btnSave = new JButton("SAVE");
		btnSave.setBounds(71, 333, 107, 33);
		contentPane.add(btnSave);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(188, 333, 108, 33);
		contentPane.add(btnCancel);
		
		JLabel lblTitle = new JLabel("TITLE:");
		lblTitle.setBounds(10, 65, 51, 14);
		contentPane.add(lblTitle);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		textFieldTitle.setBounds(71, 69, 249, 23);
		contentPane.add(textFieldTitle);
		
		comboBoxGenre = new JComboBox();
		comboBoxGenre.setBounds(71, 36, 249, 22);
		contentPane.add(comboBoxGenre);
		
		JLabel lblSummary = new JLabel("SUMMARY:");
		lblSummary.setBounds(10, 111, 89, 14);
		contentPane.add(lblSummary);
		
		textAreaSummary = new JTextArea();
		textAreaSummary.setBounds(71, 106, 249, 105);
		contentPane.add(textAreaSummary);
		
		JLabel lblNewLabel_1 = new JLabel("YEAR:");
		lblNewLabel_1.setBounds(10, 237, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("DURATION:");
		lblNewLabel_1_1.setBounds(10, 279, 77, 14);
		contentPane.add(lblNewLabel_1_1);
		
		spinnerDuration = new JSpinner();
		spinnerDuration.setBounds(71, 276, 89, 20);
		contentPane.add(spinnerDuration);
		
		spinnerYear = new JSpinner();
		spinnerYear.setBounds(71, 234, 89, 20);
		contentPane.add(spinnerYear);
		
		NewMovieController newMovieController = new NewMovieController(selectView,this);
		
	}
}
