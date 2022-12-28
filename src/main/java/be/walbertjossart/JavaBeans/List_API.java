package be.walbertjossart.JavaBeans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;

import be.walbertjossart.DAO.AbstractDAOFactory_API;
import be.walbertjossart.DAO.DAO;

public class List_API implements Serializable{

	/*Attributs*/
	private static final long serialVersionUID = 6880376709357849747L;
	private int id_list;
	private LocalDate limit_date;
	private String occasion;
	private String state;
	private ArrayList<Present_API> presents;
	private Users_API owner;
	private ArrayList<Users_API> guests;
	static AbstractDAOFactory_API adf = AbstractDAOFactory_API.getFactory(AbstractDAOFactory_API.DAO_FACTORY);
	static DAO<List_API> listDAO = adf.getListDAO_API();
	
	/*Constructor(s)*/
	public List_API() {}

	public List_API(int id_list, LocalDate limit_date, String occasion, String state, Users_API owner, Users_API guest, Present_API present) {
		this.id_list = id_list;
		this.limit_date = limit_date;
		this.occasion = occasion;
		this.state = state;
		this.owner=owner;
		this.guests = new ArrayList<>();
		this.presents = new ArrayList<>();
		this.presents.add(present);
	}

	
	/*Getters/Setters*/
	public int getId_list() {
		return id_list;
	}
	public void setId_list(int id_list) {
		this.id_list = id_list;
	}
	public LocalDate getLimit_date() {
		return limit_date;
	}
	public void setLimit_date(LocalDate limit_date) {
		this.limit_date = limit_date;
	}
	public String getOccasion() {
		return occasion;
	}
	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public Users_API getOwner() {
		return owner;
	}

	public void setOwner(Users_API owner) {
		this.owner = owner;
	}

	public ArrayList<Users_API> getGuests() {
		return guests;
	}

	public void setGuests(ArrayList<Users_API> guests) {
		this.guests = guests;
	}

	public ArrayList<Present_API> getPresents() {
		return presents;
	}

	public void setPresents(ArrayList<Present_API> presents) {
		this.presents = presents;
	}
	
	
	/*Methods*/
	public boolean insertList() throws SQLException {
		return listDAO.create(this);
	}
	public static ArrayList<List_API> getAll() throws SQLException, JsonProcessingException{
		return listDAO.findAll();
	}
	
	public List_API ConvertObject(ArrayList<Object> list_objects, Users_API user) {
		List_API list_api = new List_API();
		list_api.setId_list(Integer.parseInt(list_objects.get(0).toString()));
		list_api.setLimit_date(Date.valueOf(list_objects.get(1).toString()).toLocalDate());
		list_api.setOccasion(String.valueOf(list_objects.get(2).toString()));
 		list_api.setState(String.valueOf(list_objects.get(3).toString()));
  		list_api.setOwner(user);
  		
		return list_api;
	}
	
}
