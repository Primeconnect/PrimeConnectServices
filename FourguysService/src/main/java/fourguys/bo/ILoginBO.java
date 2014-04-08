package fourguys.bo;

import fourguys.dto.Profile;


public interface ILoginBO 
{
	public Profile getProfileForProvider(final String userName);
	public Profile getProfileForClient(final String userName);
}
