package week2.Opdracht22;

import java.util.ArrayList;

public class MyStack<E> implements MyStackInterface<E> {

	private ArrayList<E> stack = new ArrayList<E>();

	public boolean isEmpty() {

		if(stack == null){
			return true;
		}
		if(stack.size() == 0) {
			return true;
		}

		return false;
	}

	public void push(E item) {
		stack.add(item);
	}

	public E pop() {
		if(isEmpty()){
			return null;
		}

		E output = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return(output);
	}

	public E peek() {
		if(!isEmpty()){
			int lastIndex = stack .size()-1;
			return(stack.get(lastIndex));
		}else{
			return null;
		}
	}

	public String toString() {
		if(isEmpty())
			return "toString: de stack is leeg!";

		String s = "toString: de stack heeft " + stack .size() + " objecten. Dat zijn: \n";
		for(E item : stack )
			s += item.toString() + "\n";

		return s;
	}
}
