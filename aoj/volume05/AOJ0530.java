package volume05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Pyon-Pyon River Crossing
public class AOJ0530 {

	int[][][] dp;

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			int[][] x = new int[n][];
			int[][] a = new int[n][];
			int[] num = new int[n];
			for(int i=0;i<n;i++){
				int k = sc.nextInt();
				x[i] = new int[k];
				a[i] = new int[k];
				num[i] = k;
				for(int j=0;j<k;j++){
					x[i][j] = sc.nextInt();
					a[i][j] = sc.nextInt();
				}
			}
			dp = new int[n][m+1][];
			for(int i=0;i<n;i++){
				for(int j=0;j<=m;j++){
					dp[i][j] = new int[num[i]];
					Arrays.fill(dp[i][j], 1<<30);
				}
			}
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(n, new Comparator<int[]>(){
				public int compare(int[] o1, int[] o2) {
					return dp[o1[0]][o1[1]][o1[2]] - dp[o2[0]][o2[1]][o2[2]];
				}
			});
			for(int j=0;j<num[0];j++){
				dp[0][m][j] = 0;
				q.add(new int[]{0,m,j});
			}
			if(m>0)
				for(int j=0;j<num[1];j++){
					dp[1][m-1][j] = 0;
					q.add(new int[]{1,m-1,j});
				}
			int min = 1<<30;
			while(!q.isEmpty()){
				int[] p = q.poll();
				int i = p[0];
				int rest = p[1];
				int pos = p[2];
				if(n-1<=i||0<rest&&n-2<=i){
					min = Math.min(min, dp[i][rest][pos]);
					continue;
				}
				for(int j=0;j<num[i+1];j++){
					int v = dp[i][rest][pos] + (a[i][pos]+a[i+1][j])*Math.abs(x[i][pos]-x[i+1][j]);
					if(v<dp[i+1][rest][j]){
						dp[i+1][rest][j] = v;
						q.add(new int[]{i+1,rest,j});
					}
				}
				if(rest==0)continue;
				for(int j=0;j<num[i+2];j++){
					int v = dp[i][rest][pos] + (a[i][pos]+a[i+2][j])*Math.abs(x[i][pos]-x[i+2][j]);
					if(v<dp[i+2][rest-1][j]){
						dp[i+2][rest-1][j] = v;
						q.add(new int[]{i+2,rest-1,j});
					}
				}
			}
			System.out.println(min);
		}
	}

	public static void main(String[] args) {
		new AOJ0530().run();
	}
}
