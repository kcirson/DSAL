// MachtDemo.java

package week1;

import java.math.BigInteger;

public class MachtDemo
{
	public int teller = 0;
	
	public double machtv1(double a, int n)
    {
        return Math.pow(a,n);
    }

	public double machtv2(double a, int n)
    {
        if (n == 0) return 1.0;
        if (n < 0) return 1/machtv2(a,-n);
        double m = 1.0;
        for (int i = 0; i<n; i++)
            m = m*a;
        return m;
    }
    
	public double machtv3(double a, int n) {
        if (n == 0) return 1.0;
        if (n < 0) return 1/machtv3(a,-n);
        double m = 1.0;
        while (n > 1 ) {
            if (n % 2 == 1)
               m = m*a;
            n = n/2;
            a = a*a; 
        }
        return m*a;
    }
	
	public BigInteger machtv2BigInteger(BigInteger a, int n) {
		teller = 0;
        if (n == 0) return BigInteger.ONE;
        if (n < 0) return BigInteger.ONE.divide(machtv2BigInteger(a,-n));
        BigInteger m = BigInteger.ONE;
        for (int i = 0; i<n; i++) {
            m = m.multiply(a);
            teller++;
        }
        return m;
    }
    
	public BigInteger machtv3BigInteger(BigInteger a, int n) {
		teller = 0;
		if (n == 0) return BigInteger.ONE;
        if (n < 0) return BigInteger.ONE.divide(machtv3BigInteger(a,-n));
        BigInteger m = BigInteger.ONE;
        while (n > 1 ) {
            if (n % 2 == 1) {
            	m = m.multiply(a);
            	teller++;
            }
            n /= 2;
            a = a.multiply(a);
            teller++;
        }
        return m.multiply(a);
    }
	
	public String StringFormat(BigInteger bi) {
		String BigIntString = bi.toString();
		
		String bi1 = BigIntString.substring(0, 1);
		String bi2 = BigIntString.substring(1, 26);
		
		String rest = BigIntString.substring(1, BigIntString.length());
		
		return bi1 + "." + bi2 + "^" + rest.length();
	}
	
	public String stappenTeller() {
		return "BigInteger heeft er: " + teller + " stappen over gedaan";
	}
    
    public static void main(String[] args) {
        MachtDemo m = new MachtDemo();
        System.out.println(m.machtv1(2,1000));        
        System.out.println(m.machtv2(2,1000));        
        System.out.println(m.machtv3(2,1000));
        System.out.println();
        System.out.println("Machtv2 BigInteger:" + m.StringFormat((m.machtv2BigInteger(new BigInteger("2"), 1000))));
        System.out.println(m.stappenTeller());
        System.out.println();
        System.out.println("Machtv3 BigInteger:" + m.StringFormat(m.machtv3BigInteger(new BigInteger("2"), 1000)));
        System.out.println(m.stappenTeller());
        System.out.println();
    }
}