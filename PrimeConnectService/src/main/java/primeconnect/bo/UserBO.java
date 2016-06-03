package primeconnect.bo;

import primeconnect.dao.IUserDAO;
import primeconnect.dao.entity.UserProfile;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

@Named
public class UserBO implements IUserBO {

	@Inject
	@NotNull
	private IUserDAO userDAO;
	
	@Override
	public UserProfile getUser(String email)
	{
		return userDAO.getUserProfile(email);
	}

	@Override
	public UserProfile getUser(Long userId)
	{
		return userDAO.getUserProfile(userId);
	}
}
