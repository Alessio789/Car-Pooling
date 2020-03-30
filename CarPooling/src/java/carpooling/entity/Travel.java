package carpooling.entity;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import lombok.*;


/**
 *
 * @author Alessio Trentin
 */
@AllArgsConstructor
@NoArgsConstructor
public class Travel {
    
    @Getter @Setter
    private int id;
    
    @Getter @Setter
    private String departureCity;
    
    @Getter @Setter
    private String arrivalCity;
    
    @Getter @Setter
    private Date date;
    
    @Getter @Setter
    private LocalTime hour;
    
    @Getter @Setter
    private double contribution;
    
    @Getter @Setter
    private boolean prenotable = true;
    
    @Getter @Setter
    private Time travelTime;
    
    @Getter @Setter
    private boolean luggage;
    
    @Getter @Setter
    private String additionalNotes;  
    
    @Getter @Setter
    private Driver driver;
}
