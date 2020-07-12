package dataStructures;

public class LinkedList {
	
	Node head;
	Node tail;
	public int Length;
	
	public class Node {
		
		private Node next;
		private int val;
		
		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}
	
	public void Add(int val) {
		
		Node node = new Node(val);
		if(head == null) {
			head = node;
			tail = node;
			return;
		}
		
		tail.next = node;
		tail = node;
	}
	
	public void DeleteLast() {
		
		if(head == null) {
			return;
		}
		
		if(head.next == null) {
			head = null;
			return;
		}

		Node current = head;
		while(current.next.next != null) {
			current = current.next;
		}
		
		tail = current;
        tail.next = null;
	}
	
	public void ReverseList() {
		if(head == null) {
			return;
		}
		
		Node current = head, next = head;
		Node prev = null;
		
		int FistVal = current.val;
		tail = new Node(FistVal);
		tail.next = null;
		
		while(next != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
	}
	
	public void DeleteAt(int index) {
		int count = 1;
		Node current = head;
		
		if(head == null || index < 0) {
			return;
		}
		
		if(current.next == null && index > 2) {
			return;
		}
		
		while(current != null) {
			if(count + 1 == index) {
				current.next = current.next.next;	
				Length--;
				return;
			}
			count++;
			current = current.next;
		}
	}
	
	public void ShowAll(){
		if(head == null) {
			return;
		}
		
		Node current = head;
		
		while(current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
		System.out.println();
	}
}