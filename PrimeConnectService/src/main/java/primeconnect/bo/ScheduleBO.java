package primeconnect.bo;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import primeconnect.dao.IScheduleDAO;
import primeconnect.jb.ScheduleData;

@Named
public class ScheduleBO implements IScheduleBO 
{
	@Inject
	@NotNull
	private IScheduleDAO scheduleDAO;
	
/*	public Profile getProfile(String email)
	{
        return loginDAO.getProfileData(email);
	}
	
	public Profile getProfile(String username, String password)
	{
		return loginDAO.getProfileData(username,password);
	}
*/
	public List <ScheduleData> getScheduleData(String email)
	{
		return scheduleDAO.getScheduleData(email);
	}

/*	public void register(IRegisterFormBean formBean)
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
*/	
}
