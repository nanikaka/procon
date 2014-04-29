package volume20;

import java.util.Arrays;
import java.util.Scanner;

//Princess's Marriage
public class AOJ2019 {

	class P implements Comparable<P>{
		int d, p;
		public P(int d, int p) {
			this.d = d;
			this.p = p;
		}
		public int compareTo(P o) {
			return o.p-p;
		}
	}

	int n, m;
	P[] p;

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			m = sc.nextInt();
			if((n|m)==0)break;
			p = new P[n];
			int s = 0;
			for(int i=0;i<n;i++){
				p[i]=new P(sc.nextInt(), sc.nextInt());
				s += p[i].d*p[i].p;
			}
			Arrays.sort(p);
			int r = 0;
			int i = 0;
			while(m>0 && i<n){
				int min = Math.min(m, p[i].d);
				r += min*p[i].p;
				i++;
				m-=min;
			}
			System.out.println(s-r);
		}
	}

	public static void main(String[] args) {
		new AOJ2019().run();
	}
}
