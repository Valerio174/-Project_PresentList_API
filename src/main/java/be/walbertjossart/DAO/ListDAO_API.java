package be.walbertjossart.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import be.walbertjossart.JavaBeans.List_API;

public class ListDAO_API extends DAO<List_API>{

	public ListDAO_API(Connection conn) {
		super(conn);
 	}

	@Override
	public boolean create(List_API list) throws SQLException {
		CallableStatement stmt = connect.prepareCall("{call Insert_list(?,?,?,?,?)}");	 
		
		stmt.setDate(1, Date.valueOf(list.getLimit_date()));
		stmt.setString(2, list.getOccasion());
		stmt.setString(3, list.getState());
		stmt.setInt(4, list.getOwner().getId());
		
		stmt.registerOutParameter(5, java.sql.Types.VARCHAR);
		
		stmt.executeUpdate();
 
		
		if(stmt.getString(5).equals("TRUE")) {
			return true;
		}
		else {
 			return false;
		}
	}

	@Override
	public boolean delete(List_API obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(List_API obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List_API find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List_API> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
