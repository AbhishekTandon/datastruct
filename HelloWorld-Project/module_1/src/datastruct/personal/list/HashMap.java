package datastruct.personal.list;

public class HashMap {

	int DEFAULT_SIZE = 11;
	EntryList<String, String>[] table = new EntryList[DEFAULT_SIZE];


	public void put(String key, String value) {
		int hash = hash(key);

		//TODO: Allow adding new key into the table
		for (int i =0; i< table.length; i++) {
			if (table[i].hash == hash) {
				table[i].put(key, value);
			}
		}
	}


	public String get(String key) {
		int hash = hash(key);
		for(int i = 0; i < table.length; i++) {
			if (table[i].hash == hash) {
				Entry entry = table[i].getEntry(key);
				if (entry != null) return (String)entry.value;
			}
		}
		return null;
	}

	/**
	 * logic to compute hashCode inside the String.java
	 */
	public int hashCode(String key) {
		int h = 0;
		int length = key.length();

		if (h == 0 && length > 0) {
			char val[] = key.toCharArray();
			for (int i = 0; i < length; i++) {
				h = 31 * h + val[i];
			}
		}
		return h;
	}

	public int hash(String key) {
		int h = 0;
		int length = key.length();
		char val[] = key.toCharArray();
		for (int i = 0; i < length; i++) {
			h = h + val[i];
		}

		return (h % 11);
	}


	class Entry <K, V> {
		K key;
		V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	class EntryList<K, V> {
		int DEFAULT_SIZE = 100;
		int hash;
		int pointer = -1;

		//TODO: increasing the lenght of the string
		Entry<K, V>[] entries = new Entry[DEFAULT_SIZE];

		Entry<K, V> getEntry(K key) {
			for(int i= 0; i < entries.length; i++) {
				if (key.equals(entries[i].key)) {
					return entries[i];
				}
			}
			return null;
		}

		void put(K key, V value) {
			entries[++pointer] = new Entry(key, value);
		}

		boolean isHashEqual(int hash) {
			return this.hash == hash;
		}
	}

}
