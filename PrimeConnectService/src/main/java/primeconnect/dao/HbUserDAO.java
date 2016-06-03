package primeconnect.dao;

import primeconnect.dao.entity.UserProfile;
import primeconnect.jb.ScheduleData;
import primeconnect.util.Hasher;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class HbUserDAO extends AbstractBaseJPADAO implements IUserDAO
{

	@Override
	public UserProfile getUserProfile(Long userId) {
		return getUniqueResult(userId,UserProfile.class);
	}

	@Override
	public UserProfile getUserProfile(String email) {
		return getUniqueResult("select u from UserProfile u where email=?", UserProfile.class, email);
	}
}
