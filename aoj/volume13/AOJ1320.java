package volume13;

import java.util.Arrays;
import java.util.Scanner;

//City Merger
public class AOJ1320 {

	int n;
	String[] s;
	int[][] cut;
	int[][] dp;
	
	int get(int S, int last){
		if(dp[S][last]!=-1)return dp[S][last];
		int res = 1<<29;
		int ns = S-(1<<last);
		for(int j=0;j<n;j++){
			if(((ns>>j)&1)==0)continue;
			res = Math.min(res, get(ns, j)+s[last].length()-cut[j][last]);
		}
		return dp[S][last] = res;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			n = sc.nextInt();
			if(n==0)break;
			String[] t = new String[n];
			for(int i=0;i<n;i++)t[i]=sc.next();
			boolean[] del = new boolean[n];
			for(int i=0;i<n;i++)for(int j=0;j<n;j++)if(i!=j&&t[i].contains(t[j]))del[j] = true;
			int N = 0;
			for(boolean f:del)if(!f)N++;
			s = new String[N];
			int id = 0;
			for(int i=0;i<n;i++)if(!del[i])s[id++]=t[i];
			n = N;
			cut = new int[n][n];
			for(int i=0;i<n;i++)for(int j=0;j<n;j++){
				for(int k=0;k<s[i].length();k++){
					if(s[j].startsWith(s[i].substring(k))){
						cut[i][j] = s[i].length()-k; break;
					}
				}
			}
			dp = new int[1<<n][n];
			for(int[]a:dp)Arrays.fill(a, -1);
			for(int i=0;i<n;i++)dp[1<<i][i] = s[i].length();
			int res = 1<<29;
			for(int i=0;i<n;i++)res = Math.min(res, get((1<<n)-1, i));
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1320().run();
	}
}
