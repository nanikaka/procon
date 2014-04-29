package volume23;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Lucky Dip
public class AOJ2364 {

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
	
	void run(){
		int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt(), h = sc.nextInt();
		char[][] m = new char[h][];
		int ti = -1, tj = -1;
		for(int i=0;i<h;i++){
			m[i]=sc.next().toCharArray();
			for(int j=0;j<w;j++)if(m[i][j]=='t'){
				ti = i; tj = j; m[i][j]='.';
			}
		}
		int ID = 0;
		int[][] id = new int[h][w];
		for(int[]a:id)Arrays.fill(a, -1);
		for(int i=0;i<h;i++)for(int j=0;j<w;j++){
			if(id[i][j]==-1&&m[i][j]=='.'){
				Queue<int[]> q = new LinkedList<int[]>();
				id[i][j] = ID;
				q.add(new int[]{i, j});
				while(!q.isEmpty()){
					int[] a = q.poll();
					for(int k=0;k<4;k++){
						int ni = a[0]+d[k][0], nj = a[1]+d[k][1];
						if(0<=ni&&ni<h&&0<=nj&&nj<w&&m[ni][nj]=='.'&&id[ni][nj]==-1){
							id[ni][nj] = ID;
							q.add(new int[]{ni, nj});
						}
					}
				}
				ID++;
			}
		}
		int t = id[ti][tj];
		if(t==0){
			System.out.println(0); return;
		}
		UnionFind uf = new UnionFind(w*h);
		int res = -1, n = sc.nextInt();
		for(int i=1;i<=n;i++){
			int xj = sc.nextInt(), xi = sc.nextInt();
			m[xi][xj] = '.'; id[xi][xj] = ID;
			for(int k=0;k<4;k++){
				int ni = xi+d[k][0], nj = xj+d[k][1];
				if(0<=ni&&ni<h&&0<=nj&&nj<w&&id[ni][nj]!=-1)uf.union(ID, id[ni][nj]);
			}
			ID++;
			if(uf.find(0, t)){
				res = i; break;
			}
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new AOJ2364().run();
	}
}
