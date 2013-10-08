package week4.opdracht41;

public class DoubleLinkedList<E> {

	private DoubleLinkedListNode<E> head = null;
	private DoubleLinkedListNode<E> tail = null;

	public void addLast(E e) {
		if (head == null) {
			head = new DoubleLinkedListNode<E>(e, null, null);
			tail = head;
		} else {
			DoubleLinkedListNode<E> n = new DoubleLinkedListNode<E>(e, null, tail);
			tail.next = n;
			tail = tail.next;
		}
	}

	public void delete(E e) {
		if (head != null) {
			if (head.data.equals(e)) {
				head = head.next;
				if (head == null)
					tail = null;
			} else {
				DoubleLinkedListNode<E> current = head;
				while (current.next != null && !current.next.data.equals(e))
					current = current.next;
				if (current.next != null)
					current.next = current.next.next;
				if (current.next == null)
					tail = current;
			}
		}
	}

	public void addFirst(E e) {
		if (head != null) {
			DoubleLinkedListNode<E> n = new DoubleLinkedListNode<E>(e, head, null);
			head = n;
		} else {
			head = new DoubleLinkedListNode<E>(e, null, null);
			tail = head;
		}
	}

	public String reverseToString() {
		String s = "";

		DoubleLinkedListNode<E> current = tail;
		if (tail != null) {
			s += current.toString();
			current = current.previous;
		} else {
			s += "Nothing to display";
		}

		while (current != null) {
			s += " -> " + current.toString();
			System.out.println(current);
			current = current.previous;
		}

		return s;
	}

	public String toString() {
		String s = "";

		DoubleLinkedListNode<E> current = head;
		if (current != null) {
			s = s + current.toString();
			current = current.next;
		} else {
			s += "Nothing to display";
		}
		
		while (current != null) {
			s = s + " -> " + current.toString();
			current = current.next;
		}
		return s;
	}

	public static void main(String[] s) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
//		System.out.println("Print empty list:");
//		System.out.println(list);
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
//		System.out.println("Print 1 to 5");
//		System.out.println("list: " + list);
//		System.out.println("reverse: " + list.reverseToString());
		list.addFirst(0);
		System.out.println("Print added 0");
		System.out.println("list: " + list);
		System.out.println("reverse: " + list.reverseToString());
//		list.addLast(6);
//		System.out.println("Print added 6");
//		System.out.println("list: " + list);
//		System.out.println("reverse: " + list.reverseToString());
//		list.delete(3);
//		System.out.println("Print removed 3");
//		System.out.println("list: " + list);
//		System.out.println("reverse: " + list.reverseToString());
//		list.delete(6);
//		System.out.println("Print removed 6");
//		System.out.println("list: " + list);
//		System.out.println("reverse: " + list.reverseToString());
//		list.delete(0);
//		System.out.println("Print removed 0");
//		System.out.println("list: " + list);
//		System.out.println("reverse: " + list.reverseToString());
	}
}
