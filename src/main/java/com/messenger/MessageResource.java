package com.messenger;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.messenger.beanParam.BeanFilterResource;
import com.model.Message;
import com.model.MessageService;


@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     * 
     * @return String that will be returned as a text/plain response.
     */
	
	MessageService mService = new MessageService();
	
    @GET   
    public List<Message> getMsg(@BeanParam BeanFilterResource beanFilter) {
    	
    	if(beanFilter.getYear()>0) {
    		return mService.getMessagesYear(beanFilter.getYear());
    	}
    	
    	if(beanFilter.getStart()>=0&&beanFilter.getSize()>=0) {
    		return mService.getMsgPaginated(beanFilter.getStart(), beanFilter.getSize());
    	}
    
        return mService.getMessages();
    }
    
    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long id, Message message){
    	message.setId(id);
    	return mService.updateMessage(message);
    }
    
    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long id) {
    	mService.removeMessage(id);
    }
    
    @POST
    public Message addMessage(Message message) {
    	return mService.addMessage(message);
    }
    
    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam("messageId") long id) {
    	
    	return mService.getMessage(id);
    }

	@Path("/{messageId}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
