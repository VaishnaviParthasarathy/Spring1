package org.vaish.java.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.vaish.java.messenger.dao.MessageDao;
import org.vaish.java.messenger.model.Message;

public class MessageService {
	
	Map<Long,Message> messages=MessageDao.getMessages();
	
	
	public MessageService(){
		Message m1=new Message(1L,"Hello World","vaish");
		Message m2=new Message(2L,"Hello Jersey","vaish");
		Message m3=new Message(2L,"Hello Chennai","vaish");
		messages.put(1L, m1);
		messages.put(2L, m2);
	}
	
	public List<Message> getMessages(){
		/*Message m1=new Message(1L,"Hello World","vaish");
		Message m2=new Message(2L,"Hello Jersey","vaish");
		List<Message> messagesList=new ArrayList<>();
		messagesList.add(m1);
		messagesList.add(m2);*/
		return new ArrayList<>(messages.values());
		
	}

	public Message addMessage(Message message){
		message.setId((long) (messages.size()+1));
		messages.put(message.getId(), message);
		return message;
    	
    }
    
    public Long deleteMessage(Long id){
    	messages.remove(id);
    	return id;
    }
    
    public Message updateMessage(Message message){
    	messages.put(message.getId(), message);
		return message;
    	
    }
    
    public Message getMessage(Long id){
    	return messages.get(id);
    }
}
