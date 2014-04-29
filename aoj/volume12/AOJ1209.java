package volume12;

import java.util.Scanner;

//Square Coins
public class AOJ1209 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int[][] dp = new int[18][300];
		dp[0][0]=1;
		for(int i=1;i<18;i++){
			int x = i*i;
			for(int j=0;j<300;j++){
				if(j-x>=0)dp[i][j]=dp[i][j-x];
				dp[i][j] += dp[i-1][j];
			}
		}
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			System.out.println(dp[17][n]);
		}
	}

	public static void main(String[] args) {
		new AOJ1209().run();
	}
}
