package volume01;

import java.util.Scanner;

//Greatest Common Divisor: Euclidean Algorithm
public class AOJ0197 {

	static long gcd(long a, long b){
		c = 0;
		if(a < b){
			long tmp = a;
			a = b;
			b = tmp;
		}
		while(b!=0){
			long r = a%b;
			a = b;
			b = r;
			c++;
		}
		return a;
	}

	static int c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int a = sc.nextInt();
			int b = sc.nextInt();
			if((a|b)==0)break;
			System.out.println(gcd(a,b)+" "+c);
		}
	}
}
