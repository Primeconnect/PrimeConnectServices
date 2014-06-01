package fourguys.bo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import fourguys.dao.ILoginDAO;
import fourguys.jb.Profile;

@Named
public class LoginBO implements ILoginBO 
{
	@Inject
	@NotNull
	private ILoginDAO loginDAO;
	
	public Profile getProfile(final String email)
	{
        return loginDAO.getProfileData(email);
	}
	
}
