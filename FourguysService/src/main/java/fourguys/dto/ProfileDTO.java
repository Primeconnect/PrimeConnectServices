package fourguys.dto;

import javax.xml.bind.annotation.XmlRootElement;

import fourguys.jb.Profile;

@XmlRootElement
public class ProfileDTO
{
	private Profile profile;
	
	public ProfileDTO(Profile profile)
	{
		this.profile = profile;
	}
	
	public String getUserName() {
		return profile != null ? profile.getUserName() : null;
	}

	public String getFirstName() {
		return profile != null ? profile.getFirstName() : null;
	}

	public String getLastName() {
		return profile != null ? profile.getLastName() : null;
	}

	public String getMiddleName() {
		return profile != null ? profile.getMiddleName() : null;
	}

	public String getEmail() {
		return profile != null ? profile.getEmail() : null;
	}

	public String getPhoneNumber() {
		return profile != null ? profile.getPhoneNumber() : null;
	}

	public String getFaxNumber() {
		return profile != null ? profile.getFaxNumber() : null;
	}

	public Character getStatus() {
		return profile != null ? profile.getStatus() : null;
	}
}
