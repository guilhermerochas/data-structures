package dataStructures;

public class Queue {
	public class Node{
		
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private Node head;
	private Node tail;
	
	public void peek() {
		if(head != null){
			System.out.println(head.data);
		}
	}
	
	public void add(int data) {
		Node node = new Node(data);
		if(head == null) {
			head = node;
			tail = node;
			return;
		}
		tail.next = node;
		tail = tail.next;
	}
	
	public void remove() {
		head = head.next;
		if(head == null) {
			tail = null;
		}
		return;
	}
	
	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		return false;
	}
	
}
