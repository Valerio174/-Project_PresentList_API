package be.walbertjossart.api;

import java.awt.Image;
import java.sql.SQLException;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import be.walbertjossart.JavaBeans.List_API;
import be.walbertjossart.JavaBeans.Present_API;
import be.walbertjossart.JavaBeans.Users_API;

@Path("/present")
public class PresentAPI {
	
//	@POST
//	public Response InsertPresent(
//			@FormParam("name")String name, 
//			@FormParam("description")String description,
//			@FormParam("average_price")double average_price,
//			@FormParam("priority")int priority,
//			@DefaultValue("not payed")@FormParam("state")String state,
//			@DefaultValue("")@FormParam("link")String link,
//			@DefaultValue("")@FormParam("")Image image, 
//			@FormParam("")List_API list) throws SQLException {
//		if(name == null || description == null || average_price == 0) {
//			return Response.
//					status(Status.BAD_REQUEST).
//					build();
//		}
//		
////		Present_API present = new Present_API(0,name,description, average_price, priority, state, link , image, List_API list);
//// 		
////		if(!present.insertPresent()) {
////			return Response.
////					status(Status.SERVICE_UNAVAILABLE).
////					build();
////		}
//		return Response.
//				status(Status.CREATED).
//				header("Location", "/Project_PresentList_API/api/users/" /*+ users.getId()*/).
//				build();
//	}
}
