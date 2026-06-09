package pekan9_2511532029;

public class Node_2511532029 {
	int data_2029;
	Node_2511532029 left_2029;
	Node_2511532029 right_2029;
	
	public Node_2511532029 (int data_2029) {
		this.data_2029 = data_2029;
		left_2029 = null;
		right_2029 = null;
	}
	
	public void setleft_2029 (Node_2511532029 node) {
		if (left_2029 == null)
			left_2029 = node;
	}
	
	public void setRight_2029(Node_2511532029 node) {
		if (right_2029 == null)
			right_2029 = node;
	}
	
	public Node_2511532029 getLeft_2029 () {
		return this.left_2029;
	}
	public Node_2511532029 getRight_2029() {
		return this.right_2029;
	}
	
	public int getData_2029() {
		return data_2029;
	}
	
	public void setData_2029(int data_2029) {
		this.data_2029 = data_2029;
	}
	
	void printPreorder_2029 (Node_2511532029 node) {
		if (node == null)
			return;
		System.out.print(node.data_2029 +  "");
		printPreorder_2029 (node.left_2029);
		printPreorder_2029(node.right_2029);
	}
	void printPostorder_2029 (Node_2511532029 node) {
		if (node == null)
			return;
		printPostorder_2029(node.left_2029);
		printPostorder_2029(node.right_2029);
		System.out.print(node.data_2029 +  "");
	}
	
	void printInorder_2029(Node_2511532029 node) {
		if (node == null)
			return;
		printInorder_2029(node.left_2029);
			System.out.print(node.data_2029 +  "");
			printInorder_2029(node.right_2029);
	}
	
	public String print() {
		return this.print("",true,"");
	}
	
	public String print(String prefix, boolean isTail, String sb) {
		if (right_2029 != null ) {
			right_2029.print(prefix + (isTail ? "| " : " "),false , sb);
		}
		System.out.println(prefix+(isTail ? "\\--" : "/--") +data_2029);
		if (left_2029 != null) {
			left_2029.print(prefix+(isTail ? " " : "|  "), true,sb);
		}
		return sb;
	}
}