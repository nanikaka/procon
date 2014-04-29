package volume22;

import java.util.Scanner;

//Cicada
public class AOJ2272 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		char[][] m = new char[h][w];
		int[][] c = new int[h][w];
		for(int i=0;i<h;i++)m[i]=sc.next().toCharArray();
		for(int i=0;i<h;i++)for(int j=0;j<w;j++)c[i][j]=m[i][j]-'0';
		int[][] dp = new int[h][w];
		dp[h-1][w-1]=c[h-1][w-1];
		for(int j=w-2;j>=0;j--)dp[h-1][j]=dp[h-1][j+1]+c[h-1][j];
		for(int i=h-2;i>=0;i--)dp[i][w-1]=dp[i+1][w-1]+c[i][w-1];
		for(int i=h-2;i>=0;i--)for(int j=w-2;j>=0;j--)dp[i][j] = c[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
		System.out.println(dp[0][0]);
	}
	
	public static void main(String[] args) {
		new AOJ2272().run();
	}
}
