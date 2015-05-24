package primeconnect.bo;

import java.util.List;

import primeconnect.jb.ScheduleData;


public interface IScheduleBO 
{
/*	public Profile getProfile(String email);
	public Profile getProfile(String username, String password);
*/	
	public List <ScheduleData> getScheduleData(String email);

//	public void register(IRegisterFormBean formBean);
}
