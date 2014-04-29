package volume24;

import java.util.Scanner;

//Equation
public class AOJ2401 {

	boolean[] assign;
	char[] s;
	int idx;
	char get(){
		return s[idx++];
	}
	
	String s1, s2;
	
	boolean f(int k){
		if(k==11){
			s = s1.toCharArray();
			idx = 0;
			boolean f1 = formula();
			s = s2.toCharArray();
			idx = 0;
			return f1==formula();
		}
		assign[k] = false;
		if(!f(k+1))return false;
		assign[k] = true;
		return f(k+1);
	}
	
	boolean formula(){
		char ch = get();
		if(ch=='('){
			boolean f1 = formula();
			ch = get();
			if(ch=='*'){
				boolean f2 = formula();
				get();
				return f1&&f2;
			}
			else if(ch=='+'){
				boolean f2 = formula();
				get();
				return f1||f2;
			}
			else{
				get();
				boolean f2 = formula();
				get();
				return !f1||f2;
			}
		}
		else if(ch=='-'){
			return !formula();
		}
		else if(ch=='T'){
			return true;
		}
		else if(ch=='F'){
			return false;
		}
		else return assign[ch-'a'];
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		assign = new boolean[11];
		for(;;){
			String t = sc.next();
			if("#".equals(t))break;
			String[] tt = t.split("=");
			s1 = tt[0]+"$"; s2 = tt[1]+"$";
			System.out.println(f(0)?"YES":"NO");
		}
	}
	
	public static void main(String[] args) {
		new AOJ2401().run();
	}
}
