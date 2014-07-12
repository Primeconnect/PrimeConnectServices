package fourguys.service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.jboss.resteasy.annotations.Form;
import org.jboss.resteasy.plugins.validation.hibernate.ValidateRequest;

import fourguys.bo.ILoginBO;
import fourguys.dto.GenericDTO;
import fourguys.dto.ProfileDTO;
import fourguys.jb.Profile;
import fourguys.service.form.CustomRegisterFormBean;
import fourguys.service.form.ThirdPartyRegisterFormBean;

@Path("/")
public class LoginService 
{
	@Inject
	private ILoginBO loginBO;

    @GET
    @Path("login/{type: facebook|google}")
    @Produces(MediaType.APPLICATION_JSON)
    @ValidateRequest
    public GenericDTO<ProfileDTO> getProfile(@Email @NotBlank @QueryParam("email") String email) 
    {
    	GenericDTO<ProfileDTO> dto = new GenericDTO<ProfileDTO>();
    	Profile profile = loginBO.getProfile(email);
    	
    	if( profile != null )
    		dto.setResult(new ProfileDTO(profile));
    	
    	return dto;
    }
    
    @GET
    @Path("login/custom")
    @Produces(MediaType.APPLICATION_JSON)
    @ValidateRequest
    public GenericDTO<ProfileDTO> getProfile(
    		@NotBlank @QueryParam("uname") String username, 
    		@NotBlank @QueryParam("pwd") String password) 
    {
    	GenericDTO<ProfileDTO> dto = new GenericDTO<ProfileDTO>();
    	Profile profile = loginBO.getProfile(username,password);
    	
    	if( profile != null )
    		dto.setResult(new ProfileDTO(profile));
    	return dto;
    }
    
    @POST
    @Path("register/{type: facebook|google}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public GenericDTO<Object> register(@Valid @Form ThirdPartyRegisterFormBean formBean) 
    {
    	GenericDTO<Object> dto = new GenericDTO<>();
//    	Map<String,String> map = new HashMap<>();
//    	map.put("username", username);
//    	map.put("firstName", firstName);
//    	map.put("middleName", middleName);
//    	map.put("lastName", lastName);
//    	map.put("email", email);
//    	dto.setResult(map);
    	
    	loginBO.register(formBean);
    	
//    	Profile profile = loginBO.getProfile(username,password);
    	
//    	if( profile != null )
//    		dto.setResult(new ProfileDTO(profile));
    	return dto;
    }
    
    @POST
    @Path("register/custom")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public GenericDTO<Object> register(@Valid @Form CustomRegisterFormBean formBean) 
    {
    	GenericDTO<Object> dto = new GenericDTO<>();
//    	Map<String,String> map = new HashMap<>();
//    	map.put("username", username);
//    	map.put("firstName", firstName);
//    	map.put("middleName", middleName);
//    	map.put("lastName", lastName);
//    	map.put("email", email);
//    	dto.setResult(map);
    	
    	loginBO.register(formBean);
    	
//    	Profile profile = loginBO.getProfile(username,password);
    	
//    	if( profile != null )
//    		dto.setResult(new ProfileDTO(profile));
    	return dto;
    }
    
}
