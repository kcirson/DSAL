package week2.Opdracht21;

import java.util.ArrayList;

public class MyStack<E> implements MyStackInterface<E>{
	
	private ArrayList<E> stack = new ArrayList<E>();
	
	public boolean isEmpty() {
		if(stack==null)
			return true;
		
		return false;
	}

	public void push(E item) {
		stack.add(item);
	}

	public E pop() {
		if(isEmpty())
			return null;
		
	    E output = stack.get(stack.size()-1);
	    stack.remove(stack.size()-1);

	    return(output);
	}

	public E peek() {
		if(!isEmpty()) {
			int lastIndex = stack.size()-1;
			return(stack.get(lastIndex));
		} else {
			return null;
		}
		
	}
	
	public String toString() {
		int size = 0;
		String s = "";
		
		if(isEmpty())
			return "stack is leeg!";
		
		size = stack.size();
		
		if(size > 1)
			s = "stack heeft " + size + " objecten. Dat zijn: \n";
		else 
			s = "stack heeft " + size + " object. Dit is: \n";
		
		for(E item : stack)
			s += item.toString() + "\n";
		
		return s;
	}
	
}
