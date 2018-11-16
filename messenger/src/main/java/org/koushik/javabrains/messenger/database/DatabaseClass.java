package org.koushik.javabrains.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.koushik.javabrains.messenger.model.Message;
import org.koushik.javabrains.messenger.model.Profile;

public class DatabaseClass {
	
	//Message m1 = new Message(1L, "Hello World!", "Shiva");
	//Message m2 = new Message(2L, "Haribol!!!!!!!", "Shiva");
	
	public static Map<Long, Message> messages = new HashMap<>();
	public static Map<Long, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}

	public static Map<Long, Profile> getProfiles() {
		return profiles;
	}

}
