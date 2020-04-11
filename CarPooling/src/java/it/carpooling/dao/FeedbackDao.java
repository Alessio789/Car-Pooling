package it.carpooling.dao;

import it.carpooling.entity.Feedback;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


/**
 *
 * Feedback DAO 
 *
 * @author Alessio Trentin
 */
public class FeedbackDao {

    public static EntityManager em = Dao.getEm();

    public static List<Feedback> findAll() {
        TypedQuery<Feedback> typedQuery = em.createQuery("SELECT f FROM Feedback f", Feedback.class);
        List<Feedback> feedbackList = typedQuery.getResultList();
        return feedbackList;
    }

    public static Feedback findById(Long id) {
        TypedQuery<Feedback> typedQuery = em.createQuery("SELECT f FROM Feedback f WHERE f.id=:id", Feedback.class);
        typedQuery.setParameter("id", id);
        Feedback feedback = typedQuery.getResultList().get(0);
        return feedback;
    }

    public static boolean insert(Feedback f) {
        em.getTransaction().begin();
        try {
            em.persist(f);
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
    
    public static boolean delete(Feedback f) {
        em.getTransaction().begin();
        try {
            em.remove(f);
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
