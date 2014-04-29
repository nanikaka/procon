package volume05;

import java.util.Scanner;
import java.util.Stack;

//Setting Go Stones
public class AOJ0527 {

	class R{
		int id;
		boolean white;
		public R(int id, boolean white) {
			this.id = id;
			this.white = white;
		}
	}

	void run(){
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			Stack<R> s = new Stack<R>();
			for(int i=1;i<=n;i++){
				boolean w = sc.nextInt()==0;
				if(s.isEmpty()){
					s.add(new R(i,w));
					continue;
				}
				if(i%2==1&&s.peek().white!=w)s.add(new R(i,w));
				else if(i%2==0&&s.peek().white!=w){
					R r = s.pop();
					s.push(new R(r.id,w));
					while(s.size()>=2){
						R a = s.pop();
						if(a.white!=s.peek().white){
							s.push(a);
							break;
						}
					}
				}
			}
			int c = 0;
			int p = n+1;
			while(!s.isEmpty()){
				R r = s.pop();
				if(r.white)c+=p-r.id;
				p = r.id;
			}
			System.out.println(c);
		}
	}

	public static void main(String[] args) {
		new AOJ0527().run();
	}
}
