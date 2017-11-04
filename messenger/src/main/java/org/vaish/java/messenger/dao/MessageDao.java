package org.vaish.java.messenger.dao;

import java.util.HashMap;
import java.util.Map;

import org.vaish.java.messenger.model.Message;

public class MessageDao {

	private static Map<Long,Message> messagesMap=new HashMap<>();
	
	
	public static Map<Long,Message> getMessages(){
		return messagesMap;
	}
}
