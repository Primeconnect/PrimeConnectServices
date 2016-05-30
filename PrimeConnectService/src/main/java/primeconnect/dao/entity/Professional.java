package primeconnect.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="PC_PROFESSIONAL")
public class Professional {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PROFESSIONAL_ID")
    private Integer professionalId;

    @Column(name="PROFESSION")
    private String profession;

    @Column(name="SUB_PROFESSION")
    private String subProfession;

    @Column(name="ACTIVE_IND")
    private Character activeInd;

    @Column(name="ADD_TIMESTAMP")
    private Date addTimestamp;

    @Column(name="ADD_USER_NAME")
    private String addUserName;

    @Column(name="UPDATE_TIMESTAMP")
    private Date updateTimestamp;

    @Column(name="UPDATE_USER_NAME")
    private String updateUserName;

    @Column(name="USER_ID")
    private Integer userId;

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSubProfession() {
        return subProfession;
    }

    public void setSubProfession(String subProfession) {
        this.subProfession = subProfession;
    }

    public Character getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(Character activeInd) {
        this.activeInd = activeInd;
    }

    public Date getAddTimestamp() {
        return addTimestamp;
    }

    public void setAddTimestamp(Date addTimestamp) {
        this.addTimestamp = addTimestamp;
    }

    public String getAddUserName() {
        return addUserName;
    }

    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }

    public Date getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Date updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
