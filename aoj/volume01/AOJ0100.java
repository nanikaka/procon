package volume01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//Sale Result
public class AOJ0100 {

	static class P implements Comparable<P>{
		public int x;
		public int o;
		public long s;
		public int compareTo(P o) {
			return this.o-o.o;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			List<P> l = new ArrayList<P>();
			P[] s = new P[4001];
			int id = 1;
			while(n--!=0){
				int d = sc.nextInt();
				if(s[d]==null){
					s[d] = new P();
					s[d].x = d;
					s[d].o = id++;
				}
				long p = sc.nextLong();
				long k = sc.nextLong();
				s[d].s+=p*k;
			}
			for(int i=1;i<4001;i++)if(s[i]!=null&&1000000<=s[i].s)l.add(s[i]);
			Collections.sort(l);
			if(l.isEmpty())System.out.println("NA");
			else for(P i:l)System.out.println(i.x);
		}
	}
}
