package week4.opdracht43;

public class BinaryTree<E> {
	private BinaryNode<E> root = null;

	public BinaryTree(E[] a) {
		if (a == null || a.length == 0)
			root = null;
		else
			root = new BinaryNode<E>(a);
	}

	int size() {
		if (root == null)
			return 0;
		return root.size();
	}

	int height() {
		if (root == null)
			return -1;
		return root.height();
	}

	public String toString() {
		if (root == null)
			return "null-tree";
		else
			return root.toString();
	}

	String toPreOrderString() {
		if (root == null)
			return "null-tree";
		else
			return root.toPreOrderString();
	}

	String toInOrderString() {
		if (root == null)
			return "null-tree";
		else
			return root.toInOrderString();
	}

	String toPostOrderString() {
		if (root == null)
			return "null-tree";
		else
			return root.toPostOrderString();
	}

	String toLevelOrderString() {
		if (root == null)
			return "null-tree";
		else
			return root.toLevelOrderString();
	}

	public static void main(String[] s) {
		BinaryTree<Integer> b = new BinaryTree<Integer>(new Integer[]{1, 2, 3});
		// System.out.println(b);
		// System.out.println("----------------");
		b = new BinaryTree<Integer>(new Integer[]{1, 2, 3, 4});
		// System.out.println(b);
		// System.out.println("----------------");
		b = new BinaryTree<Integer>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		// System.out.println(b);
		// System.out.println("----------------");
		b = new BinaryTree<Integer>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
		// System.out.println(b);
		// System.out.println("size: " + b.size());
		// System.out.println("height: " + b.height());
		// System.out.println("----------------");
		b = new BinaryTree<Integer>(null);
		// System.out.println(b);
		b = new BinaryTree<Integer>(new Integer[0]);
		// System.out.println(b);
		b = new BinaryTree<Integer>(new Integer[]{21, 11, 22, 1, 23, 12, 24});
		System.out.println("size: " + b.size());
		System.out.println("height: " + b.height());
		// System.out.println(b);
		// System.out.println(b.toPreOrderString());
		// System.out.println(b.toInOrderString());
		System.out.println(b.toPostOrderString());
		System.out.println("Level Order String:");
		System.out.println(b.toLevelOrderString());
		// System.out.println("----------------");
	}
}