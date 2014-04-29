package volume05;

import java.util.Scanner;

//Lightest Mobile
public class AOJ0520 {

	static long gcd(long a, long b){
		if(a < b){
			long tmp = a;
			a = b;
			b = tmp;
		}
		while(b!=0){
			long r = a%b;
			a = b;
			b = r;
		}
		return a;
	}

	class R{
		long p, q;
		R l, r, parent;
		public R() {
			l = r = parent = null;
		}
		long get(){
			if(p==0)return 1;
			int k = 1;
			long w1 = l.get();
			long w2 = r.get();
			while(true){
				if((k*q)%w1==0&&(k*p)%w2==0)break;
				k++;
			}
			return k*(p+q);
		}
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			R[] s = new R[n+1];
			for(int i=0;i<=n;i++)s[i]=new R();
			for(int i=1;i<=n;i++){
				s[i].p = sc.nextLong();
				s[i].q = sc.nextLong();
				long g = gcd(s[i].p, s[i].q);
				s[i].p/=g;
				s[i].q/=g;
				int l = sc.nextInt();
				int r = sc.nextInt();
				s[i].l = s[l];
				s[i].r = s[r];
				s[l].parent = s[i];
				s[r].parent = s[i];
			}
			R root = null;
			for(int i=1;i<=n;i++)if(s[i].parent==null)root = s[i];
			System.out.println(root.get());
		}
	}

	public static void main(String[] args) {
		new AOJ0520().run();
	}
}
