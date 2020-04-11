package it.carpooling.dao;

import it.carpooling.entity.Travel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


/**
 *
 * Travel DAO 
 * 
 * @author Alessio Trentin
 */
public class TravelDao {
    
    public static EntityManager em = Dao.getEm();

    public static List<Travel> findAll() {
        TypedQuery<Travel> typedQuery = em.createQuery("SELECT t FROM Travel t", Travel.class);
        List<Travel> travelList = typedQuery.getResultList();
        return travelList;
    }

    public static Travel findById(Long id) {
        TypedQuery<Travel> typedQuery = em.createQuery("SELECT t FROM Travel t WHERE t.id=:id", Travel.class);
        typedQuery.setParameter("id", id);
        Travel travel = typedQuery.getResultList().get(0);
        return travel;
    }
    
    public static List<Travel> findByArrivalCity(String arrivalCity) {
        TypedQuery<Travel> typedQuery = em.createQuery("SELECT t FROM Travel t "
                + "WHERE t.arrivalCity = :arrivalCity", Travel.class);
        typedQuery.setParameter("arrivalCity", arrivalCity);
        List<Travel> travelList = typedQuery.getResultList();
        return travelList;
    }

    public static boolean insert(Travel t) {
        em.getTransaction().begin();
        try {
            em.persist(t);
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
    
    public static boolean delete(Travel t) {
        em.getTransaction().begin();
        try {
            em.remove(t);
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
