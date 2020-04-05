package it.carpooling.dao;

import it.carpooling.entity.Travel;
import java.util.ArrayList;


/**
 *
 * Travel DAO mockup
 * 
 * @author Alessio Trentin
 */
public class TravelDao {
    
    public static ArrayList<Travel> travelList = new ArrayList<>();
    
    public static void add(Travel t) {
        travelList.add(t);
    }
    
    public static void remove(Travel t) {
        travelList.remove(t);
    }
    
    public static ArrayList<Travel> findAll() {
        return travelList;
    }
    
    public static Travel findById(int id) {
        for (Travel t : travelList) {
            if (id == t.getId()) 
                return t;
        }
        return null;
    }
}
