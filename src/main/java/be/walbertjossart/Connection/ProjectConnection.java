package be.walbertjossart.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import be.walbertjossart.Connection.ProjectConnection;

public class ProjectConnection {
	private static Connection instance = null;
	
	private ProjectConnection(){
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@//193.190.64.10:1522/XEPDB1";
			instance = DriverManager.getConnection(url);
		}
		catch(ClassNotFoundException ex){
			JOptionPane.showMessageDialog(null, "Driver class not found" + ex.getMessage());
			System.exit(0);	
		}
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "JDBC Error: " + ex.getMessage());
		}
		if (instance == null) {
            JOptionPane.showMessageDialog(null, "The database is inaccessible, closing the program.");
            System.exit(0);
        }
	}
	
	public static Connection getInstance() {
		if(instance == null){
			new ProjectConnection();
		}
		return instance;
	}
}
