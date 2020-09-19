package dataStructures;

import java.util.LinkedList;

public class HashTable {
	
	protected int ElementsSize; 
	protected LinkedList<KeyValue> ElementsList;
	
	public class KeyValue{
		
		public String Key;
		public String Value;
		
		public KeyValue(String Key, String Value) {
			this.Key = Key;
			this.Value = Value;
		}
	}
	
	public HashTable(int size) {
		this.ElementsSize = size;
		this.ElementsList = new LinkedList<KeyValue>();
		
		for(int i = 0; i < ElementsSize; i++ ) {
			ElementsList.add(null);
		}
	}
	
	protected int GetPosition(String Key) {
		int pos = Key.hashCode() % ElementsSize;
		return Math.abs(pos);	
	}
	
	public String Get(String Key) {
		int pos  = GetPosition(Key);
		KeyValue keyValue = ElementsList.get(pos);
		if(keyValue == null) {
			return "Value not found";
		}	
		return keyValue.Key;
	}
	
	public void Add(String Key, String Value) {
		int pos = GetPosition(Key);
		KeyValue keyValue = new KeyValue(Key, Value);
		ElementsList.add(pos, keyValue);
	}
}
