package dataStructures;



public class DinamicArray<T> {
	T [] arr;
	int capacity;
	int size;
	
	@SuppressWarnings("unchecked")
	DinamicArray(int cap){
		size = 0;
		capacity = cap;
		arr = (T[]) new Object[capacity];
	}
	
	public Boolean isEmpty() { return size == 0; }
	
	public int getCapacity() { return capacity; }
	
	public void Add(int at, T value) {
		if(at > capacity)
			return;
		
		arr[at] = value;
		size++;
	}
	
	public void Remove(int at) {
		if(arr[at] != null) {
			arr[at] = null;
			size--;
		}
	}
	
	public void clearAll() {
		for(int i = 0; i < capacity; i++) {
			arr[i] = null;
		}
		size = 0;
	}
	
	public void increaseCap(int by) {
		@SuppressWarnings("unchecked")
		T[] newArr = (T[]) new Object[capacity+by];
		for(int i = 0; i < capacity; i++ ) {
			newArr[i] = arr[i];
		}
		capacity = capacity + by;
	}
	
}
