package week4.opdracht43;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNode<E> {
	E element;
	BinaryNode<E> left;
	BinaryNode<E> right;

	BinaryNode(E[] a, int low, int high) {
		// int mid = (low+high)/2; // soms links van het midden
		int mid = (low + high + 1) / 2; // soms rechts van het midden
		element = a[mid];
		if (mid > low)
			left = new BinaryNode<E>(a, low, mid - 1);
		else
			left = null;
		if (high > mid)
			right = new BinaryNode<E>(a, mid + 1, high);
		else
			right = null;
	}

	BinaryNode(E[] a) {
		// eis: a != null && a.length != 0
		this(a, 0, a.length - 1);
	}

	int size() {
		int s = 1;
		if (left != null)
			s = s + left.size();
		if (right != null)
			s = s + right.size();
		return s;
	}

	int height() {
		int hleft = -1, hright = -1;

		if (left != null)
			hleft = left.height();
		if (right != null)
			hright = right.height();

		return 1 + Math.max(hleft, hright);
	}

	String toString(int nspaces) {
		String s1 = "";
		String s2 = "";
		String s3 = "";
		if (right != null)
			s1 = right.toString(nspaces + 3); // drie spaties extra
		for (int i = 0; i < nspaces; i++)
			s2 = s2 + ' ';
		s2 = s2 + element.toString() + '\n';
		if (left != null)
			s3 = left.toString(nspaces + 3); // drie spaties extra
		return s1 + s2 + s3;
	}

	public String toString() {
		return toString(0);
	}

	String toPreOrderString() {
		String s = element.toString();
		if (left != null)
			s = s + ", " + left.toPreOrderString();
		if (right != null)
			s = s + ", " + right.toPreOrderString();
		return s;
	}

	String toInOrderString() {
		String s = "";
		if (left != null)
			s = left.toInOrderString() + ", ";
		s = s + element.toString();
		if (right != null)
			s = s + ", " + right.toInOrderString();
		return s;
	}

	String toPostOrderString() {
		String s = "";
		if (left != null)
			s = s + left.toPostOrderString() + ", ";
		if (right != null)
			s = s + right.toPostOrderString() + ", ";
		s = s + element.toString();
		return s;
	}

	String toLevelOrderString() {
		Queue<String> q = new LinkedList<String>();
		q.add(element.toString());
		if (left != null) {
			q.add(left.element.toString());
			left.toLevelOrderString();
		} else {
			q.add(left.element.toString());
		}
		if (right != null) {
			q.add(right.element.toString());
			right.toLevelOrderString();
		} else {
			q.add(right.element.toString());
		}

		return q.toString();
	}

}
