package fourguys.bo;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import fourguys.dao.ILoginDAO;
import fourguys.jb.Profile;
import fourguys.service.form.IRegisterFormBean;

@Named
public class LoginBO implements ILoginBO 
{
	@Inject
	@NotNull
	private ILoginDAO loginDAO;
	
	public Profile getProfile(String email)
	{
        return loginDAO.getProfileData(email);
	}
	
	public Profile getProfile(String username, String password)
	{
		return loginDAO.getProfileData(username,password);
	}
	
	public void register(IRegisterFormBean formBean)
	{
		Profile profile = new Profile();
		profile.setEmail(formBean.getEmail());
		profile.setFirstName(formBean.getFirstName());
		profile.setMiddleName(formBean.getMiddleName());
		profile.setLastName(formBean.getLastName());
		profile.setUserName(formBean.getUsername());
		profile.setPhoneNumber(formBean.getPhoneNumber());
		profile.setFaxNumber(formBean.getFaxNumber());
		profile.setStatus(formBean.getStatus());
		
		loginDAO.saveProfileData(profile,formBean.getPassword());
	}
	
}
