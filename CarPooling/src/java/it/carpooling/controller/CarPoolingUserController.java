package it.carpooling.controller;

import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import it.carpooling.dao.CarPoolingUserDao;
import it.carpooling.entity.Driver;
import it.carpooling.entity.Passenger;
import it.carpooling.util.SaltGenerator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Alessio Trentin
 */
@Controller
public class CarPoolingUserController {
    
     @RequestMapping(value = "/signedup.htm", method = RequestMethod.POST, 
            produces = "text/html;charset=UTF-8")
    public String registration(HttpServletRequest request) throws ParseException {
        
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String dateString = request.getParameter("birthDate");
        Date birthDate = new SimpleDateFormat("yyyy-MM-dd")
                .parse(dateString);
        String fiscalCode = request.getParameter("fiscalCode");
        String phoneNumber = request.getParameter("phoneNumber");
        String username = request.getParameter("username");
        
        String salt = DatatypeConverter.printBase64Binary(
                SaltGenerator.getNextSalt());
        String passwordSalt = request.getParameter("password") + salt;
        
        Hasher hasher = Hashing.sha256().newHasher();
        hasher.putString(passwordSalt, Charsets.UTF_8);
        String sha256 = hasher.hash().toString();
        
        if (role.equals("driver")) {
            
            String numDrivingLicense = request.getParameter("numDrivingLicense");
            Date deadline = new SimpleDateFormat("yyyy/MM/dd")
                    .parse(request.getParameter("deadline"));
            
            Driver d = new Driver(numDrivingLicense, deadline, name, lastName, 
                    fiscalCode, birthDate, phoneNumber, email, username, sha256,
                    salt);

            CarPoolingUserDao.insert(d);
            
        } else {
            
            String numDocument = request.getParameter("numDocument");
            
            Passenger p = new Passenger(name, lastName, fiscalCode, birthDate, 
                    phoneNumber, email, username, sha256, salt, numDocument);
            
            CarPoolingUserDao.insert(p);
        }
        
        return "Fatto";
    }
}
