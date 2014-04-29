package volume20;

import java.util.Arrays;
import java.util.Scanner;

//Osaki
public class AOJ2013 {

	int f(String s){
		String[] t = s.split(":");
		return Integer.parseInt(t[0])*3600+Integer.parseInt(t[1])*60+Integer.parseInt(t[2]);
	}
	
	class R implements Comparable<R>{
		int s, t;
		public R(int s, int t) {
			this.s = s;
			this.t = t;
		}
		public int compareTo(R o) {
			return s!=o.s?s-o.s:t-o.t;
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			R[] r = new R[n*2];
			for(int i=0;i<n;i++){
				r[i] = new R(f(sc.next()), 1); r[i+n] = new R(f(sc.next()), 0); 
			}
			Arrays.sort(r);
			int res = 0, c = 0;
			for(int i=0;i<2*n;i++){
				if(r[i].t==1)c++;
				else c--;
				res = Math.max(res, c);
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ2013().run();
	}
}
