package be.walbertjossart.DAO;

import be.walbertjossart.JavaBeans.Users;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;

	public abstract DAO<Users> getUsersDAO();

//	public abstract DAO<List> getListDAO();

//	public abstract DAO<Message> getMessageDAO();
//	
//	public abstract DAO<Present> getPresentDAO();
	
	public static AbstractDAOFactory getFactory(int type){
		switch(type){
		case DAO_FACTORY:
			return new DAOFactory();
			default:
				return null;
		}
	}
}
