package volume02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Highway Express Bus
public class AOJ0212 {

	static int[][] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int c = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();
			int d = sc.nextInt();
			if((c|n|m|s|d)==0)break;
			s--;
			d--;
			int[][] e = new int[n][n];
			for(int[]ee:e)Arrays.fill(ee, 1<<28);
			while(m--!=0){
				int a = sc.nextInt()-1;
				int b = sc.nextInt()-1;
				int cos = sc.nextInt();
				e[a][b]=e[b][a]=cos;
			}
			dist = new int[c+1][n];
			for(int[] dd:dist)Arrays.fill(dd, 1<<28);
			dist[c][s] = 0;
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(n, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return dist[o1[0]][o1[1]]-dist[o2[0]][o2[1]];
				}
			});
			q.add(new int[]{c,s});
			while(!q.isEmpty()){
				int[] a = q.poll();
				int u = a[0];
				int v = a[1];
				if(v==d){
					System.out.println(dist[u][v]);
					break;
				}
				for(int k=0;k<n;k++){
					if(e[v][k]==1<<28)continue;
					int w = dist[u][v]+e[v][k];
					if(w<dist[u][k]){
						dist[u][k] = w;
						q.add(new int[]{u,k});
					}
					if(u>0){
						w = dist[u][v]+e[v][k]/2;
						if(w<dist[u-1][k]){
							dist[u-1][k] = w;
							q.add(new int[]{u-1,k});
						}
					}
				}
			}
		}
	}
}
