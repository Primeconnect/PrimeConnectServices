package primeconnect.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.plugins.validation.hibernate.ValidateRequest;

@Path("/")
public class DummyService 
{

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GET
    @Path("dummy")
    @Produces(MediaType.APPLICATION_JSON)
    @ValidateRequest
    public Map getDummyResults() 
    {
    	Map map = new HashMap();
    	
    	map.put("resultError", null);
    	map.put("successful", true);
    	
    	Map map2 = new HashMap();
    	map2.put("email", "william@gmail.com");
    	map2.put("uname", "will");
    	map2.put("fname", "William");
    	map2.put("lname", "Lee");
    	
    	List list = new ArrayList(1);
    	Map map3 = new HashMap();
    	map3.put("fname", "Lorraine");
    	map3.put("lname", "McCarthy");
    	map3.put("profession", "Dentist");
    	list.add(map3);
    	map2.put("professional", list);
    	
    	List list1 = new ArrayList(1);
    	Map map4 = new HashMap();
    	map4.put("fname", "Lorraine");
    	map4.put("lname", "McCarthy");
    	map4.put("profession", "Dentist");
    	map4.put("stime", "4898834");
    	map4.put("etime", "5454535");
    	list1.add(map4);
    	map2.put("appointment", list1);
    	
    	map.put("result", map2);
    	
    	return map;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GET
    @Path("dummy/user")
    @Produces(MediaType.APPLICATION_JSON)
    @ValidateRequest
    public Map getDummyUser(@QueryParam("email") String email) 
    {
    	Map map = new HashMap();
    	
    	map.put("resultError", null);
    	map.put("successful", true);
    	
    	Map map2 = new HashMap();
    	map2.put("email", email);
    	
    	int indexAt = email.indexOf('@');
    	if( indexAt < 0 )
    	{
	    	map2.put("uname", "will");
	    	map2.put("fname", "William");
	    	map2.put("lname", "Lee");
    	}
    	else
    	{
    		String emailWithAt = email.substring(0,indexAt);
    		map2.put("uname", emailWithAt);
	    	map2.put("fname", emailWithAt);
	    	map2.put("lname", emailWithAt);
    	}
    	map.put("result", map2);
    	
    	return map;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GET
    @Path("dummy/professional")
    @Produces(MediaType.APPLICATION_JSON)
    @ValidateRequest
    public Map getDummyProf(@QueryParam("email") String email) 
    {
    	Map map = new HashMap();
    	
    	map.put("resultError", null);
    	map.put("successful", true);
    	
    	List<Map<String,String>> profList = new ArrayList<Map<String,String>>();
    	for(int i=0; i<50; i++)
    	{
    		Map<String,String> profMap = new HashMap<String,String>();
    		profMap.put("fname","profFirst"+i);
    		profMap.put("lname","profLast"+i);
    		if( i % 2 == 1)
    			profMap.put("profession","Cardiologist");
    		else
    			profMap.put("profession","Dentist");
    		profList.add(profMap);
    	}
    	map.put("result", profList);
    	
    	return map;
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GET
    @Path("dummy/schedule")
    @Produces(MediaType.APPLICATION_JSON)
    @ValidateRequest
    public Map getDummySchedule(@QueryParam("email") String email) 
    {
    	Map map = new HashMap();
    	
    	map.put("resultError", null);
    	map.put("successful", true);
    	
    	List<Map<String,String>> scheduleList = new ArrayList<>();
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(new Date());
    	for(int i=0; i<5; i++)
    	{
    		Map<String,String> scheduleMap = new HashMap<>();
    		
    		cal.add(Calendar.HOUR_OF_DAY, 1);
    		long stime = cal.getTimeInMillis();
    		cal.add(Calendar.HOUR_OF_DAY, 1);
    		long etime = cal.getTimeInMillis();
    		
    		scheduleMap.put("stime",""+stime);
    		scheduleMap.put("etime",""+etime);
    		scheduleMap.put("fname","profFirst"+i);
    		scheduleMap.put("lname","profLast"+i);
    		
    		scheduleList.add(scheduleMap);
    	}
    	map.put("result", scheduleList);
    	
    	return map;
    }
        
}
