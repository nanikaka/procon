package volume21;

import java.util.Arrays;
import java.util.Scanner;

//Erratic Sleep Habits
public class AOJ2166 {

	int T, n, INF = 1<<29;
	int[] a, d;
	int[][] dp;
	
	int get(int k, int c){
		if(k==101)return 0;
		if(dp[k][c]!=-1)return dp[k][c];
		int res = get(k+1, 0)+1;
		int f = k+1, nc = (c+1)%T;
		for(;f<=100;f++, nc=(nc+1)%T){
			if(d[f]<a[nc])break;
			res = Math.min(res, get(f+1, 0)+1);
		}
		if(100<f)res = 0;
		return dp[k][c] = res;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			T = sc.nextInt();
			if(T==0)break;
			a = new int[T];
			for(int i=0;i<T;i++)a[i]=sc.nextInt();
			n = sc.nextInt();
			d = new int[101];
			Arrays.fill(d, INF);
			for(int i=0;i<n;i++){
				int x = sc.nextInt();
				d[x] = Math.min(d[x], sc.nextInt());
			}
			dp = new int[101][T];
			for(int[]p:dp)Arrays.fill(p, -1);
			System.out.println(get(1, 0));
		}
	}
	
	public static void main(String[] args) {
		new AOJ2166().run();
	}
}
