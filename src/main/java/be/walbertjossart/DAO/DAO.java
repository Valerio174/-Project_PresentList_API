package be.walbertjossart.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class DAO<T> {
	protected Connection connect = null;

	public DAO(Connection conn){
		this.connect = conn;
	}
	
	public abstract boolean create(T obj) throws SQLException;
	
	public abstract boolean delete(T obj) throws SQLException;
	
	public abstract boolean update(T obj)throws SQLException ;
	
	public abstract T find(int id) throws SQLException;
	
	public abstract ArrayList<T> findAll() throws SQLException, JsonProcessingException;
}