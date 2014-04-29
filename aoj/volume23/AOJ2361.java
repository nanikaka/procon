package volume23;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

//Sort
public class AOJ2361 {

	int N, ID, INF = 1<<29;
	Map<Integer, Integer> ref;
	boolean[] u;
	
	void dfs(int k, int x){
		if(k==N){
			ref.put(x, ID++); return;
		}
		for(int i=1;i<=N;i++){
			if(!u[i]){
				u[i] = true;
				dfs(k+1, x*10+i);
				u[i] = false;
			}
		}
	}
	
	int[] d;
	void run(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		u = new boolean[N+1];
		ref = new HashMap<Integer, Integer>();
		ID = 0;
		dfs(0, 0);
		int[][] c = new int[N][N];
		for(int i=0;i<N;i++)for(int j=0;j<N;j++)c[i][j]=sc.nextInt();
		d = new int[ID];
		Arrays.fill(d, INF);
		int s = 0;
		for(int i=1;i<=N;i++)s=s*10+i;
		d[ref.get(s)] = 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(N, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return d[ref.get(o1)]-d[ref.get(o2)];
			}
		});
		q.add(s);
		int[] a = new int[N];
		while(!q.isEmpty()){
			int V = q.poll(), v = V;
			for(int i=N-1;i>=0;i--){
				a[i] = v%10; v/=10;
			}
			for(int i=0;i<N;i++)for(int j=i+1;j<N;j++){
				int t = a[i];
				a[i] = a[j]; a[j] = t;
				int nv = 0, w = d[ref.get(V)]+c[i][j];
				for(int k=0;k<N;k++)nv=nv*10+a[k];
				if(w<d[ref.get(nv)]){
					d[ref.get(nv)] = w; q.add(nv);
				}
				a[j] = a[i]; a[i] = t;
			}
		}
		int res = 0;
		for(int v:ref.keySet())res = Math.max(res, d[ref.get(v)]);
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new AOJ2361().run();
	}
}
