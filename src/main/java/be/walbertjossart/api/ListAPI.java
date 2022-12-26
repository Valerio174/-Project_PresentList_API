package be.walbertjossart.api;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.walbertjossart.JavaBeans.List_API;
import be.walbertjossart.JavaBeans.Users_API;

@Path("/list")
public class ListAPI {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(){
		ArrayList<List_API> lists = List_API.getAll();
		
		return Response.status(Status.OK).entity(lists).build();
	}
	
	@POST
	public Response InsertList(
			@FormParam("limit_date")Date limit_date, 
			@FormParam("occasion")String occasion) throws SQLException {
		if(limit_date == null || occasion == null) {
			return Response.
					status(Status.BAD_REQUEST).
					build();
		}
		
		List_API list = new List_API();
 		
		if(!list.insertList()) {
			return Response.
					status(Status.SERVICE_UNAVAILABLE).
					build();
		}
		return Response.
				status(Status.CREATED).
				header("Location", "/Project_PresentList_API/api/lists/" + list.getId_list()).
				build();
	}
	
}
