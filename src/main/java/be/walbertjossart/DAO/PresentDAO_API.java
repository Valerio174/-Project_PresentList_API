package be.walbertjossart.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import be.walbertjossart.JavaBeans.Present_API;

public class PresentDAO_API extends DAO<Present_API>{

	public PresentDAO_API(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Present_API obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Present_API obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Present_API obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Present_API find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Present_API> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
