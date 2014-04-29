package volume21;

import java.util.Arrays;
import java.util.Scanner;

//Moonlight Farm
public class AOJ2198 {

	class R implements Comparable<R>{
		String r;
		double E;
		public R(String r, double e) {
			this.r = r;
			E = e;
		}
		public int compareTo(R o) {
			return Math.abs(E-o.E)<1e-8?r.compareTo(o.r):(int)Math.signum(o.E-E);
		}
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			R[] r = new R[n];
			for(int i=0;i<n;i++){
				String t = sc.next();
				int p = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt(), e = sc.nextInt(),
				f = sc.nextInt(), s = sc.nextInt(), m = sc.nextInt();
				int S = s*f*m-p, T = a+b+c+m*(d+e);
				r[i] = new R(t, S*1.0/T);
			}
			Arrays.sort(r);
			for(R v:r)System.out.println(v.r);
			System.out.println("#");
		}
	}

	public static void main(String[] args) {
		new AOJ2198().run();
	}
}
