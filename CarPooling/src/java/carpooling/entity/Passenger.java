package carpooling.entity;

import lombok.*;


/**
 *
 * @author Alessio Trentin
 */
@AllArgsConstructor
@NoArgsConstructor
public class Passenger extends CarPoolingUser{
    
    @Getter @Setter
    private String numDocument;
}
