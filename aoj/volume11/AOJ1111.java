package volume11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Cyber Guardian
public class AOJ1111 {

	boolean match(String s, String t){
		for(int i=0;i<16;i++){
			if(s.charAt(i)=='?'||t.charAt(i)=='?')continue;
			if(s.charAt(i)!=t.charAt(i))return false;
		}
		return true;
	}

	class P{
		String s, t, m;
		public P(String s, String t, String m) {
			this.s = s;
			this.t = t;
			this.m = m;
		}
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if((n|m)==0)break;
			String[] rule = new String[n];
			String[] d = new String[n];
			for(int i=0;i<n;i++){
				rule[i] = sc.next();
				d[i] = sc.next()+sc.next();
			}
			List<P> l = new ArrayList<P>();
			while(m--!=0){
				P p = new P(sc.next(), sc.next(), sc.next());
				String z = p.s+p.t;
				for(int i=n-1;i>=0;i--){
					if(match(z, d[i])){
						if(rule[i].equals("permit"))l.add(p);
						break;
					}
				}
			}
			System.out.println(l.size());
			for(P p:l)System.out.println(p.s+" "+p.t+" "+p.m);
		}
	}

	public static void main(String[] args) {
		new AOJ1111().run();
	}
}
