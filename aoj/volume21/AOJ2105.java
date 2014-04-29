package volume21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Rhythm Machine
public class AOJ2105 {

	class R implements Comparable<R>{
		int k, c;
		public R(int k, int c) {
			this.k = k;
			this.c = c;
		}
		public int compareTo(R o) {
			return k-o.k;
		}
	}
	
	int gcd(int a, int b){
		return b==0?a:gcd(b, a%b);
	}
	int lcm(int a, int b){
		int g = gcd(a, b);
		return a/g*b;
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T--!=0){
			int n = sc.nextInt();
			int[] N = new int[n];
			List<R>[] l = new List[n];
			for(int i=0;i<n;i++){
				l[i] = new ArrayList<R>();
				char[] s = sc.next().toCharArray();
				N[i] = s.length/2;
				int g = N[i];
				for(int k=0;k<N[i];k++){
					int c = (s[k*2]-'0')*16+s[k*2+1]-'0';
					if(c==0)continue;
					l[i].add(new R(k, c));
					if(k!=0)g = gcd(g, k);
				}
				if(l[i].isEmpty())continue;
				N[i]/=g;
				for(R r:l[i])r.k/=g;
			}
			int lcm = 1;
			for(int i=0;i<n;i++){
				if(1024<lcm||l[i].isEmpty())continue;
				lcm = lcm(lcm, N[i]);
			}
			if(1024<lcm){
				System.out.println("Too complex."); continue;
			}
			List<R> res = new ArrayList<R>();
			for(int i=0;i<n;i++){
				int mul = lcm/N[i];
				for(R r:l[i])res.add(new R(r.k*mul, r.c));
			}
			if(res.isEmpty())System.out.println("00");
			else{
				Collections.sort(res);
				int[] a = new int[lcm];
				for(R r:res)a[r.k]+=r.c;
				StringBuilder sb = new StringBuilder();
				for(int i=0;i<lcm;i++)sb.append(String.format("%02X", a[i]));
				System.out.println(sb);
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ2105().run();
	}
}
