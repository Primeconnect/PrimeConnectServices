package primeconnect.bo;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import primeconnect.dao.ILoginDAO;
import primeconnect.jb.ProfessionalData;
import primeconnect.jb.Profile;
import primeconnect.service.form.IRegisterFormBean;

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

	public List <ProfessionalData> getProfessionalData(String email)
	{
		return loginDAO.getProfessionalData(email);
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
