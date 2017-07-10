package com.AdvanceJax;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.model.Message;

//For handling Generic data like :(List<Message>) 
public class GenericDemo {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		List<Message> messages = client.target("http://localhost:8080/messenger/webapi/")
										.path("messages")
										.queryParam("year", 2017)
										.request(MediaType.APPLICATION_JSON)
										.get(new GenericType<List<Message>>() { } ); //**generic
		
		System.out.println(messages);
				
	}
}
