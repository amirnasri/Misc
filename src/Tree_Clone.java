class A {
}

class Tree_Clone {
	static class Node {
		int data;
		Node left, right;
		
		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	static void print_tree(Node root) {
		if (root == null)
			return;
		
		print_tree(root.left);
		System.out.print(root.data + "  ");
		print_tree(root.right);
	}
	
	static Node clone_tree(Node root) {
		if (root == null)
			return null;
		Node nh = new Node(root.data);
		nh.left = clone_tree(root.left);
		nh.right = clone_tree(root.right);
		return nh;
	}

	public static void main(String[] args) {
		
		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);
		n.right.left = new Node(4);
		n.right.right = clone_tree(n);
		print_tree(n);
		System.out.println();
		Node nh = clone_tree(n);
		print_tree(nh);
		System.out.println();
	}
}