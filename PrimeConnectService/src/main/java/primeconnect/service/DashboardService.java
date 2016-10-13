package primeconnect.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/dashboard")
public class DashboardService
{
	@PersistenceContext(unitName = "hbMysqlPU",type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

	@GET
	@Path("professionals")
	@Produces(MediaType.APPLICATION_JSON)
	public List getProfessionals(@QueryParam("email") String email)
	{
		Query query = entityManager.createNativeQuery(
				"select prof.PROFESSION, prof.SUB_PROFESSION, " +
						" profProfile.FIRST_NAME, profProfile.MIDDLE_NAME, profProfile.LAST_NAME, " +
						"    address.LINE_1, address.LINE_2, address.city, address.state, address.zip, address.country, office.PHONE_NUMBER" +
						" from " +
						" PC_USER_PROFILE userProfile, PC_CLIENT client, " +
						"    PC_CLIENT_OFFICE clientOffice, PC_PROFESSIONAL prof, " +
						"    PC_USER_PROFILE profProfile, PC_OFFICE office, PC_ADDRESS address" +
						" where userProfile.email=? and userProfile.status='A' and" +
						" client.USER_ID = userProfile.USER_ID and client.ACTIVE_IND = 'A' and" +
						" client.CLIENT_ID = clientOffice.CLIENT_ID and clientOffice.ACTIVE_IND = 'A' and" +
						"    prof.PROFESSIONAL_ID=clientOffice.PROFESSIONAL_ID and prof.ACTIVE_IND = 'A' and" +
						"    profProfile.USER_ID=prof.USER_ID and profProfile.status='A' and" +
						"    office.OFFICE_ID=clientOffice.OFFICE_ID and office.ACTIVE_IND='A' and" +
						"    address.ADDRESS_ID=office.ADDRESS_ID and address.ACTIVE_IND='A'");
		query.setParameter(1,email);

		List<Map<String,Object>> returnList = new ArrayList<>();

		List<Object[]> resultList = query.getResultList();
		for ( Object[] objArr : resultList) {
			Map<String,Object> map = new HashMap<>();
			map.put("PROFESSION",objArr[0]);
			map.put("SUB_PROFESSION",objArr[1]);
			map.put("FIRST_NAME",objArr[2]);
			map.put("MIDDLE_NAME",objArr[3]);
			map.put("LAST_NAME",objArr[4]);
			map.put("LINE_1",objArr[5]);
			map.put("LINE_2",objArr[6]);
			map.put("CITY",objArr[7]);
			map.put("STATE",objArr[8]);
			map.put("ZIP",objArr[9]);
			map.put("COUNTRY",objArr[10]);
			map.put("PHONE_NUMBER",objArr[10]);
			returnList.add(map);
		}



		return returnList;
	}

	@GET
	@Path("schedules")
	@Produces(MediaType.APPLICATION_JSON)
	public List getSchedules(@QueryParam("email") String email)
	{
		Query query = entityManager.createNativeQuery(
				"select profProfile.FIRST_NAME, profProfile.MIDDLE_NAME, profProfile.LAST_NAME,office.NAME as OFFICE_NAME, office.LOCATION,   " +
						"    address.LINE_1, address.LINE_2, address.city, address.state, address.zip, address.country, office.PHONE_NUMBER " +
						" from  " +
						" PC_CORE.PC_USER_PROFILE userProfile, PC_CORE.PC_CLIENT client,  " +
						"    PC_CORE.PC_CLIENT_OFFICE clientOffice, PC_CORE.PC_PROFESSIONAL prof,  " +
						"    PC_CORE.PC_USER_PROFILE profProfile, PC_CORE.PC_OFFICE office, PC_ADDRESS address, PC_CORE.PC_SCHEDULE sch " +
						" where userProfile.email=? and userProfile.status='A' and " +
						" client.USER_ID = userProfile.USER_ID and client.ACTIVE_IND = 'A' and " +
						" client.CLIENT_ID = clientOffice.CLIENT_ID and clientOffice.ACTIVE_IND = 'A' and " +
						"    prof.PROFESSIONAL_ID=clientOffice.PROFESSIONAL_ID and prof.ACTIVE_IND = 'A' and " +
						"    profProfile.USER_ID=prof.USER_ID and profProfile.status='A' and " +
						"    office.OFFICE_ID=clientOffice.OFFICE_ID and office.ACTIVE_IND='A' and " +
						"    address.ADDRESS_ID=office.ADDRESS_ID and address.ACTIVE_IND='A' and " +
						"    sch.CLIENT_OFFICE_ID=clientOffice.CLIENT_OFFICE_ID and sch.status='A' ");
		query.setParameter(1,email);

		List<Map<String,Object>> returnList = new ArrayList<>();

		List<Object[]> resultList = query.getResultList();
		for ( Object[] objArr : resultList) {
			Map<String,Object> map = new HashMap<>();
			map.put("FIRST_NAME",objArr[0]);
			map.put("MIDDLE_NAME",objArr[1]);
			map.put("LAST_NAME",objArr[2]);
			map.put("OFFICE_NAME",objArr[3]);
			map.put("LOCATION",objArr[4]);
			map.put("LINE_1",objArr[5]);
			map.put("LINE_2",objArr[6]);
			map.put("CITY",objArr[7]);
			map.put("STATE",objArr[8]);
			map.put("ZIP",objArr[9]);
			map.put("COUNTRY",objArr[10]);
			map.put("PHONE_NUMBER",objArr[10]);
			returnList.add(map);
		}



		return returnList;
	}
}
