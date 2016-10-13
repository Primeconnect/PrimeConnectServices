package primeconnect.service;


import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Payload;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.jboss.resteasy.plugins.validation.hibernate.ValidateRequest;

import primeconnect.bo.ILoginBO;
import primeconnect.dto.GenericDTO;
import primeconnect.dto.ProfessionalDTO;
import primeconnect.dto.ProfileDTO;
import primeconnect.jb.ProfessionalData;
import primeconnect.jb.Profile;
import primeconnect.service.form.CustomRegisterFormBean;
import primeconnect.service.form.ThirdPartyRegisterFormBean;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Path("/login")
public class LoginService
{
    Logger logger = LogManager.getLogger();

    @Inject
    private ILoginBO loginBO;

    @POST
    @Path("google")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String,String> getProfile(Map<String,String> requestParams)
    {
        logger.info(requestParams);

        //clientId, code and redirectUri
        final MultivaluedMap<String, String> formData = new MultivaluedHashMap<>();

        formData.putSingle("client_id", requestParams.get("clientId"));
        formData.putSingle("client_secret", "eK3FawOCLUAklbz7P5Pfsf6U");
        formData.putSingle("code", requestParams.get("code"));
        formData.putSingle("redirect_uri", requestParams.get("redirectUri"));
        formData.putSingle("grant_type","authorization_code");

        Client client = ClientBuilder.newClient();
        Response response = client.target("https://accounts.google.com/o/oauth2/token").request().post(Entity.form(formData));
        Map<String,String> result = response.readEntity(Map.class);
        String accessToken = result.get("access_token");
        String tokenType = result.get("token_type");
//        String idToken = result.get("id_token");
//        Long expiresIn = Long.valueOf(result.get("expires_in"));

        logger.info(result);

        Response response2 = client.target("https://www.googleapis.com/oauth2/v2/userinfo").request().header("Authorization",tokenType+" "+accessToken).get();
        Map<String,String> result2 = response2.readEntity(Map.class);

        logger.info(result2);

        Map<String,Object> payload = new HashMap<>();
        payload.put("email",result2.get("email"));
        payload.put("name",result2.get("name"));


        long timePlus5mins = System.currentTimeMillis() + 1000 * 60 * 5;
        Date expDate = new Date(timePlus5mins);
        String token = Jwts.builder()
                .setClaims(payload)
                .setExpiration(expDate)
                .signWith(SignatureAlgorithm.HS512, "deathToAll666".getBytes())
                .compact();

        result2.put("access_token",token);

//        GenericDTO<Map<String,String>> dto = new GenericDTO<>();
//        dto.setResult(result2);

        Map<String,String> resultMap = new HashMap<>(1);
        resultMap.put("access_token",token);

        return resultMap;
    }

//    @GET
//    @Path("login/{type: facebook|google}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ValidateRequest
//    public GenericDTO <List <ProfessionalDTO>> getProfile(@Email @NotBlank @QueryParam("email") String email)
//    {
//    	List <ProfessionalDTO> professionalDTOList = new ArrayList<ProfessionalDTO> ();
//    	GenericDTO <List <ProfessionalDTO>> dto = new GenericDTO<List <ProfessionalDTO>>();
//    	List <ProfessionalData> profData = loginBO.getProfessionalData(email);
//
//    	for (ProfessionalData pd : profData) {
//    		professionalDTOList.add (new ProfessionalDTO (pd));
//    	}
//
//    	if( profData != null )
//    		dto.setResult(professionalDTOList);
//
//    	return dto;
//    }

//    @GET
//    @Path("login/profiledata")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ValidateRequest
//    public GenericDTO <ProfileDTO> getProfileData(@Email @NotBlank @QueryParam("email") String email)
//    {
//    	GenericDTO <ProfileDTO> profileDTO = new GenericDTO <ProfileDTO>() ;
//
//    	Profile profile = loginBO.getProfile(email);
//
//    	if( profile != null )
//    		profileDTO.setResult(new ProfileDTO(profile));
//    	return profileDTO;
//
//    }
//
//
//    @GET
//    @Path("login/custom")
//    @Produces(MediaType.APPLICATION_JSON)
//    @ValidateRequest
//    public GenericDTO<ProfileDTO> getProfile(
//    		@NotBlank @QueryParam("uname") String username,
//    		@NotBlank @QueryParam("pwd") String password)
//    {
//    	GenericDTO<ProfileDTO> dto = new GenericDTO<ProfileDTO>();
//    	Profile profile = loginBO.getProfile(username,password);
//
//    	if( profile != null )
//    		dto.setResult(new ProfileDTO(profile));
//    	return dto;
//    }

//    @POST
//    @Path("register/{type: facebook|google}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Transactional
//    public GenericDTO<Object> register(@Valid @Form ThirdPartyRegisterFormBean formBean)
//    {
//    	GenericDTO<Object> dto = new GenericDTO<>();
////    	Map<String,String> map = new HashMap<>();
////    	map.put("username", username);
////    	map.put("firstName", firstName);
////    	map.put("middleName", middleName);
////    	map.put("lastName", lastName);
////    	map.put("email", email);
////    	dto.setResult(map);
//
//    	loginBO.register(formBean);
//
////    	Profile profile = loginBO.getProfile(username,password);
//
////    	if( profile != null )
////    		dto.setResult(new ProfileDTO(profile));
//    	return dto;
//    }
//
//    @POST
//    @Path("register/custom")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Transactional
//    public GenericDTO<Object> register(@Valid @Form CustomRegisterFormBean formBean)
//    {
//    	GenericDTO<Object> dto = new GenericDTO<>();
////    	Map<String,String> map = new HashMap<>();
////    	map.put("username", username);
////    	map.put("firstName", firstName);
////    	map.put("middleName", middleName);
////    	map.put("lastName", lastName);
////    	map.put("email", email);
////    	dto.setResult(map);
//
//    	loginBO.register(formBean);
//
////    	Profile profile = loginBO.getProfile(username,password);
//
////    	if( profile != null )
////    		dto.setResult(new ProfileDTO(profile));
//    	return dto;
//    }

}
