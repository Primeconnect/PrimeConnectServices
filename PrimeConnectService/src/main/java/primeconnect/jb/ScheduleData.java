package primeconnect.jb;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@Entity
@SqlResultSetMapping(name="schedule",entities=@EntityResult(entityClass=ScheduleData.class))
@NamedNativeQuery(name="findProfessionalScheduleByEmail", 
query= "select userProf.FIRST_NAME, userProf.LAST_NAME, userProf.MIDDLE_NAME, prof.PROFESSION, sch.SCHEDULE_ID, sch.START_TIME,sch.END_TIME " +  
" from PC_CORE.PC_SCHEDULE sch, " +
" PC_CORE.PC_CLIENT_OFFICE cltOff, " + 
" PC_CORE.PC_PROFESSIONAL prof, " +
" PC_CORE.PC_USER_PROFILE userClient, " +
" PC_CORE.PC_USER_PROFILE userProf, " +
" PC_CORE.PC_CLIENT clt " +  
" where cltOff.CLIENT_OFFICE_ID=sch.CLIENT_OFFICE_ID and " +
" cltOff.PROFESSIONAL_ID=prof.PROFESSIONAL_ID and " +
" prof.USER_ID=userProf.USER_ID and " +
" cltOff.CLIENT_ID=clt.CLIENT_ID and " +
" clt.USER_ID=userClient.USER_ID and " + 
" userClient.email=:email " ,  
	  resultSetMapping="schedule")

public class ScheduleData {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="schedule_id")
	private Long scheduleId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="profession")
	private String profession;

	@Column(name="start_time")
	private Date startTime;

	@Column(name="end_time")
	private Date endTime;

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
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

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

			
}
