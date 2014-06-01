package fourguys.bo;

import fourguys.jb.Profile;


public interface ILoginBO 
{
	public Profile getProfile(final String email);
}
