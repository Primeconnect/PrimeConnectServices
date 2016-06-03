//package primeconnect.service;
//
//import primeconnect.dao.entity.Address;
//import primeconnect.dao.entity.Office;
//import primeconnect.dao.entity.Professional;
//import primeconnect.dao.entity.UserProfile;
//import primeconnect.dto.GenericDTO;
//import primeconnect.dto.ProfessionalDTO;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Path("professionals")
//public class ProfessionalService {
//
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response saveProfessional()
//    {
//        return Response.created()
//    }
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<ProfessionalDTO> getAllProfessional()
//    {
//
//    }
//
//    @GET
//    @Path("client/{email}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<ProfessionalDTO> getProfessionalForClient(@PathParam("email") String email)
//    {
//
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<ProfessionalDTO> getProfessionalForClient(@PathParam("id") String email)
//    {
//
//    }
//
//    //        List<ProfessionalDTO> professionalDetailsList = new ArrayList<>();
////        Professional p1 = new Professional();
////        p1.setProfession("Surgeon");
////        UserProfile u1 = new UserProfile();
////        u1.setFirstName("Alfred");
////        u1.setLastName("Pennyworth");
////        u1.setEmail("alfred@wayne_industries.com");
////        u1.setPhoneNumber("(715) 847-248");
////        Address a1 = new Address();
////        a1.setLine1("333 Pine Ridge Blvd");
////        a1.setCity("Wausau");
////        a1.setState("WI");
////        a1.setZip("54401");
////        a1.setCountry("USA");
////        Office o1 = new Office();
////        o1.setName("Wiscousin");
////        o1.setLocation("Wiscousin");
////        professionalDetailsList.add(new ProfessionalDTO(u1,p1,o1,a1));
////        Professional p2 = new Professional();
////        p2.setProfession("Cardiologist");
////        UserProfile u2 = new UserProfile();
////        u2.setFirstName("Jason");
////        u2.setLastName("Todd");
////        u2.setEmail("jason@wayne_industries.com");
////        u2.setPhoneNumber("(715) 847-248");
////        Address a2 = new Address();
////        a2.setLine1("333 Pine Ridge Blvd");
////        a2.setCity("Wausau");
////        a2.setState("WI");
////        a2.setZip("54401");
////        a2.setCountry("USA");
////        Office o2 = new Office();
////        o2.setName("Wiscousin");
////        o2.setLocation("Wiscousin");
////        professionalDetailsList.add(new ProfessionalDTO(u2,p2,o2,a2));
////
////    	return professionalDetailsList;
//}
//
