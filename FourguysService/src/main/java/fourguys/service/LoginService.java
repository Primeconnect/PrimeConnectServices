package fourguys.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.validator.constraints.Email;
import org.jboss.resteasy.plugins.validation.hibernate.ValidateRequest;

import fourguys.bo.ILoginBO;
import fourguys.dependency.DependencyResolverFactory;
import fourguys.dto.GenericDTO;
import fourguys.dto.Profile;

@Path("login")
public class LoginService 
{

    @GET
    @Path("{email}")
    @Produces(MediaType.APPLICATION_JSON)
    @ValidateRequest
    public GenericDTO<Profile> getProfile(@Email @PathParam("email") final String email) 
    {
    	ILoginBO myService = DependencyResolverFactory.getDepedencyResolver().getDependentObject(ILoginBO.class);
    	
    	GenericDTO<Profile> dto = new GenericDTO<Profile>();
    	dto.setResult(myService.getProfile(email));
    	return dto;
    }
    
}
