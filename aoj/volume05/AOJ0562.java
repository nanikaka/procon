package volume05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//Shopping in JOI Kingdom
public class AOJ0562 {

	int n, m, k, INF = 1<<29;
	List<E>[] adj;
	int[] d;
	
	class E{
		int t, c;
		public E(int t, int c) {
			this.t = t;
			this.c = c;
		}
	}
	
	void dijkstra(int x){
		d[x] = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return d[o1]-d[o2];
			}
		});
		q.add(x);
		while(!q.isEmpty()){
			int v = q.poll();
			for(E e:adj[v]){
				int w = d[v]+e.c;
				if(w<d[e.t]){
					q.remove(e.t); d[e.t] = w; q.add(e.t);
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
		adj = new List[n];
		for(int i=0;i<n;i++)adj[i]=new ArrayList<E>();
		d = new int[n];
		Arrays.fill(d, INF);
		while(m--!=0){
			int s = sc.nextInt()-1, t = sc.nextInt()-1, c = sc.nextInt();
			adj[s].add(new E(t, c)); adj[t].add(new E(s, c));
		}
		while(k--!=0)dijkstra(sc.nextInt()-1);
		double res = 0;
		for(int i=0;i<n;i++)for(E e:adj[i]){
			int dif = Math.abs(d[i]-d[e.t]);
			if(d[i]<d[e.t])res = Math.max(res, d[i]+dif+(e.c-dif)/2.0);
			else res = Math.max(res, d[e.t]+dif+(e.c-dif)/2.0);
		}
		System.out.printf("%.0f\n", res);
	}
	
	public static void main(String[] args) {
		new AOJ0562().run();
	}
}
