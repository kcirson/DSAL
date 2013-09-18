package week2.Opdracht21;

public interface MyStackInterface<E>
{
	boolean isEmpty( ); 		// ga na of de stack leeg is
	void push( E item);			// plaats item op stack
	E pop( );					// haal item van stack
								// bij een lege stack is de return-waarde null 
	E peek( );            
								// raadpleeg top van stack, maar haal geen item weg
								// bij een lege stack is de return-waarde null 
	String toString();
}