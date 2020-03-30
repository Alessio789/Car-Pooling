package carpooling.dao;

import carpooling.entity.Booking;
import java.util.ArrayList;


/**
 *
 * Booking DAO mockup
 * 
 * @author Alessio Trentin
 */
public class BookingDao {
    
    public static ArrayList<Booking> bookingList = new ArrayList<>();
    
    public static void add(Booking b) {
        bookingList.add(b);
    }
    
    public static void remove(Booking b) {
        bookingList.remove(b);
    }
    
    public static ArrayList<Booking> findAll() {
        return bookingList;
    }
    
    public static Booking findById(int id) {
        for (Booking b : bookingList) {
            if (id == b.getId()) 
                return b;
        }
        return null;
    }
}
