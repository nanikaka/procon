package volume05;

import java.util.Scanner;

//A Traveler
public class AOJ0549 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] s = new int[n+1];
		s[1] = 0;
		for(int i=2;i<=n;i++)s[i]=s[i-1]+sc.nextInt();
		int r = 0;
		int k = 1;
		while(m--!=0){
			int x = sc.nextInt();
			r += Math.abs(s[k+x]-s[k]);
			r %= 100000;
			k += x;
		}
		System.out.println(r);
	}
}
