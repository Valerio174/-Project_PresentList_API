package be.walbertjossart.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import be.walbertjossart.JavaBeans.Message_API;

public class MessageDAO_API extends DAO<Message_API> {

	public MessageDAO_API(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Message_API obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Message_API obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Message_API obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Message_API find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Message_API> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
