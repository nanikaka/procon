package volume21;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//A Book Shop With a Frequent Greetings
public class AOJ2191 {

	class E implements Comparable<E>{
		int id, t;
		public E(int id, int t) {
			this.id = id;
			this.t = t;
		}
		public int compareTo(E o) {
			return t-o.t;
		}
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int L = 10000, INF = 1<<29;
		while(T--!=0){
			int n = sc.nextInt(), X = sc.nextInt(), Y = sc.nextInt();
			int sx = sc.nextInt(), sy = sc.nextInt();
			int[][] p = new int[n][2];
			for(int i=0;i<n;i++)for(int j=0;j<2;j++)p[i][j]=sc.nextInt();
			boolean[][] e = new boolean[n][n];
			for(int i=0;i<n;i++)for(int j=i+1;j<n;j++)if(Math.hypot(p[i][0]-p[j][0], p[i][1]-p[j][1])<=50)e[i][j]=e[j][i]=true;
			int[] last = new int[n];
			Arrays.fill(last, -150);
			int res = 0;
			PriorityQueue<E> q = new PriorityQueue<E>();
			for(int i=0;i<n;i++)if(Math.hypot(p[i][0]-sx, p[i][1]-sy)<=10)q.add(new E(i, 0));
			while(!q.isEmpty()){
				E ev = q.poll();
				if(L<ev.t){
					res = INF; break;
				}
				if(last[ev.id]<ev.t-Y){
					last[ev.id] = ev.t+X;
					res = Math.max(res, last[ev.id]);
					for(int i=0;i<n;i++)if(e[ev.id][i])q.add(new E(i, ev.t+X));
				}
			}
			System.out.println(res==INF?"You're always welcome!":res);
		}
	}

	public static void main(String[] args) {
		new AOJ2191().run();
	}
}
