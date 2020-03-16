package it.mondadori.we.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.mondadori.we.util.error.ErrorMessagesList;

public class AnonymousController extends BaseController {


public void begin(HttpServletRequest request, HttpServletResponse response, ErrorMessagesList errors) {
	
	super.begin(request, response, errors);
		
		if (getProfileHandler().isUserLogged(request)) {
			
			redirect("/", response);
			
		}		
	}	
}
	
