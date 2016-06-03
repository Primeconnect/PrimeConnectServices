package primeconnect.dao.entity;

import javax.persistence.*;

@Entity
@Table(name="PC_CLIENT_OFFICE")
public class ClientProfessionalOffice {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="CLIENT_OFFICE_ID")
    private Integer clientOfficeId;

    @Column(name="CLIENT_ID")
    private Integer clientId;

    @Column(name="OFFICE_ID")
    private Integer officeId;

    @Column(name="ACTIVE_IND")
    private Character activeInd;

    @Column(name="PROFESSIONAL_ID")
    private Integer professionalId;

}
