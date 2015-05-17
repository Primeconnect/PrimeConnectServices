package primeconnect.dto;

import primeconnect.jb.ProfessionalData;

public class ProfessionalDTO {
	
	private ProfessionalData professionalData;
	private AddressDTO addressDTO;
	
	public ProfessionalDTO(ProfessionalData professionalData)
	{
		this.professionalData = professionalData;
		this.addressDTO = new AddressDTO (professionalData);
	}

	
	public String getFirstName() {
		return professionalData != null ? professionalData.getFirstName() : null;
	}

	public String getLastName() {
		return professionalData != null ? professionalData.getLastName() : null;
	}
	
//	public String getUserId() {
//		return professionalData != null ? professionalData.getUserID() : null;
//	}
	
	public String getEmail() {
		return professionalData != null ? professionalData.getEmail() : null;
	}
	
	public String getPhoneNumber ()	{
		return professionalData != null ? professionalData.getPhoneNumber() : null;
	}
	
	public String getProfession() {
		return professionalData != null ? professionalData.getProfession() : null;
	}

	public AddressDTO getAddress()	{
		return addressDTO;
	}
	
}
