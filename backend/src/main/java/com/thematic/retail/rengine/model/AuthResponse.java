package com.thematic.retail.rengine.model;

public class AuthResponse {

	private String authResponse;

	private UserInfo userInfo;

	public AuthResponse(String authResponse, UserInfo userInfo) {
		super();
		this.authResponse = authResponse;
		this.userInfo = userInfo;
	}

	public AuthResponse() {
	}

	public String getAuthResponse() {
		return authResponse;
	}

	public void setAuthResponse(String authResponse) {
		this.authResponse = authResponse;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "AuthResponse [authResponse=" + authResponse + ", userInfo=" + userInfo + "]";
	}

}
