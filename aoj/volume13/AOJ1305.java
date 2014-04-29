package volume13;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//Membership Management
public class AOJ1305 {

	class R{
		String s;
		Set<R> adj;
		boolean u;
		public R(String s) {
			this.s = s;
			adj = new HashSet<R>();
		}
		int f(){
			if(u)return 0;
			u = true;
			if(adj.isEmpty())return 1;
			int res = 0;
			for(R r:adj)res+=r.f();
			return res;
		}
	}
	
	Map<String, R> ref;
	R get(String s){
		if(ref.containsKey(s))return ref.get(s);
		R r = new R(s);
		ref.put(s, r);
		return r;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			ref = new HashMap<String, R>();
			String g = "";
			while(n--!=0){
				String t = sc.next();
				String[] s = t.substring(0, t.length()-1).split(":");
				if("".equals(g))g=s[0];
				R r = get(s[0]);
				for(String v:s[1].split(","))r.adj.add(get(v));
			}
			System.out.println(get(g).f());
		}
	}
	
	public static void main(String[] args) {
		new AOJ1305().run();
	}
}
