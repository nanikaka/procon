package volume11;

import java.util.Arrays;
import java.util.Scanner;

//Cards
public class AOJ1163 {

	static int[] bipartiteMatching(boolean[][] graph) {
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
	static boolean go(int v,boolean[][] graph,boolean[] visited,int[] match) {
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
	
	public static long gcd(long a, long b){
		if(a < b){
			long tmp = a;
			a = b;
			b = tmp;
		}
		while(b!=0){
			long r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			int[] blue = new int[n];
			int[] red = new int[m];
			for(int i=0;i<n;i++)blue[i]=sc.nextInt();
			for(int j=0;j<m;j++)red[j]=sc.nextInt();
			boolean[][] match = new boolean[n][m];
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					match[i][j] = gcd(blue[i], red[j]) >= 2;
				}
			}
			int[] r = bipartiteMatching(match);
			int s = 0;
			for(int i:r)s+=i==-1?0:1;
			System.out.println(s);
		}
	}
}
