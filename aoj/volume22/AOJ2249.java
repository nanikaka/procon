package volume22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//Road Construction
public class AOJ2249 {

	class E{
		int t, d, c;
		public E(int t, int d, int c) {
			this.t = t;
			this.d = d;
			this.c = c;
		}
	}
	
	int INF = 1<<29;
	int[] dist;
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		dist = new int[10001];
		for(;;){
			int n = sc.nextInt(), m = sc.nextInt();
			if((n|m)==0)break;
			List<E>[] adj = new List[n+1];
			for(int i=0;i<=n;i++)adj[i]=new ArrayList<E>();
			while(m--!=0){
				int s = sc.nextInt(), t = sc.nextInt(), D = sc.nextInt(), C = sc.nextInt();
				adj[s].add(new E(t, D, C)); adj[t].add(new E(s, D, C));
			}
			Arrays.fill(dist, INF);
			dist[1] = 0;
			PriorityQueue<Integer> q = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return dist[o1]-dist[o2];
				}
			});
			q.add(1);
			while(!q.isEmpty()){
				int v = q.poll();
				for(E e:adj[v]){
					int w = dist[v]+e.d;
					if(w<dist[e.t]){
						dist[e.t] = w; q.add(e.t);
					}
				}
			}
			int res = 0;
			for(int i=2;i<=n;i++){
				E edge = null;
				for(E e:adj[i]){
					if(dist[e.t]+e.d!=dist[i])continue;
					if(edge==null)edge = e;
					else if(e.c<edge.c)edge = e;
				}
				res+=edge.c;
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2249().run();
	}
}
