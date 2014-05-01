package fourguys.bo;

import fourguys.dto.Profile;


public interface ILoginBO 
{
	public Profile getProfile(final String email);
}
