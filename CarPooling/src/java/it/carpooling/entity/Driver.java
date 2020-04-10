package it.carpooling.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.*;

/**
 *
 * @author Alessio Trentin
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends CarPoolingUser {
    
    @Column(unique = true)
    @Getter @Setter
    private String numDrivingLicense;
    
    @Temporal(TemporalType.DATE)
    @Column()
    @Getter @Setter
    private Date deadline;  

    public Driver(String numDrivingLicense, Date deadline, String name, String lastName, String fiscalCode, Date birthDate, String phoneNumber, String email, String username, String PasswordHash, String salt) {
        super(name, lastName, fiscalCode, birthDate, phoneNumber, email, username, PasswordHash, salt);
        this.numDrivingLicense = numDrivingLicense;
        this.deadline = deadline;
    }    
}
