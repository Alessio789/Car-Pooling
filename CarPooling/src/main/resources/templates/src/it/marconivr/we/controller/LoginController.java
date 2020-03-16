package it.mondadori.we.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import it.mondadori.db.DBM;
import it.mondadori.db.Record;
import it.mondadori.we.bean.User;
import it.mondadori.we.util.error.ErrorMessage;
import it.mondadori.we.util.error.ErrorMessagesList;

public class LoginController extends AnonymousController{
	
	public void login(HttpServletRequest request, HttpServletResponse response, ErrorMessagesList errors) 
	
	{
		User user = null;
		
		String inputUsername = request.getParameter("username");
		String inputPassword = request.getParameter("password");
		String submit = request.getParameter("submit");
		if (submit!=null) {
			
			
			/* Database login */
			DBM dbm = new DBM("jdbc/todo");
			List<Object> params = new ArrayList<Object>();
			params.add(inputUsername);
			List<Record> userRecord = dbm.query("SELECT * FROM todo.users where username = ?",params);
			if (userRecord != null && userRecord.size() == 1) {
				if (StringUtils.equals(userRecord.get(0).getString("password"), inputPassword)) {
					user = new User();
					user.setName(inputUsername);
					user.setPassword(inputPassword);
				}
			}
			
			
			/**/		
			/*Local login* /
		     List<String> users = Settings.getKeys("users");
			
			
			String passwordKey =null;
			for (String key : users) {
				
				if (StringUtils.endsWith(key, ".name")) {
					
					if(Settings.get(key).equals(inputUsername)) {
						
						 passwordKey = StringUtils.replace(key, ".name", ".password");
						
						if(Settings.get(passwordKey).equals(inputPassword)) {
							
							user = new User();
							user.setName(inputUsername);
							user.setPassword(inputPassword);
							break;
						}
						
					}
					
				}
				
			}/**/
			
			if (user == null) {
				
				errors.addError("LoginError", new ErrorMessage("error.login"));
				
				
			}else {
				//request.getSession().setAttribute("currentuser", user);
				getProfileHandler().setUserProfile(request, user);
				
				String backUrl = request.getParameter("backUrl");
				if (StringUtils.isBlank(backUrl)) {
					backUrl = "/dashboard";
				}
				
				redirect( backUrl, response);
				return;
			}
		}
		getProfileHandler().setUserProfile(request, user);
		
		setScreen("Login", "login");
	
		
	}

	
	
	

 
}
