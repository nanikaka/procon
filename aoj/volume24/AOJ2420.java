package volume24;

import java.util.Scanner;

//Anipero 2012
public class AOJ2420 {

	int n, m, MIN = -(1<<29);
	int[] a, b, c;
	int[][][][] dp;
	
	int get(int k, int M, int L1, int L2){
		if(k==n)return 0;
		if(dp[k][M][L1][L2]!=MIN)return dp[k][M][L1][L2];
		int res = c[k] + get(k+1, M, L2, 0);
		for(int d=1;d<=8;d++){
			if(M<d)break;
			res = Math.max(res, c[k] + get(k+1, M-d, L2, d));
		}
		for(int u2=0;u2<=8;u2++){
			if(L2<u2)break;
			for(int u1=0;u1+u2<=8;u1++){
				if(L1<u1)break;
				if(u1==0 && u2==0)continue;
				for(int d=0;d<=8;d++){
					if(M<d)break;
					res = Math.max(res, u2*a[k] + u1*b[k] + get(k+1, M-d, L2, d));
				}
			}
		}
		return dp[k][M][L1][L2] = res;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt();
		a = new int[n]; b = new int[n]; c = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt(); b[i] = sc.nextInt(); c[i] = sc.nextInt();
		}
		dp = new int[n][m+1][m+1][m+1];
		for(int i=0;i<n;i++)for(int j=0;j<=m;j++)for(int k=0;k<=m;k++)for(int l=0;l<=m;l++)dp[i][j][k][l] = MIN;
		int res = MIN+1;
		for(int d=0;d<=8;d++)if(d<=m)res = Math.max(res, get(0, m-d, 0, d));
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new AOJ2420().run();
	}
}
