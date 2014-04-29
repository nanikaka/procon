package volume11;

import java.util.Scanner;

//Calculation of Expressions
public class AOJ1102 {

	class R{
		int r, i;
		public R(int r, int i) {
			this.r = r;
			this.i = i;
		}
		R add(R t){
			return new R(r+t.r, i+t.i);
		}
		R sub(R t){
			return new R(r-t.r, i-t.i);
		}
		R mul(R t){
			return new R(r*t.r-i*t.i, r*t.i+i*t.r);
		}
		public String toString() {
			if(r==0&&i==0)return "0";
			if(i==0)return r+"";
			if(r==0)return i+"i";
			if(i>0)return r+"+"+i+"i";
			return r+""+i+"i";
		}
	}
	
	boolean f;
	char[] s;
	int id;
	char get(){
		return s[id++];
	}
	
	void check(R r){
		if(Math.abs(r.r)>10000||Math.abs(r.i)>10000)f = true;
	}
	
	R exp(){
		R res = term();
		while(true){
			char ch = get();
			if(ch=='+'){
				res = res.add(term());
				check(res);
			}
			else if(ch=='-'){
				res = res.sub(term());
				check(res);
			}
			else break;
		}
		return res;
	}
	
	R term(){
		R res = fact();
		check(res);
		char ch = get();
		while(ch=='*'){
			R r = fact();
			check(r);
			res = res.mul(r);
			check(res);
			ch = get();
		}
		id--;
		return res;
	}
	
	R fact(){
		char ch = get();
		if(ch=='(')return exp();
		if(Character.isDigit(ch)){
			int x = 0;
			while(Character.isDigit(ch)){
				x = x*10 + ch-'0';
				check(new R(x, 0));
				ch = get();
			}
			id--;
			return new R(x, 0);
		}
		return new R(0, 1);
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			s = (sc.next()+"$").toCharArray();
			id = 0;
			f = false;
			R res = exp();
			System.out.println(f?"overflow":res);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1102().run();
	}
}
