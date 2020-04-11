package it.carpooling.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.*;


/**
 *
 * @author Alessio Trentin
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Passenger extends CarPoolingUser{
    
    @Column(unique = true)
    @Getter @Setter
    private String numDocument;

    public Passenger(String name, String lastName, String fiscalCode, Date birthDate, String phoneNumber, String email, String username, String PasswordHash, String salt, String numDocument) {
        super(name, lastName, fiscalCode, birthDate, phoneNumber, email, username, PasswordHash, salt);
        this.numDocument = numDocument;
    }
   
}
