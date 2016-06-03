package primeconnect.dao.entity;

import javax.persistence.*;

@Entity
@Table(name="PC_ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ADDRESS_ID")
    private Integer addressId;

    @Column(name="LINE_1")
    private String line1;

    @Column(name="LINE_2")
    private String line2;

    @Column(name="CITY")
    private String city;

    @Column(name="STATE")
    private String state;

    @Column(name="ZIP")
    private String zip;

    @Column(name="COUNTRY")
    private String country;

    @Column(name="ACTIVE_IND")
    private Character activeInd;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Character getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(Character activeInd) {
        this.activeInd = activeInd;
    }
}
