package carpooling.entity;

import java.util.Date;
import lombok.*;

/**
 *
 * @author Alessio Trentin
 */
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends CarPoolingUser {
    
    @Getter @Setter
    private String numDrivingLicense;
    
    @Getter @Setter
    private Date deadline;  
}
