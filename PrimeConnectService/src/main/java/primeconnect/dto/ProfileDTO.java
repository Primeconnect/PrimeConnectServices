package primeconnect.dto;

import javax.xml.bind.annotation.XmlRootElement;

import primeconnect.jb.Profile;

@XmlRootElement
public class ProfileDTO
{
	private Profile profile;
	
	public ProfileDTO(Profile profile)
	{
		this.profile = profile;
	}
	
	public String getUName() {
		return profile != null ? profile.getUserName() : null;
	}

	public String getFName() {
		return profile != null ? profile.getFirstName() : null;
	}

	public String getLName() {
		return profile != null ? profile.getLastName() : null;
	}

	public String getMName() {
		return profile != null ? profile.getMiddleName() : null;
	}

	public String getEmail() {
		return profile != null ? profile.getEmail() : null;
	}

	public String getPNum() {
		return profile != null ? profile.getPhoneNumber() : null;
	}

	public String getFNum() {
		return profile != null ? profile.getFaxNumber() : null;
	}

	public Character getStatus() {
		return profile != null ? profile.getStatus() : null;
	}
}
