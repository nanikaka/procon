package volume05;

import java.util.Scanner;

//Dividing Snacks
public class AOJ0550 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), INF = 1<<29;
		int[] a = new int[n+2];
		for(int i=1;i<n;i++)a[i]=sc.nextInt();
		int[][][] dp = new int[2][2][n/2+1];
		for(int i=0;i<2;i++)for(int j=0;j<2;j++)for(int k=0;k<=n/2;k++)dp[i][j][k]=INF;
		dp[0][0][0] = 0;
		int x = 1;
		for(int i=1;i<=n;i++,x=1-x)for(int j=0;j<2;j++){
			int t = Math.min(i, n>>1);
			for(int k=0;k<=t;k++){
				dp[x][0][k] = Math.min(dp[1-x][0][k], dp[1-x][1][k]);
				if(0<k)dp[x][1][k] = Math.min(dp[1-x][0][k-1]+a[i-1]+a[i], dp[1-x][1][k-1]-a[i-1]+a[i]);
			}
		}
		System.out.println(Math.min(dp[1-x][0][n/2], dp[1-x][1][n/2]));
	}
	
	public static void main(String[] args) {
		new AOJ0550().run();
	}
}
