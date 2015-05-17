package primeconnect.dao;

import java.util.List;

import primeconnect.jb.ProfessionalData;
import primeconnect.jb.Profile;

public interface ILoginDAO
{
	public Profile getProfileData(String email);
	public Profile getProfileData(String username, String password);
	
	public List <ProfessionalData> getProfessionalData(String email);
	public void saveProfileData(Profile profile,String password);
}
