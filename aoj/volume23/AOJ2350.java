package volume23;

import java.util.Arrays;
import java.util.Scanner;

//A-B Problem
public class AOJ2350 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(), B = sc.nextInt(), K = sc.nextInt(), res = 0;
		int[] a = new int[10], b = new int[10], w = new int[11], c = new int[10];
		for(int i=0;i<10;i++){
			a[i] = A%10; A/=10;
			b[i] = B%10; B/=10;
		}
		for(int S=0;S<1<<10;S++){
			int k = 0, C = 0;
			for(int i=0;i<10;i++)if(((S>>i)&1)>0)k++;
			if(K<k)continue;
			Arrays.fill(w, 0);
			Arrays.fill(c, 0);
			for(int i=0;i<10;i++){
				if(b[i]<=a[i]-w[i]){
					c[i] = a[i]-w[i]-b[i]; w[i+1] = 0;
				}
				else {
					c[i] = a[i]-w[i]+10-b[i];
					if(((S>>i)&1)==0)w[i+1] = 1;
					else w[i+1] = 0;
				}
			}
			for(int i=9;i>=0;i--)C=C*10+c[i];
			res = Math.max(res, C);
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new AOJ2350().run();
	}
}
