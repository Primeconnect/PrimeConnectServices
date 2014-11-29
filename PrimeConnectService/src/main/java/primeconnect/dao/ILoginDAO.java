package primeconnect.dao;

import primeconnect.jb.Profile;

public interface ILoginDAO
{
	public Profile getProfileData(String email);
	public Profile getProfileData(String username, String password);
	
	public void saveProfileData(Profile profile,String password);
}
