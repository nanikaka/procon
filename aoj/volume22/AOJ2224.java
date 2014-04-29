package volume22;

import java.util.Arrays;
import java.util.Scanner;

//Save your cat
public class AOJ2224 {
	
	class UnionFind {
		final int[] tree;
		int num;
		public UnionFind(int n) {
			this.tree = new int[n];
			Arrays.fill(tree, -1);
			num=n;
		}
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
		boolean find(int x, int y) {
			return root(x) == root(y);
		}
		int root(int x) {
			return tree[x] < 0 ? x : (tree[x] = root(tree[x]));
		}
		int size(int x) {
			return -tree[root(x)];
		}
		int getNum() {
			return num;
		}
	}
	
	class E implements Comparable<E>{
		int s, t;
		double d;
		public E(int s, int t, double d) {
			this.s = s;
			this.t = t;
			this.d = d;
		}
		public int compareTo(E o) {
			return (int)Math.signum(o.d-d);
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		int[] x = new int[n+1], y = new int[n+1];
		for(int i=1;i<=n;i++){
			x[i] = sc.nextInt(); y[i] = sc.nextInt();
		}
		E[] es = new E[m];
		double sum = 0;
		for(int i=0;i<m;i++){
			int s = sc.nextInt(), t = sc.nextInt();
			double d = Math.hypot(x[s]-x[t], y[s]-y[t]);
			sum+=d;
			es[i] = new E(s, t, d);
		}
		Arrays.sort(es);
		UnionFind u = new UnionFind(n+1);
		double res = 0;
		for(E e:es){
			if(u.find(e.s, e.t))continue;
			res+=e.d;
			u.union(e.s, e.t);
		}
		System.out.printf("%.8f\n", sum-res);
	}
	
	public static void main(String[] args) {
		new AOJ2224().run();
	}
}
