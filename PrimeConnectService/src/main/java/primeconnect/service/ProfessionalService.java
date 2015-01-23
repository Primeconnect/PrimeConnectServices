package primeconnect.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.validator.constraints.NotBlank;
import org.jboss.resteasy.plugins.validation.hibernate.ValidateRequest;

import primeconnect.bo.IProfessionalBO;
import primeconnect.dto.GenericDTO;
import primeconnect.dto.ProfessionalDTO;
import primeconnect.jb.Professional;

public class ProfessionalService {

	@Inject
	IProfessionalBO bo;
	
	@GET
    @Path("professional")
    @Produces(MediaType.APPLICATION_JSON)
    @ValidateRequest
    public GenericDTO<List<ProfessionalDTO>> getProfessional(
    		@NotBlank @QueryParam("email") String email) 
    {
    	GenericDTO<List<ProfessionalDTO>> dto = new GenericDTO<>();
    	List<Professional> profList = bo.getProfessional(email);
    	
    	if( profList != null && !profList.isEmpty() )
    	{
    		List<ProfessionalDTO> dtoList = new ArrayList<>();
    		for( Professional prof : profList )
    			dtoList.add(new ProfessionalDTO(prof));
    		dto.setResult(dtoList);
    	}
    	
    	return dto;
    }
	
}
