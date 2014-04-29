package volume24;

import java.util.PriorityQueue;
import java.util.Scanner;

//Power
public class AOJ2409 {

	class R implements Comparable<R>{
		int s, t;
		public R(int s, int t) {
			this.s = s;
			this.t = t;
		}
		public int compareTo(R o) {
			return s-o.s;
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), M = sc.nextInt();
		PriorityQueue<R> q = new PriorityQueue<R>();
		while(M--!=0)q.add(new R(sc.nextInt(), sc.nextInt()));
		int res = 0, f = 0;
		while(!q.isEmpty()&&f<N){
			if(f+1 < q.peek().s)break;
			int max = q.poll().t;
			while(!q.isEmpty()&&q.peek().s<=f+1)max = Math.max(max, q.poll().t);
			if(f<max){
				res++; f = max;
			}
		}
		System.out.println(f==N?res:"Impossible");
	}
	
	public static void main(String[] args) {
		new AOJ2409().run();
	}
}
