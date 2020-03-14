package it.marconivr.domain;

import java.util.Date;
import lombok.*;

/**
 *
 * @author Alessio Trentin
 */
public abstract class User {
 
    @Getter @Setter
    private int id;
    
    @Getter @Setter
    private String name;
    
    @Getter @Setter
    private String lastname;
    
    @Getter @Setter
    private String fiscalCode;
    
    @Getter @Setter
    private Date birthDate;
    
    @Getter @Setter
    private String phoneNumber;
    
    @Getter @Setter
    private String email;
    
    @Getter @Setter
    private long PasswordHash;
    
    /**
     * 
     * Constructor
     * 
     * @param id
     * @param name
     * @param lastname
     * @param fiscalCode
     * @param birthDate
     * @param phoneNumber
     * @param email
     * @param PasswordHash 
     */
    public User(int id, String name, String lastname, String fiscalCode, 
            Date birthDate, String phoneNumber, String email, 
            long PasswordHash) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.fiscalCode = fiscalCode;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.PasswordHash = PasswordHash;
    }
}
