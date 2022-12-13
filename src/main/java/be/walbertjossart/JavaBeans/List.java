package be.walbertjossart.JavaBeans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class List implements Serializable{

	/*Attributs*/
	private static final long serialVersionUID = 6880376709357849747L;
	private int id_list;
	private LocalDate limit_date;
	private String occasion;
	private boolean state;
	private ArrayList<Present> presents;
	private Users owner;
	private ArrayList<Users> guests;
	
	/*Constructor(s)*/
	public List() {}

	public List(int id_list, LocalDate limit_date, String occasion, boolean state, Users owner, Users guest, Present present) {
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
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}

	public Users getOwner() {
		return owner;
	}

	public void setOwner(Users owner) {
		this.owner = owner;
	}

	public ArrayList<Users> getGuests() {
		return guests;
	}

	public void setGuests(ArrayList<Users> guests) {
		this.guests = guests;
	}

	public ArrayList<Present> getPresents() {
		return presents;
	}

	public void setPresents(ArrayList<Present> presents) {
		this.presents = presents;
	}
	
	
	/*Methods*/
	
}
