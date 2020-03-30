package it.marconivr.carpooling.domain;

import java.util.Date;
import lombok.*;


/**
 *
 * @author Alessio Trentin
 */
public class Feedback {
    
    @Getter @Setter
    private int id;
    
    @Getter @Setter
    private String title;
    
    @Getter @Setter
    private double vote;
    
    @Getter @Setter
    private String judgement;
    
    @Getter @Setter
    private Date timestamp;
    
    @Getter @Setter
    private User author;
    
    @Getter @Setter
    private User recipient;

    /**
     * 
     * Constructor
     * 
     * @param id
     * @param title
     * @param vote
     * @param judgement
     * @param timestamp
     * @param author
     * @param recipient 
     */
    public Feedback(int id, String title, double vote, String judgement,
            Date timestamp, User author, User recipient) {
        this.id = id;
        this.title = title;
        this.vote = vote;
        this.judgement = judgement;
        this.timestamp = timestamp;
        this.author = author;
        this.recipient = recipient;
    }
}
