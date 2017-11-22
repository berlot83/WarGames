package com.falcon.entities;

public class User {

	private int id;
	private String user;
	private String passwrord;
	
	public User() {
		
	}
	
	public User(String user, String passwrord) {
		super();
		this.id = id;
		this.user = user;
		this.passwrord = passwrord;
	}
	
	public User(int id, String user, String passwrord) {
		super();
		this.id = id;
		this.user = user;
		this.passwrord = passwrord;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPasswrord() {
		return passwrord;
	}
	public void setPasswrord(String passwrord) {
		this.passwrord = passwrord;
	}

}
