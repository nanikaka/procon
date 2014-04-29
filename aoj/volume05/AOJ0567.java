package volume05;

import java.util.Scanner;

//Best Pizza
public class AOJ0567 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt(), P = A+n*B;
		int[] c = new int[n+1];
		for(int i=1;i<=n;i++)c[i]=sc.nextInt();
		int[][] dp = new int[n+1][P+1];
		for(int p=A;p<=P;p++)dp[0][p] = C;
		for(int i=1;i<=n;i++)for(int p=A;p<=P;p++){
			dp[i][p] = dp[i-1][p];
			if(A+B<=p)dp[i][p] = Math.max(dp[i][p], dp[i-1][p-B]+c[i]);
		}
		int max = 0;
		for(int p=A;p<=P;p++)max = Math.max(max, dp[n][p]/p);
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		new AOJ0567().run();
	}
}
