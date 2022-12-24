package be.walbertjossart.DAO;

import java.sql.Connection;

import be.walbertjossart.JavaBeans.List;
import be.walbertjossart.JavaBeans.Message;
import be.walbertjossart.JavaBeans.Present;
import be.walbertjossart.JavaBeans.Users_API;
 
public class DAOFactory_API extends AbstractDAOFactory_API{
	protected static final Connection conn = be.walbertjossart.Connection.ProjectConnection.getInstance();
	
	public DAO<Users_API> getUsersDAO_API(){
		return new UsersDAO_API(conn);
	}
	
	public DAO<List> getListDAO_API(){
		return new ListDAO_API(conn);
	}
	
	public DAO<Message> getMessageDAO_API(){
		return new MessageDAO_API(conn);
	}
	
	public DAO<Present> getPresentDAO_API() {
		return new PresentDAO_API(conn);
	}

 
}
