package primeconnect.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import primeconnect.dao.entity.Address;
import primeconnect.dao.entity.Office;
import primeconnect.dao.entity.Professional;
import primeconnect.dao.entity.UserProfile;
import primeconnect.jb.ProfessionalDetails;

@Named
public class HbProfessionalDAO extends AbstractBaseJPADAO implements IProfessionalDAO
{

	@Override
	public List<ProfessionalDetails> getProfessionalData(String email) {
//		StringBuilder sbSql = new StringBuilder("SELECT user.USER_ID, user.USER_NAME, user.FIRST_NAME, user.LAST_NAME , user.email")
//			.append("FROM PC_PROFESSIONAL prof, PC_USER_PROFILE user ")
//			.append("where prof.USER_ID=user.USER_ID and user.email=:email")
//			.append("and user.status = 'A' and prof.status = 'A'")
//			;
//
//		Map<String,Object> paramMap = new HashMap<>();
//		paramMap.put("email", email);
//
//		return getResults(sbSql.toString(),ProfessionalDetails.class,paramMap);

		Map<String,Object> paramMap = new HashMap<>(1);
		paramMap.put("email",email);
		UserProfile userProfile = getUniqueResult("select u from UserProfile u where u.email=:email", UserProfile.class, paramMap);
		if( userProfile == null )
			return Collections.emptyList();
		paramMap.clear();

		Long userId = userProfile.getUserId();
		paramMap.put("userId",userId);

		@SuppressWarnings("unchecked")
		List<Object[]> professionalList = getResults(
				"select p,o,a " +
				"from ProfessionalDetails p, ProfessionalOffice po, Office o, Address a, Client c, ClientProfessionalOffice cpo " +
						"where c.userId=:userId and c.clientId=cpo.clientId and p.professionalId=po.professionalId and po.officeId=o.officeId" +
						"and o.addressId=a.addressId", paramMap);

		if( professionalList.isEmpty() )
			return Collections.emptyList();
		paramMap.clear();

		for (Object[] objects : professionalList) {
			Professional professional = (Professional)objects[0];
			Office office = (Office)objects[1];
			Address address = (Address)objects[2];


		}

		return Collections.emptyList();

	}

	@Override
	public void saveProfileData(ProfessionalDetails professionalDetails) {
		// TODO Auto-generated method stub
		
	}
	
	
}
