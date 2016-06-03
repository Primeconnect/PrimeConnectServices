package primeconnect.dto;

import primeconnect.dao.entity.*;

import java.util.Date;

public class ScheduleDTO {
	
	private UserProfile userProfile;
	private Schedule schedule;
	private Professional professional;
	private Office office;
	private Address address;

	public ScheduleDTO(UserProfile userProfile, Schedule schedule, Professional professional, Office office, Address address) {
		this.userProfile = userProfile;
		this.schedule = schedule;
		this.professional = professional;
		this.office = office;
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

	public String getProfession() {
		return professional.getProfession();
	}

	public String getSubProfession() {
		return professional.getSubProfession();
	}

	public Date getStartTime() {
		return schedule.getStartTime();
	}

	public Date getEndTime() {
		return schedule.getEndTime();
	}

	public String getName() {
		return office.getName();
	}

	public String getLocation() {
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
