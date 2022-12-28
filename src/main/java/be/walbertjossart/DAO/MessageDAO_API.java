package be.walbertjossart.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import be.walbertjossart.JavaBeans.List_API;
import be.walbertjossart.JavaBeans.Message_API;
import be.walbertjossart.JavaBeans.Present_API;
import be.walbertjossart.JavaBeans.Users_API;

public class MessageDAO_API extends DAO<Message_API> {

	public MessageDAO_API(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Message_API obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Message_API obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Message_API obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Message_API find(int id) throws SQLException {
		Message_API m = new Message_API();
	        ResultSet result = this.connect.createStatement(
	                ResultSet.TYPE_SCROLL_INSENSITIVE,
	                ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT Message.id_message, Message.content, Users.id_users, Users.pseudo, Users.password, Users.email"
	                		+ "  FROM Message inner join Users on message.id_users = users.id_users WHERE Message.id_message = " + id);
	        if(result.first()) {            
	            m = new Message_API(result.getInt("id_message"), 
	            		result.getString("content"), 
	            		new Users_API(result.getInt("id_users"), result.getString("pseudo"),result.getString("password"), result.getString("email")));
	            
 	         }
	        return m;
	}

	@Override
	public ArrayList<Message_API> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
