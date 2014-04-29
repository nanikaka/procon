package volume12;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

//Confusing Login Names
public class AOJ1252 {

	Set<String>[] s;
	
	class P implements Comparable<P>{
		String s, t;
		public P(String s, String t) {
			this.s = s.compareTo(t)<0?s:t;
			this.t = s.compareTo(t)<0?t:s;
		}
		public int compareTo(P o) {
			return s.equals(o.s)?t.compareTo(o.t):s.compareTo(o.s);
		}
	}
	
	void make(int i, String v){
		int n = v.length();
		StringBuffer f = new StringBuffer(v);
		//delete
		for(int j=0;j<n;j++){
			char ch = f.charAt(j);
			f.deleteCharAt(j);
			s[i].add(f.toString());
			f.insert(j, ch);
		}
		//insert
		for(int j=0;j<=n;j++){
			for(char ch='a';ch<='z';ch++){
				f.insert(j, ch); s[i].add(f.toString()); f.deleteCharAt(j);
			}
		}
		//replace
		for(int j=0;j<n;j++){
			char ch = f.charAt(j);
			for(char c='a';c<='z';c++){
				f.setCharAt(j, c); s[i].add(f.toString());
			}
			f.setCharAt(j, ch);
		}
		//swap
		for(int j=0;j<n-1;j++){
			char a = f.charAt(j), b = f.charAt(j+1);
			f.setCharAt(j, b); f.setCharAt(j+1, a);
			s[i].add(f.toString());
			f.setCharAt(j, a); f.setCharAt(j+1, b);
		}
	}
	
	@SuppressWarnings("unchecked")
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			int d = sc.nextInt();
			s = new HashSet[n];
			String[] name = new String[n];
			for(int i=0;i<n;i++){
				name[i] = sc.next();
				s[i] = new HashSet<String>();
				make(i, name[i]);
			}
			PriorityQueue<P> q = new PriorityQueue<P>();
			for(int i=0;i<n;i++)for(int j=i+1;j<n;j++){
				if(d==1){
					if(s[i].contains(name[j]))q.add(new P(name[i], name[j]));
				}
				else{
					if(s[i].contains(name[j]))q.add(new P(name[i], name[j]));
					else{
						for(String v:s[i])if(s[j].contains(v)){
							q.add(new P(name[i], name[j]));
							break;
						}
					}
				}
			}
			int r = q.size();
			while(!q.isEmpty()){
				P p = q.poll(); System.out.println(p.s+","+p.t);
			}
			System.out.println(r);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1252().run();
	}
}
