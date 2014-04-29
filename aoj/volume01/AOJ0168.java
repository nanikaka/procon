package volume01;

import java.util.Scanner;

//Kannondou
public class AOJ0168 {

	public static void main(String[] args) {
		int[][] dp = new int[31][31];
		dp[0][0] = 1;
		for(int i=1;i<=30;i++){
			for(int j=1;j<=30;j++){
				for(int k=1;k<=3;k++){
					if(j-k<0)continue;
					dp[i][j] += dp[i-1][j-k];
				}
			}
		}
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int t = 0;
			for(int i=1;i<=n;i++)t+=dp[i][n];
			System.out.println((t/10-1)/365+1);
		}
	}
}
