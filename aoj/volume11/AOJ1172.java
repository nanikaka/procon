package volume11;

import java.util.Arrays;
import java.util.Scanner;

//Chebyshev's Theorem
public class AOJ1172 {

	public static void main(String[] args) {
		boolean[] p = new boolean[123456*2+1];
		Arrays.fill(p, true);
		p[0]=p[1]=false;
		for(int i=2;i<p.length;i++)if(p[i])for(int j=i*2;j<p.length;j+=i)p[j]=false;
		int[] c = new int[p.length];
		for(int i=1;i<p.length;i++)c[i] = c[i-1]+(p[i]?1:0);
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			System.out.println(c[2*n]-c[n]);
		}
	}
}
