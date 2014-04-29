package volume0;

import java.util.Scanner;

//Factorial
public class AOJ0019 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] f = new long[21];
		f[0]=f[1]=1;
		for(int i=2;i<21;i++)f[i]=i*f[i-1];
		System.out.println(f[sc.nextInt()]);
	}
}
