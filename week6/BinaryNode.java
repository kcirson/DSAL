package week6;

public class BinaryNode {
	private int element;
	private BinaryNode left;
	private BinaryNode right;

	public BinaryNode() {
		this(0, null, null);
	}

	public BinaryNode(int n, BinaryNode lt, BinaryNode rt) {
		element = n;
		left = lt;
		right = rt;
	}

	public int aantalLeaves() {
		if (left == null && right == null)
			return 1;
		if (left != null && right != null)
			return left.aantalLeaves() + right.aantalLeaves();
		if (left != null && right == null)
			return left.aantalLeaves();
		if (right != null && left == null)
			return right.aantalLeaves();

		return -1;
	}

	public static void main(String[] args) {
		//should be 1;
		BinaryNode node = new BinaryNode();
		System.out.println(node.aantalLeaves());

		// should be 2, 2 nodes without leaves, so only count the 2 nodes; 
		node = new BinaryNode(0, new BinaryNode(), new BinaryNode());
		System.out.println(node.aantalLeaves());

		// should be 1, only 1 leaf;
		node = new BinaryNode(0, null, new BinaryNode());
		System.out.println(node.aantalLeaves());

		// should be 1, only 1 leaf;
		node = new BinaryNode(0, new BinaryNode(), null);
		System.out.println(node.aantalLeaves());

		// should be 1, from root to 1 node to 1 node == 1;
		node = new BinaryNode(0, new BinaryNode(0, new BinaryNode(), null), null);
		System.out.println(node.aantalLeaves());
		
		//should be 3, 1 node with 2 leaves and 1 leaf == 3;
		node = new BinaryNode(0, new BinaryNode(0, new BinaryNode(), new BinaryNode()), new BinaryNode());
		System.out.println(node.aantalLeaves());
	}
}
