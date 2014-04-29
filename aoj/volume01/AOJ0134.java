package volume01;

import java.util.Scanner;

//Exit Survey
public class AOJ0134 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long s = 0;
		for(int i=0;i<n;i++)s+=sc.nextLong();
		System.out.println(s/n);
	}
}
