package be.walbertjossart.JavaBeans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import be.walbertjossart.DAO.AbstractDAOFactory_API;
import be.walbertjossart.DAO.DAO;
 
public class Users_API implements Serializable {
	
	/*Attributs*/
	private static final long serialVersionUID = -3471872605497920096L;
	private int id;
	private String pseudo;
	private String password;
	private String email;
	private ArrayList<List>own_lists;
	private ArrayList<List>as_guest_lists;
	private ArrayList<List>messages;
	static AbstractDAOFactory_API adf = AbstractDAOFactory_API.getFactory(AbstractDAOFactory_API.DAO_FACTORY);
	static DAO<Users_API> usersDAO = adf.getUsersDAO_API();
	
	/*Constructor(s)*/
	public Users_API() {}
	public Users_API(int id, String pseudo, String password, String email) {
		this.id = id;
		this.pseudo = pseudo;
		this.password = password;
		this.email = email;
		own_lists = new ArrayList<>();
		as_guest_lists = new ArrayList<>();
		messages = new ArrayList<>();
	}
	public Users_API(String pseudo, String password, String email) {
 		this.pseudo = pseudo;
		this.password = password;
		this.email = email;
		own_lists = new ArrayList<>();
		as_guest_lists = new ArrayList<>();
		messages = new ArrayList<>();
	}
	
	/*Getters/Setters*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<List> getOwn_lists() {
		return own_lists;
	}
	public void setOwn_lists(ArrayList<List> own_lists) {
		this.own_lists = own_lists;
	}
	public ArrayList<List> getAs_guest_lists() {
		return as_guest_lists;
	}
	public void setAs_guest_lists(ArrayList<List> as_guest_lists) {
		this.as_guest_lists = as_guest_lists;
	}
	public ArrayList<List> getMessages() {
		return messages;
	}
	public void setMessages(ArrayList<List> messages) {
		this.messages = messages;
	}

	
	/*Methods*/
	public boolean insertUsers() throws SQLException {
		return usersDAO.create(this);
	}
	public static ArrayList<Users_API> getAll(){
		return usersDAO.findAll();
	}
//	public void AddOwnList(List new_list) {
//		own_lists.add(new_list);
//	}
//	
//	public void AddListAsGuest(List new_list) {
//		as_guest_lists.add(new_list);
//	}
//	public void AddMessage(Message new_message) {
//	as_guest_lists.add(new_message);
//}
}