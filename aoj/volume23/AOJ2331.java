package volume23;

import java.util.PriorityQueue;
import java.util.Scanner;

//A Way to Invite Friends
public class AOJ2331 {

	class R implements Comparable<R>{
		int x;
		boolean f;
		public R(int x, boolean f) {
			this.x = x;
			this.f = f;
		}
		public int compareTo(R o) {
			return x-o.x;
		}
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<R> q = new PriorityQueue<R>();
		for(int i=0;i<n;i++){
			q.add(new R(sc.nextInt(), true)); q.add(new R(sc.nextInt()+1, false));
		}
		//ダミー
		q.add(new R(n+3, true));
		int res = 0, c = 0, f = 1;
		while(!q.isEmpty()){
			R r = q.poll();
			while(f!=r.x){
				if(f-1<=c)res = f-1;
				f++;
			}
			c+=r.f?1:-1;
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new AOJ2331().run();
	}
}
