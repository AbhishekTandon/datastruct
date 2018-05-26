package com.tandon.java.journal;

import java.util.Map;

public interface JournalItem<T> {
	/**
	 * Convert Object into Map
	 */
	public Map<String, Object> getMap(T t);

	public T getObject(Map<String, Object> map);

}
