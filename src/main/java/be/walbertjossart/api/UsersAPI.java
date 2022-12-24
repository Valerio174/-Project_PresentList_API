package be.walbertjossart.api;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.walbertjossart.JavaBeans.Users_API;
 
@Path("/user")
public class UsersAPI {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(){
		ArrayList<Users_API> users = Users_API.getAll();
		
		return Response.status(Status.OK).entity(users).build();
	}
	
	@POST
	public Response InsertUsers(
			@FormParam("pseudo")String pseudo, 
			@FormParam("password")String password,
			@FormParam("email")String email) throws SQLException {
		if(pseudo == null || password == null || email == null) {
			return Response.
					status(Status.BAD_REQUEST).
					build();
		}
		
		Users_API users = new Users_API(pseudo, password, email);
 		
		if(!users.insertUsers()) {
			return Response.
					status(Status.SERVICE_UNAVAILABLE).
					build();
		}
		return Response.
				status(Status.CREATED).
				header("Location", "/Project_PresentList_API/api/users/" + users.getId()).
				build();
	}
	
}
