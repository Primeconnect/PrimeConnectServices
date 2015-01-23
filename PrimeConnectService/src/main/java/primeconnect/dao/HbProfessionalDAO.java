package primeconnect.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import primeconnect.jb.Professional;

@Named
public class HbProfessionalDAO extends AbstractBaseJPADAO implements IProfessionalDAO
{

	@Override
	public List<Professional> getProfessionalData(String email) {
		StringBuilder sbSql = new StringBuilder("SELECT user.USER_ID, user.USER_NAME, user.FIRST_NAME, user.LAST_NAME , user.email")
			.append("FROM PC_PROFESSIONAL prof, PC_USER_PROFILE user ")
			.append("where prof.USER_ID=user.USER_ID and user.email=:email")
			.append("and user.status = 'A' and prof.status = 'A'")
			;
		
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		
		return getResults(sbSql.toString(),Professional.class,paramMap);
		
	}

	@Override
	public void saveProfileData(Professional professional) {
		// TODO Auto-generated method stub
		
	}
	
	
}
