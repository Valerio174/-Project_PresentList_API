package be.walbertjossart.JavaBeans;

import java.io.Serializable;
import java.util.ArrayList;

public class Message_API implements Serializable {

	/*Attributs*/
	private static final long serialVersionUID = -1676868000897287743L;
 	private int id_message;
	private String content; 
	private Users_API users;
	
	/*Constructor(s)*/
	public Message_API() {}
	public Message_API(int id_message, String content, Users_API users) {
		this.id_message = id_message;
		this.content =content;
		this.users = users;
	}
	
	/*Getters/Setters*/
	public int getIdMessage() {
		return id_message;
	}
	public void setId(int id_message) {
		this.id_message = id_message;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Users_API getUsers() {
		return users;
	}
	public void setUsers(Users_API users) {
		this.users = users;
	}
	
	/*Methods*/

}
