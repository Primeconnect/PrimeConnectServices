package primeconnect.dto;

import primeconnect.dao.entity.UserProfile;

public class UserDTO {

    private UserProfile userProfile;

    public UserDTO(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public Long getUserId() {
        return userProfile.getUserId();
    }

    public String getFirstName() {
        return userProfile.getFirstName();
    }

    public String getMiddleName() {
        return userProfile.getMiddleName();
    }

    public String getLastName() {
        return userProfile.getLastName();
    }

    public String getEmail() {
        return userProfile.getEmail();
    }

    public String getPhoneNumber() {
        return userProfile.getPhoneNumber();
    }

    public String getFaxNumber() {
        return userProfile.getFaxNumber();
    }
}
