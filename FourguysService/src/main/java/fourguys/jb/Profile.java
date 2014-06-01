package fourguys.jb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PC_USER_PROFILE")
public class Profile
{
	
//	@Id
//	@Column(name="user_id")
//	private Integer userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Id
	private String email;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="fax_number")
	private String faxNumber;
	
	@Column(name="password")
	private String hashedPassword;
	
	private Character status;

//	public Integer getUserId() {
//		return userId;
//	}

	public String getUserName() {
		return userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public Character getStatus() {
		return status;
	}
	
	public String getPassword() {
		//TODO: unhash the password
		return hashedPassword;
	}

}
