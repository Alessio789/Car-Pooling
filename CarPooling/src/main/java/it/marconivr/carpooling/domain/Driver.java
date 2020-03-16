package it.marconivr.carpooling.domain;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Alessio Trentin
 */
public class Driver extends User {
    
    @Getter @Setter
    private String numDrivingLicense;
    
    @Getter @Setter
    private Date deadline;

    /**
     * 
     * Constructor
     * 
     * @param numDrivingLicense
     * @param deadline
     * @param id
     * @param name
     * @param lastname
     * @param fiscalCode
     * @param birthDate
     * @param phoneNumber
     * @param email
     * @param PasswordHash 
     */
    public Driver(String numDrivingLicense, Date deadline, int id, String name, 
            String lastname, String fiscalCode, Date birthDate, 
            String phoneNumber, String email, long PasswordHash) {
        
        super(id, name, lastname, fiscalCode, birthDate, phoneNumber, email, 
                PasswordHash);
        this.numDrivingLicense = numDrivingLicense;
        this.deadline = deadline;
    }   
}
