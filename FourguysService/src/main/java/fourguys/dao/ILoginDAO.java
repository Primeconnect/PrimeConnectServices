package fourguys.dao;

import fourguys.dto.Profile;

public interface ILoginDAO 
{
	public Profile getProfileData(String user, String userType);
}
