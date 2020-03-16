package it.mondadori.we.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.mondadori.we.bean.User;
import it.mondadori.we.util.error.ErrorMessagesList;

public class DashboardController extends AuthorizedController{
	
	private BreadCrumb dashboardBread = new BreadCrumb();
	
	
	public void begin(HttpServletRequest request, HttpServletResponse response, ErrorMessagesList errors) {
		super.begin(request, response, errors);
		getDashboard(request);
		
		//User user= (User)getProfileHandler().getUserProfile(request);
		//String username=user.getName();
		//request.getSession().setAttribute("currentuser", username);
	
	}
	
	public void list(HttpServletRequest request, HttpServletResponse response, ErrorMessagesList errors) {
		
	
		setScreen("Homepage", "dashboard_list");
		getDashboard(request);
		
	}
	



public void addList(HttpServletRequest request, HttpServletResponse response, ErrorMessagesList errors) {
	
		String title = getStringParameter(request, "title");
	//	setScreen("Homepage", "dashboard_addList");
		List<TripList> list = getDashboard(request).getList();
		TripList listLoader = new TripList();
		listLoader.setColor("f65456");
		listLoader.setStatus(0);
		listLoader.setTitle(title);
		User user = (User)getProfileHandler().getUserProfile(request);
		listLoader.addUser(user.getName());
		list.add(listLoader);

		request.setAttribute("Homepage", listLoader);
		
		addScreenParameter("page", "list", request);
		
		setScreen("empty");
		//redirect("/dashboard", response);
		
		}

public void removeList(HttpServletRequest request, HttpServletResponse response, ErrorMessagesList errors) {
		String tripListId = request.getParameter("listLoaderID");
		List<TripList> list = getDashboard(request).getList();
		for(TripList x : list) {
			if(x.getId() == toDoId ) {
				list.remove(x);
			}
		}
		redirect("/dashboard", response);
}
	}
