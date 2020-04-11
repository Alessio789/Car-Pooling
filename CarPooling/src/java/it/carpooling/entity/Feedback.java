package it.carpooling.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.*;


/**
 *
 * @author Alessio Trentin
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;
    
    @Column(nullable = false)
    @Getter @Setter
    private String title;
    
    @Column(nullable = false)
    @Getter @Setter
    private double vote;
    
    @Lob
    @Column(nullable = false)
    @Getter @Setter
    private String judgement;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Getter @Setter
    private Date timestamp;
    
    @ManyToOne(targetEntity = CarPoolingUser.class)
    @JoinColumn(nullable = false)
    @Getter @Setter
    private CarPoolingUser author;
    
    @ManyToOne(targetEntity = CarPoolingUser.class)
    @JoinColumn(nullable = false)
    @Getter @Setter
    private CarPoolingUser recipient;
}
