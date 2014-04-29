package volume13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

//Long Distance Taxi
public class AOJ1318 {

	class E{
		int t, c;
		public E(int t, int c) {
			this.t = t;
			this.c = c;
		}
	}
	
	Map<String, Integer> ref;
	int ID, INF = 1<<29, M = 2001;
	int reg(String s){
		if(ref.containsKey(s))return ref.get(s);
		ref.put(s, ID);
		return ID++;
	}

	Set<E>[] adj;
	int[] d;
	boolean[] gas;
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		d = new int[6000*2001];
		adj = new Set[6000];
		gas = new boolean[6000];
		for(;;){
			int n = sc.nextInt(), m = sc.nextInt(), cap = sc.nextInt();
			if((n|m|cap)==0)break;
			ref = new HashMap<String, Integer>();
			ID = 0;
			int S = reg(sc.next()), T = reg(sc.next());
			for(int i=0;i<6000;i++)adj[i]=new HashSet<E>();
			while(n--!=0){
				int s = reg(sc.next()), t = reg(sc.next()), D = sc.nextInt();
				adj[s].add(new E(t, D)); adj[t].add(new E(s, D));
			}
			Arrays.fill(gas, false);
			while(m--!=0)gas[reg(sc.next())]=true;
			for(int i=0;i<ID;i++)for(int j=0;j<=10*cap;j++)d[i*M+j]=INF;
			PriorityQueue<Integer> q = new PriorityQueue<Integer>(ID, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return d[o1]-d[o2];
				}
			});
			d[S*M+10*cap] = 0;
			q.add(S*M+10*cap);
			int res = -1;
			while(!q.isEmpty()){
				int v = q.poll();
				int p = v/M, c = v%M;
				if(p==T){
					res = d[v]; break;
				}
				for(E e:adj[p]){
					if(c-e.c<0)continue;
					int w = d[v]+e.c;
					if(gas[e.t]){
						if(w < d[e.t*M+10*cap]){
							d[e.t*M+10*cap] = w; q.add(e.t*M+10*cap);
						}
					}
					else{
						if(w < d[e.t*M+c-e.c]){
							d[e.t*M+c-e.c] = w; q.add(e.t*M+c-e.c);
						}
					}
				}
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1318().run();
	}
}
