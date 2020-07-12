package dataStructures;

public class BinaryTree {
	
	Node root;
	int treeSize = 0;
	
	public class Node{
		protected int value;
		protected Node left;
		protected Node right;
		
		public Node(int value){
			
			this.value = value;
			left = null;
			right = null;
		}
		
		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}
	
	public void addToTree(int value) {
		
		Node node = new Node(value);
		
		if(root == null) {
			root = node;
			return;
		}
		
		Node current = root;
		Node parent; 
		
		while(true) {		
			parent = current;
			
			if(value < current.value) {
				
				current = current.left;
				
				if(current == null) {
					parent.left = node;
					return;
				}
				
			} else {
				current = current.right;
				
				if(current == null) {
					parent.right = node;
					return;
				}
			}
		}
	}
	
	public BinaryTree buildFromArray(int arr[]) {
		
		BinaryTree tree = new BinaryTree();
		
		tree.root = buildFromArray(arr, root, 0);
		
		return tree;
	}
	
	public Node buildFromArray(int arr[], Node current, int i) {
		
		if(i < arr.length) {
			Node temp = new Node(arr[i]);
			
			if(root == null) {
				root = temp;
			}
			
			current = temp;
			
			current.left = buildFromArray(arr, current.left, i * 2 + 1);
			current.right = buildFromArray(arr, current.right, i * 2 + 2);
		}
		
		return current;
	}
	
	public void InOrder() {
		
		if(root == null) {
			return;
		}
		
		Node current = root;		
		InOrder(current);
	}
	
	private void InOrder(Node node) {
		if(node != null) {
			InOrder(node.left);
			System.out.println(node);
			InOrder(node.right);
		}
	}
}
