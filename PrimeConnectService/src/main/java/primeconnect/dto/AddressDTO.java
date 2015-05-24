package primeconnect.dto;

import primeconnect.jb.ProfessionalData;

public class AddressDTO {

	private ProfessionalData professionalData;

	public AddressDTO(ProfessionalData professionalData)
	{
		this.professionalData = professionalData;
	}
	
	public String getLine1()
	{
		return professionalData.getAddress_line1();
	}
	
	public String getLine2 ()
	{
		return professionalData.getAddress_line2();
	}
	
	public String getCity ()
	{
		return professionalData.getAddress_city();
	}
	
	public String getState ()
	{
		return professionalData.getAddress_state();
	}

	public String getZip ()
	{
		return professionalData.getAddress_zip();
	}

	public String getCountry ()
	{
		return professionalData.getAddress_country();
	}
}
