package volume01;

import java.util.Arrays;
import java.util.Scanner;

//Cards
public class AOJ0145 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] c = new int[n][2];
		for(int i=0;i<n;i++)for(int j=0;j<2;j++)c[i][j]=sc.nextInt();
		int[][] dp = new int[n][n];
		for(int i=0;i<n;i++)Arrays.fill(dp[i], Integer.MAX_VALUE);
		for(int i=0;i<n;i++)dp[i][i]=0;
		for(int w=1;w<n;w++){
			for(int i=0;i+w<n;i++){
				int j = i+w;
				for(int k=i;k<j;k++){
					dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j]+c[i][0]*c[k][1]*c[k+1][0]*c[j][1]);
				}
			}
		}
		System.out.println(dp[0][n-1]);
	}
}
