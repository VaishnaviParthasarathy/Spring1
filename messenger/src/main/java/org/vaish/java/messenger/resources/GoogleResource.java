package org.vaish.java.messenger.resources;

import java.net.URI;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;
import org.glassfish.jersey.client.oauth2.OAuth2FlowGoogleBuilder;
import org.vaish.java.messenger.service.SimpleOAuthService;

@Path("/googlecontact")
public class GoogleResource {
	
	@Context
    private UriInfo uriInfo;
	@Context
    private ServletContext servletContext;
 
    @GET
    @Produces("text/html")
    public Response getContact() {
    	
    	 // check oauth setup
        if (SimpleOAuthService.getClientIdentifier() == null) {
            final URI uri = UriBuilder.fromUri(servletContext.getContextPath())
                    .path("/index.html") //to show "Enter your Client Id and Secret" setup page
                    .build();
            return Response.seeOther(uri).build();
        }
        // check access token
        if (SimpleOAuthService.getAccessToken() == null) {
            return googleAuthRedirect();
        }
        // We have already an access token. Query the data from Google API.
        final Client client = SimpleOAuthService.getFlow().getAuthorizedClient();
        //return getTasksResponse(client);
        return null;
       
    }
    
    private Response googleAuthRedirect() {
        final String redirectURI = UriBuilder.fromUri(uriInfo.getBaseUri())
                .path("oauth2/authorize").build().toString();

        final OAuth2CodeGrantFlow flow = OAuth2ClientSupport.googleFlowBuilder(
                SimpleOAuthService.getClientIdentifier(),
                redirectURI,
                "https://www.googleapis.com/auth/tasks.readonly")
                .prompt(OAuth2FlowGoogleBuilder.Prompt.CONSENT).build();

        SimpleOAuthService.setFlow(flow);

        // start the flow
        final String googleAuthURI = flow.start();

        // redirect user to Google Authorization URI.
        return Response.seeOther(UriBuilder.fromUri(googleAuthURI).build()).build();
    }
}
