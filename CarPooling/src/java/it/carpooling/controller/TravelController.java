package it.carpooling.controller;

import com.google.gson.Gson;
import it.carpooling.dao.CarPoolingUserDao;
import it.carpooling.dao.TravelDao;
import it.carpooling.entity.Driver;
import it.carpooling.entity.Travel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 *
 * @author Alessio Trentin
 */
@Controller
public class TravelController {

    @RequestMapping(value = "bookings.htm", method = RequestMethod.GET,
            produces = "text/html;charset=UTF-8")
    public String toTravelPage(HttpServletRequest request) {

        if(request.getSession(false) == null) {

            return "error";

        }
        else {

            return "html/findTravel.html";
        }
    }

    @RequestMapping(value = "/travels.htm", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String travelsByArrivalCity(HttpServletRequest request) {

        String arrivalCity = request.getParameter("arrivalCity");

        List<Travel> travelList = TravelDao.findByArrivalCity(arrivalCity);

        Gson gson = new Gson();

        return gson.toJson(travelList);
    }

    @RequestMapping(value = "/travels.htm", method = RequestMethod.GET,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String travelsByUser(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        String username = (String) session.getAttribute("username");

        Driver d = (Driver) CarPoolingUserDao.findByUsername(username);

        List<Travel> travelList = TravelDao.findByDriver(d);

        
        
        
        Gson gson = new Gson();

        return gson.toJson(travelList);
    }

    @RequestMapping(value = "mytravels.htm", method = RequestMethod.GET,
            produces = "text/html;charset=UTF-8")
    public String myTravels(HttpServletRequest request) {

        if(request.getSession(false) == null) {

            return "error";

        }
        else {

            return "html/travels.html";
        }
    }

    @RequestMapping(value = "addtravel.htm", method = RequestMethod.GET,
            produces = "text/html;charset=UTF-8")
    public String addTravel(HttpServletRequest request) {

        if(request.getSession(false) == null) {

            return "error";

        }
        else {

            return "html/addTravel.html";
        }
    }

    @RequestMapping(value = "savetravel.htm", method = RequestMethod.POST,
            produces = "text/html;charset=UTF-8")
    public String saveTravel(HttpServletRequest request) throws ParseException {
        
        String departureCity = request.getParameter("departureCity");
        String arrivalCity = request.getParameter("arrivalCity");
        String dateString = request.getParameter("date");
        Date date = new SimpleDateFormat("yyyy-MM-dd")
                .parse(dateString);
        double contribution = Double.parseDouble(
                request.getParameter("contribution"));
        int travelTime = Integer.parseInt(request.getParameter("travelTime"));
        
        String depTimeString = request.getParameter("hour");
        Date depTime = new SimpleDateFormat("H").parse(depTimeString);
        boolean luggage = false;
        
        if (request.getParameter("luggage").equals("yes")) {
            luggage = true;
        } 
        
        String additionalNotes = request.getParameter("additonalNotes");
        
        HttpSession session = request.getSession(false);
        Driver driver = (Driver) CarPoolingUserDao.findByUsername((String) 
                session.getAttribute("username"));
        
        Travel t = new Travel(departureCity, arrivalCity, date, depTime, contribution, travelTime, luggage, additionalNotes, driver);
        
        TravelDao.insert(t);
        
        return "redirect:/mytravels.htm";
    }
}
