package primeconnect.jb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@Entity
@SqlResultSetMapping(name="implicit",entities=@EntityResult(entityClass=ProfessionalData.class))
@NamedNativeQuery(name="findProfessionalByEmail", 
query=" select userProf.FIRST_NAME, userProf.LAST_NAME, userProf.MIDDLE_NAME, userProf.PHONE_NUMBER, userProf.email, " + 
	  " prof.PROFESSIONAL_ID, prof.PROFESSION, address.LINE_1, address.LINE_2, address.CITY, address.STATE, address.ZIP, address.COUNTRY from " +
	  " PC_CORE.PC_PROFESSIONAL prof, " + 
	  " PC_CORE.PC_PROFESSIONAL_OFFICE profOffice, " +
	  " PC_CORE.PC_OFFICE office, " +
	  " PC_CORE.PC_CLIENT clt, " + 
	  " PC_CORE.PC_CLIENT_OFFICE clientOffice, " + 
	  " PC_CORE.PC_ADDRESS address, " + 
	  " PC_CORE.PC_USER_PROFILE userClient, " +
    " PC_CORE.PC_USER_PROFILE userProf "+ 
	" where " +
	" userClient.EMAIL=:email and " +
    " clt.USER_ID=userClient.USER_ID and " +
	" clientOffice.CLIENT_ID=clt.CLIENT_ID and " +
    " prof.PROFESSIONAL_ID=clientOffice.PROFESSIONAL_ID and " +
    " userProf.USER_ID=prof.USER_ID and " +
    " office.OFFICE_ID=clientOffice.OFFICE_ID and " + 
	" profOffice.PROFESSIONAL_ID=prof.PROFESSIONAL_ID and " +  
	" profOffice.OFFICE_ID=office.OFFICE_ID and " +  
	" office.ADDRESS_ID=address.ADDRESS_ID  and " +
	" userProf.STATUS='A' and " +
	" address.ACTIVE_IND='A' ", 
	  
resultSetMapping="implicit")

public class ProfessionalData {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="professional_id")
	private Long professionalId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_number")
	private String phoneNumber;

	@Column(name="profession")
	private String profession;

	@Column(name="line_1")
	private String address_line1;

	@Column(name="line_2")
	private String address_line2;

	@Column(name="city")
	private String address_city;

	@Column(name="state")
	private String address_state;

	@Column(name="zip")
	private String address_zip;

	public Long getProfessionalId() {
		return professionalId;
	}

	public void setProfessionalId(Long professionalId) {
		this.professionalId = professionalId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getAddress_line1() {
		return address_line1;
	}

	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}

	public String getAddress_line2() {
		return address_line2;
	}

	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}

	public String getAddress_city() {
		return address_city;
	}

	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}

	public String getAddress_state() {
		return address_state;
	}

	public void setAddress_state(String address_state) {
		this.address_state = address_state;
	}

	public String getAddress_zip() {
		return address_zip;
	}

	public void setAddress_zip(String address_zip) {
		this.address_zip = address_zip;
	}

	public String getAddress_country() {
		return address_country;
	}

	public void setAddress_country(String address_country) {
		this.address_country = address_country;
	}

	@Column(name="country")
	private String address_country;
		
}
