package it.carpooling.entity;

import javax.persistence.*;
import lombok.*;


/**
 *
 * @author Alessio Trentin
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;

    @Column(nullable = false)
    @Getter @Setter
    private boolean accepted;
    
    @ManyToOne(targetEntity = Passenger.class)
    @JoinColumn(nullable = false)
    @Getter @Setter
    private Passenger passenger;
    
    @ManyToOne(targetEntity = Travel.class)
    @JoinColumn(nullable = false)
    @Getter @Setter
    private Travel travel;
}
