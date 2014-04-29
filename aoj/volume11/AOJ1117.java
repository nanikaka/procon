package volume11;

import java.util.PriorityQueue;
import java.util.Scanner;

//Missing Numbers
public class AOJ1117 {

	class R implements Comparable<R>{
		boolean row;
		int p, c;
		public R(boolean row, int p, int c) {
			this.row = row;
			this.p = p;
			this.c = c;
		}
		public int compareTo(R o) {
			return c-o.c;
		}
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		int NOT = 1<<29;
		for(boolean head=true;;head=false){
			int h = sc.nextInt();
			if(h==0)break;
			int w = sc.nextInt();
			if(!head)System.out.println();
			int[][] a = new int[h+1][w+1];
			boolean[][] m = new boolean[h+1][w+1];
			for(int i=0;i<=h;i++)for(int j=0;j<=w;j++){
				String s = sc.next();
				m[i][j] = "?".equals(s);
				if(m[i][j])a[i][j]=NOT;
				else a[i][j]=Integer.parseInt(s);
			}
			boolean ok = false;
			for(;;){
				PriorityQueue<R> q = new PriorityQueue<R>();
				int[] rc = new int[h], cc = new int[w];
				for(int i=0;i<h;i++)for(int j=0;j<w;j++){
					if(a[i][j]==NOT){
						rc[i]++; cc[j]++;
					}
				}
				for(int i=0;i<h;i++)if(0<rc[i])q.add(new R(true, i, rc[i]));
				for(int j=0;j<w;j++)if(0<cc[j])q.add(new R(false, j, cc[j]));
				if(q.isEmpty()){
					ok = true; break;
				}
				R r = q.poll();
				if(2<=r.c)break;
				if(r.row){
					int pj = -1, v = a[r.p][w];
					for(int j=0;j<w;j++){
						if(a[r.p][j]==NOT)pj = j;
						else v-=a[r.p][j];
					}
					a[r.p][pj] = v;
				}
				else{
					int pi = -1, v = a[h][r.p];
					for(int i=0;i<h;i++){
						if(a[i][r.p]==NOT)pi = i;
						else v-=a[i][r.p];
					}
					a[pi][r.p] = v;
				}
			}
			if(ok){
				for(int i=0;i<h;i++)for(int j=0;j<w;j++)if(m[i][j])System.out.println(a[i][j]);
			}
			else System.out.println("NO");
		}
	}

	public static void main(String[] args) {
		new AOJ1117().run();
	}
}
