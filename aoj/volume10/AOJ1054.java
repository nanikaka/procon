package volume10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//Distorted Love
public class AOJ1054 {

	class B{
		int x1, y1, x2, y2;
		String s;
		public B(int x1, int y1, int x2, int y2, String s) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.s = s;
		}
	}
	
	class R{
		String name;
		List<B> l;
		public R(String name) {
			this.name = name;
			l = new ArrayList<B>();
		}
		String click(int x, int y){
			for(B b:l){
				if(b.x1<=x&&x<=b.x2&&b.y1<=y&&y<=b.y2)return b.s;
			}
			return "";
		}
	}
	
	Map<String, Integer> ref;
	R[] page;
	int id;
	
	int get(String s){
		if(ref.containsKey(s))return ref.get(s);
		page[id] = new R(s);
		ref.put(s, id);
		return id++;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			sc.next();sc.next();
			page = new R[n];
			ref = new TreeMap<String, Integer>();
			id = 0;
			for(int i=0;i<n;i++){
				int x = get(sc.next());
				int k = sc.nextInt();
				while(k--!=0){
					page[x].l.add(new B(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.next()));
				}
			}
			int m = sc.nextInt();
			R[] h = new R[m];
			h[0] = page[0];
			int pos = 0;
			int t = 1;
			while(m--!=0){
				String cmd = sc.next();
				if(cmd.equals("show")){
					System.out.println(h[pos].name);
				}
				else if(cmd.equals("back")){
					pos = Math.max(0, pos-1);
				}
				else if(cmd.equals("forward")){
					pos = Math.min(t-1, pos+1);
				}
				else {
					String hit = h[pos].click(sc.nextInt(), sc.nextInt());
					if(hit.equals(""))continue;
					int x = ref.get(hit);
					h[++pos] = page[x];
					t = pos+1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new AOJ1054().run();
	}
}
