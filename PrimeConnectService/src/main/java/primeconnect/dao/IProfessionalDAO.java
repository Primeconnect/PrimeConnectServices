package primeconnect.dao;

import java.util.List;

import primeconnect.jb.ProfessionalDetails;

public interface IProfessionalDAO
{
	public List<ProfessionalDetails> getProfessionalData(String email);
	
	public void saveProfileData(ProfessionalDetails professionalDetails);
}
