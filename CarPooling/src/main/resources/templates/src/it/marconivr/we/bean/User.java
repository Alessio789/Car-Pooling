package it.mondadori.we.bean;

import it.mondadori.we.util.profile.IProfile;

public class User implements IProfile{

	private String name;
	private String password;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public boolean hasUserRole(String arg0) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean hasUserRule(String arg0) {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
