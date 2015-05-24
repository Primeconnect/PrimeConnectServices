package primeconnect.dao;

import java.util.List;

import primeconnect.jb.ScheduleData;

public interface IScheduleDAO
{
/*	public Profile getScheduleData(String email);
	public Profile getProfileData(String username, String password);
*/	
	public List <ScheduleData> getScheduleData(String email);
//	public void saveProfileData(Profile profile,String password);
}
