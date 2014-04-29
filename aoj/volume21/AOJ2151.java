package volume21;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Brave Princess Revisited
public class AOJ2151 {

	int[][] dist;
	void run(){
		Scanner sc =new Scanner(System.in);
		int INF = 1<<29;
		for(;;){
			int n = sc.nextInt(), m = sc.nextInt(), L = sc.nextInt();
			if((n|m|L)==0)break;
			int[][] d = new int[n][n], e = new int[n][n];
			for(int[]a:d)Arrays.fill(a, INF);
			for(int[]a:e)Arrays.fill(a, INF);
			while(m--!=0){
				int s = sc.nextInt()-1, t = sc.nextInt()-1, D = sc.nextInt(), E = sc.nextInt();
				d[s][t] = d[t][s] = D; e[s][t] = e[t][s] = E;
			}
			dist = new int[n][L+1];
			for(int[]a:dist)Arrays.fill(a, INF);
			dist[0][L] = 0;
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(n, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return dist[o1[0]][o1[1]]-dist[o2[0]][o2[1]];
				}
			});
			q.add(new int[]{0, L});
			int res = INF;
			while(!q.isEmpty()){
				int[] a = q.poll();
				int v = a[0], c = a[1];
				if(v==n-1){
					res = Math.min(res, dist[v][c]); continue;
				}
				for(int i=0;i<n;i++){
					if(d[v][i]==INF)continue;
					int w = dist[v][c] + e[v][i];
					if(w<dist[i][c]){
						dist[i][c] = w; q.add(new int[]{i, c});
					}
					if(d[v][i]<=c&&dist[v][c]<dist[i][c-d[v][i]]){
						dist[i][c-d[v][i]] = dist[v][c]; q.add(new int[]{i, c-d[v][i]});
					}
				}
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2151().run();
	}
}
