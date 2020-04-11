package it.carpooling.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import lombok.Getter;


/**
 *
 * @author Alessio Trentin
 */
public class Dao {
    
    public static String PERSISTENCE_UNIT_NAME = "CarPoolingPU";
    
    @Getter
    private static final EntityManager em = Persistence
            .createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
            .createEntityManager();
}
