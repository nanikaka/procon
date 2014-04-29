package volume10;

import java.util.Scanner;

//Greatest Common Divisor
public class AOJ1009 {

	public static long gcd(long a, long b){
		if(a < b){
			long tmp = a;
			a = b;
			b = tmp;
		}
		while(b!=0){
			long r = a%b;
			a = b;
			b = r;
		}
		return a;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
			System.out.println(gcd(sc.nextLong(), sc.nextLong()));
	}
}
