package volume0;

import java.util.Scanner;

//Drawing Lots
public class AOJ0011 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int[] a = new int[w+1];
		for(int i=1;i<=w;i++)a[i]=i;
		int m = sc.nextInt();
		while(m--!=0){
			String[] s = sc.next().split(",");
			int l = Integer.parseInt(s[0]);
			int r = Integer.parseInt(s[1]);
			int t = a[l];
			a[l] = a[r];
			a[r] = t;
		}
		for(int i=1;i<=w;i++)System.out.println(a[i]);
	}
}
