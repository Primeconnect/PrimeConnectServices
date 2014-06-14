package fourguys.bo;

import fourguys.jb.Profile;
import fourguys.service.form.IRegisterFormBean;


public interface ILoginBO 
{
	public Profile getProfile(String email);
	public Profile getProfile(String username, String password);
	
	public void register(IRegisterFormBean formBean);
}
