package volume02;

import java.util.Scanner;

//Room Numbers of a Hospital
public class AOJ0208 {

	static int[] t = {0,1,2,3,5,7,8,9};
	
	static void f(int n){
		if(n>=8)f(n/8);
		System.out.print(t[n%8]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			f(n);
			System.out.println();
		}
	}
}
