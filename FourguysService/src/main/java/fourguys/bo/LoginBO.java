package fourguys.bo;

import javax.inject.Named;

import fourguys.dto.Profile;


@Named
public class LoginBO implements ILoginBO 
{
	public Profile getProfile(final String email)
	{
		Profile b = new Profile();
    	b.setEmail(email);
        return b;
	}
	
}
