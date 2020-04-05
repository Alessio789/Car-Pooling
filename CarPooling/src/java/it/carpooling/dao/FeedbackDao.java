package it.carpooling.dao;

import it.carpooling.entity.Feedback;
import java.util.ArrayList;


/**
 *
 * Feedback DAO mockup
 * 
 * @author Alessio Trentin
 */
public class FeedbackDao {
    
    public static ArrayList<Feedback> feedbackList = new ArrayList<>();
    
    public static void add(Feedback f) {
        feedbackList.add(f);
    }
    
    public static void remove(Feedback f) {
        feedbackList.remove(f);
    }
    
    public static ArrayList<Feedback> findAll() {
        return feedbackList;
    }
    
    public static Feedback findById(int id) {
        for (Feedback f : feedbackList) {
            if (id == f.getId()) 
                return f;
        }
        return null;
    }
    
}
