/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.carpooling.controller;

/**
 *
 * @author ptom
 */
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    // Un controller può avere più metodi di risposta a varie request
    @RequestMapping(value = "/login.htm", method = RequestMethod.GET, //Value arbitrario, dipende dal nome che vogliamo dare al percorso
            produces = "text/html;charset=UTF-8")
    public String toLoginPage(HttpServletRequest request) {

        return "html/login.html";

    }
}
