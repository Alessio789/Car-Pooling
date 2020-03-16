package it.mondadori.we.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import it.mondadori.we.bean.Dashboard;
import it.mondadori.we.bean.User;
import it.mondadori.we.util.error.ErrorMessagesList;

public class AuthorizedController extends BaseController {

public void begin(HttpServletRequest request, HttpServletResponse response, ErrorMessagesList errors) {
	
	super.begin(request, response, errors);
		
		if (!getProfileHandler().isUserLogged(request)) {
			String backUrl = "/dashboard";
			
			String realUri = (String)request.getAttribute("realUri");
			if ( !StringUtils.isBlank(realUri) && !StringUtils.equals(realUri,"/login") && !StringUtils.equals(realUri,"/logout")) {
				backUrl = realUri;
			}
			
			
			redirect("/login?backUrl=".concat(backUrl), response);
			
			
		}		
	}
public Dashboard getDashboard(HttpServletRequest request) {
	
	Dashboard dashboard = (Dashboard)request.getSession().getAttribute("dashboard");
	if (dashboard == null) {
		User user = (User)getProfileHandler().getUserProfile(request);
		dashboard = new Dashboard(user);
		setDashboard(request, dashboard);
		
	}
	
	return dashboard;
	
	
}
public void setDashboard(HttpServletRequest request,Dashboard dashboard) {
	request.getSession().setAttribute("dashboard",dashboard);
}

}
