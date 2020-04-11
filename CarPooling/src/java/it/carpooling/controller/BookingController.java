/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.carpooling.controller;

import com.google.gson.Gson;
import it.carpooling.dao.BookingDao;
import it.carpooling.dao.TravelDao;
import it.carpooling.entity.Booking;
import it.carpooling.entity.Travel;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author Alessio Trentin
 */
@Controller
public class BookingController {
    
    @RequestMapping(value = "/bookingbytravel.htm", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public String getBookingByTravel(HttpServletRequest request) {
        
        long travelId = Long.parseLong(request.getParameter("travelId"));
        
        Travel travel = TravelDao.findById(travelId);
        
        List<Booking> bookingList = BookingDao.findByTravel(travel);
        
        Gson g = new Gson();
        
        return g.toJson(bookingList);
    }
    
}
