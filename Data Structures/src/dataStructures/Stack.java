package dataStructures;

public class Stack {
	public class Node{
		Node next;
		int data;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	Node top;
	int size = 0;
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(int data) {
		Node node = new Node(data);
		if(top == null) {
			top = node;
		}
		else {
			node.next = top;
			top = node;
		}
		
		size++;
	}
	
	public void pop() {
		if(top != null) {
			System.out.println(top.data +  " was popped from stack!");
			top = top.next;
			size--;
			return;
		}
	}
	
	public void peek() {
		if(top != null) {
			System.out.println(top.data);
			return;
		}
	}
}
