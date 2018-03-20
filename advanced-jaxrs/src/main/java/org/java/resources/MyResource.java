package org.java.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParamExample}/message")
public class MyResource {
	
	@PathParam("pathParamExample") String pathParamExample;
	@QueryParam("queryParamExample") String queryParamExample;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(){
		
		return "It works! with pathParamValue" + pathParamExample + "queryPAram value" + queryParamExample;
	}

}
