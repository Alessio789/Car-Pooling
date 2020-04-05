package it.carpooling.entity;

import java.util.Date;
import lombok.*;


/**
 *
 * @author Alessio Trentin
 */
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    
    @Getter @Setter
    private int id;
    
    @Getter @Setter
    private String title;
    
    @Getter @Setter
    private double vote;
    
    @Getter @Setter
    private String judgement;
    
    @Getter @Setter
    private Date timestamp;
    
    @Getter @Setter
    private CarPoolingUser author;
    
    @Getter @Setter
    private CarPoolingUser recipient;
}
