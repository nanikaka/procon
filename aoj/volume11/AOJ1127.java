package volume11;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//Building a Space Station
public class AOJ1127 {

	class E implements Comparable<E>{
		int s, t;
		double d;
		public E(int s, int t, double d) {
			this.s = s;
			this.t = t;
			this.d = d;
		}
		public int compareTo(E o) {
			return d-o.d<0?-1:o.d-d<0?1:0;
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			UnionFind u = new UnionFind(n);
			double[][] p = new double[n][3];
			double[] r = new double[n];
			for(int i=0;i<n;i++){
				for(int j=0;j<3;j++)p[i][j]=sc.nextDouble();
				r[i] = sc.nextDouble();
			}
			PriorityQueue<E> q = new PriorityQueue<E>();
			for(int i=0;i<n;i++)for(int j=i+1;j<n;j++){
				if(u.find(i, j))continue;
				double d = Math.sqrt(Math.pow(p[i][0]-p[j][0], 2)+Math.pow(p[i][1]-p[j][1], 2)+Math.pow(p[i][2]-p[j][2], 2))-r[i]-r[j];
				if(d<1e-6)u.union(i, j);
				else q.add(new E(i, j, d));
			}
			double res = 0;
			while(u.num>1){
				E e = q.poll();
				if(!u.find(e.s, e.t)){
					u.union(e.s, e.t);
					res+=e.d;
				}
			}
			System.out.printf("%.3f\n", res);
		}
	}
	
	class UnionFind {
		final int[] tree;
		int num;
		public UnionFind(int n) {
			this.tree = new int[n];
			Arrays.fill(tree, -1);
			num=n;
		}

		// merge the set contains x and the set contains y
		void union(int x, int y) {
			x = root(x);
			y = root(y);
			if(x != y) {
				if(tree[x] < tree[y]) {
					x ^= y; y ^= x; x^= y;
				}
				tree[x] += tree[y];
				tree[y] = x;
				num--;
			}
		}
		// decide if x and y belong to the same set
		boolean find(int x, int y) {
			return root(x) == root(y);
		}
		int root(int x) {
			return tree[x] < 0 ? x : (tree[x] = root(tree[x]));
		}
		// return size of the set contains x
		int size(int x) {
			return -tree[root(x)];
		}
		// return the number of sets
		int getNum() {
			return num;
		}
	}
	
	public static void main(String[] args) {
		new AOJ1127().run();
	}
}
