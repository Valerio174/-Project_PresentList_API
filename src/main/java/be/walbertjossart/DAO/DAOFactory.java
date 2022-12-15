package be.walbertjossart.DAO;

import java.sql.Connection;

import be.walbertjossart.JavaBeans.Users;

public class DAOFactory extends AbstractDAOFactory{
	protected static final Connection conn = be.walbertjossart.Connection.ProjectConnection.getInstance();
	
	public DAO<Users> getUsersDAO(){
		return new UsersDAO(conn);
	}
	
//	public DAO<List> getListDAO(){
//		return new ListDAO(conn);
//	}
	
//	public DAO<Message> getMessageDAO(){
//		return new MessageDAO(conn);
//	}
	
//	public DAO<Present> getPresent() {
//		return new PresentDAO(conn);
//	}
	
}
