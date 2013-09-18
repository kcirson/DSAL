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
		HashMap<String, String> tokens = new HashMap<String, String>();
		tokens.put(">", "<");
		tokens.put("]", "[");
		tokens.put(")", "(");
		tokens.put("}", "{");
		
		for(int i = 0; i < s.length(); i++) {
			String currentChar = String.valueOf(s.charAt(i));

			if(tokens.containsValue(currentChar))
				stack.push((E) currentChar);
			else if(tokens.containsKey(currentChar))
				if(stack.peek().equals(tokens.get(currentChar)))
					stack.pop();
				else
					return false;
		}
		return true;
	}
}