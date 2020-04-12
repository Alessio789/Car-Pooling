package it.carpooling.entity;

import javax.persistence.*;
import lombok.*;


/**
 *
 * @author Alessio Trentin
 */
@Entity
@NoArgsConstructor
public class Booking {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;

    @Column
    @Getter @Setter
    private Boolean accepted = null;
    
    @ManyToOne(targetEntity = Passenger.class)
    @JoinColumn(nullable = false)
    @Getter @Setter
    private Passenger passenger;
    
    @ManyToOne(targetEntity = Travel.class)
    @JoinColumn(nullable = false)
    @Getter @Setter
    private Travel travel;

    public Booking(Passenger passenger, Travel travel) {
        this.passenger = passenger;
        this.travel = travel;
    }
}
