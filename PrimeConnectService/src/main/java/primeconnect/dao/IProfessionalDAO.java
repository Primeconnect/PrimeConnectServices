package primeconnect.dao;

import java.util.List;

import primeconnect.jb.Professional;

public interface IProfessionalDAO
{
	public List<Professional> getProfessionalData(String email);
	
	public void saveProfileData(Professional professional);
}
