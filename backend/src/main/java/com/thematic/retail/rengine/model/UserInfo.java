package com.thematic.retail.rengine.model;

public class UserInfo {
	
    private String username;

    private String role;

	public UserInfo(String username, String role) {
		super();
		this.username = username;
		this.role = role;
	}

	public UserInfo() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", role=" + role + "]";
	}
    
    

}
