package pekan9_2511532029;

public class BTree_2511532029 {
	private Node_2511532029 root;
	private Node_2511532029 currentNode;
	public BTree_2511532029() {
		root = null;
	}
	public boolean search_2029(int data_2029) {
		return search_2029 (root, data_2029);
	}
	
	private boolean search_2029(Node_2511532029 node, int data_2029) {
		if (node.getData_2029() == data_2029)
			return true;
		
		if (node.getLeft_2029() != null)
			if (search_2029(node.getLeft_2029() ,data_2029))
			return true;
		
		if (node.getRight_2029() != null)
			if (search_2029(node.getRight_2029(), data_2029))
				return true;
		return false;
	}
	
	public void printInorder_2029() {
		root.printInorder_2029(root);
	}
	
	public void printPreorder_2029() {
		root.printPreorder_2029(root);
	}
	
	public void printPostorder_2029() {
		root.printPostorder_2029(root);
	}
	
	public Node_2511532029 getRoot() {
		return root;
	}
	
	
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public int countNodes() {
		return  countNodes(root);
	}
	
	private int  countNodes(Node_2511532029 node) {
		int count = 1;
		if (node == null) {
		return 0;
	} else {
		count += countNodes(node.getLeft_2029());
		count += countNodes(node.getRight_2029());
		return count;
		}
	}
	
	public void print() {
		root.print();
	}
	
	public  Node_2511532029 getCurrent() {
		return currentNode;
	}
	
	public void setCurrent(Node_2511532029 node) {
		this.currentNode = node;
	}
	
	public void setRoot(Node_2511532029 root) {
		this.root = root;
	}
}