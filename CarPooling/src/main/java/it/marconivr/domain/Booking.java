package it.marconivr.domain;

import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Alessio Trentin
 */
public class Booking {
    
    @Getter @Setter
    private int id;

    @Getter @Setter    
    private boolean accepted;
    
    @Getter @Setter
    private Passenger passenger;
    
    @Getter @Setter
    private Travel travel;
    
    /**
     * 
     * Constructor
     * 
     * @param id
     * @param passenger
     * @param travel 
     */
    public Booking(int id, Passenger passenger, Travel travel) {
        this.id = id;
        this.passenger = passenger;
        this.travel = travel;
    }
}
