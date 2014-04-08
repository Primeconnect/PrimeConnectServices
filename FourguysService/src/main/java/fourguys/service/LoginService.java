package fourguys.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fourguys.bo.ILoginBO;
import fourguys.dependency.DependencyResolverFactory;
import fourguys.dto.GenericDTO;
import fourguys.dto.Profile;



@Path("login")
public class LoginService 
{

    @GET
    @Path("provider/{user}")
//    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces(MediaType.APPLICATION_JSON)
    public GenericDTO<Profile> getProfileForProvider(@PathParam("user") final String user) 
    {
    	ILoginBO myService = DependencyResolverFactory.getDepedencyResolver().getDependentObject(ILoginBO.class);
    	
    	GenericDTO<Profile> dto = new GenericDTO<Profile>();
    	dto.setResult(myService.getProfileForProvider(user));
    	return dto;
    }
    
    @GET
    @Path("client/{user}")
//    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces(MediaType.APPLICATION_JSON)
    public GenericDTO<Profile> getProfileForCustomer(@PathParam("user") final String user) 
    {
    	ILoginBO myService = DependencyResolverFactory.getDepedencyResolver().getDependentObject(ILoginBO.class);
    	
    	GenericDTO<Profile> dto = new GenericDTO<Profile>();
    	dto.setResult(myService.getProfileForClient(user));
    	return dto;
    }
    
}
