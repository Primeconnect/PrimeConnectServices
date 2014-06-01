package fourguys.dao;

import fourguys.jb.Profile;

public interface ILoginDAO
{
	public Profile getProfileData(String email);
}
