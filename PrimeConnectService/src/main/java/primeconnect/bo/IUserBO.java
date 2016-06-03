package primeconnect.bo;

import primeconnect.dao.entity.UserProfile;

/**
 * Created by William on 6/2/2016.
 */
public interface IUserBO {
    UserProfile getUser(String email);

    UserProfile getUser(Long userId);
}
