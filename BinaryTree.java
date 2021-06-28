public class BinaryTree {
    private class Node {
		Character item;
		Node left, right;
		
		Node(Character val, Node lft, Node rgt) {
			item = val;
			left = lft;
			right = rgt;
		}
		
		Node(Character val) {
			this(val,null,null);
		}
		
		public boolean isLeaf(){
			return left == null && right == null;
		}
		
		public String toString() {
			return item.toString();
		}
	}
	
	Node root;
	
	BinaryTree() {
		Node nodeH = new Node('H');
		Node nodeI = new Node('I');
		Node nodeJ = new Node('J');
		Node nodeE = new Node('E');
		Node nodeD = new Node('D',nodeH,null);
		Node nodeB = new Node('B',nodeD,nodeE);
		Node nodeF = new Node('F',null,nodeI);
		Node nodeG = new Node('G',null,nodeJ);
		Node nodeC = new Node('C',nodeF,nodeG);
		Node nodeA = new Node('A', nodeB, nodeC);

		root = nodeA;
	}
	
	private String preorder(Node node) {		
		if (node == null) return "";
		if (node.isLeaf()) return node.toString();
		
		String left = node.left == null ? "" : preorder(node.left) + ", ";
		String right = node.right == null ? "" : preorder(node.right) + ", ";
		
		String str = node.item.toString()+", "+left+right; 
				
		return str.substring(0,str.length()-2);
	}
	
	public String preorder() {
		return "[" + preorder(root) + "]";
	}
	
	private String inorder(Node node) {	
		if (node == null) return "";
		if (node.isLeaf()) return node.toString();
		
		String left = node.left == null ? "" : inorder(node.left) + ", ";
		String right = node.right == null ? "" : inorder(node.right) + ", ";
		
		String str = left+ node.item.toString()+", "+right; 
				
		return str.substring(0,str.length()-2);
	}
	
	public String inorder() {
		return "[" + inorder(root) + "]";
	}
	
	private String postorder(Node node) {	
		if (node == null) return "";
		if (node.isLeaf()) return node.toString();
		
		String left = node.left == null ? "" : postorder(node.left) + ", ";
		String right = node.right == null ? "" : postorder(node.right) + ", ";
		
		String str = left+right+ node.item.toString()+", "; 
				
		return str.substring(0,str.length()-2);
	}
	
	public String postorder() {
		return "[" + postorder(root)+ "]";
	}
	
	
	public String toString() {
		return "";
	}
}
