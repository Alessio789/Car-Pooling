package it.carpooling.dao;

import it.carpooling.entity.Booking;
import it.carpooling.entity.Travel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


/**
 *
 * Booking DAO 
 * 
 * @author Alessio Trentin
 */
public class BookingDao {
    
        public static EntityManager em = Dao.getEm();

    public static List<Booking> findAll() {
        TypedQuery<Booking> typedQuery = em.createQuery("SELECT b FROM Booking "
                + "b", Booking.class);
        List<Booking> bookingList = typedQuery.getResultList();
        return bookingList;
    }

    public static Booking findById(Long id) {
        TypedQuery<Booking> typedQuery = em.createQuery("SELECT b FROM Booking "
                + "b WHERE b.id=:id", Booking.class);
        typedQuery.setParameter("id", id);
        Booking booking = typedQuery.getResultList().get(0);
        return booking;
    }
    
    public static List<Booking> findByTravel(Travel travel) {
        TypedQuery<Booking> typedQuery = em.createQuery("SELECT b FROM Booking "
                + "b WHERE b.travel=:travel", Booking.class);
        typedQuery.setParameter("travel", travel);
        List<Booking> bookingList = typedQuery.getResultList();
        return bookingList;
    }

    public static boolean insert(Booking b) {
        em.getTransaction().begin();
        try {
            em.persist(b);
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
    
    public static boolean delete(Booking b) {
        em.getTransaction().begin();
        try {
            em.remove(b);
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
