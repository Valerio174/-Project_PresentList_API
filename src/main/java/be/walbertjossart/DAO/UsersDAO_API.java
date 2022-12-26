package be.walbertjossart.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.walbertjossart.JavaBeans.Users_API;
  
public class UsersDAO_API extends DAO<Users_API>{
	private static UsersDAO_API instance;


	public UsersDAO_API getInstance() {
		if(instance == null) {
			instance = new UsersDAO_API(connect);
		}
		return instance;
	}
	public UsersDAO_API(Connection conn) {
		super(conn);
 	} 

	@Override
	public boolean create(Users_API users) throws SQLException {
		CallableStatement stmt = connect.prepareCall("{call Insert_user(?,?,?,?)}");	 
		
		stmt.setString(1, users.getPseudo());
		stmt.setString(2, users.getPassword());
		stmt.setString(3, users.getEmail());
		
		stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
		
		stmt.executeUpdate();
 
		
		if(stmt.getString(4).equals("TRUE")) {
			return true;
		}
		else {
 			return false;
		}
		
 	}


	@Override
	public boolean delete(Users_API obj) {
		return false;
	}

	@Override
	public boolean update(Users_API obj) {
		return false;
	}


	@Override
	public Users_API find(int id) {
		return null;
	}


	@Override
	public ArrayList<Users_API> findAll() {
		ArrayList<Users_API> all_users = new ArrayList<>();
		
		try{	 
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM flight");
			while(result.next()){
				 
					System.out.println(result.getString("flightnumber"));
				
			}
			//String query ="{? = call get_emp_infos(900,1300)}";
			//CallableStatement callableStatement  = connect.prepareCall(query);
  		 
 			//callableStatement.registerOutParameter(1, Types.ARRAY, "EMP_TYPES1");
			 
			//callableStatement.execute();
			
			//get employee name
			
//			while(rs.next()) {
//				String empName = callableStatement.getString(1);
//				System.out.println("Emp Name: " + empName);
//			}
			 
			
			//close connection
			
   		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return all_users;
	}
	

	/******PARTICULAR METHODS FOR Users*******/
	
	public Users_API GetUser(String pseudo, String password) {
		 
		try{
			ResultSet result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT id_users, pseudo, password, email "
							+ "FROM Users WHERE pseudo = '" + pseudo + "' AND password = ora_hash('" + password +"')");
			if(result.first()) {
				Users_API users = new Users_API(result.getInt("id_users"), result.getString("pseudo"), result.getString("password"), result.getString("email"));
					return users;
				}
			else
				return null;
		
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	 
	
}
