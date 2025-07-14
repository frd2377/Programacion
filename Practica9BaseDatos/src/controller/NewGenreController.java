package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.HandlerDb;
import view.NewGenreView;
import view.NewMovieView;
import view.SelectView;

public class NewGenreController implements ActionListener{

	private SelectView selectView;
	private NewGenreView newGenreView;
	private HandlerDb handlerDb = new HandlerDb();
	
	public NewGenreController(SelectView selectView, NewGenreView newGenreView) {
		this.selectView = selectView;
		this.newGenreView = newGenreView;
		newGenreView.btnSave.addActionListener(this);
		newGenreView.btnCancel.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String genre = newGenreView.textFieldGenreName.getText();
		
		if (e.getSource().equals(newGenreView.btnSave)) {
			handlerDb.setQuery(String.format("insert into netflix.genre values(null,'%s')",genre));
			JOptionPane.showConfirmDialog(newGenreView, "SAVE GENRE "+genre,null,1);
			newGenreView.setVisible(false);
			selectView.setVisible(true);
		}
		
		else if (e.getSource().equals(newGenreView.btnCancel)) {
			newGenreView.setVisible(false);
			selectView.setVisible(true);
		}
		
	}
	
}
