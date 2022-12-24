package be.walbertjossart.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import be.walbertjossart.JavaBeans.Message;

public class MessageDAO_API extends DAO<Message> {

	public MessageDAO_API(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Message obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Message obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Message obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Message find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Message> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
