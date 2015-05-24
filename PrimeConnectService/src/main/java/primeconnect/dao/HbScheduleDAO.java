package primeconnect.dao;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import primeconnect.jb.ScheduleData;
import primeconnect.util.Hasher;

@Named
public class HbScheduleDAO extends AbstractBaseJPADAO implements IScheduleDAO
{
	@Inject
	private Hasher hasher;
	
	/*@Override
	public Profile getProfileData(final String email)
	{
//		return getUniqueResult(email,Profile.class);
		
		String jpql = "select p from Profile p where p.email=:email and p.status in ('A','P')";
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		
		return getUniqueResult(jpql,Profile.class,paramMap);
	}
*/
	@Override
	public List <ScheduleData> getScheduleData (String email)
	{
		return entityManager.createNamedQuery("findProfessionalScheduleByEmail",ScheduleData.class)
			       .setParameter("email", email)
			       .getResultList();
	
	}
	
/*	@Override
	public Profile getProfileData(String username, String password) 
	{
		String hashedPassword = hasher.hash(password);
		
		String jpql = "select p from Profile p where p.userName=:user and p.hashedPassword=:pwd and p.status in ('A','P')";
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("user", username);
		paramMap.put("pwd", hashedPassword);
		
		return getUniqueResult(jpql,Profile.class,paramMap);
	}
	
	@Override
	public void saveProfileData(Profile profile,String password)
	{
		if( !StringUtils.isBlank(password) )
			profile.setHashedPassword(hasher.hash(password));
		
		persist(profile);
	}
*/	
}
