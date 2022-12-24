package be.walbertjossart.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import be.walbertjossart.JavaBeans.Present;

public class PresentDAO_API extends DAO<Present>{

	public PresentDAO_API(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Present obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Present obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Present obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Present find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Present> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
