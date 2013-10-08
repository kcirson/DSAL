package week6;

public class Proeftentamen {

	int somCijfers(int n) {
		if (n < 0)
			return somCijfers(-n);
		if (n <= 9)
			return n;
		if (n > 9)
			return somCijfers(n / 10) + n % 10;

		return -1;
	}

	public static void main(String[] args) {
		Proeftentamen p = new Proeftentamen();

		System.out.println(p.somCijfers(123));
		System.out.println(p.somCijfers(-123));
		
		System.out.println(p.somCijfers(123456));
	}
}
