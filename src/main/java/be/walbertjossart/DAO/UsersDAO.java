package be.walbertjossart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import be.walbertjossart.JavaBeans.Users;
 
public class UsersDAO extends DAO<Users>{
	
	public UsersDAO(Connection conn) {
		super(conn);
 	}

	private static int nextId = 5;
	
	private static ArrayList<Users> users= new ArrayList<Users>();
	
	private static UsersDAO instance;
	
//	public static UsersDAO getInstance() {
//		if(instance == null) {
//			instance = new UsersDAO(connect);
//		}
//		return instance;
//	}
	
	
//	private UsersDAO() {
//		users.add(new Users(1,"John","Doe","john.doe@gmail.com"));
//		users.add(new Users(2,"Sarah","Conor","sarah.conor@yahoo.fr"));
//		users.add(new Users(3,"Jack","Sparrow","jack.sparrow@outlook.com"));
//		users.add(new Users(4,"Laurent","Masset","masset.laurent@gmail.com"));
//		
//	}
	
//	public ArrayList<Users> getAll(){
//		ArrayList<Users> all_users = new ArrayList<>();
//		
//		try{
//			PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM passenger;");
//			ResultSet resultSet = preparedStatement.executeQuery();
//			
//			while(resultSet.next()){ 
//					Users newuser =  new Users(resultSet.getInt("flightid"), resultSet.getString("flightnumber"), resultSet.getString("depart_from"), resultSet.getString("scheduled_time") );
//					all_users.add(newuser);
//			}
// 		}
//		catch(SQLException e){
//			e.printStackTrace();
//		}
//		
//		return all_users;
//	}



	@Override
	public boolean create(Users obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Users obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean update(Users obj) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Users find(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ArrayList<Users> findAll() {
		ArrayList<Users> all_users = new ArrayList<>();
		
		try{
			PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM flight");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){ 
					Users newuser =  new Users(resultSet.getInt("flightid"), resultSet.getString("flightnumber"), resultSet.getString("depart_from"), resultSet.getString("scheduled_time") );
					all_users.add(newuser);
			}
 		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return all_users;
	}
	
}
