package volume21;

import java.util.Scanner;

//Text Justification
public class AOJ2129 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int[] a = new int[1001], sum = new int[1001], dp = new int[1001];
		int INF = (1<<30)-1;
		for(int T=1;;T++){
			int n = sc.nextInt(), w = sc.nextInt();
			if((n|w)==0)break;
			for(int i=1;i<=n;i++){
				a[i] = sc.nextInt();
				sum[i] = sum[i-1]+a[i];
				dp[i] = INF;
			}
			for(int i=1;i<=n;i++)for(int j=0;j<i;j++)dp[i] = Math.min(dp[i], dp[j]+(Math.abs(sum[i]-sum[j]-w)));
			int res = INF;
			for(int i=1;i<=n;i++)res = Math.min(res, dp[i-1]+Math.max(0, sum[n]-sum[i-1]-w));
			System.out.printf("Case %d: %d\n", T, res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2129().run();
	}
}
