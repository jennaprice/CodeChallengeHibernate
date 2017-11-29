package com.gc.dto;

import java.io.Serializable;

public class UserDto implements Serializable{
	
	
	private int id;
	private String fullname;
	private String emailaddress;
	private String password;
	private String pw_hash;
	private boolean optin;
	
	public UserDto() {
		
	}

	public UserDto(String fullname, String emailaddress, String password) {
		this.fullname = fullname;
		this.emailaddress = emailaddress;
		this.password = password;
		optin = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPw_hash() {
		return pw_hash;
	}

	public void setPw_hash(String pw_hash) {
		this.pw_hash = pw_hash;
	}

	public boolean isOptin() {
		return optin;
	}

	public void setOptin(boolean optin) {
		this.optin = optin;
	}
	
	

}
