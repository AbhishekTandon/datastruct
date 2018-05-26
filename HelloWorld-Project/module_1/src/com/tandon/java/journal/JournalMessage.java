package com.tandon.java.journal;

import java.util.HashMap;
import java.util.Map;

public class JournalMessage implements JournalItem<Message> {

	public Map<String, Object> getMap(Message message) {
		Map<String, Object> map = new HashMap<>();

		return map;
	}


	public Message getObject(Map<String, Object> map) {


		return null;
	}
}
