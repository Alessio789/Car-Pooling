package it.carpooling.controller;

import com.google.gson.Gson;
import it.carpooling.dao.TravelDao;
import it.carpooling.entity.Travel;
import java.util.List;
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
public class TravelController {
    
    @RequestMapping(value = "bookings.htm", method = RequestMethod.GET, 
            produces = "text/html;charset=UTF-8")
    public String toTravelPage(HttpServletRequest request) {
        
        if ( request.getSession(false) == null) {
          
            return "error";
            
        } else {
            
            return "html/addTravel.html";
        }
    } 
    
    
    @RequestMapping(value = "/travels.htm", method = RequestMethod.POST, 
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String travelsByArrivalCity(HttpServletRequest request) {
        
        String arrivalCity = request.getParameter("arrivalCity");
        
        List<Travel> travelList = TravelDao.findByArrivalCity(arrivalCity);
        
        Gson gson = new Gson();
        
        return  gson.toJson(travelList);
    }
}
