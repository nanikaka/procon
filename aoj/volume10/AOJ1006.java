package volume10;

import java.util.PriorityQueue;
import java.util.Scanner;

//Boring Commercials
public class AOJ1006 {

	public static class R implements Comparable<R>{
		public int s;
		public int t;
		public R(int s, int t) {
			this.s = s;
			this.t = t;
		}
		public int compareTo(R o) {
			return s-o.s;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			p = (p/100)*60 + p%100;
			q = (q/100)*60 + q%100;
			if(n==0&&p==0&&q==0)break;
			PriorityQueue<R> pq = new PriorityQueue<R>();
			for(int i=0;i<n;i++){
				int k = sc.nextInt();
				int last = 0;
				for(int j=0;j<k;j++){
					int s = sc.nextInt();
					int t = sc.nextInt();
					s = (s/100)*60+s%100;
					t = (t/100)*60+t%100;
					if(j==0){
						pq.add(new R(p, s));
						last = t;
					}
					else{
						pq.add(new R(last, s));
						last = t;
					}
					if(j==k-1){
						pq.add(new R(last, q));
					}
				}
			}
			int max = 0;
			R r = null;
			while(!pq.isEmpty()){
				R a = pq.poll();
				if(r==null){
					r = a;
				}
				else if(r.s <= a.s && a.s <= r.t){
					r.t = Math.max(r.t, a.t);
				}
				else{
					r = a;
				}
				max = Math.max(max, r.t-r.s);
			}
			System.out.println(max);
		}
	}
}
