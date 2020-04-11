package it.carpooling.controller;

/**
 *
 * @author Alessio Trentin
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/login.htm", method = RequestMethod.GET, 
            produces = "text/html;charset=UTF-8")
    public String toLoginPage() {

        return "html/login.html";
    }
    
    @RequestMapping(value = "/signup.htm", method = RequestMethod.GET,
            produces = "text/html;charset=UTF-8")
    public String toRegistrationPage() {
        
        return "html/registration.html";
    }
}
