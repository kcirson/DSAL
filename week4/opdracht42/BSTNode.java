package week4.opdracht42;

public class BSTNode<E extends Comparable<E>> {
	E element;
	BSTNode<E> left;
	BSTNode<E> right;

	BSTNode(E element, BSTNode<E> left, BSTNode<E> right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}

	BSTNode(E[] a) {
		// eis: a != null && a.length != 0

		int len = a.length;
		int mid = len / 2;
		element = a[mid];
		left = null;
		right = null;
		if (mid > 0)
			insert(a, 0, mid - 1);
		if (len - 1 > mid)
			insert(a, mid + 1, len - 1);
	}

	private void insert(E[] a, int low, int high) {
		int mid = (low + high + 1) / 2;
		insert(a[mid]);
		if (mid > low)
			insert(a, low, mid - 1);
		if (high > mid)
			insert(a, mid + 1, high);
	}

	private String toString(int nspaces) {
		String s1 = "";
		String s2 = "";
		String s3 = "";
		if (right != null)
			s1 = right.toString(nspaces + 3);
		for (int i = 0; i < nspaces; i++)
			s2 = s2 + ' ';
		s2 = s2 + element.toString() + '\n';
		if (left != null)
			s3 = left.toString(nspaces + 3);
		return s1 + s2 + s3;
	}

	public String toString() {
		return toString(0);
	}

	BSTNode<E> search(E e) {
		// eis: e != null

		BSTNode<E> current = this;
		while (current != null) {
			if (current.element.compareTo(e) < 0)
				current = current.right;
			else if (current.element.compareTo(e) > 0)
				current = current.left;
			else
				return current;
		}
		return null;
	}

	BSTNode<E> search2(E e) {
		// eis: e != null

		if (element.equals(e))
			return this;
		BSTNode<E> parent = parent(e);
		if (parent == null)
			return null;
		if (parent.element.compareTo(e) < 0)
			return parent.right;
		return parent.left;
	}

	BSTNode<E> rsearch(E e) {
		if (e.compareTo(e) > 0) {
			if (right != null) {
				return right.rsearch(e);
			} else {
				return null;
			}
		} else if (e.compareTo(e) < 0) {
			if (left != null) {
				return left.rsearch(e);
			} else {
				return null;
			}
		} else {
			return this;
		}
	}

	boolean insert(E e) {
		// eis: e != null

		BSTNode<E> parent = this;
		BSTNode<E> current = null;

		if (parent.element.compareTo(e) < 0)
			current = parent.right;
		else if (parent.element.compareTo(e) > 0)
			current = parent.left;
		else
			return false;

		while (current != null) {
			parent = current;
			if (parent.element.compareTo(e) < 0)
				current = parent.right;
			else if (parent.element.compareTo(e) > 0)
				current = parent.left;
			else
				return false;
		}
		if (parent.element.compareTo(e) < 0)
			parent.right = new BSTNode<E>(e, null, null);
		else
			parent.left = new BSTNode<E>(e, null, null);
		return true;
	}

	boolean rinsert(E e) {
		// System.out.println("rinsert");
		if (e.compareTo(e) > 0) {
			if (right != null) {
				return right.rinsert(e);
			} else {
				right = new BSTNode<E>(e, null, null);
				return true;
			}
		} else if (e.compareTo(e) < 0) {
			if (left != null) {
				return left.rinsert(e);
			} else {
				left = new BSTNode<E>(e, null, null);
				return true;
			}
		} else {
			return true;
		}
	}

	private BSTNode<E> parent(E e) {
		// eis: e != null
		// eis: element.equals(e) != 0

		BSTNode<E> parent = this;
		BSTNode<E> current = null;
		boolean found = false;

		if (parent.element.compareTo(e) < 0)
			current = parent.right;
		else if (parent.element.compareTo(e) > 0)
			current = parent.left;
		else
			return null;

		while (!found && current != null) {
			if (current.element.equals(e))
				found = true;
			else {
				parent = current;
				if (current.element.compareTo(e) < 0)
					current = current.right;
				else
					current = current.left;
			}
		}
		if (found)
			return parent;
		else
			return null;
	}

	boolean delete(E e) {
		// eis: e != null
		// eis: element.equals(e) != 0

		BSTNode<E> parent = parent(e);
		BSTNode<E> current;

		if (parent == null)
			return false;
		if (parent.element.compareTo(e) < 0) {
			current = parent.right; // current bevat e
			if (current.left == null) // geen linker-subboom
			{
				parent.right = parent.right.right;
				return true;
			} else if (current.right == null) // geen rechter-subboom
			{
				parent.right = parent.right.left;
				return true;
			}
		} else {
			current = parent.left; // current bevat e
			if (current.left == null) // geen linker-subboom
			{
				parent.left = parent.left.right;
				return true;
			} else if (current.right == null) // geen rechter-subboom
			{
				parent.left = parent.left.left;
				return true;
			}
		}

		// current bevat e ; current.right != null

		if (current.right.left == null) {
			current.element = current.right.element;
			current.right = current.right.right;
			return true;
		}
		BSTNode<E> node = current.getParentMinRightTree();
		current.element = node.left.element;
		node.left = node.left.right;
		return true;
	}

	BSTNode<E> getParentMinRightTree() // bepaal parent van node die kleinste element
										// van rechter-subtree bevat
	{
		// eis right.left != null

		BSTNode<E> parent = right;
		BSTNode<E> current = parent.left;
		while (current.left != null) {
			parent = current;
			current = current.left;
		}

		return parent;
	}

	public static void main(String[] s) {
		BSTNode<Integer> b = new BSTNode<Integer>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});

		System.out.println(b);
		BSTNode<Integer> node = b.search(new Integer(3));
		if (node != null)
			System.out.println(node.element);
		node = b.search(new Integer(4));
		if (node != null)
			System.out.println(node.element);
		node = b.search(new Integer(8));
		if (node != null)
			System.out.println(node.element);
		node = b.search(new Integer(11));
		if (node != null)
			System.out.println(node.element);
		node = b.search(new Integer(16));
		if (node != null)
			System.out.println(node.element);
		b.insert(new Integer(17));
		System.out.println(b);
		b.delete(new Integer(14));
		System.out.println(b);
		System.out.println("----------------");
	}
}
