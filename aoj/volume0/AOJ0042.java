package volume0;

import java.util.Scanner;

//A Thief
public class AOJ0042 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Case = 1;
		while(true){
			int W = sc.nextInt();
			if(W==0)break;
			int n = sc.nextInt();
			int[] w = new int[n+1];
			int[] v = new int[n+1];
			for(int i=1;i<=n;i++){
				String[] s = sc.next().split(",");
				v[i] = Integer.parseInt(s[0]);
				w[i] = Integer.parseInt(s[1]);
			}
			int[][] dp = new int[n+1][W+1];
			int maxV = Integer.MIN_VALUE;
			int minW = Integer.MAX_VALUE;
			for(int i=1;i<=n;i++){
				for(int j=1;j<=W;j++){
					if(j-w[i]>=0){
						dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j-w[i]]), dp[i-1][j-w[i]]+v[i]);
						if(maxV < dp[i][j]){
							maxV = dp[i][j];
							minW = j;
						}
						else if(maxV == dp[i][j]){
							minW = Math.min(minW, j);
						}
					}
					else dp[i][j] = dp[i-1][j];
				}
			}
			System.out.println("Case " + Case++ + ":\n" + maxV + "\n" + minW);
			
		}
	}
}
