package it.carpooling.dao;

import it.carpooling.entity.Driver;
import java.util.ArrayList;


/**
 *
 * Driver DAO mockup
 * 
 * @author Alessio Trentin
 */
public class DriverDao {
    
    public static ArrayList<Driver> driverList = new ArrayList<>();
    
    public static void add(Driver d) {
        driverList.add(d);
    }
    
    public static void remove(Driver d) {
        driverList.remove(d);
    }
    
    public static ArrayList<Driver> findAll() {
        return driverList;
    }
    
    public static Driver findById(int id) {
        for (Driver d : driverList) {
            if (id == d.getId()) 
                return d;
        }
        return null;
    }
    
}
