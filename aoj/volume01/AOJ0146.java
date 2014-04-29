package volume01;

import java.util.Arrays;
import java.util.Scanner;

//Lupin The 4th
public class AOJ0146 {

	int n, INF = 1<<29;
	int[] dist, num;
	double[][] dp;
	int[][][] next;
	
	double get(int state, int v, int w){
		if(state==(1<<n)-1){
			next[state][v] = new int[]{-1, -1};
			return 0;
		}
		if(dp[state][v]!=INF)return dp[state][v];
		double min = INF;
		for(int i=0;i<n;i++){
			if(((state>>i)&1)>0)continue;
			double t = Math.abs(dist[v]-dist[i])/(2000.0/(70+w)) + get(state+(1<<i), i, w+20*num[i]);
			if(t<min){
				min = t;
				next[state][v] = new int[]{state+(1<<i), i};
			}
		}
		return dp[state][v] = min;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] ref = new int[n];
		dist = new int[n];
		num = new int[n];
		for(int i=0;i<n;i++){
			ref[i] = sc.nextInt();
			dist[i] = sc.nextInt();
			num[i] = sc.nextInt();
		}
		dp = new double[1<<n][n];
		for(double[]a:dp)Arrays.fill(a, INF);
		next = new int[1<<n][n][2];
		double min = INF;
		int id = -1;
		for(int i=0;i<n;i++){
			double t = get(1<<i, i, 20*num[i]);
			if(t<min){
				min = t; id = i;
			}
		}
		int[] s = new int[]{1<<id, id};
		System.out.print(ref[id]);
		for(;;){
			s = next[s[0]][s[1]];
			if(s[0]==-1)break;
			System.out.print(" "+ref[s[1]]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		new AOJ0146().run();
	}
}
