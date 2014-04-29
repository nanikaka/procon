package volume01;

import java.util.Scanner;

//Baby Tree
public class AOJ0191 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			double[][] t = new double[n][n];
			for(int i=0;i<n;i++)for(int j=0;j<n;j++)t[i][j]=sc.nextDouble();
			double[][] dp = new double[m][n];
			for(int i=0;i<n;i++)dp[0][i]=1;
			for(int i=1;i<m;i++){
				for(int j=0;j<n;j++){
					for(int k=0;k<n;k++){
						dp[i][j] = Math.max(dp[i][j], dp[i-1][k]*t[k][j]);
					}
				}
			}
			double a = 0;
			for(int i=0;i<n;i++)a=Math.max(a, dp[m-1][i]);
			System.out.printf("%.2f\n", a);
		}
	}
}
