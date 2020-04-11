package it.carpooling.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.*;

/**
 *
 * @author Alessio Trentin
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
@NoArgsConstructor  
@AllArgsConstructor
public abstract class CarPoolingUser {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;
    
    @Column(nullable = false)
    @Getter @Setter
    private String name;
    
    @Column(nullable = false)
    @Getter @Setter
    private String lastName;
    
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String fiscalCode;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @Getter @Setter
    private Date birthDate;
    
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String phoneNumber;
    
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String email;
    
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String username;
    
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String PasswordHash;
    
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String salt;

    public CarPoolingUser(String name, String lastName, String fiscalCode, Date birthDate, String phoneNumber, String email, String username, String PasswordHash, String salt) {
        this.name = name;
        this.lastName = lastName;
        this.fiscalCode = fiscalCode;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.PasswordHash = PasswordHash;
        this.salt = salt;
    }
    
    
    
}
