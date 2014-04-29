package volume12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//Repeated Substitution with Sed
public class AOJ1296 {

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			String[] a = new String[n];
			String[] b = new String[n];
			for(int i=0;i<n;i++){
				a[i] = sc.next(); b[i] = sc.next();
			}
			String init = sc.next(), g = sc.next();
			List<String> l = new ArrayList<String>();
			Set<String> set = new HashSet<String>();
			l.add(init); set.add(init);
			int res = -1, step = 0;
			while(!l.isEmpty()){
				List<String> next = new ArrayList<String>();
				for(String s:l){
					if(g.equals(s)){
						res = step; next.clear(); break;
					}
					for(int i=0;i<n;i++){
						String r = "";
						String sub = s;
						while(sub.length()>0){
							if(sub.startsWith(a[i])){
								r+=b[i];
								sub = sub.substring(a[i].length());
							}
							else{
								r+=sub.charAt(0);
								sub = sub.substring(1);
							}
						}
						if(r.length()<=g.length()&&!set.contains(r)){
							next.add(r); set.add(r);
						}
					}
				}
				l = next;
				step++;
			}
			System.out.println(res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1296().run();
	}
}
