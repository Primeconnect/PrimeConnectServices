package primeconnect.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="PC_SCHEDULE")
public class Schedule {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="SCHEDULE_ID")
    private Integer scheduleId;

    @Column(name="CLIENT_OFFICE_ID")
    private Integer clientOfficeId;

    @Column(name="PROFESSIONAL_OFFICE_ID")
    private Integer professionalOfficeId;

    @Column(name="START_TIME")
    private Date startTime;

    @Column(name="END_TIME")
    private Date endTime;

    @Column(name="STATUS")
    private Character status;

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getClientOfficeId() {
        return clientOfficeId;
    }

    public void setClientOfficeId(Integer clientOfficeId) {
        this.clientOfficeId = clientOfficeId;
    }

    public Integer getProfessionalOfficeId() {
        return professionalOfficeId;
    }

    public void setProfessionalOfficeId(Integer professionalOfficeId) {
        this.professionalOfficeId = professionalOfficeId;
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

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
}
