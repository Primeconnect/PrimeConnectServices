package primeconnect.dao;

import primeconnect.dao.entity.UserProfile;
import primeconnect.jb.ProfessionalData;
import primeconnect.jb.Profile;

import java.util.List;

public interface IUserDAO
{
	public UserProfile getUserProfile(Long userId);
	public UserProfile getUserProfile(String email);
}
