package week2.Opdracht22;

public class Main {
	
	static MyStack<Character> stack = new MyStack<>();
	static ExpressionValidator<Character> expression = new ExpressionValidator<>(stack);
	
	public static void main(String[] args){
		//correct, correct, correct, incorrect, incorrect
		String[] tests = new String[]{"((<>))", "((<>)())", "[(<>)]()(()())", "([)]]", "(((<)>))"};

		for(String s : tests) {
			if(expression.CorrectExpression(s)){
				System.out.println(s + " is correct!");
			}else{
				System.out.println(s + " is incorrect!");
			}
		}
	}
}
