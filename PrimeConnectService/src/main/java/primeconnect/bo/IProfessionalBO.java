package primeconnect.bo;

import java.util.List;

import primeconnect.jb.ProfessionalDetails;


public interface IProfessionalBO 
{
	public List<ProfessionalDetails> getAllProfessional(String email);
	
	public void save();
}
