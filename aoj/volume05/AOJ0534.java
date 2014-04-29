package volume05;

import java.util.LinkedList;
import java.util.Scanner;

//Chain
public class AOJ0534 {

	class R{
		int c, len;
		public R(int c, int len) {
			this.c = c;
			this.len = len;
		}
	}

	int chain(LinkedList<R> l, int s, int t){
		int res = 0;
		int n = l.size();
		while(s>=0&&t<n){
			if(l.get(s).c==l.get(t).c&&l.get(s).len+l.get(t).len>=4){
				res+=l.get(s).len+l.get(t).len;
				s--; t++;
			}
			else break;
		}
		return res;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		for(;;){
			int n = sc.nextInt();
			if(n==0)break;
			LinkedList<R> l = new LinkedList<R>();
			for(int i=0;i<n;i++){
				int c = sc.nextInt();
				if(l.isEmpty()||l.get(l.size()-1).c!=c){
					l.add(new R(c, 1));
				}
				else l.get(l.size()-1).len++;
			}
			int min = n;
			int N = l.size();
			for(int i=0;i<N;i++){
				R r = l.get(i);
				if(i>0){
					if(l.get(i-1).len==3){
						R t = new R(l.get(i-1).c, 1);
						R in = new R(r.c, r.len-1);
						l.remove(i);
						if(in.len>0)l.add(i, in);
						l.add(i, t);
						int L = chain(l, i-1, i);
						min = Math.min(min, n-L);
						l.remove(i);
						if(in.len>0)l.remove(i);
						l.add(i, r);
					}
				}
				if(i+1<N){
					if(l.get(i+1).len==3){
						R t = new R(l.get(i+1).c, 1);
						R in = new R(r.c, r.len-1);
						l.remove(i);
						l.add(i, t);
						if(in.len>0)l.add(i, in);
						int L = chain(l, i, i+1);
						min = Math.min(min, n-L);
						l.remove(i);
						if(in.len>0)l.remove(i);
						l.add(i, r);
					}
				}
				if(i>0&&i+1<N&&r.len==1&&l.get(i-1).c==l.get(i+1).c&&l.get(i-1).len+l.get(i+1).len>=3){
					R in = new R(l.get(i-1).c, l.get(i-1).len+1);
					R pre = l.get(i-1);
					l.remove(i);
					l.remove(i-1);
					l.add(i-1, in);
					int L = chain(l, i-1, i);
					min = Math.min(min, n-L);
					l.remove(i-1);
					l.add(i-1, pre);
					l.add(i, r);
				}
			}
			System.out.println(min);
		}
	}

	public static void main(String[] args) {
		new AOJ0534().run();
	}
}
