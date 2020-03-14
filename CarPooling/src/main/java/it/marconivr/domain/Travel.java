package it.marconivr.domain;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Alessio Trentin
 */
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
    
    /**
     * 
     * Constructor
     * 
     * @param id
     * @param departureCity
     * @param arrivalCity
     * @param date
     * @param hour
     * @param contribution
     * @param travelTime
     * @param luggage
     * @param additionalNotes 
     * @param driver 
     */
    public Travel(int id, String departureCity, String arrivalCity, Date date, 
            LocalTime hour, double contribution, Time travelTime, 
            boolean luggage, String additionalNotes, Driver driver) {
        
        this.id = id;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.date = date;
        this.hour = hour;
        this.contribution = contribution;
        this.travelTime = travelTime;
        this.luggage = luggage;
        this.additionalNotes = additionalNotes;
        this.driver = driver;
    }  
}
