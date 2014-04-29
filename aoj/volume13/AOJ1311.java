package volume13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//Test Case Tweaking
public class AOJ1311 {

	class E{
		int t, c;
		public E(int t, int c) {
			this.t = t;
			this.c = c;
		}
	}
	
	int[][] d;
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		int INF = 1<<29;
		for(;;){
			int n = sc.nextInt(), m = sc.nextInt(), C = sc.nextInt();
			if((n|m|C)==0)break;
			List<E>[] e = new List[n+1];
			for(int i=1;i<=n;i++)e[i]=new ArrayList<E>();
			while(m--!=0){
				int s = sc.nextInt(), t = sc.nextInt(), c = sc.nextInt();
				e[s].add(new E(t, c));
			}
			d = new int[n+1][n+1];
			for(int[]a:d)Arrays.fill(a, INF);
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(n, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return d[o1[0]][o1[1]] - d[o2[0]][o2[1]];
				}
			});
			d[1][0] = 0;
			q.add(new int[]{1, 0});
			while(!q.isEmpty()){
				int[] V = q.poll();
				int v = V[0], K = V[1];
				for(E r:e[v]){
					if(d[v][K]+r.c < d[r.t][K]){
						d[r.t][K] = d[v][K]+r.c; q.add(new int[]{r.t, K});
					}
					if(K+1<=n && d[v][K] < d[r.t][K+1]){
						d[r.t][K+1] = d[v][K]; q.add(new int[]{r.t, K+1});
					}
				}
			}
			for(int k=0;k<=n;k++)if(d[n][k]<=C){
				System.out.println(k); break;
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ1311().run();
	}
}
