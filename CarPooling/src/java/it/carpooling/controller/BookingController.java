/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.carpooling.controller;

import com.google.gson.Gson;
import it.carpooling.dao.BookingDao;
import it.carpooling.dao.CarPoolingUserDao;
import it.carpooling.dao.TravelDao;
import it.carpooling.entity.Booking;
import it.carpooling.entity.Driver;
import it.carpooling.entity.Passenger;
import it.carpooling.entity.Travel;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author Alessio Trentin
 */
@Controller
public class BookingController {

    @RequestMapping(value = "/bookingbytravel.htm", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getBookingByTravel(HttpServletRequest request) {

        long travelId = Long.parseLong(request.getParameter("travelId"));

        Travel travel = TravelDao.findById(travelId);

        List<Booking> bookingList = BookingDao.acceptedByTravel(travel);

        Gson g = new Gson();

        return g.toJson(bookingList);
    }

    @RequestMapping(value = "/book.htm", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String book(HttpServletRequest request) {

        long travelId = Long.parseLong(request.getParameter("travelId"));
        Travel travel = TravelDao.findById(travelId);

        String username = (String) request.getSession(false)
                .getAttribute("username");
        Passenger passenger = (Passenger) CarPoolingUserDao
                .findByUsername(username);

        Booking booking = new Booking(passenger, travel);

        BookingDao.insert(booking);

        Gson g = new Gson();

        return g.toJson(booking);
    }

    @RequestMapping(value = "/alreadybooked.htm", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String ifAlreadyBooked(HttpServletRequest request) {

        long travelId = Long.parseLong(request.getParameter("travelId"));
        Travel travel = TravelDao.findById(travelId);

        String username = (String) request.getSession(false)
                .getAttribute("username");
        Passenger passenger = (Passenger) CarPoolingUserDao
                .findByUsername(username);

        Optional<Booking> bookingOp = BookingDao
                .findByTravelAndPassenger(travel, passenger);

        if(bookingOp.isPresent()) {

            Gson g = new Gson();

            return g.toJson(bookingOp.get());
        }
        return request.getParameter("travelId");
    }

    @RequestMapping(value = "mybooking.htm", method = RequestMethod.GET,
            produces = "text/html;charset=UTF-8")
    public String toMyBookingPage() {

        return "html/myBooking.html";
    }

    @RequestMapping(value = "/bookingmade.htm", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String bookingMade(HttpServletRequest request) {

        String username = (String) request.getSession(false)
                .getAttribute("username");
        Passenger passenger = (Passenger) CarPoolingUserDao
                .findByUsername(username);

        List<Booking> booking = BookingDao.findByPassenger(passenger);

        Gson g = new Gson();

        return g.toJson(booking);
    }

    @RequestMapping(value = "/bookingreceived.htm", method = RequestMethod.GET,
            produces = "text/html;charset=UTF-8")
    public String bookingReceived(HttpServletRequest request) {

        return "html/driverBooking.html";
    }

    @RequestMapping(value = "/driverbooking.htm", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String driverBooking(HttpServletRequest request) {

        String username = (String) request.getSession(false)
                .getAttribute("username");
        Driver driver = (Driver) CarPoolingUserDao
                .findByUsername(username);

        List<Booking> bookingList = BookingDao.findByDriver(driver);
       
        Gson g = new Gson();

        return g.toJson(bookingList);
    }

    @RequestMapping(value = "/acceptbooking.htm", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String acceptBooking(HttpServletRequest request) {

        long bookingId = Long.parseLong(request.getParameter("bookingId"));
        Booking booking = BookingDao.findById(bookingId);

        booking.setAccepted(Boolean.TRUE);

        BookingDao.update(booking);
        booking.setId(bookingId);
        Gson g = new Gson();
        String bJson = g.toJson(booking);
        return bJson;
    }

    @RequestMapping(value = "/declinebooking.htm", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String declineBooking(HttpServletRequest request) {

        long bookingId = Long.parseLong(request.getParameter("bookingId"));
        Booking booking = BookingDao.findById(bookingId);

        booking.setAccepted(Boolean.FALSE);

        BookingDao.update(booking);
        booking.setId(bookingId);
        Gson g = new Gson();
        String bJson = g.toJson(booking);
        return bJson;
    }
}
