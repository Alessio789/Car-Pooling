package carpooling.entity;

import java.util.Date;
import lombok.*;


/**
 *
 * @author Alessio Trentin
 */
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    
    @Getter @Setter
    private int id;
    
    @Getter @Setter
    private String brand;
    
    @Getter @Setter
    private String model;
    
    @Getter @Setter
    private Date registrationDate;
    
    @Getter @Setter
    private int kmTraveled;
    
    @Getter @Setter
    private String licensePlate;
    
    @Getter @Setter
    private int numberSeats;
    
    @Getter @Setter
    private Driver driver;
}
