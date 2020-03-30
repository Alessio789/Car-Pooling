package carpooling.dao;

import carpooling.entity.Passenger;
import java.util.ArrayList;


/**
 *
 * Passenger DAO mockup
 * 
 * @author Alessio Trentin
 */
public class PassengerDao {
    
    public static ArrayList<Passenger> passengerList = new ArrayList<>();
    
    public static void add(Passenger p) {
        passengerList.add(p);
    }
    
    public static void remove(Passenger p) {
        passengerList.remove(p);
    }
    
    public static ArrayList<Passenger> findAll() {
        return passengerList;
    }
    
    public static Passenger findById(int id) {
        for (Passenger p : passengerList) {
            if (id == p.getId()) 
                return p;
        }
        return null;
    }
}
