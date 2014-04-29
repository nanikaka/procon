package volume22;

import java.util.Scanner;

//THE BYDOLM@STER
public class AOJ2219 {

	void run(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int M = sc.nextInt();
			int[] c = new int[n];
			int[][] p = new int[n][3];
			for(int i=0;i<n;i++){
				sc.nextLine();sc.nextLine();
				c[i] = sc.nextInt();
				for(int j=0;j<3;j++)p[i][j] = sc.nextInt();
			}
			int[][][] dp = new int[3][n][M+1];
			for(int x=0;x<3;x++){
				for(int i=0;i<n;i++){
					for(int j=1;j<=M;j++){
						dp[x][i][j] = dp[x][i][j-1];
						if(j-c[i]>=0)dp[x][i][j] = Math.max(dp[x][i][j], dp[x][i][j-c[i]]+p[i][x]);
						if(i>0)dp[x][i][j] = Math.max(dp[x][i][j], dp[x][i-1][j]);
					}
				}
			}
			int max = 0;
			for(int i=0;i<3;i++)max = Math.max(max, dp[i][n-1][M]);
			System.out.println(max);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2219().run();
	}
}
