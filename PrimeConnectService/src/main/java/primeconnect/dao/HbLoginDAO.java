package primeconnect.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.StringUtils;

import primeconnect.jb.ProfessionalData;
import primeconnect.jb.Profile;
import primeconnect.util.Hasher;

@Named
public class HbLoginDAO extends AbstractBaseJPADAO implements ILoginDAO
{
	@Inject
	private Hasher hasher;
	
	@Override
	public Profile getProfileData(final String email)
	{
//		return getUniqueResult(email,Profile.class);
		
		String jpql = "select p from Profile p where p.email=:email and p.status in ('A','P')";
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		
		return getUniqueResult(jpql,Profile.class,paramMap);
	}

	@Override
	public List <ProfessionalData> getProfessionalData (String email)
	{
//		StringBuilder profDataQuery = new StringBuilder();
//		
//		profDataQuery.append("select userProf.FIRST_NAME, userProf.LAST_NAME, userProf.MIDDLE_NAME, userProf.PHONE_NUMBER, userProf.email, ");
//		profDataQuery.append("prof.PROFESSION, address.LINE_1, address.LINE_2, address.CITY, address.STATE, address.ZIP, address.COUNTRY from ");
//		profDataQuery.append("PC_CORE.PC_PROFESSIONAL prof, ");
//		profDataQuery.append("PC_CORE.PC_PROFESSIONAL_OFFICE profOffice, ");
//		profDataQuery.append("PC_CORE.PC_OFFICE office, ");
//		profDataQuery.append("PC_CORE.PC_ADDRESS address,");
//		profDataQuery.append("PC_CORE.PC_ADDRESS address,");
//		profDataQuery.append("PC_CORE.PC_USER_PROFILE userProf ");
//		profDataQuery.append("where ");
//		profDataQuery.append("prof.PROFESSIONAL_ID = profOffice.PROFESSIONAL_ID and ");
//		profDataQuery.append("profOffice.OFFICE_ID=office.OFFICE_ID and ");
//		profDataQuery.append("office.ADDRESS_ID=address.ADDRESS_ID  and ");
//		profDataQuery.append("userProf.USER_ID=prof.USER_ID and ");
//		profDataQuery.append("userProf.STATUS='A' and ");
//		profDataQuery.append("address.ACTIVE_IND='A' ");

		return entityManager.createNamedQuery("findProfessionalByEmail",ProfessionalData.class)
			       .setParameter("email", email)
			       .getResultList();
	
	}
	
	@Override
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
	
}
