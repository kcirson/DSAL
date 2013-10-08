package week5;

public interface ChainingHashInterface<E> {
	public boolean search(E e); // return  "e found"
	public boolean insert(E e);  //return  "e not found"
	String toString();
}