package fourguys.dao;

import javax.inject.Named;

import fourguys.dto.Profile;

@Named
public class HbLoginDAO implements ILoginDAO
{
	public Profile getProfileData(final String email)
	{
		Profile b = new Profile();
    	b.setEmail(email);
        return b;
	}
}
