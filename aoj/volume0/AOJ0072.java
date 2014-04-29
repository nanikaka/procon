package volume0;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//Carden Lantern
public class AOJ0072 {

	static class E implements Comparable<E>{
		public int s;
		public int t;
		public int x;
		public E(int s, int t, int x) {
			this.s = s;
			this.t = t;
			this.x = x;
		}
		public int compareTo(E o) {
			return x-o.x;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			int m = sc.nextInt();
			PriorityQueue<E> q = new PriorityQueue<E>();
			for(int i=0;i<m;i++){
				String[] s = sc.next().split(",");
				q.add(new E(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2])/100-1));
			}
			UnionFind union = new UnionFind(n);
			int c = 0;
			while(union.num>1){
				E e = q.poll();
				if(!union.find(e.s, e.t)){
					union.union(e.s, e.t);
					c+=e.x;
				}
			}
			System.out.println(c);
		}
	}
	
	static class UnionFind {
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
}
