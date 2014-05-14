package volume02;

import java.util.Arrays;
import java.util.Scanner;

//Izua Dictionary
public class AOJ0271 {

	long M = 1000000007;

	public void run() {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[100000];
		long[] f = new long[100001];
		f[0] = 1;
		for(int i=1;i<=100000;i++)f[i]=f[i-1]*i%M;
		for(;;){
			int n = sc.nextInt();
			if (n==0)break;
			for(int i=0;i<n;i++)a[i]=i+1;
			int r = sc.nextInt();
			while(r--!=0){
				int s = sc.nextInt()-1, t = sc.nextInt()-1;
				int x = a[s];
				a[s] = a[t];
				a[t] = x;
			}
			BIT bit = new BIT(100001);
			for(int i=2;i<=100000;i++){
				bit.add(i, 1);	
			}
			long res = 0;
			for(int i=0;i<n;i++){
				res+=bit.sum(a[i])*f[n-1-i];
				res%=M;
				bit.add(a[i], -1);
			}
			System.out.println(res);
		}
	}

	public static void main(String[] args) {
		new AOJ0271().run();
	}

	public static class BIT {

		public int n;
		private int[] bit;

		public BIT(int n) {
			this.n = n;
			bit = new int[n+1];
		}

		public int sum(int i){
			int s = 0;
			while(i>0){
				s += bit[i];
				i -= i&-i;
			}
			return s;
		}

		public void add(int i, int x){
			while(i<=n){
				bit[i] += x;
				i += i&-i;
			}
		}
	}
}

