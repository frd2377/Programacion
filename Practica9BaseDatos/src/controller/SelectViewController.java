package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import model.HandlerDb;
import view.NewGenreView;
import view.NewMovieView;
import view.SelectView;

public class SelectViewController implements ActionListener{
	
	private SelectView selectView;
	private HandlerDb handlerDb = new HandlerDb();
	
	public SelectViewController(SelectView selectView) {
		this.selectView= selectView;
		selectView.btnQuery.addActionListener(this);
		selectView.rdbtnGenre.addActionListener(this);
		selectView.rdbtnMovies.addActionListener(this);
		selectView.rdbtnSql.addActionListener(this);
		selectView.btnNewGenre.addActionListener(this);
		selectView.btnNewMovie.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(selectView.btnQuery) && selectView.rdbtnSql.isSelected()) {
			ResultSet resultSet = handlerDb.query(selectView.textFieldSql.getText());
			try {
				selectView.tableData.setModel(setJtable(resultSet));
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource().equals(selectView.rdbtnMovies)) {
			System.out.println("movie");
			ResultSet resultSet = handlerDb.getMovies();
			try {
				selectView.tableData.setModel(setJtable(resultSet));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		else if (e.getSource().equals(selectView.rdbtnGenre)) {
			ResultSet resultSet = handlerDb.getGenres();
			try {
				selectView.tableData.setModel(setJtable(resultSet));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource().equals(selectView.btnNewGenre)) {
			NewGenreView genreView = new NewGenreView(selectView);
			selectView.setVisible(false);
			genreView.setVisible(true);
		}
		
		else if (e.getSource().equals(selectView.btnNewMovie)) {
			System.out.println("movie");
			NewMovieView newMovieView = new NewMovieView(selectView);
			selectView.setVisible(false);
			newMovieView.setVisible(true);
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
	
	public void printResultSet(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
			    System.out.println(resultSet.getObject(1)+" "+resultSet.getObject(2)+" "+resultSet.getObject(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
