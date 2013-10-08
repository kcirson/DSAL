package week3.opdracht32;

public class BinaryDemo {

	String getBinary(int n) {
		if (n < 0) {
			return "?";
		} else if (n == 0) {
			return "0";
		} else if (n == 1) {
			return "1";
		} else {
			return getBinary(n / 2) + n % 2;
		}
	}

	public static void main(String[] args) {
		BinaryDemo demo = new BinaryDemo();

		System.out.println(demo.getBinary(-10));
		System.out.println(demo.getBinary(0));
		System.out.println(demo.getBinary(1));
		System.out.println(demo.getBinary(1000));
	}
}
