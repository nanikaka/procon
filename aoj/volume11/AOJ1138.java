package volume11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//Traveling by Stagecoach
public class AOJ1138 {

	static double[][] dist;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			int p = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if((n|m|p|a|b)==0)break;
			int[] h = new int[n];
			for(int i=0;i<n;i++)h[i]=sc.nextInt();
			int[][] cost = new int[m+1][m+1];
			while(p--!=0){
				int s = sc.nextInt();
				int t = sc.nextInt();
				int d = sc.nextInt();
				cost[s][t] = cost[t][s] = d;
			}
			dist = new double[m+1][1<<n];
			for(double i[]:dist)Arrays.fill(i, Integer.MAX_VALUE);
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(m+1, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return dist[o1[0]][o1[1]]-dist[o2[0]][o2[1]]<0?-1:dist[o1[0]][o1[1]]-dist[o2[0]][o2[1]]>0?1:0;
				}
			});
			dist[a][(1<<n)-1] = 0;
			q.add(new int[]{a, (1<<n)-1});
			while(!q.isEmpty()){
				int[] v = q.poll();
				if(v[0]==b)break;
				for(int j=0;j<n;j++){
					if((v[1]&(1<<j))==0)continue;
					for(int t=1;t<=m;t++){
						if(cost[v[0]][t]==0)continue;
						double w = dist[v[0]][v[1]] + cost[v[0]][t]*1.0/h[j];
						if(w < dist[t][v[1]-(1<<j)]){
							dist[t][v[1]-(1<<j)] = w;
							q.add(new int[]{t, v[1]-(1<<j)});
						}
					}
				}
			}
			double min = Integer.MAX_VALUE;
			for(int i=0;i<1<<n;i++)min=Math.min(min, dist[b][i]);
			System.out.println(min==Integer.MAX_VALUE?"Impossible":min);
		}
	}
}
