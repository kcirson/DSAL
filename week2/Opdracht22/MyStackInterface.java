package week2.Opdracht22;

public interface MyStackInterface<E> {
	boolean isEmpty( );
	void push( E item);
	E pop();
	E peek();
	String toString();
}