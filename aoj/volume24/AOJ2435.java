package volume24;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

//Zero Division Checker
public class AOJ2435 {

	class R{
		boolean[] p;
		public R() {
			p = new boolean[256];
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		Map<String, Integer> ref = new HashMap<String, Integer>();
		int[] lb = new int[m], ub = new int[m];
		for(int i=0;i<m;i++){
			ref.put(sc.next(), i);
			lb[i] = sc.nextInt(); ub[i] = sc.nextInt();
		}
		int n = sc.nextInt();
		boolean res = true;
		Stack<R> r = new Stack<R>();
		while(n--!=0){
			String s = sc.next();
			R v = new R();
			if(ref.containsKey(s)){
				int id = ref.get(s);
				for(int i=lb[id];i<=ub[id];i++)v.p[i] = true;
			}
			else if("/".equals(s)){
				R b = r.pop(), a = r.pop();
				if(b.p[0]){
					res = false; break;
				}
				for(int x=0;x<256;x++)if(a.p[x])for(int y=0;y<256;y++)if(b.p[y])v.p[(x/y)%256] = true;
			}
			else if("+".equals(s)){
				R b = r.pop(), a = r.pop();
				for(int x=0;x<256;x++)if(a.p[x])for(int y=0;y<256;y++)if(b.p[y])v.p[(x+y)%256] = true;
			}
			else if("-".equals(s)){
				R b = r.pop(), a = r.pop();
				for(int x=0;x<256;x++)if(a.p[x])for(int y=0;y<256;y++)if(b.p[y])v.p[(x-y+256)%256] = true;
			}
			else if("*".equals(s)){
				R b = r.pop(), a = r.pop();
				for(int x=0;x<256;x++)if(a.p[x])for(int y=0;y<256;y++)if(b.p[y])v.p[(x*y)%256] = true;
			}
			else{
				v.p[Integer.parseInt(s)] = true;
			}
			r.add(v);
		}
		System.out.println(res?"correct":"error");
	}
	
	public static void main(String[] args) {
		new AOJ2435().run();
	}
}
