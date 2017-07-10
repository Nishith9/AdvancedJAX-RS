package com.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.database.DbClass;

public class ProfileService {

	private Map<String,Profile> profiles = DbClass.getProfiles();
	
	public ProfileService() {
		profiles.put("nishith", new Profile(1,"NishithReddy","Nishith","Kistammagari"));
		
		
	}
	
	public List<Profile> getProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile  getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile p) {
		p.setId(profiles.size()+1);
		profiles.put(p.getProfileName(), p);
		return p;
	}
	
	public Profile updateProfile(Profile p) {
		if(p.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(p.getProfileName(),p);
		return p;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
}
