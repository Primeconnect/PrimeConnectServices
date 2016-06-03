package primeconnect.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="PC_OFFICE")
public class Office {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="OFFICE_ID")
    private Integer officeId;

    @Column(name="NAME")
    private String name;

    @Column(name="LOCATION")
    private String location;

    @Column(name="ADDRESS_ID")
    private Integer addressId;

    @Column(name="ADD_TIMESTAMP")
    private Date addTimestamp;

    @Column(name="ADD_USER_NAME")
    private String addUserName;

    @Column(name="UPDATE_TIMESTAMP")
    private Date updateTimestamp;

    @Column(name="UPDATE_USER_NAME")
    private String updateUserName;

    @Column(name="ACTIVE_IND")
    private Character activeInd;

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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

    public Character getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(Character activeInd) {
        this.activeInd = activeInd;
    }
}
