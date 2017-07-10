package com.AdvanceJax;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.model.Message;

public class RestClient {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		
		
		// GET method (to read msgs) using REST client **Basic way of declaration....
		/*Response res = client.target("http://localhost:8080/messenger/webapi/messages/1").request().get();		
		Message msg = res.readEntity(Message.class);
		System.out.println(msg.getMessage());
		*/
		
		//GET method : detailed declaration of methods involved....
		WebTarget baseTarget = client.target("http://localhost:8080/messenger/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMsgTarget = messagesTarget.path("{messageId}");
		
		Message msg1 = singleMsgTarget
						.resolveTemplate("messageId", "1")
						.request(MediaType.APPLICATION_JSON)
						.get(Message.class);
		

		Message msg2 = singleMsgTarget
				.resolveTemplate("messageId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		System.out.println(msg1.getMessage());
		System.out.println(msg2.getMessage());
		
		//POST method: inserting new message in the message list...		
		Message newMsg = new Message(3,"New msg for AdvJax","NR");
		Response postRes = messagesTarget
							.request()
							.post(Entity.json(newMsg));
		
		Message createdMsg = postRes.readEntity(Message.class);
		System.out.println(createdMsg.getMessage());
		
		
	}

}
