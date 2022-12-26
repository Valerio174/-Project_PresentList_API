package be.walbertjossart.DAO;

import be.walbertjossart.JavaBeans.List_API;
import be.walbertjossart.JavaBeans.Message_API;
import be.walbertjossart.JavaBeans.Present_API;
import be.walbertjossart.JavaBeans.Users_API;
import be.walbertjossart.api.UsersAPI;

public abstract class AbstractDAOFactory_API {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;

	public abstract DAO<Users_API> getUsersDAO_API();

	public abstract DAO<List_API> getListDAO_API();

	public abstract DAO<Message_API> getMessageDAO_API();

	public abstract DAO<Present_API> getPresentDAO_API();
	
	public static AbstractDAOFactory_API getFactory(int type){
		switch(type){
		case DAO_FACTORY:
			return new DAOFactory_API();
			default:
				return null;
		}
	}
}
