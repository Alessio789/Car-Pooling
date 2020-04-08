package it.carpooling.dao;

import it.carpooling.entity.CarPoolingUser;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


/**
 *
 * CarPoolingUser DAO
 * 
 * @author Alessio Trentin
 */
public class CarPoolingUserDao {
    
        public static EntityManager em = Dao.getEm();

    public static List<CarPoolingUser> findAll() {
        TypedQuery<CarPoolingUser> typedQuery = em.createQuery("SELECT u FROM CarPoolingUser u", CarPoolingUser.class);
        List<CarPoolingUser> userList = typedQuery.getResultList();
        return userList;
    }

    public static CarPoolingUser findById(Long id) {
        TypedQuery<CarPoolingUser> typedQuery = em.createQuery("SELECT u FROM CarPoolingUser u WHERE u.id=:id", CarPoolingUser.class);
        typedQuery.setParameter("id", id);
        CarPoolingUser user = typedQuery.getResultList().get(0);
        return user;
    }

    public static boolean insert(CarPoolingUser u) {
        em.getTransaction().begin();
        try {
            em.persist(u);
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
    
    public static boolean delete(CarPoolingUser u) {
        em.getTransaction().begin();
        try {
            em.remove(u);
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
