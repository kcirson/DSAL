package week2.Opdracht22;

import java.util.HashMap;

public class ExpressionValidator<E> implements ExpressionValidatorInterface {

	MyStack<E> stack;

	public ExpressionValidator(MyStack<E> stack) {
		this.stack = stack;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean CorrectExpression(String s) {
		HashMap<String, String> tekens = new HashMap<String, String>();
		tekens.put(">", "<");
		tekens.put("]", "[");
		tekens.put(")", "(");
		tekens.put("}", "{");
		
		for(int i = 0; i < s.length(); i++) {
			String currentChar = String.valueOf(s.charAt(i));

			if(tekens.containsValue(currentChar))	//Openkarakter
				stack.push((E) currentChar);
			else if(tekens.containsKey(currentChar))	//Sluitkarakter
				if(stack.peek().equals(tekens.get(currentChar)))
					stack.pop();
				else
					return false;
		}
		return true;
	}
}