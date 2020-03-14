package it.marconivr.domain;

import java.util.Date;
import lombok.*;


/**
 *
 * @author Alessio Trentin
 */
public class Passenger extends User{
    
    @Getter @Setter
    private String numDocument;

    /**
     * 
     * Constructor
     * 
     * @param numDocument
     * @param id
     * @param name
     * @param lastname
     * @param fiscalCode
     * @param birthDate
     * @param phoneNumber
     * @param email
     * @param PasswordHash 
     */
    public Passenger(String numDocument, int id, String name, String lastname, 
            String fiscalCode, Date birthDate, String phoneNumber, String email,
            long PasswordHash) {
        
        super(id, name, lastname, fiscalCode, birthDate, phoneNumber, email, PasswordHash);
        this.numDocument = numDocument;
    }
}
