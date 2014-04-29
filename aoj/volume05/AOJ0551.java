package volume05;

import java.util.PriorityQueue;
import java.util.Scanner;

//Icicles
public class AOJ0551 {

	class R implements Comparable<R>{
		int i, x;
		public R(int i, int x) {
			this.i = i;
			this.x = x;
		}
		public int compareTo(R o) {
			return o.x-x;
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int L = sc.nextInt();
		int[] a = new int[n+2];
		PriorityQueue<R> q = new PriorityQueue<R>();
		for(int i=1;i<=n;i++){
			a[i]=sc.nextInt();
			q.add(new R(i, a[i]));
		}
		long[] t = new long[n+2];
		long max = 0;
		while(!q.isEmpty()){
			R r = q.poll();
			t[r.i] = L-r.x+Math.max(t[r.i-1], t[r.i+1]);
			max = Math.max(max, t[r.i]);
		}
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		new AOJ0551().run();
	}
}
