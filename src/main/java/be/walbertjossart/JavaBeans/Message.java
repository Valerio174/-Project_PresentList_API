package be.walbertjossart.JavaBeans;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {

	/*Attributs*/
	private static final long serialVersionUID = -1676868000897287743L;
 	private int id_message;
	private String content; 
	private Users users;
	
	/*Constructor(s)*/
	public Message() {}
	public Message(int id_message, String content, Users users) {
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
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	/*Methods*/

}
