package volume21;

import java.util.Scanner;

//Heian-Kyo Walking
public class AOJ2186 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0){
			int w = sc.nextInt(), h = sc.nextInt(), n = sc.nextInt();
			int[][] dp = new int[h+1][w+1];
			boolean[][][][] e = new boolean[h+1][w+1][h+1][w+1];
			while(n--!=0){
				int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt();
				e[y1][x1][y2][x2] = e[y2][x2][y1][x1] = true;
			}
			dp[0][0] = 1;
			for(int j=1;j<=w;j++)dp[0][j] = e[0][j-1][0][j]?0:dp[0][j-1];
			for(int i=1;i<=h;i++)dp[i][0] = e[i][0][i-1][0]?0:dp[i-1][0];
			for(int i=1;i<=h;i++)for(int j=1;j<=w;j++)dp[i][j] = (e[i][j][i][j-1]?0:dp[i][j-1])+(e[i][j][i-1][j]?0:dp[i-1][j]);
			System.out.println(dp[h][w]==0?"Miserable Hokusai!":dp[h][w]);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2186().run();
	}
}
