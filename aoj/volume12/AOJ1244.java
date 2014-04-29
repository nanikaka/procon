package volume12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Molecular Formula
public class AOJ1244 {

	char[] s;
	int id;
	char get(){
		return s[id++];
	}
	
	Map<String, Integer> ref;
	
	int mol(){
		int res = 0;
		for(;;){
			char ch = get();
			if(ch=='('){
				int x = mol();
				if(x==-1)return -1;
				res+=x*num();
			}
			else if(Character.isUpperCase(ch)){
				id--;
				int a = atom();
				if(a==-1)return -1;
				if(Character.isDigit(s[id]))res+=a*num();
				else res+=a;
			}
			else break;
		}
		return res;
	}
	int atom(){
		String res = get()+"";
		if(Character.isLowerCase(s[id]))res+=get();
		return ref.containsKey(res)?ref.get(res):-1;
	}
	int num(){
		int x = get()-'0';
		if(Character.isDigit(s[id]))x=x*10+get()-'0';
		return x;
	}
	
	void run(){
		Scanner sc = new Scanner(System.in);
		ref = new HashMap<String, Integer>();
		for(;;){
			String x = sc.next();
			if("END_OF_FIRST_PART".equals(x))break;
			ref.put(x, sc.nextInt());
		}
		for(;;){
			s = (sc.next()+"$").toCharArray();
			if(s[0]=='0')break;
			id = 0;
			int r = mol();
			System.out.println(r==-1?"UNKNOWN":r);
		}
	}
	
	public static void main(String[] args) {
		new AOJ1244().run();
	}
}
