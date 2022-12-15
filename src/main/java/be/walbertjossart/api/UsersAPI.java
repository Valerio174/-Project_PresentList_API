package be.walbertjossart.api;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.walbertjossart.DAO.UsersDAO;
import be.walbertjossart.JavaBeans.Users;
 
@Path("/user")
public class UsersAPI {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(){
		ArrayList<Users> users = Users.getAll();
		
		return Response.status(Status.OK).entity(users).build();
	}
	
}
