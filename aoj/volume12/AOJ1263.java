package volume12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

//Network Mess
public class AOJ1263 {

	class R{
		int id, con;
		int[] dist;
		Set<Integer> adj;
		public R(int id) {
			con = 0;
			this.id = id;
			dist = new int[n];
			Arrays.fill(dist, -1);
			adj = new HashSet<Integer>();
		}
		void add(int k){
			R v = new R(ID);
			sw[ID] = v;
			adj.add(ID);
			v.adj.add(id);
			for(int i=0;i<n;i++){
				if(dist[i]==-1)continue;
				v.dist[i] = dist[i]+1;
			}
			ID++;
			if(a[0][k]-1==v.dist[0]){
				v.con++;
				v.assign(k, 1);
			}
			else v.add(k);
		}
		void assign(int k, int d){
			if(dist[k]!=-1)return;
			dist[k] = d;
			for(int i:adj)sw[i].assign(k, d+1);
		}
	}
	
	int n, ID;
	R[] sw;
	int[][] a;
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			n = sc.nextInt();
			if(n==0)break;
			a = new int[n][n];
			for(int i=0;i<n;i++)for(int j=0;j<n;j++)a[i][j]=sc.nextInt();
			sw = new R[1500];
			ID = 0;
			sw[0] = new R(ID++);
			sw[0].con++;
			sw[0].assign(0, 1);
			for(int k=1;k<n;k++){
				boolean s = true;
				for(int i=0;i<ID;i++){
					boolean f = true;
					for(int j=0;j<k;j++){
						if(sw[i].dist[j]!=a[j][k]-1){
							f = false; break;
						}
					}
					if(f){
						s = false; sw[i].con++; sw[i].assign(k, 1); break;
					}
				}
				if(!s)continue;
				for(int i=0;i<ID;i++){
					boolean f = true;
					int dif = a[0][k]-sw[i].dist[0];
					for(int j=1;j<k;j++){
						if(dif!=a[j][k]-sw[i].dist[j])f = false;
					}
					if(f){
						sw[i].add(k);
						break;
					}
				}
				
			}
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			for(int i=0;i<ID;i++)q.add(sw[i].adj.size()+sw[i].con);
			System.out.print(q.poll());
			while(!q.isEmpty())System.out.print(" "+q.poll());
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new AOJ1263().run();
	}
}
