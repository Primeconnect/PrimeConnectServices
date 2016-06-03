package primeconnect.dao.entity;

import javax.persistence.*;

@Entity
@Table(name="PC_CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CLIENT_ID")
    private Integer clientId;

    @Column(name="USER_ID")
    private Integer userId;

    @Column(name="TYPE")
    private String type;

    @Column(name="ADDRESS_ID")
    private Integer addressId;

    @Column(name="BILLING_ADDRESS_ID")
    private Integer billingAddressId;

    @Column(name="ACTIVE_IND")
    private Character activeInd;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(Integer billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public Character getActiveInd() {
        return activeInd;
    }

    public void setActiveInd(Character activeInd) {
        this.activeInd = activeInd;
    }
}
