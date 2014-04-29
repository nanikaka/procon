package volume01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

//A reward for a Carpentor
public class AOJ0117 {

	public static int n;
	public static int m;

	public static int[] dist;
	public static int[][] cost;

	public static int dijkstra(int s, int t){
		dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(n, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2) {
				return dist[o1]-dist[o2];
			}
		});
		q.add(s);
		while(!q.isEmpty()){
			int v = q.poll();
			if(v == t)return dist[t];
			for(int i=1;i<=n;i++){
				if(cost[v][i]!=Integer.MAX_VALUE){
					int w = dist[v]+cost[v][i];
					if(w<dist[i]){
						dist[i] = w;
						q.add(i);
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		cost = new int[n+1][n+1];
		for(int[] a:cost)Arrays.fill(a, Integer.MAX_VALUE);
		for(int i=0;i<m;i++){
			String[] s = sc.nextLine().split(",");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			int d = Integer.parseInt(s[3]);
			cost[a][b] = c;
			cost[b][a] = d;
		}
		String[] s = sc.nextLine().split(",");
		int a = Integer.parseInt(s[0]);
		int b = Integer.parseInt(s[1]);
		int c = Integer.parseInt(s[2]);
		int d = Integer.parseInt(s[3]);
		System.out.println(c-d-dijkstra(a, b)-dijkstra(b, a));
	}
}
