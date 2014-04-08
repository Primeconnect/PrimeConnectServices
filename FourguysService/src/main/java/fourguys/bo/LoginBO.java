package fourguys.bo;

import javax.inject.Named;

import fourguys.dto.Profile;


@Named
public class LoginBO implements ILoginBO 
{
	public Profile getProfileForProvider(final String userName)
	{
		if(!userName.equals("batman"))
			throw new RuntimeException("You are not batman!!");
		
		Profile b = new Profile();
    	b.setUserName(userName);
    	b.setClientType("Provider");
    	b.setFirstName("Bruce");
    	b.setLastName("Wayne");
    	b.setAddress1("1007 Mountain Drive");
    	b.setCity("Gotham City");
    	b.setState("Gotham State");
    	b.setZipCode("88888");
    	b.setPhoneNumber("888-888-8888");
    	b.setEmail("bruce.wayne@wayne_industries");
    	b.setSecondaryEmail("batman@batcave");
        return b;
	}
	
	public Profile getProfileForClient(final String userName)
	{
		Profile b = new Profile();
    	b.setUserName(userName);
    	b.setClientType("Client");
    	b.setFirstName("Bruce");
    	b.setLastName("Wayne");
    	b.setAddress1("1007 Mountain Drive");
    	b.setCity("Gotham City");
    	b.setState("Gotham State");
    	b.setZipCode("88888");
    	b.setPhoneNumber("888-888-8888");
    	b.setEmail("bruce.wayne@wayne_industries");
    	b.setSecondaryEmail("batman@batcave");
        return b;
	}
}
