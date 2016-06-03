package primeconnect.service;

import primeconnect.bo.IUserBO;
import primeconnect.dao.entity.UserProfile;
import primeconnect.dto.ProfessionalDTO;
import primeconnect.dto.UserDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("user")
public class UserService {

    @Inject
    IUserBO bo;

//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response saveProfessional(Map<String,Object> data)
//    {
//        return Response.created()
//    }

    @GET
    @Path("id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getUser(@PathParam("id") Long id)
    {
        UserProfile userProfile = bo.getUser(id);
        return new UserDTO(userProfile);
    }

    @GET
    @Path("{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getUser(@PathParam("email") String email)
    {
        UserProfile userProfile = bo.getUser(email);
        return new UserDTO(userProfile);
    }
//
//    @GET
//    @Path("{email}/professionals")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<ProfessionalDTO> getProfessionalForClient(@PathParam("email") String email)
//    {
//
//    }
//
//    @GET
//    @Path("{email}/schedules")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<ScheduleDTO> getProfessionalForClient(@PathParam("email") String email)
//    {
//
//    }

//    @GET
//    @Path("{email}/schedules/{professionalId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<ScheduleDTO> getProfessionalForClient(@PathParam("email") String email,@PathParam("professionalId") String professionalId)
//    {
//
//    }
//
//    @GET
//    @Path("{email}/schedules/{professionalId}/{officeId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<ScheduleDTO> getProfessionalForClient(@PathParam("email") String email,@PathParam("professionalId") String professionalId,@PathParam("officeId") String officeId)
//    {
//
//    }
//
//    @GET
//    @Path("{email}/messages")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<MessageDTO> getProfessionalForClient(@PathParam("email") String email)
//    {
//
//    }
//
//    @GET
//    @Path("{email}/messages/{professionalId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<MessageDTO> getProfessionalForClient(@PathParam("email") String email,@PathParam("professionalId") String professionalId)
//    {
//
//    }

}

