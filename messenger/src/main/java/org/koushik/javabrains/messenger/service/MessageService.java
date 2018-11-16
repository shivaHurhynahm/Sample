package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Calendar; 

import org.koushik.javabrains.messenger.database.DatabaseClass;
import org.koushik.javabrains.messenger.model.Message;

public class MessageService {
	
	public static Map<Long, Message> messages = DatabaseClass.getMessages();
	
	/*public List<Message> getAllMessages(){
		Message m1 = new Message(1L, "Hello World!", "Koushik");
		Message m2 = new Message(2L, "Hello Jersey", "Koushik");
		List<Message> list = new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		return list;		
	}*/
	
	public MessageService() {
		messages.put(1L, new Message(1L, "Hello World!", "Koushik"));
		messages.put(2L, new Message(2L, "Hello Jersey", "Koushik"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()) {
			if(cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());		
		return list.subList(start, size);
	}
	

	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		if(message.getCreated() == null) message.setCreated(new Date());
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0) return null;		
		messages.put(message.getId(), message);		
		return message;
	}

	public void removeMessage(long messageId) {
		if(messages.containsKey(messageId)) {
			messages.remove(messageId);
		}
	}

}
