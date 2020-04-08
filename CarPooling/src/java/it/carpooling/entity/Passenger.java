package it.carpooling.entity;

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
    
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String numDocument;
}
