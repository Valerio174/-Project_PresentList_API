package be.walbertjossart.DAO;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Struct;
import java.sql.Types;
import java.util.ArrayList;

import javax.management.Query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import be.walbertjossart.JavaBeans.List_API;
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
	public boolean delete(Users_API obj) throws SQLException {
		return false;
	}

	@Override
	public boolean update(Users_API users) throws SQLException {
		 
 			return false;
		
	}


	@Override
	public Users_API find(int id_users) throws SQLException{
		//Create new Users_API object
		Users_API users = new Users_API();
		
		try{
			//Declare the query (the procedure/function)
			String query ="{? = call get_user_infos(?)}";
			
			//Call the query with prepareCallmethod
			CallableStatement callableStatement  = connect.prepareCall(query);
  		 
 			//Assign the IN PARAMETER
 			callableStatement.setInt(2, 25);
 			
			//Assign the OUT parameter
 			callableStatement.registerOutParameter(1, Types.ARRAY, "USERS_TYPES_TABLE".toUpperCase());
			 
 			//Execute the query
			callableStatement.executeUpdate();
			
			//Get an Array (in sql) who is the OUT return type of procedure/function
			Array array = callableStatement.getArray(1);
			
			//Get the ResulSet of this array
			ResultSet result = array.getResultSet();
					
			if(result.next()){ 
 				   Object tab = array.getArray(1, 1); 
 				   
				   //tableau est tableau Java 
				   Object[] datatab = (Object[])tab; 
				   
				   //ArrayList of Objects
				   ArrayList<Object> list = new ArrayList<>();

				   for(int i=0; i<datatab.length ; i++){ 
 				      Struct struct = (Struct) datatab[i];     
 				      
 				      for (Object object : struct.getAttributes()) {
 				    	  list.add(object);
 				      }
					}
				   
				   users = new Users_API(Integer.parseInt(list.get(0).toString()),
						   String.valueOf(list.get(1).toString()),
						   String.valueOf(list.get(2).toString()),
						   String.valueOf(list.get(3).toString()));
				      
						   
				ListDAO_API listDAO =new ListDAO_API(this.connect);		
				while(result.next()) {
					users.AddOwnList(listDAO.find(result.getInt("id_list")));
				}
				result = this.connect.createStatement(
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Guests WHERE id_users="+id_users);
 				while(result.next()) {
 					users.AddListAsGuest(listDAO.find(result.getInt("id_list")));
 				}
 				result = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM message WHERE id_users=" + id_users);
				MessageDAO_API messageDao = new MessageDAO_API(this.connect);
				while(result.next()) {
					users.AddMessage(messageDao.find(result.getInt("id_message")));
				}
			
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return users;
	}


	@Override
	public ArrayList<Users_API> findAll() throws SQLException, JsonProcessingException{
	
		ArrayList<Users_API> all_users = new ArrayList<>();
		
		try{	 
//			String[] columnName;
//			//Declare the query (the procedure/function)
//			String query ="{? = call get_emp_infos(900,1300)}";
//			
//			//Call the query with prepareCallmethod
//			CallableStatement callableStatement  = connect.prepareCall(query);
//  		 
//			//Assign the OUT parameter
// 			callableStatement.registerOutParameter(1, Types.ARRAY, "EMP_TYPES_TABLE".toUpperCase());
//			 
// 			//Execute the query
//			callableStatement.executeUpdate();
//			
//			//Get an Array (in sql) who is the OUT return type of procedure/function
//			Array array = callableStatement.getArray(1);
//			Object outputParamValue = array.getArray();
//			
//			//Get the ResulSet of this array
//			ResultSet result = array.getResultSet();
//			
//			//Execute the ResultSet..
//			 while(result.next()) {
//				 System.out.println("user trouvé");
//			 }
// 			
			//Declare the query (the procedure/function)
			String query ="{? = call get_user_infos(?)}";
			
			//Call the query with prepareCallmethod
			CallableStatement callableStatement  = connect.prepareCall(query);
  		 
 			//Assign the IN PARAMETER
 			callableStatement.setInt(2, 25);
 			
			//Assign the OUT parameter
 			callableStatement.registerOutParameter(1, Types.ARRAY, "USERS_TYPES_TABLE".toUpperCase());
			 
 			//Execute the query
			callableStatement.executeUpdate();
			
			//Get an Array (in sql) who is the OUT return type of procedure/function
			Array array = callableStatement.getArray(1);
			
			//Get the ResulSet of this array
			ResultSet result = array.getResultSet();
		
			//Create new Users_API object
			Users_API users = new Users_API();
			
			while(result.next()){ 
 				   Object tab = array.getArray(1, 1); 
 				   
				   //tableau est tableau Java 
				   Object[] datatab = (Object[])tab; 
				   
				   //ArrayList of Objects
				   ArrayList<Object> list = new ArrayList<>();

				   for(int i=0; i<datatab.length ; i++){ 
 				      Struct struct = (Struct) datatab[i];     
 				      
 				      for (Object object : struct.getAttributes()) {
 				    	  System.out.println(object.toString());
 				    	  list.add(object);
 				      }
					}
				   
				   users = new Users_API(Integer.parseInt(list.get(0).toString()),
						   String.valueOf(list.get(1).toString()),
						   String.valueOf(list.get(2).toString()),
						   String.valueOf(list.get(3).toString()));
				      
				}		
			
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
				Users_API users = this.find(result.getInt("id_users"));
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
