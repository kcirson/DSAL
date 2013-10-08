package week4.opdracht41;

public class DoubleLinkedListNode<E> {

	E data;
	DoubleLinkedListNode<E> next;
	DoubleLinkedListNode<E> previous;

	DoubleLinkedListNode(E data, DoubleLinkedListNode<E> next, DoubleLinkedListNode<E> previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;
	}

	public String toString() {
		return data.toString();
	}
}