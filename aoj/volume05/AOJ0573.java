package volume05;

import java.util.Scanner;

//Night Market
public class AOJ0573 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), T = sc.nextInt(), S = sc.nextInt();
		int[] a = new int[n], b = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt(); b[i] = sc.nextInt();
		}
		int[][] dp = new int[n][T+1];
		for(int j=b[0];j<=T;j++){
			dp[0][j] = dp[0][j-1];
			if(!(j-b[0]<S&&S<j))dp[0][j] = a[0];
		}
		for(int i=1;i<n;i++)for(int t=1;t<=T;t++){
			dp[i][t] = Math.max(dp[i-1][t], dp[i][t-1]);
			if(b[i]<=t&&!(t-b[i]<S&&S<t))dp[i][t] = Math.max(dp[i][t], dp[i-1][t-b[i]]+a[i]);
		}
		System.out.println(dp[n-1][T]);
	}
	
	public static void main(String[] args) {
		new AOJ0573().run();
	}
}
