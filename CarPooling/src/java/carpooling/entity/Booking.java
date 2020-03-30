package carpooling.entity;

import lombok.*;


/**
 *
 * @author Alessio Trentin
 */
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    
    @Getter @Setter
    private int id;

    @Getter @Setter    
    private boolean accepted;
    
    @Getter @Setter
    private Passenger passenger;
    
    @Getter @Setter
    private Travel travel;
}
