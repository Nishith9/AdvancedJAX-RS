package com.model;

import java.util.Date;

public class Profile {

	private long id;
	private String profileName;
	private String fname;
	private String lname;
	private Date created;
	
	public Profile() {
		
	}
	
	public Profile(long id, String profileName, String fname, String lname) {
		super();
		this.id = id;
		this.profileName = profileName;
		this.fname = fname;
		this.lname = lname;
		this.created = new Date();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}	
}
