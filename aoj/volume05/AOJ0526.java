package volume05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//Boat Travel
public class AOJ0526 {

	class E{
		int s, t, d;
		public E(int s, int t, int d) {
			this.s = s;
			this.t = t;
			this.d = d;
		}
	}

	int[] dist;

	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int k = sc.nextInt();
			if((n|k)==0)break;
			dist = new int[n+1];
			List<E>[] l = new ArrayList[n+1];
			for(int i=1;i<=n;i++)l[i]=new ArrayList<E>();
			while(k--!=0){
				int x = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(x==1){
					int d = sc.nextInt();
					l[a].add(new E(a,b,d));
					l[b].add(new E(b,a,d));
				}
				else{
					Arrays.fill(dist, 1<<30);
					dist[a] = 0;
					PriorityQueue<Integer> q = new PriorityQueue<Integer>(n, new Comparator<Integer>(){
						public int compare(Integer o1, Integer o2) {
							return dist[o1]-dist[o2];
						}
					});
					q.add(a);
					while(!q.isEmpty()){
						int v = q.poll();
						if(b==v)break;
						for(E e:l[v]){
							int w = dist[v] + e.d;
							if(w<dist[e.t]){
								q.remove(e.t);
								dist[e.t] = w;
								q.add(e.t);
							}
						}
					}
					System.out.println(dist[b]==1<<30?-1:dist[b]);
				}
			}
		}
	}

	public static void main(String[] args) {
		new AOJ0526().run();
	}
}
