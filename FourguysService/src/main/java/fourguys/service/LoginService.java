package fourguys.service;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.validator.constraints.Email;
import org.jboss.resteasy.plugins.validation.hibernate.ValidateRequest;

import fourguys.bo.ILoginBO;
import fourguys.dto.GenericDTO;
import fourguys.dto.ProfileDTO;
import fourguys.jb.Profile;

@Path("/login")
public class LoginService 
{
	@Inject
	private ILoginBO loginBO;

    @GET
    @Path("{email}")
    @Produces(MediaType.APPLICATION_JSON)
    @ValidateRequest
    public GenericDTO<ProfileDTO> getProfile(@Email @PathParam("email") final String email) 
    {
    	GenericDTO<ProfileDTO> dto = new GenericDTO<ProfileDTO>();
    	Profile profile = loginBO.getProfile(email);
    	if( profile != null )
    		dto.setResult(new ProfileDTO(profile));
    	return dto;
    }
    
}
