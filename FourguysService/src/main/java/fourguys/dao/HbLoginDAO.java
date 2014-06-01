package fourguys.dao;

import javax.inject.Named;

import fourguys.jb.Profile;

@Named
public class HbLoginDAO extends AbstractBaseJPADAO implements ILoginDAO
{
	public Profile getProfileData(final String email)
	{
		return getUniqueResult(email,Profile.class);
	}
}
