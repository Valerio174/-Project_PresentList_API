package be.walbertjossart.DAO;

import java.sql.Connection;
import java.util.ArrayList;

import be.walbertjossart.JavaBeans.List;

public class ListDAO_API extends DAO<List>{

	public ListDAO_API(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(List obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(List obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(List obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
