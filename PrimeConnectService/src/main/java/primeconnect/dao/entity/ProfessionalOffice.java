package primeconnect.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="PC_PROFESSIONAL_OFFICE")
public class ProfessionalOffice {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PROFESSIONAL_OFFICE_ID")
    private Integer professionalOfficeId;

    @Column(name="PROFESSIONAL_ID")
    private Integer professionalId;

    @Column(name="OFFICE_ID")
    private Integer officeId;

    @Column(name="ACTIVE_IND")
    private Character activeInd;

    public Integer getProfessionalOfficeId() {
        return professionalOfficeId;
    }

    public void setProfessionalOfficeId(Integer professionalOfficeId) {
        this.professionalOfficeId = professionalOfficeId;
    }

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public Character getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(Character activeInd) {
        this.activeInd = activeInd;
    }
}
