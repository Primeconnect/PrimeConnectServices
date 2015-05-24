package primeconnect.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.jboss.resteasy.plugins.validation.hibernate.ValidateRequest;

import primeconnect.bo.IScheduleBO;
import primeconnect.dto.GenericDTO;
import primeconnect.dto.ScheduleDTO;
import primeconnect.jb.ScheduleData;

@Path("/")
public class ScheduleService 
{
	@Inject
	private IScheduleBO scheduleBO;

    @GET
    @Path("schedule")
    @Produces(MediaType.APPLICATION_JSON)
    @ValidateRequest
    public GenericDTO <List <ScheduleDTO>> getSchedule(@Email @NotBlank @QueryParam("email") String email) 
    {
    	List <ScheduleDTO> scheduleDTOList = new ArrayList<ScheduleDTO> ();
    	GenericDTO <List <ScheduleDTO>> dto = new GenericDTO<List <ScheduleDTO>>();
    	List <ScheduleData> scheduleDataList = scheduleBO.getScheduleData(email);
    	
    	for (ScheduleData sd : scheduleDataList) {
    		scheduleDTOList.add (new ScheduleDTO (sd));
    	}
    	
    	if( scheduleDataList != null )
    		dto.setResult(scheduleDTOList);
    	
    	return dto;
    }
        
}
