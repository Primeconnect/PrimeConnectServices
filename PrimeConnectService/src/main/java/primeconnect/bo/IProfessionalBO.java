package primeconnect.bo;

import java.util.List;

import primeconnect.jb.Professional;


public interface IProfessionalBO 
{
	public List<Professional> getProfessional(String email);
	
	public void save();
}
