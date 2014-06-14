package fourguys.service.form;

import javax.ws.rs.FormParam;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class ThirdPartyRegisterFormBean implements IRegisterFormBean
{
	@NotBlank
	@FormParam("uname")
	private String username;
	
	//Not applicable
	private String password;
	
	@NotBlank
	@FormParam("fname")
	private String firstName;
	
	@FormParam("mname")
	private String middleName;
	
	@NotBlank
	@FormParam("lname")
	private String lastName;
	
	@Email
	@NotBlank
	@FormParam("email")
	private String email;
	
	@FormParam("pnum")
	private String phoneNumber;
	
	@FormParam("fnum")
	private String faxNumber;

	//getters
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
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
		return Character.valueOf('A');
	}
}
