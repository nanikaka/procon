package volume01;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//Stellar Performance of the Debunkey Family
public class AOJ0180 {

	static  class UnionFind {
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
	
	static class E implements Comparable<E>{
		int s, t, cost;
		public E(int s, int t, int cost) {
			this.s = s;
			this.t = t;
			this.cost = cost;
		}
		public int compareTo(E o) {
			return cost-o.cost;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			PriorityQueue<E> q = new PriorityQueue<E>();
			while(m--!=0)q.add(new E(sc.nextInt(),sc.nextInt(),sc.nextInt()));
			UnionFind u = new UnionFind(n);
			int s = 0;
			while(u.num>1){
				E e = q.poll();
				if(!u.find(e.s, e.t)){
					u.union(e.s, e.t);
					s+=e.cost;
				}
			}
			System.out.println(s);
		}
	}
}
