package volume22;

import java.util.Arrays;
import java.util.Scanner;

//The First Acceptance
public class AOJ2263 {

	class R implements Comparable<R>{
		int a, b;
		public R(int a, int b) {
			this.a = a;
			this.b = b;
		}
		public int compareTo(R o) {
			return b-o.b;
		}
	}
	
	int n;
	
	void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		R[] r = new R[n];
		for(int i=0;i<n;i++)r[i]=new R(sc.nextInt(), sc.nextInt());
		Arrays.sort(r);
		int[][] dp = new int[n][n+1];
		for(int[] a:dp)Arrays.fill(a, 1<<30);
		dp[0][1] = r[0].a<=r[0].b?r[0].a:(1<<30);
		for(int i=0;i<n;i++)dp[i][0] = 0;
		for(int i=1;i<n;i++){
			for(int j=1;j<=i+1;j++){
				if(dp[i-1][j-1]+r[i].a<=r[i].b)dp[i][j]=Math.min(Math.min(dp[i][j], dp[i-1][j]), dp[i-1][j-1]+r[i].a);
				else dp[i][j] = dp[i-1][j];
				
			}
		}
		for(int j=n;j>=0;j--){
			if(dp[n-1][j]!=1<<30){
				System.out.println(j);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ2263().run();
	}
}
