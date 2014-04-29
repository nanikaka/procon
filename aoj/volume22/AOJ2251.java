package volume22;

import java.util.Arrays;
import java.util.Scanner;

//Merry Christmas
public class AOJ2251 {

	int INF = 1<<29;
	
	@SuppressWarnings("unused")
	int[] bipartiteMatching(boolean[][] graph) {
		int n = graph.length;
		if(n==0)return new int[0];
		int m = graph[0].length;
		int[] match = new int[m];
		Arrays.fill(match, -1);
		int res = 0;
		for (int i = 0; i < n; i++) {
			boolean[] visited = new boolean[m];
			if (go(i,graph,visited,match)) res++;
		}
		return match;
	}
	boolean go(int v,boolean[][] graph,boolean[] visited,int[] match) {
		int m = graph[0].length;
		for (int i = 0; i < m; i++)  if (!visited[i] && graph[v][i] && match[i] == -1) {
			visited[i] = true;
			match[i] = v;
			return true;
		}
		for (int i = 0; i < m; i++) if (!visited[i] && graph[v][i]) {
			visited[i] = true;
			if (go(match[i],graph,visited,match)) {
				match[i] = v;
				return true;
			}
		}
		return false;
	}
	
	void run(){
		int[][] wf = new int[100][100];
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), m = sc.nextInt(), L = sc.nextInt();
			if((n|m|L)==0)break;
			for(int i=0;i<n;i++)for(int j=0;j<n;j++)wf[i][j]=INF;
			while(m--!=0){
				int s = sc.nextInt(), t = sc.nextInt(), d = sc.nextInt();
				wf[s][t] = wf[t][s] = d;
			}
			for(int k=0;k<n;k++)for(int i=0;i<n;i++)for(int j=0;j<n;j++)wf[i][j]=Math.min(wf[i][j], wf[i][k]+wf[k][j]);
			boolean[][] e = new boolean[L][L];
			for(int i=0;i<L;i++)for(int j=0;j<L;j++)e[i][j]=false;
			int[] p = new int[L], t = new int[L];
			for(int i=0;i<L;i++){
				p[i] = sc.nextInt(); t[i] = sc.nextInt();
			}
			for(int i=0;i<L;i++)for(int j=0;j<L;j++){
				if(i==j)continue;
				if(p[i]==p[j]){
					if(t[i]<t[j])e[i][j]=true;
				}
				else if(t[i]+wf[p[i]][p[j]]<=t[j])e[i][j]=true;
			}
			int[] r = bipartiteMatching(e);
			int res = 0;
			for(int x:r)if(x!=-1)res++;
			System.out.println(L-res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2251().run();
	}
}
