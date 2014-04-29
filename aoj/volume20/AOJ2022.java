package volume20;

import java.util.Arrays;
import java.util.Scanner;

//Princess, a Cryptanalyst
public class AOJ2022 {

	int n, INF = 1<<29, len;
	int[][] cut, dp;
	String[] s;
	String INFS = "?", res;
	boolean[] u;
	
	void dfs(int k, String str, int pre){
		if(len<str.length()||comp(str, res)>0)return;
		if(k==n){
			res = str; return;
		}
		for(int i=0;i<n;i++){
			if(u[i])continue;
			u[i] = true;
			String nx = "";
			if(pre==-1)nx = s[i];
			else nx = str+s[i].substring(cut[pre][i]);
			dfs(k+1, nx, i);
			u[i] = false;
		}
	}
	
	int get(int S, int last){
		if(dp[S][last]!=INF)return dp[S][last];
		int ns = S-(1<<last);
		if(ns==0)return dp[S][last] = s[last].length();
		int res = INF;
		for(int k=0;k<n;k++){
			if(((ns>>k)&1)==0)continue;
			int r = get(ns, k)+s[last].length()-cut[k][last];
			res = Math.min(res, r);
		}
		return dp[S][last] = res;
	}
	
	int comp(String a, String b){
		if(INFS.equals(a))return 1;
		if(INFS.equals(b))return -1;
		int m = Math.min(a.length(), b.length());
		for(int i=0;i<m;i++)if(a.charAt(i)!=b.charAt(i))return a.charAt(i)-b.charAt(i);
		return 0;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int N = sc.nextInt();
			if(N==0)break;
			String[] t = new String[N];
			for(int i=0;i<N;i++)t[i]=sc.next();
			boolean[] del = new boolean[N];
			for(int i=0;i<N;i++)for(int j=i+1;j<N;j++)if(t[i].equals(t[j]))del[j] = true;
			for(int i=0;i<N;i++)for(int j=0;j<N;j++){
				if(i==j||del[i]||del[j])continue;
				if(t[i].contains(t[j]))del[j] = true;
			}
			n = 0;
			for(boolean f:del)if(!f)n++;
			s = new String[n];
			int id = 0;
			for(int i=0;i<N;i++)if(!del[i])s[id++] = t[i];
			cut = new int[n][n];
			for(int i=0;i<n;i++)for(int j=0;j<n;j++){
				if(i==j)continue;
				for(int k=0;k<s[i].length();k++){
					if(s[j].startsWith(s[i].substring(k))){
						cut[i][j] = s[i].length()-k; break;
					}
				}
			}
			dp = new int[1<<n][n];
			for(int[]a:dp)Arrays.fill(a, INF);
			len = INF;
			for(int i=0;i<n;i++)len = Math.min(len, get((1<<n)-1, i));
			res = INFS;
			u = new boolean[n];
			dfs(0, "", -1);
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2022().run();
	}
}
