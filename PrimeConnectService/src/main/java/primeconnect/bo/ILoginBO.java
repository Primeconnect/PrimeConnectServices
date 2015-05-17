package primeconnect.bo;

import java.util.List;

import primeconnect.jb.ProfessionalData;
import primeconnect.jb.Profile;
import primeconnect.service.form.IRegisterFormBean;


public interface ILoginBO 
{
	public Profile getProfile(String email);
	public Profile getProfile(String username, String password);
	
	public List <ProfessionalData> getProfessionalData(String email);

	public void register(IRegisterFormBean formBean);
}
