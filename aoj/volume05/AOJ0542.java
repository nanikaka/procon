package volume05;

import java.util.PriorityQueue;
import java.util.Scanner;

//Authentication Level
public class AOJ0542 {

	class E implements Comparable<E>{
		int k, i, j;
		public E(int k, int i, int j) {
			this.k = k;
			this.i = i;
			this.j = j;
		}
		public int compareTo(E o) {
			return k-o.k;
		}
	}
	
	int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
	int[] f(int h, int w, int[][] a, int si, int sj){
		int[] r = new int[w*h+1];
		boolean[][] mark = new boolean[h][w], u = new boolean[h][w];
		int id = 1, L = -1;
		mark[si][sj] = true;
		PriorityQueue<E> q = new PriorityQueue<E>();
		q.add(new E(a[si][sj], si, sj));
		while(!q.isEmpty()){
			E e = q.poll();
			if(L<e.k)L = e.k;
			u[e.i][e.j] = true;
			r[id++] = L;
			for(int k=0;k<4;k++){
				int ni = e.i+d[k][0], nj = e.j+d[k][1];
				if(0<=ni&&ni<h&&0<=nj&&nj<w&&!mark[ni][nj]){
					mark[ni][nj] = true;
					q.add(new E(a[ni][nj], ni, nj));
				}
			}
		}
		return r;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int R = sc.nextInt();
			if(R==0)break;
			int[][] a = new int[2][];
			for(int k=0;k<2;k++){
				int w = sc.nextInt(), h = sc.nextInt(), sj = sc.nextInt()-1, si = sc.nextInt()-1;
				int[][] m = new int[h][w];
				for(int i=0;i<h;i++)for(int j=0;j<w;j++)m[i][j]=sc.nextInt();
				a[k] = f(h, w, m, si, sj);
			}
			int res = 1<<29;
			for(int r=0;r<=Math.min(R, a[0].length-1);r++){
				if(a[1].length<=R-r)continue;
				res = Math.min(res, a[0][r]+a[1][R-r]);
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ0542().run();
	}
}
