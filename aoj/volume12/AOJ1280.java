package volume12;

import java.util.Arrays;
import java.util.Scanner;

//Slim Span
public class AOJ1280 {

	class E implements Comparable<E>{
		int s, t, w;
		public E(int s, int t, int w) {
			this.s = s;
			this.t = t;
			this.w = w;
		}
		public int compareTo(E o) {
			return w-o.w;
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt(), m = sc.nextInt();
			if((n|m)==0)break;
			E[] e = new E[m];
			for(int i=0;i<m;i++){
				e[i] = new E(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt());
			}
			Arrays.sort(e);
			int res = 1<<29;
			for(int i=0;i<m;i++){
				UnionFind u = new UnionFind(n);
				for(int j=i;j<m;j++){
					if(!u.find(e[j].s, e[j].t))u.union(e[j].s, e[j].t);
					if(u.num==1){
						res = Math.min(res, e[j].w-e[i].w); break;
					}
				}
			}
			System.out.println(res==1<<29?-1:res);
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
	
	public static void main(String[] args) {
		new AOJ1280().run();
	}
}
