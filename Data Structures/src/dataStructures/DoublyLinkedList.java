package dataStructures;

public class DoublyLinkedList {
	
	int Length = 0;
	Node head;
	Node tail;
	
	public class Node{
		
		Node prev;
		Node next;
		int value;
		
		Node(int value){
			this.value = value;
			next = null;
			prev = null;
		}
	}
	
	public void AddAtEnd(int val) {
		
		Node node = new Node(val);
		
		if(head == null) {
			head = node;
			tail = node;
			tail.prev = head;			
		}
		else {
			tail.next = node;
			tail.next.prev = tail;
			tail = tail.next;
		}
		Length++;
	}
	
	public void AddAtBeg(int val) {
		Node node = new Node(val);
		
		if(head == null) {
			AddAtEnd(val);
			return;
		}
		
		head.prev = node;
		node.next = head;
		head = head.prev;
		
		Length++;
	}
	
	public void PrintAll() {
		if(head == null)
			return;
		
		Node current = head;
		while(current != null) {
			System.out.println(current.value);
			current = current.next;
		}
	}
	
	public void ReverseList() {
		Node current = head;
		Node prev = null;
		
		while(current != null) {
			prev = current.prev;
			current.prev = current.next;
			current.next = prev;
			current = current.prev;
		}
		
		tail = head;
		head = prev.prev;
	}
	
	public void RemoveLast() {
		if(head == null)
			return;
		
		if(tail.prev == null) {
			tail = null;
			Length--;
			return;
		}
		
		tail = tail.prev;
		tail.next = null;
		
		Length--;
	}
	
	public void RemoveFirst() {
		if(head == null)
			return;
		
		if(head.next == null) {
			head = null;
			Length--;
			return;
		}
		
		head = head.next;
		head.prev = null;
		
		Length--;
	}
	
	public void RemoveAt(int index) {
		if(head == null || index <= 0 || index > Length)
			return;
		
		if(index == Length) {
			RemoveLast();
			return;
		}
		
		if(index == 1) {
			RemoveFirst();
			return;
		}
		
		
		Node current = head;
		int count = 1;
		
		while(current != null) {
			if(count == index) {
				current.prev.next = current.next;
				current.next.prev = current.prev;
				break;
			}
			
			current = current.next;
			count++;
		}
		
		Length--;
	}
}
