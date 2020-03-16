package it.mondadori.we.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.mondadori.we.util.error.ErrorMessagesList;

public class LogoutController extends AuthorizedController {
	


public void logout(HttpServletRequest request, HttpServletResponse response, ErrorMessagesList errors) 
	
	{
		getProfileHandler().removeUserProfile(request);
		request.getSession().invalidate();
		redirect("logout", request,response);
	
	}
}
