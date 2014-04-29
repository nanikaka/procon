package volume02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Hot Spring Trip
public class AOJ0244 {

	int[][] e;
	int[][] dist;
	int INF = 1<<29;

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), m = sc.nextInt();
			if((n|m)==0)break;
			e = new int[n][n];
			//0: can use 1:tochuu 2:cant use
			dist = new int[n][3];
			for(int[]ee:e)Arrays.fill(ee, INF);
			for(int[]d:dist)Arrays.fill(d, INF);
			while(m--!=0){
				int s = sc.nextInt()-1, t = sc.nextInt()-1, c = sc.nextInt();
				e[s][t] = e[t][s] = Math.min(e[s][t], c);
			}
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(n, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return dist[o1[0]][o1[1]] - dist[o2[0]][o2[1]];
				}
			});
			dist[0][0] = 0;
			q.add(new int[]{0, 0});
			int res = INF;
			while(!q.isEmpty()){
				int[] V = q.poll();
				int p = V[0], s = V[1];
				if(p==n-1&&s!=1){
					res = Math.min(res, dist[p][s]);
				}
				if(s==0){
					for(int nx=0;nx<n;nx++){
						if(e[p][nx]==INF)continue;
						int w = dist[p][s] + e[p][nx];
						if(w < dist[nx][0]){
							dist[nx][0] = w; q.add(new int[]{nx, 0});
						}
						w = dist[p][s];
						if(w < dist[nx][1]){
							dist[nx][1] = w; q.add(new int[]{nx, 1});
						}
					}
				}
				else if(s==1){
					for(int nx=0;nx<n;nx++){
						if(e[p][nx]==INF)continue;
						int w = dist[p][s];
						if(w < dist[nx][2]){
							dist[nx][2] = w; q.add(new int[]{nx, 2});
						}
					}
				}
				else{
					for(int nx=0;nx<n;nx++){
						if(e[p][nx]==INF)continue;
						int w = dist[p][s] + e[p][nx];
						if(w < dist[nx][2]){
							dist[nx][2] = w; q.add(new int[]{nx, 2});
						}
					}
				}
			}
			System.out.println(res);
		}
	}

	public static void main(String[] args) {
		new AOJ0244().run();
	}
}
