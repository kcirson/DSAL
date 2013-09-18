package week2.Opdracht22;

public class Main {
	
	static MyStack<Character> stack = new MyStack<>();
	static ExpressionValidator<Character> expression = new ExpressionValidator<>(stack);
	
	public static void main(String[] args){
		//tests: goed, goed, goed, fout, fout
		String[] tests = new String[]{"((<>))", "((<>)())", "[(<>)]()(()())", "([)]]", "(((<)>))"};

		for(String s : tests) {
			if(expression.CorrectExpression(s)){
				System.out.println(s + " is goed!");
			}else{
				System.out.println(s + " is fout!");
			}
		}
	}
}
