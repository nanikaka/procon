package volume01;

import java.util.Scanner;

//Search
public class AOJ0188 {

	static int c;
	static int[] a;

	static int comp(int k, int x){
		c++;
		return a[k]-x;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			a = new int[n];
			for(int i=0;i<n;i++)a[i]=sc.nextInt();
			int x = sc.nextInt();
			c = 0;
			int l = 0;
			int r = n-1;
			int k = (l+r)/2;
			while(l<=r){
				int com = comp(k, x);
				if(r<=l)break;
				if(com<0)l=k+1;
				else if(com>0)r=k-1;
				else break;
				k=(l+r)/2;
			}
			System.out.println(c);
		}
	}
}
