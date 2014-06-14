package fourguys.util;

import javax.inject.Named;

@Named
public class SimpleStringHasher implements Hasher {

	@Override
	public String hash(String input) 
	{
		return ""+input.hashCode();
	}

}
