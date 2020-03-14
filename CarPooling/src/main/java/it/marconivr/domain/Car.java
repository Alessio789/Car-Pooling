package it.marconivr.domain;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Alessio Trentin
 */
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

    /**
     * 
     * Constructor
     * 
     * @param id
     * @param brand
     * @param model
     * @param registrationDate
     * @param kmTraveled
     * @param licensePlate
     * @param numberSeats
     * @param driver 
     */
    public Car(int id, String brand, String model, Date registrationDate, 
            int kmTraveled, String licensePlate, int numberSeats, 
            Driver driver) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.registrationDate = registrationDate;
        this.kmTraveled = kmTraveled;
        this.licensePlate = licensePlate;
        this.numberSeats = numberSeats;
        this.driver = driver;
    }
    
    
}
