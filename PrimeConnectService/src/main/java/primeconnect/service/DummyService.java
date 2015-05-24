package primeconnect.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
public class DummyService 
{

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@GET
    @Path("dummy/social")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getDummyResults(@QueryParam("email") String email) 
    {
    	if( email.equals("leelawliet7@gmail.com"))
    	{
	    	Map map = new HashMap();
	    	
	    	map.put("resultError", null);
	    	map.put("successful", true);
	    	
	    	Map map2 = new HashMap();
	    	map2.put("email", email);
	    	map2.put("username", "will");
	    	map2.put("firstname", "Lee");
	    	map2.put("lastname", "Lawliet");
	    	
//	    	List list = new ArrayList(1);
//	    	Map map3 = new HashMap();
//	    	map3.put("firstname", "Lorraine");
//	    	map3.put("lastname", "McCarthy");
//	    	map3.put("profession", "Dentist");
//	    	list.add(map3);
//	    	map2.put("professional", list);
//	    	
//	    	List list1 = new ArrayList(1);
//	    	Map map4 = new HashMap();
//	    	map4.put("fname", "Lorraine");
//	    	map4.put("lname", "McCarthy");
//	    	map4.put("profession", "Dentist");
//	    	map4.put("stime", "4898834");
//	    	map4.put("etime", "5454535");
//	    	list1.add(map4);
//	    	map2.put("appointment", list1);
	    	
	    	map.put("result", map2);
	    	
	    	return map;
    	}
    	else if( email.equals("chetancmehta@gmail.com"))
    	{
	    	Map map = new HashMap();
	    	
	    	map.put("resultError", null);
	    	map.put("successful", true);
	    	
	    	Map map2 = new HashMap();
	    	map2.put("email", email);
//	    	map2.put("username", "will");
	    	map2.put("firstname", "Chetan");
	    	map2.put("lastname", "Mehta");
	    	
	    	map.put("result", map2);
	    	
	    	return map;
    	}
    	else
    	{
    		Map map = new HashMap();
	    	
	    	map.put("resultError", null);
	    	map.put("successful", true);
	    	
	    	return map;
    	}
    }
    
    
        
}
