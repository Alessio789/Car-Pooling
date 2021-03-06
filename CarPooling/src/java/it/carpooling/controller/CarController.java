package it.carpooling.controller;

import it.carpooling.dao.CarDao;
import it.carpooling.dao.CarPoolingUserDao;
import it.carpooling.dao.TravelDao;
import it.carpooling.entity.Car;
import it.carpooling.entity.Driver;
import it.carpooling.entity.Travel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("cars.htm")
public class CarController {
    
    @RequestMapping(method = RequestMethod.GET, 
            produces = "text/html;charset=UTF-8")
    public String toRegistrationCarPage() {
        
        return "html/registrationCar.html";
    }
   
    @RequestMapping(method = RequestMethod.POST,
            produces = "text/html;charset=UTF-8")
    public String saveCar(HttpServletRequest request) throws ParseException {
        
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String dateString = request.getParameter("matriculationDate");
        Date matriculationDate = new SimpleDateFormat("yyyy-MM-dd")
                .parse(dateString);
        int kmTraveled = Integer.parseInt(request.getParameter("kmTraveled"));
        String licensePlate = request.getParameter("licensePlate");
        int numberSeats = Integer.parseInt(request.getParameter("numberSeats"));
        
        HttpSession session = request.getSession(false);
        
        Driver d = (Driver) CarPoolingUserDao.findByUsername((String) 
                session.getAttribute("username"));
        
        Car car = new Car(brand, model, matriculationDate, kmTraveled, licensePlate, numberSeats, d);

        CarDao.insert(car);
        
        session.invalidate();
        
        return "redirect:/login.htm";
    }
    
    @RequestMapping(value = "/carbytravel.htm", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String carByTravel(HttpServletRequest request) {

        int requestedSeats = Integer.parseInt(request.getParameter("requestedSeats"));
        
        long travelId = Long.parseLong(request.getParameter("travelId"));
        Travel travel = TravelDao.findById(travelId);
        
        Driver driver = travel.getDriver();
        Car car = CarDao.findByDriver(driver);
        
       String availableSeats = String.valueOf(car.getNumberSeats() 
               - requestedSeats);

        return availableSeats + " " + travelId;
    }
    
}
