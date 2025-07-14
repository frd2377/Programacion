package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.HandlerDb;
import view.NewGenreView;
import view.NewMovieView;
import view.SelectView;

public class NewMovieController implements ActionListener{

	private SelectView selectView;
	private NewMovieView newMovieView;
	private HandlerDb handlerDb = new HandlerDb();
	private HashMap<String, Integer> data = new HashMap<String, Integer>();
	
	public NewMovieController(SelectView selectView, NewMovieView newMovieView) {
		this.selectView = selectView;
		this.newMovieView = newMovieView;
		newMovieView.btnSave.addActionListener(this);
		newMovieView.btnCancel.addActionListener(this);
		init();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(newMovieView.btnSave)) {
			
			handlerDb.setQuery(String.format("insert into netflix.movie values(null, %d, '%s', '%s', %d, %d)",
					data.get(newMovieView.comboBoxGenre.getSelectedItem()),
					newMovieView.textFieldTitle.getText(),
					newMovieView.textAreaSummary.getText(),
					newMovieView.spinnerDuration.getValue(),
					newMovieView.spinnerYear.getValue()
					));
			JOptionPane.showConfirmDialog(newMovieView, "SAVE MOVIE");
			newMovieView.setVisible(false);
			selectView.setVisible(true);
		}
		
		else if (e.getSource().equals(newMovieView.btnCancel)) {
			newMovieView.setVisible(false);
			selectView.setVisible(true);
		}
		
	}
	
	public void init() {
		ResultSet resultSet = handlerDb.getGenres();
		try {
			while (resultSet.next()) {
				data.put(resultSet.getString(2),Integer.parseInt(resultSet.getString(1)));
				newMovieView.comboBoxGenre.addItem(resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public DefaultTableModel setJtable(ResultSet resultSet) throws Exception {	
		ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
		
		String[] columnNames = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i);
        }
		
		DefaultTableModel modelo = new DefaultTableModel(null, columnNames);

        while (resultSet.next()) {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            modelo.addRow(rowData);
        }
        
        return modelo;
	}
	
	
}
