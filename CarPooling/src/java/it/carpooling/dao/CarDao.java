package it.carpooling.dao;

import it.carpooling.entity.Car;
import it.carpooling.entity.Driver;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


/**
 *
 * Car DAO 
 * 
 * @author Alessio Trentin
 */
public class CarDao {
    
        public static EntityManager em = Dao.getEm();

    public static List<Car> findAll() {
        TypedQuery<Car> typedQuery = em.createQuery("SELECT c FROM Car c", Car.class);
        List<Car> carList = typedQuery.getResultList();
        return carList;
    }

    public static Car findById(Long id) {
        TypedQuery<Car> typedQuery = em.createQuery("SELECT c FROM Car c WHERE c.id=:id", Car.class);
        typedQuery.setParameter("id", id);
        Car car = typedQuery.getResultList().get(0);
        return car;
    }
    
    public static Car findByDriver(Driver d) {
        TypedQuery<Car> typedQuery = em.createQuery("SELECT c FROM Car c WHERE c.driver=:d", Car.class);
        typedQuery.setParameter("d", d);
        Car car = typedQuery.getResultList().get(0);
        return car;
    }

    public static boolean insert(Car c) {
        em.getTransaction().begin();
        try {
            em.persist(c);
            em.getTransaction().commit();
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            if(em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    
    public static boolean delete(Car c) {
        em.getTransaction().begin();
        try {
            em.remove(c);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
}
