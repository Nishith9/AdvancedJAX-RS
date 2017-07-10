package com.messenger;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.model.Profile;
import com.model.ProfileService;

@Path("profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

	ProfileService pService = new ProfileService();
	
	@GET	
	public List<Profile> getP() {
		return pService.getProfiles();
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return pService.addProfile(profile);
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		return pService.getProfile(profileName);
	}
	
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName, Profile p) {
		p.setProfileName(profileName);
		return pService.updateProfile(p);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName) {
		pService.removeProfile(profileName);
	}
}
