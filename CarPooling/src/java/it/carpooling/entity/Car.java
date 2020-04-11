package it.carpooling.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private long id;
    
    @Column(nullable = false)
    @Getter @Setter
    private String brand;
    
    @Column(nullable = false)
    @Getter @Setter
    private String model;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @Getter @Setter
    private Date matriculationDate;
    
    @Column(nullable = false)
    @Getter @Setter
    private int kmTraveled;
    
    @Column(nullable = false, unique = true)
    @Getter @Setter
    private String licensePlate;
    
    @Column(nullable = false)
    @Getter @Setter
    private int numberSeats;
    
    @ManyToOne(targetEntity = Driver.class)
    @JoinColumn(nullable = false)
    @Getter @Setter
    private Driver driver;

    public Car(String brand, String model, Date matriculationDate, int kmTraveled, String licensePlate, int numberSeats, Driver driver) {
        this.brand = brand;
        this.model = model;
        this.matriculationDate = matriculationDate;
        this.kmTraveled = kmTraveled;
        this.licensePlate = licensePlate;
        this.numberSeats = numberSeats;
        this.driver = driver;
    }
}
