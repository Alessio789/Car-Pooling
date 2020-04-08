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
    
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String numDrivingLicense;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @Getter @Setter
    private Date deadline;  
}
