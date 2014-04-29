package volume05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//JJOOII
public class AOJ0571 {

	class R{
		char ch;
		int c;
		public R(char ch, int c) {
			this.ch = ch;
			this.c = c;
		}
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		char[] s = sc.next().toCharArray();
		int n = s.length, c = 1;
		char r = s[0];
		List<R> l = new ArrayList<R>();
		for(int i=1;i<n;i++){
			if(s[i]!=r){
				l.add(new R(r, c)); r = s[i]; c = 0;
			}
			c++;
		}
		l.add(new R(r, c));
		int res = 0;
		for(int i=1;i<l.size()-1;i++){
			R r1 = l.get(i-1), r2 = l.get(i), r3 = l.get(i+1);
			if(r1.ch=='J'&&r2.ch=='O'&&r3.ch=='I'&&r2.c<=r1.c&&r2.c<=r3.c)res = Math.max(res, r2.c);
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		new AOJ0571().run();
	}
}
