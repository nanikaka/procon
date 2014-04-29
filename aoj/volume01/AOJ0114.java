package volume01;

import java.util.Scanner;

//Electro-Fly
public class AOJ0114 {

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
		while(true){
			int a1 = sc.nextInt();
			int m1 = sc.nextInt();
			int a2 = sc.nextInt();
			int m2 = sc.nextInt();
			int a3 = sc.nextInt();
			int m3 = sc.nextInt();
			if((a1|a2|a3|m1|m2|m3)==0)break;
			long x1 = 1;
			long x2 = 1;
			long x3 = 1;
			int x = a1%m1;
			int y = a2%m2;
			int z = a3%m3;
			while(x!=1){
				x1++;
				x = (x*a1)%m1;
			}
			while(y!=1){
				x2++;
				y = (y*a2)%m2;
			}
			while(z!=1){
				x3++;
				z = (z*a3)%m3;
			}
			System.out.println(x1*x2/gcd(x1, x2)*x3/gcd(x2,x3)/gcd(x1,x3)*gcd(x1, gcd(x2,x3)));
		}
	}
}
