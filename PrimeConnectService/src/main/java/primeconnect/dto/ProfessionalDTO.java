package primeconnect.dto;

import primeconnect.dao.entity.Address;
import primeconnect.dao.entity.Office;
import primeconnect.dao.entity.Professional;
import primeconnect.dao.entity.UserProfile;

public class ProfessionalDTO {

	private UserProfile userProfile;
	private Professional professional;
	private Office office;
	private Address address;

	public ProfessionalDTO(UserProfile userProfile,Professional professional, Office office, Address address) {
		this.userProfile = userProfile;
		this.professional = professional;
		this.office=office;
		this.address = address;
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

	public String getProfession() {
		return professional.getProfession();
	}

	public String getSubProfession() {
		return professional.getSubProfession();
	}

	public String getOfficeName() {
		return office.getName();
	}

	public String getOfficeLocation() {
		return office.getLocation();
	}

	public String getLine1() {
		return address.getLine1();
	}

	public String getLine2() {
		return address.getLine2();
	}

	public String getCity() {
		return address.getCity();
	}

	public String getState() {
		return address.getState();
	}

	public String getZip() {
		return address.getZip();
	}

	public String getCountry() {
		return address.getCountry();
	}
	
}
