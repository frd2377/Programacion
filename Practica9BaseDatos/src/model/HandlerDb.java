package model;

import java.sql.ResultSet;

import patron_generico.connection;

public class HandlerDb {

	private connection connection = new connection("Practica9");
	
	public HandlerDb() {
		
	}
	
	
	public ResultSet getMovies() {
		return connection.getQuery("select * from netflix.movie");
	}


	public ResultSet getGenres() {
		return connection.getQuery("select * from netflix.genre");
	}
	
	public ResultSet query(String sql) {
		return connection.getQuery(sql);
	}
	
	public boolean setQuery(String sql) {
		return connection.setQuery(sql);
	}
	
}
