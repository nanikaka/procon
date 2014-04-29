package volume22;

import java.util.Arrays;
import java.util.Scanner;

//Mr. Rito Post Office
public class AOJ2200 {

	void run(){
		Scanner sc = new Scanner(System.in);
		int INF = 1<<28;
		for(;;){
			int n = sc.nextInt(), m = sc.nextInt();
			if((n|m)==0)break;
			int[][] wf1 = new int[n][n], wf2 = new int[n][n];
			for(int i=0;i<n;i++)for(int j=0;j<n;j++){
				wf1[i][j] = wf2[i][j] = INF;
			}
			for(int i=0;i<n;i++)wf1[i][i] = wf2[i][i] = 0;
			while(m--!=0){
				int s = sc.nextInt()-1, t = sc.nextInt()-1, cost = sc.nextInt();
				String str = sc.next();
				if("L".equals(str))wf1[s][t] = wf1[t][s] = Math.min(wf1[s][t], cost);
				else wf2[s][t] = wf2[t][s] = Math.min(wf2[s][t], cost);
			}
			for(int k=0;k<n;k++)for(int i=0;i<n;i++)for(int j=0;j<n;j++){
				wf1[i][j] = Math.min(wf1[i][j], wf1[i][k]+wf1[k][j]);
				wf2[i][j] = Math.min(wf2[i][j], wf2[i][k]+wf2[k][j]);
			}
			int R = sc.nextInt();
			int[][] dp = new int[2][n];
			Arrays.fill(dp[0], INF);
			int X = 1;
			int pre = sc.nextInt()-1;
			dp[0][pre] = 0;
			for(;--R!=0;X=1-X){
				int k = sc.nextInt()-1;
				Arrays.fill(dp[X], INF);
				for(int i=0;i<n;i++)for(int j=0;j<n;j++){
					if(i!=j)
						dp[X][i] = Math.min(dp[X][i], dp[1-X][j]+wf1[pre][j]+wf2[j][i]+wf1[i][k]);
					else
						dp[X][i] = Math.min(dp[X][i], dp[1-X][j]+wf1[pre][k]);
				}
				pre = k;
			}
			int res = INF;
			for(int i=0;i<n;i++)res = Math.min(res, dp[1-X][i]);
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2200().run();
	}
}
