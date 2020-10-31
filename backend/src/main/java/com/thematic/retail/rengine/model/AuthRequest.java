package com.thematic.retail.rengine.model;

public class AuthRequest {

    private String username;

    private String userpassword;

    public String getNewparam() {
        return newparam;
    }

    public void setNewparam(String newparam) {
        this.newparam = newparam;
    }

    private String newparam;

    public AuthRequest() {
    }

    public AuthRequest(String username, String userpassword) {
        this.username = username;
        this.userpassword = userpassword;
    }

    public String getUsername() {
        return username;
    }

    public AuthRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public AuthRequest setUserpassword(String userpassword) {
        this.userpassword = userpassword;
        return this;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "username='" + username + '\'' +
                ", userpassword='" + userpassword + '\'' +
                '}';
    }
}
