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
public class Travel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;
    
    @Column(nullable = false)
    @Getter @Setter
    private String departureCity;
    
    @Column(nullable = false)
    @Getter @Setter
    private String arrivalCity;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @Getter @Setter
    private Date date;
    
    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    @Getter @Setter
    private Date hours;
    
    @Column(nullable = false)
    @Getter @Setter
    private double contribution;

    @Column(nullable = false)    
    @Getter @Setter
    private boolean prenotable = true;
    
    @Column(nullable = false)
    @Getter @Setter
    private int travelTime;
    
    @Column(nullable = false)
    @Getter @Setter
    private boolean luggage;
    
    @Lob
    @Column
    @Getter @Setter
    private String additionalNotes;  
    
    @ManyToOne(targetEntity = Driver.class)
    @JoinColumn(nullable = false)
    @Getter @Setter
    private Driver driver;

    public Travel(String departureCity, String arrivalCity, Date date, Date hours, double contribution, int travelTime, boolean luggage, String additionalNotes, Driver driver) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.date = date;
        this.hours = hours;
        this.contribution = contribution;
        this.travelTime = travelTime;
        this.luggage = luggage;
        this.additionalNotes = additionalNotes;
        this.driver = driver;
    }
}
