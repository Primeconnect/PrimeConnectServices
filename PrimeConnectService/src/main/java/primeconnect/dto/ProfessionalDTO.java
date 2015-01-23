package primeconnect.dto;

import primeconnect.jb.Professional;

public class ProfessionalDTO {
	
	private Professional professional;
	
	public ProfessionalDTO(Professional professional)
	{
		this.professional = professional;
	}
	
	public String getFirstName() {
		return professional != null ? professional.getFirstName() : null;
	}

	public String getLastName() {
		return professional != null ? professional.getLastName() : null;
	}
	
	public String getUserId() {
		return professional != null ? professional.getUserID() : null;
	}
	
	public String getEmail() {
		return professional != null ? professional.getEmail() : null;
	}
	
	public String getProfession() {
		return professional != null ? professional.getProfession() : null;
	}

}
