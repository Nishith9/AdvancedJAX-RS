package com.AdvanceJax;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


//**For Handling status messages
public class InvocationDemo {

	public static void main(String[] args) {
		
		InvocationDemo demo = new InvocationDemo();
		Invocation inv = demo.prepReqMsgyr(2016);
		
		Response res = inv.invoke();
		System.out.println(res.getStatus());
	}

	public Invocation prepReqMsgyr(int year) {
		Client client = ClientBuilder.newClient(); 
		return client.target("http://localhost:8080/messenger/webapi/")
					 .path("messages")
					 .queryParam("year", year)
					 .request(MediaType.APPLICATION_JSON)
					 .buildGet();
	}
}
