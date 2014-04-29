package volume0;

import java.util.Scanner;

//GCD and LCM
public class AOJ0005 {

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
		while(sc.hasNext()){
			int a = sc.nextInt();
			int b = sc.nextInt();
			long g = gcd(a, b);
			System.out.println(g+" "+a/g*b);
		}
	}
}
