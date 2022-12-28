package be.walbertjossart.JavaBeans;

import java.awt.Image;
import java.io.Serializable;
import java.sql.SQLException;

import be.walbertjossart.DAO.AbstractDAOFactory_API;
import be.walbertjossart.DAO.DAO;

public class Present_API implements Serializable{

	/*Attributs*/
	private static final long serialVersionUID = -2220492601912596085L;
	private int id_present;
	private String name;
	private String description;
	private double average_price;
	private int priority;
	private int state;
	private String link;
	private Image image;
	private List_API list;
	static AbstractDAOFactory_API adf = AbstractDAOFactory_API.getFactory(AbstractDAOFactory_API.DAO_FACTORY);
	static DAO<Present_API> presentDAO = adf.getPresentDAO_API();
	
	/*Getters/Setters*/
	public int getId_present() {
		return id_present;
	}
	public void setId_present(int id_present) {
		this.id_present = id_present;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAverage_price() {
		return average_price;
	}
	public void setAverage_price(double average_price) {
		this.average_price = average_price;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public List_API getList() {
		return list;
	}
	public void setList(List_API list) {
		this.list = list;
	}
	
	/*Constructor(s)*/
	public Present_API() {}
	/*With ALL attributs*/
	public Present_API(int id_present, String name, String description, double average_price, int priority, int state,
			String link, Image image, List_API list) {
 		this.id_present = id_present;
		this.name = name;
		this.description = description;
		this.average_price = average_price;
		this.priority = priority;
		this.state = state;
		this.link = link;
		this.image = image;
		this.list =list;
	}
	/*Without link*/
	public Present_API(int id_present, String name, String description, double average_price, int priority, int state,
			  Image image, List_API list) {
 		this.id_present = id_present;
		this.name = name;
		this.description = description;
		this.average_price = average_price;
		this.priority = priority;
		this.state = state;
 		this.image = image;
		this.list =list;
	}
	/*Without image*/
	public Present_API(int id_present, String name, String description, double average_price, int priority, int state,
			String link, List_API list) {
 		this.id_present = id_present;
		this.name = name;
		this.description = description;
		this.average_price = average_price;
		this.priority = priority;
		this.state = state;
		this.link = link;
 		this.list =list;
	}
	/*Without link AND image*/
	public Present_API(int id_present, String name, String description, double average_price, int priority, int state,
			List_API list) {
 		this.id_present = id_present;
		this.name = name;
		this.description = description;
		this.average_price = average_price;
		this.priority = priority;
		this.state = state;
  		this.list =list;
	}
	

	/*Methods*/
	public boolean insertPresent() throws SQLException {
		return presentDAO.create(this);
	}
}
