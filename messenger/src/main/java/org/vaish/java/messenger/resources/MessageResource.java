package org.vaish.java.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.vaish.java.messenger.model.Message;
import org.vaish.java.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService service=new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(){
		return service.getMessages();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response addMessage(Message message,@Context UriInfo uriInfo){
		System.out.println("post works");
		Message newMessage=service.addMessage(message);
		URI uri=uriInfo.getAbsolutePathBuilder().path(newMessage.getId().toString()).build();
		return Response.created(uri).build();
		//return service.addMessage(message);
    	 
    }
    
	@DELETE
	@Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") Long id){
    	service.deleteMessage(id);
    }
    
    @PUT
    @Path("/{messageId}")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Message updateMessage(@PathParam("messageId") Long id,Message message){
    	message.setId(id);
		return service.updateMessage(message);
    	
    }
    
    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("messageId") Long id){
    	System.out.println(id);
    	return service.getMessage(id);
    }
    
    @Path("/comments")
    public CommentResource getComment(){
    	return new CommentResource();
    }
}
