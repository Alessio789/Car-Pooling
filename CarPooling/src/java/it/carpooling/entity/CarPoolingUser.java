package it.carpooling.entity;

import java.io.Serializable;
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
public abstract class CarPoolingUser implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;
    
    @Column(nullable = false)
    @Getter @Setter
    private String name;
    
    @Column(nullable = false)
    @Getter @Setter
    private String lastname;
    
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
    private String PasswordHash;
    
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String salt;
}
