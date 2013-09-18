package week2.Opdracht21;

public class Main {
	
	static MyStack<Locatie> stack = new MyStack<Locatie>();
	
	public static void main(String[] args){
		test();
	}
	
	public static void test() {
		//Begin
		System.out.println("Vanaf het begin:\n");
		System.out.println(stack.toString());
		
		//Push
		stack.push(new Locatie("Duitsland", 5.32438027, 5.32438022));
		stack.push(new Locatie("Belgie", 5.32432027, 5.32436022));
		System.out.println("Na een push:");
		System.out.println(stack.toString());
		
		//Peek
		System.out.println("START VAN PEEK:");
		System.out.println(stack.peek().toString());
		System.out.println("EIND VAN PEEK:");
		System.out.println("Na een peek:");
		System.out.println(stack.toString());
				
		//Pop
		stack.pop();
		System.out.println("Na een pop:");
		System.out.println(stack.toString());
	}
}
