package volume11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Railway Connection
public class AOJ1182 {

	int N, M, C, S, G, INF = 1<<29;
	int[][][] wf;
	int[][] cost;
	int[] p, dist;
	int[][] q, r, e;
	
	void run(){
		Scanner sc = new Scanner(System.in);
		wf = new int[21][101][101];
		cost = new int[21][20001];
		for(;;){
			N = sc.nextInt(); M = sc.nextInt(); C = sc.nextInt(); S = sc.nextInt(); G = sc.nextInt();
			if((N|M|C|S|G)==0)break;
			for(int c=1;c<=C;c++)for(int i=1;i<=N;i++)for(int j=1;j<=N;j++)wf[c][i][j]=INF;
			for(int c=1;c<=C;c++)for(int i=1;i<=N;i++)wf[c][i][i]=0;
			for(int c=1;c<=C;c++)for(int i=0;i<=20000;i++)cost[c][i]=0;
			while(M--!=0){
				int s = sc.nextInt(), t = sc.nextInt(), d = sc.nextInt(), c = sc.nextInt();
				wf[c][s][t] = wf[c][t][s] = Math.min(wf[c][s][t], d);
			}
			for(int c=1;c<=C;c++){
				for(int k=1;k<=N;k++)for(int i=1;i<=N;i++)for(int j=1;j<=N;j++)wf[c][i][j]=Math.min(wf[c][i][j], wf[c][i][k]+wf[c][k][j]);
			}
			p = new int[C+1];
			q = new int[C+1][55];
			r = new int[C+1][55];
			for(int c=1;c<=C;c++){
				p[c] = sc.nextInt();
			}
			for(int c=1;c<=C;c++){
				for(int i=1;i<p[c];i++)q[c][i]=sc.nextInt();
				for(int i=1;i<=p[c];i++)r[c][i]=sc.nextInt();
				int dif = r[c][1], i=1;
				for(int j=1;j<=20000;j++){
					cost[c][j] = cost[c][j-1]+dif;
					if(j==q[c][i]){
						i++;
						dif = r[c][i];
					}
				}
			}
			e = new int[N+1][N+1];
			for(int i=1;i<=N;i++)for(int j=1;j<=N;j++)e[i][j]=INF;
			for(int i=1;i<=N;i++)for(int j=1;j<=N;j++)for(int c=1;c<=C;c++)if(wf[c][i][j]!=INF)e[i][j]=Math.min(e[i][j], cost[c][wf[c][i][j]]);
			dist = new int[N+1];
			Arrays.fill(dist, INF);
			dist[S] = 0;
			PriorityQueue<Integer> que = new PriorityQueue<Integer>(N, new Comparator<Integer>() {
				public int compare(Integer i1, Integer i2) {
					return dist[i1]-dist[i2];
				}
			});
			que.add(S);
			while(!que.isEmpty()){
				int v = que.poll();
				for(int nx=1;nx<=N;nx++){
					int w = dist[v]+e[v][nx];
					if(w < dist[nx]){
						dist[nx] = w; que.add(nx);
					}
				}
			}
			System.out.println(dist[G]==INF?-1:dist[G]);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1182().run();
	}
}
