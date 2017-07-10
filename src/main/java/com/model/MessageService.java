package com.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.database.DbClass;

public class MessageService {
	
	private Map<Long,Message> messages = DbClass.getMessages();
	

	public MessageService() {
		
		messages.put(1L, new Message(1,"Hello","NR"));
		messages.put(2L, new Message(2,"Hey","SR"));
	}
	
	public List <Message> getMessages() {
		
		return new ArrayList<Message>(messages.values());
	}
	
	/*Filtering and Pagination*/
	//Filtering by Messages by Year
	public List<Message> getMessagesYear(int year) {
		
		List<Message> msgForYear = new ArrayList<Message>(messages.values());
		Calendar cal = Calendar.getInstance();
		for(Message msg: messages.values()) {
			cal.setTime(msg.getCreate());
			if(cal.get(Calendar.YEAR)==year) {
				msgForYear.add(msg);
			}
		}
		return msgForYear;
	}
	
	public List<Message> getMsgPaginated(int start, int size) {
		
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		
		if(start + size > list.size())
			return new ArrayList<Message>();
		return list.subList(start, start+size);
	}
	
	
	/*CRUD operations*/
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
}
