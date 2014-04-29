package volume05;

import java.util.Arrays;
import java.util.Scanner;

//Pasta
public class AOJ0568 {

	int n, k, MOD = 10000;
	int[] a;
	int[][][] dp;

	int get(int v, int s, int c){
		if(a[v]!=-1&&a[v]!=s)return 0;
		if(v==n)return c==1?1:0;
		if(dp[v][s][c]!=-1)return dp[v][s][c];
		int res = 0;
		if(c==1){
			for(int j=0;j<3;j++){
				if(s==j)continue;
				res = (res+get(v+1, j, 1)+get(v+1, j, 2))%MOD;
			}
		}
		else res = get(v+1, s, 1);
		return dp[v][s][c] = res;
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); k = sc.nextInt();
		a = new int[n+1];
		Arrays.fill(a, -1);
		while(k--!=0)a[sc.nextInt()]=sc.nextInt()-1;
		dp = new int[n+1][3][3];
		for(int[][]b:dp)for(int[]c:b)Arrays.fill(c, -1);
		int res = 0;
		for(int j=0;j<3;j++)for(int c=1;c<3;c++)res+=get(1, j, c);
		System.out.println(res%MOD);
	}

	public static void main(String[] args) {
		new AOJ0568().run();
	}
}
