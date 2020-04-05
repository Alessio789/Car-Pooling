package it.carpooling.entity;

import java.util.Date;
import lombok.*;

/**
 *
 * @author Alessio Trentin
 */
@NoArgsConstructor  
@AllArgsConstructor
public abstract class CarPoolingUser {
 
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
}
