package volume21;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

///Restrictive Filesystem
public class AOJ2152 {

	class R implements Comparable<R>{
		int id, s, t;
		public R(int id, int s, int t) {
			this.id = id;
			this.s = s;
			this.t = t;
		}
		public int compareTo(R o) {
			return s-o.s;
		}
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			List<R> l = new LinkedList<R>();
			l.add(new R(-1, 0, 1000000000));
			Map<Integer, List<R>> ref = new HashMap<Integer, List<R>>();
			while(n--!=0){
				char cmd = sc.next().charAt(0);
				if(cmd=='R'){
					int p = sc.nextInt(), res = -1;
					for(int k:ref.keySet())for(R r:ref.get(k)){
						if(res!=-1)break;
						if(r.s<=p&&p<=r.t)res = r.id;
					}
					System.out.println(res);
				}
				else if(cmd=='W'){
					int id = sc.nextInt(), len = sc.nextInt();
					List<R> list = new LinkedList<R>();
					for(int i=0;i<l.size();i++){
						R r = l.get(i);
						int L = r.t-r.s+1;
						if(L<len){
							list.add(new R(id, r.s, r.t));
							l.remove(i); i--;
							len-=L;
						}
						else if(L==len){
							list.add(new R(id, r.s, r.t));
							l.remove(i);
							ref.put(id, list);
							break;
						}
						else{
							l.remove(i);
							list.add(new R(id, r.s, r.s+len-1));
							l.add(i, new R(-1, r.s+len, r.t));
							ref.put(id, list);
							break;
						}
					}
				}
				else{
					int id = sc.nextInt();
					if(ref.containsKey(id)){
						for(R r:ref.get(id)){
							l.add(new R(-1, r.s, r.t));
						}
						ref.remove(id);
						Collections.sort(l);
						for(int i=0;i+1<l.size();i++){
							R r1 = l.get(i), r2 = l.get(i+1);
							if(r1.t+1!=r2.s)continue;
							R r = new R(r1.id, r1.s, r2.t);
							l.remove(i); l.remove(i); l.add(i, r);
							i--;
						}
					}
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new AOJ2152().run();
	}
}
