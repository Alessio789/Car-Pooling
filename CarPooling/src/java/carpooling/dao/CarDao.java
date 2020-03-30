package carpooling.dao;

import carpooling.entity.Car;
import java.util.ArrayList;


/**
 *
 * Car DAO Mockup
 * 
 * @author Alessio Trentin
 */
public class CarDao {
    
    public static ArrayList<Car> carList = new ArrayList<>();
    
    public static void add(Car c) {
        carList.add(c);
    }
    
    public static void remove(Car c) {
        carList.remove(c);
    }
    
    public static ArrayList<Car> findAll() {
        return carList;
    }
    
    public static Car findById(int id) {
        for (Car c : carList) {
            if (id == c.getId()) 
                return c;
        }
        return null;
    }
    
}
