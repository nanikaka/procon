package volume24;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Acrophobia
public class AOJ2419 {

	int w, h, si, sj, gi, gj, S, G, M, INF = 1<<29, res;
	int[][] adj;
	int[][] dist;
	int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
	boolean[] v;
	void f(int id, int sum){
		if(id==G){
			res = Math.min(res, sum); return;
		}
		if(res<=sum)return;
		boolean f = true;
		for(int i=0;i<M;i++)if(i!=G && !v[i]){
			f = false;
			v[i] = true;
			f(i, sum+adj[id][i]);
			v[i] = false;
		}
		if(f)f(G, sum+adj[id][G]);
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		w = sc.nextInt(); h = sc.nextInt();
		char[][] m = new char[h][w];
		M = 0;
		int[][] cost = new int[h][w];
		int[][] id = new int[h][w];
		for(int i=0;i<h;i++)for(int j=0;j<w;j++){
			cost[i][j]=1;
			id[i][j] = -1;
		}
		for(int i=0;i<h;i++){
			m[i] = sc.next().toCharArray();
			for(int j=0;j<w;j++){
				if(m[i][j]=='S'){
					m[i][j] = '.';
					si = i; sj = j;
					S = M;
					id[i][j] = M++;
				}
				if(m[i][j]=='G'){
					m[i][j] = '.';
					gi = i; gj = j;
					G = M;
					id[i][j] = M++;
				}
				if(m[i][j]=='M'){
					m[i][j] = '.';
					id[i][j] = M++;
				}
				if(m[i][j]=='#'){
					for(int y=i-2;y<=i+2;y++)for(int x=j-2;x<=j+2;x++){
						if(0<=y&&y<h&&0<=x&&x<w)cost[y][x] = Math.max(cost[y][x], 2);
					}
					for(int y=i-1;y<=i+1;y++)for(int x=j-1;x<=j+1;x++){
						if(0<=y&&y<h&&0<=x&&x<w)cost[y][x] = Math.max(cost[y][x], 3);
					}
				}
			}
		}
		adj = new int[M][M];
		for(int i=0;i<h;i++)for(int j=0;j<w;j++)if(id[i][j]!=-1){
			int now = id[i][j];
			dist = new int[h][w];
			for(int[]d:dist)Arrays.fill(d, INF);
			dist[i][j] = 0;
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(h*w, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return dist[o1[0]][o1[1]] - dist[o2[0]][o2[1]];
				}
			});
			q.add(new int[]{i, j});
			while(!q.isEmpty()){
				int[] V = q.poll();
				int pi = V[0], pj = V[1];
				for(int k=0;k<4;k++){
					int ni = pi+d[k][0], nj = pj+d[k][1];
					if(0<=ni&&ni<h&&0<=nj&&nj<w&&m[ni][nj]!='#'){
						int w = dist[pi][pj] + cost[pi][pj];
						if(w < dist[ni][nj]){
							dist[ni][nj] = w; q.add(new int[]{ni, nj});
						}
					}
				}
			}
			for(int y=0;y<h;y++)for(int x=0;x<w;x++)if(id[y][x]!=-1)adj[now][id[y][x]] = dist[y][x];
		}
		res = INF;
		v = new boolean[M];
		v[S] = true;
		f(S, 0);
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new AOJ2419().run();
	}
}
