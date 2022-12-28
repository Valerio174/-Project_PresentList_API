package be.walbertjossart.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import be.walbertjossart.JavaBeans.List_API;
import be.walbertjossart.JavaBeans.Present_API;
import be.walbertjossart.JavaBeans.Users_API;

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
    public boolean update(List_API list) throws SQLException {
        
        CallableStatement stmt = connect.prepareCall("{call Update_list(?,?,?,?,?)}");
        
        stmt.setInt(1, list.getId_list());
        stmt.setDate(2, Date.valueOf(list.getLimit_date()));
        stmt.setString(3, list.getOccasion());
        stmt.setString(4, list.getState());
        
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
    public List_API find(int id) throws SQLException {
        List_API l = new List_API();
        ResultSet result = this.connect.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY).executeQuery(" SELECT list.id_list, list.limit_date, list.occasion, "
                		+ "list.state, list.id_users FROM list INNER JOIN Users on list.id_users =users.id_users "
                		+ "WHERE users.id_users="+id);
        if(result.first()) {            
            l = new List_API(result.getInt("id_list"), 
            		result.getDate("limit_date").toLocalDate(), 
            		result.getString("occasion"),
            		result.getString("state"),
            		new Users_API(),
            		new Users_API(), 
            		new Present_API());
            
         }
        return l;
    }

	@Override
	public ArrayList<List_API> findAll() {
 		return null;
	}

}
